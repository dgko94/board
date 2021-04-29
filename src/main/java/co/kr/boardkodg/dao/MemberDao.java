package co.kr.boardkodg.dao;

import co.kr.boardkodg.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface MemberDao {


    void join(Map<String, Object> param);

    Member findByUserId(@Param("userId") String userId);

    Member memberLogin(@Param("userId") String userId,@Param("userPw") String userPw);
}
