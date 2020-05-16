package member2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




public class BoardDAO {
	
	
	
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
	
	
	public int getBoardCount() {
		
		int count=0;
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		
		 try {
				con=getConnection();
				
		String sql="select num from board";
		 pstmt=con.prepareStatement(sql);
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
	
	
	//boardFile
	public int getBoardCountFile() {
		
		int count=0;
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		
		 try {
				con=getConnection();
				
		String sql="select num from boardFile";
		 pstmt=con.prepareStatement(sql);
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
	
	
	
	//image count
	public int getBoardCountImage() {
		
		int count=0;
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		
		 try {
				con=getConnection();
				
		String sql="select num from boardImage";
		 pstmt=con.prepareStatement(sql);
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
	
	
	
	
	//getboardcount �삤踰꾨줈�뵫
	public int getBoardCount(String search) {
		
		int count=0;
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		
		 try {
				con=getConnection();
				
		String sql="select num from board where subject like ?";
		 pstmt=con.prepareStatement(sql);
		 pstmt.setString(1, "%"+search+"%");
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
	
	
	
	public List getboardlist(int startRow,int pageSize) {//湲�紐⑹삦�씠湲곕븣臾몄뿉 諛곗뿴�뿉 �떞�븘�꽌 諛섑솚�븳 �썑 由ъ뒪�듃�솕硫댁뿉�꽌 �븯�굹�븯�굹 異쒕젰
		 //理쒓렐湲��씠 �젣�씪 �쐞履쎌뿉 �엳�쓣�닔 �엳寃� num�쓣 湲곗��쑝濡� �궡由쇱감�닚 �빐�빞�븳�떎 
			 Connection con=null;
			 PreparedStatement pstmt=null;
			 ResultSet rs = null;
			List list = new ArrayList();
			
			try {
				
				con=getConnection();
				
				
//				String sql="select * from board order by num desc";
				//num湲곗��쑝濡� �궡由쇱감�닚, 
				String sql="select * from board order by num desc limit ?,?";
				// limit�뒗 吏��젙�븳 媛��닔留뚰겮 吏ㅻ씪�꽌 蹂댁뿬以꾩닔�엳�떎 
				//sql�뿉留� �엳怨� �삤�씪�겢�뿉�뒗 �뾾�떎
				//�떆�옉�뻾 1 �걹�굹�뒗�뻾 10 �씠�씪怨� �뻽�쓣�븣 �떆�옉�뻾 1遺��꽣 吏ㅻ젮�꽌 2遺��꽣 �굹�삤誘�濡� -1�쓣 �빐以��떎
				
				 pstmt=con.prepareStatement(sql);
				 pstmt.setInt(1, startRow-1);//�떆�옉�뻾�씠 吏ㅻ젮�꽌 �삤湲곕븣臾몄뿉 -1�쓣 �빐以��떎 
				 pstmt.setInt(2, pageSize);
				 rs=pstmt.executeQuery();
				 
				 
				 while(rs.next()) {
					 BoardBean bean = new BoardBean();
					 bean.setNum(rs.getInt("num"));
					 bean.setName(rs.getString("name"));
					 bean.setSubject(rs.getString("subject"));
					 bean.setContent(rs.getString("content"));
					 bean.setDate(rs.getTimestamp("date"));
					 bean.setReadcount(rs.getInt("readcount"));
					 bean.setFile(rs.getString("file"));
					 list.add(bean);
				 }
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (rs!=null)try {rs.close();}catch (SQLException ex) {}
				if (pstmt!=null)try {pstmt.close();}catch (SQLException ex) {}
				if (con!=null)try {con.close();}catch (SQLException ex) {}
				
			}
			return list;
		}
	
	//boardFile
	public List getboardlistFile(int startRow,int pageSize) {//湲�紐⑹삦�씠湲곕븣臾몄뿉 諛곗뿴�뿉 �떞�븘�꽌 諛섑솚�븳 �썑 由ъ뒪�듃�솕硫댁뿉�꽌 �븯�굹�븯�굹 異쒕젰
		 //理쒓렐湲��씠 �젣�씪 �쐞履쎌뿉 �엳�쓣�닔 �엳寃� num�쓣 湲곗��쑝濡� �궡由쇱감�닚 �빐�빞�븳�떎 
			 Connection con=null;
			 PreparedStatement pstmt=null;
			 ResultSet rs = null;
			List list = new ArrayList();
			
			try {
				
				con=getConnection();
				
				
//				String sql="select * from board order by num desc";
				//num湲곗��쑝濡� �궡由쇱감�닚, 
				String sql="select * from boardFile order by num desc limit ?,?";
				// limit�뒗 吏��젙�븳 媛��닔留뚰겮 吏ㅻ씪�꽌 蹂댁뿬以꾩닔�엳�떎 
				//sql�뿉留� �엳怨� �삤�씪�겢�뿉�뒗 �뾾�떎
				//�떆�옉�뻾 1 �걹�굹�뒗�뻾 10 �씠�씪怨� �뻽�쓣�븣 �떆�옉�뻾 1遺��꽣 吏ㅻ젮�꽌 2遺��꽣 �굹�삤誘�濡� -1�쓣 �빐以��떎
				
				 pstmt=con.prepareStatement(sql);
				 pstmt.setInt(1, startRow-1);//�떆�옉�뻾�씠 吏ㅻ젮�꽌 �삤湲곕븣臾몄뿉 -1�쓣 �빐以��떎 
				 pstmt.setInt(2, pageSize);
				 rs=pstmt.executeQuery();
				 
				 
				 while(rs.next()) {
					 BoardBean bean = new BoardBean();
					 bean.setNum(rs.getInt("num"));
					 bean.setName(rs.getString("name"));
					 bean.setSubject(rs.getString("subject"));
					 bean.setContent(rs.getString("content"));
					 bean.setDate(rs.getTimestamp("date"));
					 bean.setReadcount(rs.getInt("readcount"));
					 bean.setFile(rs.getString("file"));
					 list.add(bean);
				 }
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (rs!=null)try {rs.close();}catch (SQLException ex) {}
				if (pstmt!=null)try {pstmt.close();}catch (SQLException ex) {}
				if (con!=null)try {con.close();}catch (SQLException ex) {}
				
			}
			return list;
		}
	
	
	
	
	//image board list
	public List getboardlistImage(int startRow,int pageSize) {//湲�紐⑹삦�씠湲곕븣臾몄뿉 諛곗뿴�뿉 �떞�븘�꽌 諛섑솚�븳 �썑 由ъ뒪�듃�솕硫댁뿉�꽌 �븯�굹�븯�굹 異쒕젰
		 //理쒓렐湲��씠 �젣�씪 �쐞履쎌뿉 �엳�쓣�닔 �엳寃� num�쓣 湲곗��쑝濡� �궡由쇱감�닚 �빐�빞�븳�떎 
			 Connection con=null;
			 PreparedStatement pstmt=null;
			 ResultSet rs = null;
			List list = new ArrayList();
			
			try {
				
				con=getConnection();
				
				
//				String sql="select * from board order by num desc";
				//num湲곗��쑝濡� �궡由쇱감�닚, 
				String sql="select * from boardImage order by num desc limit ?,?";
				// limit�뒗 吏��젙�븳 媛��닔留뚰겮 吏ㅻ씪�꽌 蹂댁뿬以꾩닔�엳�떎 
				//sql�뿉留� �엳怨� �삤�씪�겢�뿉�뒗 �뾾�떎
				//�떆�옉�뻾 1 �걹�굹�뒗�뻾 10 �씠�씪怨� �뻽�쓣�븣 �떆�옉�뻾 1遺��꽣 吏ㅻ젮�꽌 2遺��꽣 �굹�삤誘�濡� -1�쓣 �빐以��떎
				
				 pstmt=con.prepareStatement(sql);
				 pstmt.setInt(1, startRow-1);//�떆�옉�뻾�씠 吏ㅻ젮�꽌 �삤湲곕븣臾몄뿉 -1�쓣 �빐以��떎 
				 pstmt.setInt(2, pageSize);
				 rs=pstmt.executeQuery();
				 
				 
				 while(rs.next()) {
					 BoardBean bean = new BoardBean();
					 bean.setNum(rs.getInt("num"));
					 bean.setName(rs.getString("name"));
					 bean.setSubject(rs.getString("subject"));
					 bean.setContent(rs.getString("content"));
					 bean.setDate(rs.getTimestamp("date"));
					 bean.setReadcount(rs.getInt("readcount"));
					 bean.setFile(rs.getString("file"));
					 list.add(bean);
				 }
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (rs!=null)try {rs.close();}catch (SQLException ex) {}
				if (pstmt!=null)try {pstmt.close();}catch (SQLException ex) {}
				if (con!=null)try {con.close();}catch (SQLException ex) {}
				
			}
			return list;
		}
	
	
	
	
	
	
	
	
	//getvoardlist �삤踰꾨줈�뵫
	public List getboardlist(int startRow,int pageSize,String search) {//湲�紐⑹삦�씠湲곕븣臾몄뿉 諛곗뿴�뿉 �떞�븘�꽌 諛섑솚�븳 �썑 由ъ뒪�듃�솕硫댁뿉�꽌 �븯�굹�븯�굹 異쒕젰
		 //理쒓렐湲��씠 �젣�씪 �쐞履쎌뿉 �엳�쓣�닔 �엳寃� num�쓣 湲곗��쑝濡� �궡由쇱감�닚 �빐�빞�븳�떎 
			 Connection con=null;
			 PreparedStatement pstmt=null;
			 ResultSet rs = null;
			List list = new ArrayList();
			
			try {
				
				con=getConnection();
				
				
//				String sql="select * from board order by num desc";
				//num湲곗��쑝濡� �궡由쇱감�닚, 
				String sql="select * from board where subject like ? order by num desc limit ?,?";
				// limit�뒗 吏��젙�븳 媛��닔留뚰겮 吏ㅻ씪�꽌 蹂댁뿬以꾩닔�엳�떎 
				//sql�뿉留� �엳怨� �삤�씪�겢�뿉�뒗 �뾾�떎
				//�떆�옉�뻾 1 �걹�굹�뒗�뻾 10 �씠�씪怨� �뻽�쓣�븣 �떆�옉�뻾 1遺��꽣 吏ㅻ젮�꽌 2遺��꽣 �굹�삤誘�濡� -1�쓣 �빐以��떎
				
				 pstmt=con.prepareStatement(sql);
				 pstmt.setString(1, "%"+search+"%");
				 pstmt.setInt(2, startRow-1);//�떆�옉�뻾�씠 吏ㅻ젮�꽌 �삤湲곕븣臾몄뿉 -1�쓣 �빐以��떎 
				 pstmt.setInt(3, pageSize);
				 rs=pstmt.executeQuery();
				 
				 
				 while(rs.next()) {
					 BoardBean bean = new BoardBean();
					 bean.setNum(rs.getInt("num"));
					 bean.setName(rs.getString("name"));
					 bean.setSubject(rs.getString("subject"));
					 bean.setContent(rs.getString("content"));
					 bean.setDate(rs.getTimestamp("date"));
					 bean.setReadcount(rs.getInt("readcount"));
				
					 
					 list.add(bean);
				 }
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (rs!=null)try {rs.close();}catch (SQLException ex) {}
				if (pstmt!=null)try {pstmt.close();}catch (SQLException ex) {}
				if (con!=null)try {con.close();}catch (SQLException ex) {}
				
			}
			return list;
		}
	
	
	
	 public BoardBean getborad(int num) {
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		 
		 BoardBean bean = new BoardBean();
		 
		 
		 
		 try {
			 con=getConnection();
			 String sql="select * from board where num=?";
			 pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);    	
			 rs=pstmt.executeQuery();
			 
			 
			 

				if(rs.next()) {
				 bean.setNum(rs.getInt("num"));
				 bean.setName(rs.getString("name"));
				 bean.setSubject(rs.getString("subject"));
				 bean.setContent(rs.getString("content"));
				 bean.setDate(rs.getTimestamp("date"));
				 bean.setReadcount(rs.getInt("readcount"));
				 bean.setPass(rs.getString("pass"));
				 bean.setFile(rs.getString("file"));
				 
				}
 
} catch (Exception e) {
e.printStackTrace();
}finally {
if (rs!=null)try {rs.close();}catch (SQLException ex) {}
if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
if (con!=null)try {con.close();}catch (Exception ex) {}
}

return bean;
}		
	 
	 
				
		//getboardFile
 public BoardBean getboradFile(int num) {
					 Connection con=null;
					 PreparedStatement pstmt=null;
					 ResultSet rs = null;
					 
					 BoardBean bean = new BoardBean();
					 
					 
					 
					 try {
						 con=getConnection();
						 String sql="select * from boardFile where num=?";
						 pstmt=con.prepareStatement(sql);
						pstmt.setInt(1,num);    	
						 rs=pstmt.executeQuery();
						 
						 
						 

							if(rs.next()) {
							 bean.setNum(rs.getInt("num"));
							 bean.setName(rs.getString("name"));
							 bean.setSubject(rs.getString("subject"));
							 bean.setContent(rs.getString("content"));
							 bean.setDate(rs.getTimestamp("date"));
							 bean.setReadcount(rs.getInt("readcount"));
							 bean.setPass(rs.getString("pass"));
							 bean.setFile(rs.getString("file"));
							 
							}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs!=null)try {rs.close();}catch (SQLException ex) {}
			if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
			if (con!=null)try {con.close();}catch (Exception ex) {}
		}
		 
		 return bean;
	}

 
 
 
	//getboard image
public BoardBean getboradImage (int num) {
				 Connection con=null;
				 PreparedStatement pstmt=null;
				 ResultSet rs = null;
				 
				 BoardBean bean = new BoardBean();
				 
				 
				 
				 try {
					 con=getConnection();
					 String sql="select * from boardImage where num=?";
					 pstmt=con.prepareStatement(sql);
					pstmt.setInt(1,num);    	
					 rs=pstmt.executeQuery();
					 
					 
					 

						if(rs.next()) {
						 bean.setNum(rs.getInt("num"));
						 bean.setName(rs.getString("name"));
						 bean.setSubject(rs.getString("subject"));
						 bean.setContent(rs.getString("content"));
						 bean.setDate(rs.getTimestamp("date"));
						 bean.setReadcount(rs.getInt("readcount"));
						 bean.setPass(rs.getString("pass"));
						 bean.setFile(rs.getString("file"));
						 
						}
		 
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (rs!=null)try {rs.close();}catch (SQLException ex) {}
		if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
		if (con!=null)try {con.close();}catch (Exception ex) {}
	}
	 
	 return bean;
}

 
 
 
 

	public void getReadcount(int num) {
		
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 BoardBean bean = new BoardBean();
		try {
			 con=getConnection();
			
				String sql="update board set readcount=readcount+1 where num=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,num);   
				pstmt.executeUpdate();
			
		
			 
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
			if (con!=null)try {con.close();}catch (Exception ex) {}
		}
	}

	
	//getreadcountFile
	public void getReadcountFile(int num) {
		
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 BoardBean bean = new BoardBean();
		try {
			 con=getConnection();
			
				String sql="update boardFile set readcount=readcount+1 where num=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,num);   
				pstmt.executeUpdate();
			
		
			 
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
			if (con!=null)try {con.close();}catch (Exception ex) {}
		}
	}
	
	
	
	
	
	//getreadcount Image
	public void getReadcountImage(int num) {
		
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 BoardBean bean = new BoardBean();
		try {
			 con=getConnection();
			
				String sql="update boardImage set readcount=readcount+1 where num=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,num);   
				pstmt.executeUpdate();
			
		
			 
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
			if (con!=null)try {con.close();}catch (Exception ex) {}
		}
	}

	
	
	
	
	public void insertBoard(BoardBean bean) {
		
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;//select 援щЦ �궗�슜�떆 �븘�닔
		 int num =0;//寃뚯떆�뙋�뿉 湲��씠 �뾾�뒗 �긽�깭瑜� 媛먯븞�빐�꽌 0�쑝濡� 珥덇린�솕
		
		
		try {
			
			con=getConnection();
			
			String sql="select max(num) from board";
			 pstmt=con.prepareStatement(sql);
			 rs=pstmt.executeQuery();
			 if(rs.next()){
					num=rs.getInt("max(num)")+1; //寃뚯떆�뙋�뿉 湲��씠 �뾾�쓣�븣 湲곗� -> 0+1=1�씠 num�뿉 ���옣
				}
				sql="insert into board(num,name,pass,subject,content,readcount,date,file) values(?,?,?,?,?,?,?,?)";
				 pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,num ); //泥� 寃뚯떆湲��� 1遺��꽣 �떆�옉�븯寃뚮맂�떎
				pstmt.setString(2, bean.getName()); //留ㅺ컻蹂��닔濡� bean 媛앹껜瑜� 諛쏆븯湲� �븣臾몄뿉 爰쇰궡�꽌 db�뿉 ���옣
				pstmt.setString(3,bean.getPass());
				pstmt.setString(4, bean.getSubject());
				pstmt.setString(5, bean.getContent());
				pstmt.setInt(6,bean.getReadcount());
				pstmt.setTimestamp(7, bean.getDate());
				pstmt.setString(8, bean.getFile());

				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs!=null)try {rs.close();}catch (SQLException ex) {}
			if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
			if (con!=null)try {con.close();}catch (Exception ex) {}
		}
	}
	
	//fWrite
	public void insertBoardWrite(BoardBean bean) {
		
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;//select 援щЦ �궗�슜�떆 �븘�닔
		 int num =0;//寃뚯떆�뙋�뿉 湲��씠 �뾾�뒗 �긽�깭瑜� 媛먯븞�빐�꽌 0�쑝濡� 珥덇린�솕
		
		
		try {
			
			con=getConnection();
			
			String sql="select max(num) from boardFile";
			 pstmt=con.prepareStatement(sql);
			 rs=pstmt.executeQuery();
			 if(rs.next()){
					num=rs.getInt("max(num)")+1; //寃뚯떆�뙋�뿉 湲��씠 �뾾�쓣�븣 湲곗� -> 0+1=1�씠 num�뿉 ���옣
				}
				sql="insert into boardFile(num,name,pass,subject,content,readcount,date,file) values(?,?,?,?,?,?,?,?)";
				 pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,num ); //泥� 寃뚯떆湲��� 1遺��꽣 �떆�옉�븯寃뚮맂�떎
				pstmt.setString(2, bean.getName()); //留ㅺ컻蹂��닔濡� bean 媛앹껜瑜� 諛쏆븯湲� �븣臾몄뿉 爰쇰궡�꽌 db�뿉 ���옣
				pstmt.setString(3,bean.getPass());
				pstmt.setString(4, bean.getSubject());
				pstmt.setString(5, bean.getContent());
				pstmt.setInt(6,bean.getReadcount());
				pstmt.setTimestamp(7, bean.getDate());
				pstmt.setString(8, bean.getFile());

				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs!=null)try {rs.close();}catch (SQLException ex) {}
			if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
			if (con!=null)try {con.close();}catch (Exception ex) {}
		}
	}

	
	
	
	
	//Write image
	public void insertBoardImage(BoardBean bean) {
		
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;//select 援щЦ �궗�슜�떆 �븘�닔
		 int num =0;//寃뚯떆�뙋�뿉 湲��씠 �뾾�뒗 �긽�깭瑜� 媛먯븞�빐�꽌 0�쑝濡� 珥덇린�솕
		
		
		try {
			
			con=getConnection();
			
			String sql="select max(num) from boardImage";
			 pstmt=con.prepareStatement(sql);
			 rs=pstmt.executeQuery();
			 if(rs.next()){
					num=rs.getInt("max(num)")+1; //寃뚯떆�뙋�뿉 湲��씠 �뾾�쓣�븣 湲곗� -> 0+1=1�씠 num�뿉 ���옣
				}
				sql="insert into boardImage(num,name,pass,subject,content,readcount,date,file) values(?,?,?,?,?,?,?,?)";
				 pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,num ); //泥� 寃뚯떆湲��� 1遺��꽣 �떆�옉�븯寃뚮맂�떎
				pstmt.setString(2, bean.getName()); //留ㅺ컻蹂��닔濡� bean 媛앹껜瑜� 諛쏆븯湲� �븣臾몄뿉 爰쇰궡�꽌 db�뿉 ���옣
				pstmt.setString(3,bean.getPass());
				pstmt.setString(4, bean.getSubject());
				pstmt.setString(5, bean.getContent());
				pstmt.setInt(6,bean.getReadcount());
				pstmt.setTimestamp(7, bean.getDate());
				pstmt.setString(8, bean.getFile());

				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs!=null)try {rs.close();}catch (SQLException ex) {}
			if (pstmt!=null)try {pstmt.close();}catch (Exception ex) {}
			if (con!=null)try {con.close();}catch (Exception ex) {}
		}
	}

	
	
	
	
	
	
