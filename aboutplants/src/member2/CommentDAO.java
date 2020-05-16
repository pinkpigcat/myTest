package member2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentDAO {
	

		public Connection getConnection() throws Exception{
			
			Connection con=null;
			Context init = new InitialContext();
			DataSource ds =(DataSource) init.lookup("java:comp/env/jdbc/MysqlDB");
			con=ds.getConnection();
			return con;
			
		}


public void insertMember(CommentBean bean) {
	 Connection con=null;
	 PreparedStatement pstmt=null;
	 CommentBean bea = bean;
	 
	 try {
		 con=getConnection();
		 
		 String sql="insert into comment(comment_num,comment_board_num,comment_id,comment_date,comment_p,comment_content) values(?,?,?,?,?,?)";
		 pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, bean.getComment_num());
		pstmt.setInt(2, bean.getComment_board_num());
		pstmt.setString(3, bean.getComment_id());
		pstmt.setTimestamp(4, bean.getComment_date());
		pstmt.setInt(5, bean.getComment_p());
		pstmt.setString(6, bean.getComment_content());
		
		 pstmt.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (pstmt!=null) try{	pstmt.close();} catch (SQLException ex) {}
		if (con!=null)try {con.close();}catch (SQLException ex) {}
	}
  }

public List getComment(int boardNum) {
	
	 Connection con=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs = null;
	 List list = new ArrayList();
	
	 try {
			con=getConnection();
			
	String sql="select * from comment where comment_board_num=?";
	 pstmt=con.prepareStatement(sql);
	 pstmt.setInt(1,boardNum);
	 rs=pstmt.executeQuery();
		 
	 while(rs.next()) {
		 CommentBean bean = new CommentBean();
		 bean.setComment_board_num(rs.getInt("Comment_board_num"));
		 bean.setComment_content(rs.getString("Comment_content"));
		 bean.setComment_date(rs.getTimestamp("Comment_date"));
		 bean.setComment_id(rs.getString("Comment_id"));
		 bean.setComment_num(rs.getInt("Comment_num"));
		 list.add(bean);
		}
	 
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (rs!=null)try {rs.close();}catch (SQLException ex) {}
		if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
		if (con!=null)try {con.close();}catch (Exception ex) {}
	}
	
	 return list;
}

public int getCommentCount(int num) {
	
	int count=0;
	 Connection con=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs = null;
	
	 try {
			con=getConnection();
			
	String sql="select * from comment where comment_board_num=?";
	 pstmt=con.prepareStatement(sql);
	 pstmt.setInt(1,num);
	 rs=pstmt.executeQuery();
		 
	 while(rs.next()) {
			count++;
		}
	 
		
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		if (rs!=null)try {rs.close();}catch (SQLException ex) {}
		if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
		if (con!=null)try {con.close();}catch (Exception ex) {}
	}
	
	 return count;
}


public void deleteComment(int num,int comment_num) {
	Connection con=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs = null;
//	 	int check = 0;
	try {
		 con =getConnection();
			
		
			 String sql="delete from comment where comment_board_num=? and comment_num=?";
						pstmt=con.prepareStatement(sql);
						pstmt.setInt(1,num);
						pstmt.setInt(2,comment_num); 
						pstmt.executeUpdate();
				
					
	} catch (Exception e) {
		e.printStackTrace();
	}
//	return check;
}

public void updateComment(int comment_board_num,int comment_num,String comment) {
	Connection con=null;
	 PreparedStatement pstmt=null;
	 ResultSet rs = null;
//	 	int check = 0;
	try {
		 con =getConnection();
			
		
			 String sql="update comment set comment_content=? where comment_board_num=? and comment_num=?";
						pstmt=con.prepareStatement(sql);
						pstmt.setString(1,comment);
						pstmt.setInt(2,comment_board_num);
						pstmt.setInt(3,comment_num); 
						pstmt.executeUpdate();
				
					
	} catch (Exception e) {
		e.printStackTrace();
	}
//	return check;
}


}//클래스 끝
	 