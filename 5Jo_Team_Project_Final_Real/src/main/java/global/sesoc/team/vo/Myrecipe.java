package global.sesoc.team.vo;

public class Myrecipe {

	private String userId;		//유저 아이디
	private int boardNum;		//게시판 번호

	public Myrecipe() {
		super();
	}

	public Myrecipe(String userId, int boardNum) {
		super();
		this.userId = userId;
		this.boardNum = boardNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	@Override
	public String toString() {
		return "Myrecipe [userId=" + userId + ", boardNum=" + boardNum + "]";
	}

}
