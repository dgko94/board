package co.kr.boardkodg.service;


import co.kr.boardkodg.dto.Member;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface MemberService {


    void join(Map<String, Object> param);


    Member findByUserId(String userId);

    Member memberLogin(String userId, String userPw,HttpSession session);
}
