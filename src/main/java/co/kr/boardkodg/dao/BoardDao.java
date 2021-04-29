package co.kr.boardkodg.dao;

import co.kr.boardkodg.dto.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardDao {

    int countBoard();

    List<Board> selectBoard(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);

    Board findBoardDetail(@Param("id") String id);

    void boardDelete(@Param("id") String id);

    void boardInsert(Map<String, Object> param);

    void boardUpdate(Map<String, Object> param);
}
