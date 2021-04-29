package co.kr.boardkodg.controller;

import co.kr.boardkodg.dto.Member;
import co.kr.boardkodg.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("login")
    public String loginSuccess(@RequestParam("userId")String userId, @RequestParam("userPw")String userPw
            , HttpSession session
            , Model model
                               ){
        Member member = memberService.memberLogin(userId, userPw, session);

        if (member==null){
            model.addAttribute("danger",0);
        }
        return "home";
    }

}
