package global.sesoc.team.vo;

public class Wishlist {
	private int boardNum;
	private String userId;
	
	
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wishlist(int boardNum, String userId) {
		super();
		this.boardNum = boardNum;
		this.userId = userId;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Wishlist [boardNum=" + boardNum + ", userId=" + userId + "]";
	}



}
