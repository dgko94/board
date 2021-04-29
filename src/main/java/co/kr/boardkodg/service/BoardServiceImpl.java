package co.kr.boardkodg.service;

import co.kr.boardkodg.dao.BoardDao;
import co.kr.boardkodg.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardDao boardDao;

    @Override
    public int countBoard() {
        return boardDao.countBoard();
    }

    @Override
    public List<Board> selectBoard(int startIndex, int pageSize) {
        return boardDao.selectBoard(startIndex,pageSize);
    }

    @Override
    public Board findBoardDetail(String id) {
        return boardDao.findBoardDetail(id);
    }

    @Override
    public void boardDelete(String id) {
        boardDao.boardDelete(id);
    }

    @Override
    public void boardInsert(Map<String, Object> param) {
        boardDao.boardInsert(param);
    }

    @Override
    public void boardUpdate(Map<String, Object> param) {
        boardDao.boardUpdate(param);
    }
}
