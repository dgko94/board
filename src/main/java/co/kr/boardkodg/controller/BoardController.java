package co.kr.boardkodg.controller;


import co.kr.boardkodg.dto.Board;
import co.kr.boardkodg.dto.Paging;
import co.kr.boardkodg.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    BoardService boardService;

    //게시판 글쓰기
    @GetMapping("writing")
    public String WritingPage(){
        return "board/writing";
    }

    @PostMapping("writing")
    public String Writing(@RequestParam Map<String, Object>param
        ,Model model
    ){
        //글쓰기내용이. 공백이면 저장못하게해야함.
        String titleConfirm = (String)param.get("title");

        if (titleConfirm.trim().equals("") || titleConfirm==null){
            System.out.println(titleConfirm);
            model.addAttribute("msg",0);
            return "redirect:/board/writing";
        }

        String userIdConfirm = (String)param.get("userId");
        if (userIdConfirm.trim().equals("") || userIdConfirm==null){
            return "redirect:/board/writing";
        }

        boardService.boardInsert(param);

        return "redirect:/board/list";
    }

    //게시판 삭제
    @GetMapping("delete/{id}")
    public String BoardDelete(@PathVariable("id") String id){

        boardService.boardDelete(id);

        return "redirect:/board/list";
    }

    @GetMapping("list")
    public String boards(Model model
            , HttpSession session
            , @RequestParam(defaultValue = "1") int page
    ){
        //session확인해서 null이면 글쓰기 안보이기. (비로그인)
        if(session.getAttribute("loginName")==null){
            model.addAttribute("notUser", null);
        } else {
            model.addAttribute("notUser", 1);
        }
        // 총 게시물 수
        int totalListCnt = boardService.countBoard();

        // 생성인자로  총 게시물 수, 현재 페이지를 전달
        Paging paging = new Paging(totalListCnt, page);

        // DB select start index
        int startIndex = paging.getStartIndex();
        // 페이지 당 보여지는 게시글의 최대 개수
        int pageSize = paging.getPageSize();

        List<Board> boardList = boardService.selectBoard(startIndex, pageSize);
        model.addAttribute("boards", boardList);
        //model.addAttribute("boardList", boardList);
        model.addAttribute("pagination", paging);

        return "board/list";
    }
    @GetMapping("/detail/{id}")
    public String boardDetail(HttpSession session, Model model
            ,@PathVariable("id") String id
    ){
        Board board = boardService.findBoardDetail(id);

        //상세 보기하는데 session에 값이 없으면 (비로그인상태)
        if(session.getAttribute("loginName")==null){
            model.addAttribute("boards", board);
            model.addAttribute("notUser",null); //null=비로그인 유저 2=회원유저 1=관리자
        } else {
            model.addAttribute("boards", board);
            model.addAttribute("notUser",2); //null=비로그인 유저 2=회원유저 1=관리자
        }

        return "board/detail";
    }

    //게시판 업데이트
    @PostMapping("/update/{id}")
    public String BoardUpdate(@PathVariable("id") String id
            , @RequestParam Map<String, Object> param
    ){
        param.put("id", id);

        boardService.boardUpdate(param);

        return "redirect:/board/list";
    }


}
