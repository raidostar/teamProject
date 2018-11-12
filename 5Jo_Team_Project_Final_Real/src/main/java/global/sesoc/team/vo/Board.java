 	package global.sesoc.team.vo;

 public class Board {

 		private int boardNum;			// 게시판 번호
 		private String userId;			// 유저 ID
 		private String title;			// 게시판 제목
 		private String content;			// 게시판 내용
 		private int hitCount;			// 게시판 조회수
 		private String savedFile;		// 첨부파일
 		private String originalFile;	// 파일
 		private int point;				// 포인트
 		private String regdate;			// 글 쓴 시간
 		private boolean like;			// like 갯수
 		private int best;				// best
 		
 		
		public Board() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public Board(int boardNum, String userId, String title, String content, int hitCount, String savedFile,
				String originalFile, int point, String regdate, boolean like, int best) {
			super();
			this.boardNum = boardNum;
			this.userId = userId;
			this.title = title;
			this.content = content;
			this.hitCount = hitCount;
			this.savedFile = savedFile;
			this.originalFile = originalFile;
			this.point = point;
			this.regdate = regdate;
			this.like = like;
			this.best = best;
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
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public int getHitCount() {
			return hitCount;
		}
		public void setHitCount(int hitCount) {
			this.hitCount = hitCount;
		}
		public String getSavedFile() {
			return savedFile;
		}
		public void setSavedFile(String savedFile) {
			this.savedFile = savedFile;
		}
		public String getOriginalFile() {
			return originalFile;
		}
		public void setOriginalFile(String originalFile) {
			this.originalFile = originalFile;
		}
		public int getPoint() {
			return point;
		}
		public void setPoint(int point) {
			this.point = point;
		}
		public String getRegdate() {
			return regdate;
		}
		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}
		public boolean isLike() {
			return like;
		}
		public void setLike(boolean like) {
			this.like = like;
		}
		public int getBest() {
			return best;
		}
		public void setBest(int best) {
			this.best = best;
		}
		
		@Override
		public String toString() {
			return "Board [boardNum=" + boardNum + ", userId=" + userId + ", title=" + title + ", content=" + content
					+ ", hitCount=" + hitCount + ", savedFile=" + savedFile + ", originalFile=" + originalFile
					+ ", point=" + point + ", regdate=" + regdate + ", like=" + like + ", best=" + best + "]";
		}

 		
 		
 	}
