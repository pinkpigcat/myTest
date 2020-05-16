package member2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {

	public Connection getConnection() throws Exception{
		//1�떒怨� : �꽕移섎맂 JDBC�봽濡쒓렇�옩 遺덈윭�삤湲�
		 Class.forName("com.mysql.jdbc.Driver");
		 //2�떒怨� : JDBC�봽濡쒓렇�옩�쓣 �씠�슜�빐�꽌 �뵒鍮꾩뿰寃�(�뵒鍮꾩＜�냼,�뵒鍮꾩젒�냽�븘�씠�뵒,�뵒鍮꾩젒�냽鍮꾨�踰덊샇)
		 //    => �뿰寃곗젙蹂대�� ���옣�븯�뒗 媛앹껜�깮�꽦
		 String dbUrl="jdbc:mysql://localhost:3306/jspdb5";
		 String dbUser="jspid";
		 String dbPass="jsppass";
		 Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
		 return con;
	}
	
	public void insertMember(MemberBean bean) {
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 
		 
		 try {
			 con=getConnection();
			 
			 String sql="insert into member(id,pass,name,reg_date,email,phone,mobile,sample4_postcode,sample4_roadAddress,sample4_jibunAddress,sample4_detail) values(?,?,?,?,?,?,?,?,?,?,?)";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,bean.getId());
			 pstmt.setString(2,bean.getPass());
			 pstmt.setString(3,bean.getName());
			 pstmt.setTimestamp(4,bean.getReg_date());
			 pstmt.setString(5,bean.getEmail());
//			 pstmt.setString(6,bean.getAddress());
			 pstmt.setString(6,bean.getPhone());
			 pstmt.setString(7,bean.getMobile());
			 pstmt.setString(8,bean.getSample4_postcode());
			 pstmt.setString(9,bean.getSample4_roadAddress());
			 pstmt.setString(10,bean.getSample4_jibunAddress());
			 pstmt.setString(11,bean.getSample4_detail());
			 pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (pstmt!=null) try{	pstmt.close();} catch (SQLException ex) {}
			if (con!=null)try {con.close();}catch (SQLException ex) {}
		}
		 
		 
		 
	}

	public MemberBean getMember (String id){
		MemberBean bean = new MemberBean();
		 Connection con=null;
		 PreparedStatement pstmt=null;
	try {
		 con =getConnection();
		// //3�떒怨� sql 議곌굔�씠 id�뿉 �븯�뒗 �궡�슜�쓣 member�뀒�씠釉붿뿉�꽌 議고쉶�빐�꽌 媛��졇�삤湲�
		 String sql="select * from member where id=?";
		  pstmt=con.prepareStatement(sql);
		 pstmt.setString(1, id);    
		ResultSet rs =pstmt.executeQuery();

		 if(rs.next()){
			 
			 bean.setId(rs.getString("id"));
			 bean.setPass(rs.getString("pass"));
			 bean.setName(rs.getString("name"));
			 bean.setEmail(rs.getString("email"));
			 bean.setPhone(rs.getString("phone"));
			 bean.setMobile(rs.getString("mobile"));
			 bean.setSample4_postcode(rs.getString("sample4_postcode"));
			 bean.setSample4_roadAddress(rs.getString("sample4_roadAddress"));
			 bean.setSample4_jibunAddress(rs.getString("sample4_jibunAddress"));
			 bean.setSample4_detail(rs.getString("sample4_detail"));
			 
		 }
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (pstmt!=null) try{	pstmt.close();} catch (SQLException ex) {}
		if (con!=null)try {con.close();}catch (SQLException ex) {}
	} 
	return bean;
	}
	
	
	public int userCheck(String id,String pass) {
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		try {
			con=getConnection();
			 String sql="select * from member where id=?"; 
			  pstmt=con.prepareStatement(sql);
				 pstmt.setString(1, id);
				  rs=pstmt.executeQuery();
				  if(rs.next()) {
					  if(pass.equals(rs.getString("pass"))) {
						  return 1;
					  }else {
						  return 0;
					  }
				  }else {
					  return -1;
					  
				  }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch (SQLException ex) {}
			if (pstmt!=null) try{	pstmt.close();} catch (SQLException ex) {}
			if (con!=null)try {con.close();}catch (SQLException ex) {}
		}
		return 0;
	}
	


	
	public void updatemember(MemberBean bean) {
		
		
		 Connection con=null;
		 PreparedStatement pstmt=null;
//		MemberBean bean = bean1;
		
		try {
			con=getConnection();
		
			 String sql="update member set name=?,pass=?,email=?,phone=?,mobile=?,sample4_detail=?,sample4_postcode=?,sample4_roadAddress=?,sample4_jibunAddress=? where id=?";
			  pstmt=con.prepareStatement(sql);
			pstmt.setString(1,bean.getName());
			pstmt.setString(2,bean.getPass());
			pstmt.setString(3,bean.getEmail());
//			pstmt.setString(4,bean.getAddress());
			pstmt.setString(4,bean.getPhone());
			pstmt.setString(5,bean.getMobile());
			pstmt.setString(6,bean.getSample4_detail());
			pstmt.setString(7,bean.getSample4_postcode());
			pstmt.setString(8,bean.getSample4_roadAddress());
			pstmt.setString(9,bean.getSample4_jibunAddress());
			pstmt.setString(10,bean.getId());
			
			
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (pstmt!=null) try{	pstmt.close();} catch (SQLException ex) {}
			if (con!=null)try {con.close();}catch (SQLException ex) {}
		}
		
	}


	public int idcheck(String id) {
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		 int check=0;
		try {
			con=getConnection();
			 String sql="select id from member where id=?"; 
			  pstmt=con.prepareStatement(sql);
			  pstmt.setString(1, id);
			  rs=pstmt.executeQuery();
			  if(rs.next()) {
				  if(id.equals(rs.getString("id"))) {
					  
					  check=1;
			  }else {
				  check=-1;
			  }
			  
		} 
		
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try {rs.close();}catch (SQLException ex) {}
			if (pstmt!=null) try{	pstmt.close();} catch (SQLException ex) {}
			if (con!=null)try {con.close();}catch (SQLException ex) {}
		}
		
	
		
		return check;
		
		
	}




}//�겢�옒�뒪 �걹