	public int updateboard(BoardBean bean) {
		Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		 	int check = 0;
		 	
		 	try {
		 		 con =getConnection();
					
				 String sql = "select * from board where num =?";
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1,bean.getNum());   
					
					 rs=pstmt.executeQuery();
					 String pass;
				if(rs.next()) {
				if (bean.getPass().equals(rs.getString("pass"))) {
					sql="update board set name=?,subject=?,content=?,file=? where num=?";
					
					pstmt=con.prepareStatement(sql); 
					pstmt.setString(1, bean.getName());
					pstmt.setString(2, bean.getSubject());
					pstmt.setString(3, bean.getContent());
					pstmt.setString(4, bean.getFile());
					pstmt.setInt(5, bean.getNum());
					
					pstmt.executeUpdate();
				
				 return check = 1;	
				}else {
					return check=0;
				}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				if(rs!=null)try {rs.close();}catch (SQLException ex) {}
				if (pstmt!=null) try{	pstmt.close();} catch (SQLException ex) {}
				if (con!=null)try {con.close();}catch (SQLException ex) {}
			}
			return check;
	}
	
	
	
	
	
	//updateboardfile
	public int updateboardFile(BoardBean bean) {
		Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		 	int check = 0;
		 	
		 	try {
		 		 con =getConnection();
					
				 String sql = "select * from boardFile where num =?";
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1,bean.getNum());   
					
					 rs=pstmt.executeQuery();
					 String pass;
				if(rs.next()) {
				if (bean.getPass().equals(rs.getString("pass"))) {
					sql="update boardFile set name=?,subject=?,content=?,file=? where num=?";
					
					pstmt=con.prepareStatement(sql); 
					pstmt.setString(1, bean.getName());
					pstmt.setString(2, bean.getSubject());
					pstmt.setString(3, bean.getContent());
					pstmt.setString(4, bean.getFile());
					pstmt.setInt(5, bean.getNum());
					
					pstmt.executeUpdate();
				
				 return check = 1;	
				}else {
					return check=0;
				}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				if(rs!=null)try {rs.close();}catch (SQLException ex) {}
				if (pstmt!=null) try{	pstmt.close();} catch (SQLException ex) {}
				if (con!=null)try {con.close();}catch (SQLException ex) {}
			}
			return check;
	}
	
	
	
