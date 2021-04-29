package co.kr.boardkodg.service;

import co.kr.boardkodg.dto.Board;

import java.util.List;
import java.util.Map;

public interface BoardService {
    int countBoard();

    List<Board> selectBoard(int startIndex, int pageSize);

    Board findBoardDetail(String id);

    void boardDelete(String id);

    void boardInsert(Map<String, Object> param);

    void boardUpdate(Map<String, Object> param);
}
