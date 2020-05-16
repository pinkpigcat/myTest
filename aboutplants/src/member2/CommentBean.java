package member2;

import java.sql.Timestamp;

public class CommentBean {
	private int comment_num;
	private int comment_board_num;
	private String comment_id;
	private Timestamp comment_date;
	private int comment_p;
	private String comment_content;
	
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getComment_board_num() {
		return comment_board_num;
	}
	public void setComment_board_num(int comment_board_num) {
		this.comment_board_num = comment_board_num;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public Timestamp getComment_date() {
		return comment_date;
	}
	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}
	public int getComment_p() {
		return comment_p;
	}
	public void setComment_p(int comment_p) {
		this.comment_p = comment_p;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	
	
}
