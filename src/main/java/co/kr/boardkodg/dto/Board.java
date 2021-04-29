package co.kr.boardkodg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private int id;
    private String title;
    private String content;
    private String userId;
    private String regDate;
    private String updateDate;
    private String count;
    private String recommend;
}
