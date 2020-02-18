package edu.multi.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
@Repository("dao")
public class BoardDAO {
//전체게시물조회메소드
 public ArrayList<BoardVO>  getList( ){
	 ArrayList<BoardVO> list = new ArrayList<BoardVO>();
	 try {
		 //1. jdbc driver 로드(ojdbc6.jar)
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 //2. db 정보 부여하고 db 연결
		 Connection con = DriverManager.getConnection
		 ("jdbc:oracle:thin:@localhost:1521:xe" , "scott", "TIGER");
		 //3. sql 정의 
		 PreparedStatement pt = 
				 con.prepareStatement("select * from board order by time desc");
		 //4. 전송 sql 실행 결과 이용
		 ResultSet rs = pt.executeQuery();
		 while(rs.next()) {
			 //select  레코드 있을 때까지 반복
			 BoardVO vo = new BoardVO();
			 vo.setSeq(rs.getInt("seq"));
			 vo.setTitle(rs.getString("title"));
			 vo.setContents(rs.getString("contents"));	
			 vo.setWriter(rs.getString("writer"));	
			 vo.setTime(rs.getString("time"));	
			 vo.setViewcount(rs.getInt("viewcount"));	
			 list.add(vo);
		 }
		 //5. db 연결해제
		 rs.close();
		 pt.close();
		 con.close();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return list;
	 
 }
 
 //게시물1개저장메소드
 public int  insertBoard(BoardVO vo ){
	 int result = 0;
	 try {
		 //1. jdbc driver 로드(ojdbc6.jar)
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 //2. db 정보 부여하고 db 연결
		 Connection con = DriverManager.getConnection
		 ("jdbc:oracle:thin:@localhost:1521:xe" , "scott", "TIGER");
		 //3. sql 정의 
		 String insertsql = 
		 "insert into board values((SELECT MAX(SEQ)+1 FROM BOARD) , "
				 +"?, ?,?, SYSDATE, ?,0)";
		 PreparedStatement pt = con.prepareStatement (insertsql);
		 //4. 전송 sql 실행 결과 이용
		 pt.setString(1, vo.getTitle());
		 pt.setString(2, vo.getContents());		
		 pt.setString(3, vo.getWriter());
		 pt.setInt(4, vo.getPassword());
		result = pt.executeUpdate();
		 //5. db 연결해제
		 pt.close();
		 con.close();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return result;
 }
 
//글번호 해당 게시물 1개 조회메소드
public BoardVO  getBoardDetail(int seq ){
	 BoardVO vo = null;
	 try {
		 //1. jdbc driver 로드(ojdbc6.jar)
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 //2. db 정보 부여하고 db 연결
		 Connection con = DriverManager.getConnection
		 ("jdbc:oracle:thin:@localhost:1521:xe" , "scott", "TIGER");
		 
		 //3. sql 정의 
		 PreparedStatement pt0 = 
				 con.prepareStatement
				 ("update board set viewcount= viewcount + 1 where seq=?");
		 PreparedStatement pt = 
		con.prepareStatement("select * from board where seq=?");
		 //4. 전송 sql 실행 결과 이용
		 pt0.setInt(1, seq);
		 pt0.executeUpdate();
		 
		 pt.setInt(1, seq);
		 ResultSet rs = pt.executeQuery();//1개 레코드(레코드이전포이터)
		 	rs.next();//첫번째레코드이동
			 //select  레코드 있을 때까지 반복
			vo = new BoardVO();
			 vo.setSeq(rs.getInt("seq"));
			 vo.setTitle(rs.getString("title"));
			 vo.setContents(rs.getString("contents"));	
			 vo.setWriter(rs.getString("writer"));	
			 vo.setTime(rs.getString("time"));	
			 vo.setViewcount(rs.getInt("viewcount"));	


		 //5. db 연결해제
		 rs.close();
		 pt.close();
		 pt0.close();
		 con.close();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return vo;
	 
}
}
