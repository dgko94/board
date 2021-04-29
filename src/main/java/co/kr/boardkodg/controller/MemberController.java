package co.kr.boardkodg.controller;


import co.kr.boardkodg.dto.Member;
import co.kr.boardkodg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller

public class MemberController {

    @Autowired
    MemberService memberService;

    //회원가입
    @GetMapping("join")
    public String join(){
        return "member/join";
    }

    @PostMapping("join")
    public String join1(@RequestParam Map<String, Object> param
            , Model model
    ){
        //회원가입시 비밀번호랑 비밀번호체크가 같지않으면 회원가입 실패.
        if (param.get("userPw").equals(param.get("userPw_confirm"))){
            memberService.join(param);
        } else {
            model.addAttribute("danger","비밀번호가 일치하지않습니다.");
            return "member/join";
        }
        return "redirect:/";
    }

    //회원가입시 ID체크
    @PostMapping("userCheck")
    public String userCheck(@RequestParam(value = "userId") String userId
            , Model model
    ){
        //아이디 중복체크.
        Member userCheck = memberService.findByUserId(userId);
        //중복된 아이디가 없으면
        if(userCheck == null){
            model.addAttribute("userId",userId);
            model.addAttribute("msg", "사용가능 한 아이디입니다.");
        } else {
            model.addAttribute("msg","이미 사용중인 아이디입니다.");
        }
        return "member/join :: #userIdDiv";
    }
}
