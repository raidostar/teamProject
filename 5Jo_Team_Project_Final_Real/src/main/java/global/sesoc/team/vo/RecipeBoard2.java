package global.sesoc.team.vo;

import java.util.List;
import java.util.Map;

public class RecipeBoard2 {
	private int boardNum;
	private String title;
	private List<String> metarial;
	private List<String> amount;
	private List<String> recipe;
	private String category;
	private int hitcount;
	private String imglink;
	private String tips;
	private String regdate;
	public RecipeBoard2() {
		super();
	}
	public RecipeBoard2(int boardNum, String title, List<String> metarial, List<String> amount, List<String> recipe,
			String category, int hitcount, String imglink, String tips, String regdate) {
		super();
		this.boardNum = boardNum;
		this.title = title;
		this.metarial = metarial;
		this.amount = amount;
		this.recipe = recipe;
		this.category = category;
		this.hitcount = hitcount;
		this.imglink = imglink;
		this.tips = tips;
		this.regdate = regdate;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getMetarial() {
		return metarial;
	}
	public void setMetarial(List<String> metarial) {
		this.metarial = metarial;
	}
	public List<String> getAmount() {
		return amount;
	}
	public void setAmount(List<String> amount) {
		this.amount = amount;
	}
	public List<String> getRecipe() {
		return recipe;
	}
	public void setRecipe(List<String> recipe) {
		this.recipe = recipe;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public String getImglink() {
		return imglink;
	}
	public void setImglink(String imglink) {
		this.imglink = imglink;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "RecipeBoard2 [boardNum=" + boardNum + ", title=" + title + ", metarial=" + metarial + ", amount="
				+ amount + ", recipe=" + recipe + ", category=" + category + ", hitcount=" + hitcount + ", imglink="
				+ imglink + ", tips=" + tips + ", regdate=" + regdate + "]";
	}
	
}