	//updateboardfile image
		public int updateboardImage(BoardBean bean) {
			Connection con=null;
			 PreparedStatement pstmt=null;
			 ResultSet rs = null;
			 	int check = 0;
			 	
			 	try {
			 		 con =getConnection();
						
					 String sql = "select * from boardImage where num =?";
						pstmt=con.prepareStatement(sql);
						pstmt.setInt(1,bean.getNum());   
						
						 rs=pstmt.executeQuery();
						 String pass;
					if(rs.next()) {
					if (bean.getPass().equals(rs.getString("pass"))) {
						sql="update boardImage set name=?,subject=?,content=?,file=? where num=?";
						
						pstmt=con.prepareStatement(sql); 
						pstmt.setString(1, bean.getName());
						pstmt.setString(2, bean.getSubject());
						pstmt.setString(3, bean.getContent());
						pstmt.setString(4, bean.getFile());
						pstmt.setInt(5, bean.getNum());
						
						pstmt.executeUpdate();
					
					 return check = 1;	
					}else {
						return check=0;
					}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					if(rs!=null)try {rs.close();}catch (SQLException ex) {}
					if (pstmt!=null) try{	pstmt.close();} catch (SQLException ex) {}
					if (con!=null)try {con.close();}catch (SQLException ex) {}
				}
				return check;
		}
	
	
	
	
	
	

	public int deleteboard(int num,String pass) {
		Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		 	int check = 0;
		
		
		
		try {
			 con =getConnection();
				
			 String sql = "select * from board where num =?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,num);   
			
				 rs=pstmt.executeQuery();
				 if(rs.next()) {
						if (pass.equals(rs.getString("pass"))) {
							sql="delete from board where num=?";
							pstmt=con.prepareStatement(sql);
							pstmt.setInt(1,num); 
							pstmt.executeUpdate();
						check = 1;
						}
					}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	
	
	
	
//deleteboardfile
	public int deleteboardFile(int num,String pass) {
		Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs = null;
		 	int check = 0;
		try {
			 con =getConnection();
				
			 String sql = "select * from boardFile where num =?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,num);   
			
				 rs=pstmt.executeQuery();
				 if(rs.next()) {
						if (pass.equals(rs.getString("pass"))) {
							sql="delete from boardFile where num=?";
							pstmt=con.prepareStatement(sql);
							pstmt.setInt(1,num); 
							pstmt.executeUpdate();
						check = 1;
						}
					}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	
	
	
	
	//deleteboardfile image
		public int deleteboardimage(int num,String pass) {
			Connection con=null;
			 PreparedStatement pstmt=null;
			 ResultSet rs = null;
			 	int check = 0;
			try {
				 con =getConnection();
					
				 String sql = "select * from boardimage where num =?";
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1,num);   
				
					 rs=pstmt.executeQuery();
					 if(rs.next()) {
							if (pass.equals(rs.getString("pass"))) {
								sql="delete from boardimage where num=?";
								pstmt=con.prepareStatement(sql);
								pstmt.setInt(1,num); 
								pstmt.executeUpdate();
							check = 1;
							}
						}	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return check;
		}
		
		
		
	
	
	
	
	
	
	
}
