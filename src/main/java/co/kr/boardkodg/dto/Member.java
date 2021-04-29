package co.kr.boardkodg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private int id;
    private String regDate;
    private String updateDate;
    private String userId;
    private String userPw;
    private String userPw_confirm;
    private String name;
    private String nickname;
    private String cellphoneNo;
    private String email;
    private String authority;
}
