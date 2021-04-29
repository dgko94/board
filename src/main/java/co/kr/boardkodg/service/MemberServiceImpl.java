package co.kr.boardkodg.service;

import co.kr.boardkodg.dao.MemberDao;
import co.kr.boardkodg.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDao memberDao;

    @Override
    public void join(Map<String, Object> param) {
        memberDao.join(param);
    }

    @Override
    public Member findByUserId(String userId) {
        return memberDao.findByUserId(userId);
    }

    @Override
    public Member memberLogin(String userId, String userPw, HttpSession session) {
        Member member = memberDao.memberLogin(userId, userPw);
        
        //로그인결과가 있으면 session에 저장
        if (member != null){
            session.setAttribute("user",member.getUserId());
        } else {
            session.removeAttribute("user");
        }

        return member;
    }
}
