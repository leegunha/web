package edu.multi.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {// mybatis-spring.xml 설정
	@Autowired
	SqlSession sqlSession;

	public MemberVO selectMember(String userid, String password) {
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
		vo.setPassword(password);

		// select * from member where userid=? and password=?
		vo = sqlSession.selectOne("getmember", vo);
		return vo;
	}
	
	public int insertMemeber(MemberVO vo) throws Exception {
		
			
		
	return	sqlSession.insert("newmember", vo);
		
	}

}
