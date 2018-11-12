package global.sesoc.team.vo;

public class MovieLike {
	
	private String userId;
	private int boardNum;
	private int point;
	public MovieLike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieLike(String userId, int boardNum, int point) {
		super();
		this.userId = userId;
		this.boardNum = boardNum;
		this.point = point;
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
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "MovieLike [userId=" + userId + ", boardNum=" + boardNum + ", point=" + point + "]";
	}

}
