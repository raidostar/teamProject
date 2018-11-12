package global.sesoc.team.vo;

public class RecipeBoard {
   private int boardNum;
   private String title;
   private String material;
   private String amount;
   private String recipe;
   private String category;
   private int hitcount;
   private String imglink;
   private String tips;
   private String regdate;
   public RecipeBoard() {
      super();
   }
   public RecipeBoard(int boardNum, String title, String material, String amount, String recipe, String category,
         int hitcount, String imglink, String tips, String regdate) {
      super();
      this.boardNum = boardNum;
      this.title = title;
      this.material = material;
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
   public String getMaterial() {
      return material;
   }
   public void setMaterial(String material) {
      this.material = material;
   }
   public String getAmount() {
      return amount;
   }
   public void setAmount(String amount) {
      this.amount = amount;
   }
   public String getRecipe() {
      return recipe;
   }
   public void setRecipe(String recipe) {
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
      return "RecipeBoard [boardNum=" + boardNum + ", title=" + title + ", material=" + material + ", amount="
            + amount + ", recipe=" + recipe + ", category=" + category + ", hitcount=" + hitcount + ", imglink="
            + imglink + ", tips=" + tips + ", regdate=" + regdate + "]";
   }
   
   public String sendResult() {
      //String temp = material.replace("?", ":");
      String[] m = material.split(" ");
      String leng = "";
      for( String i : m) {
         leng += i+"\n";
      }
      System.out.println(leng);
      
      String[] a = amount.split(" ");
      leng = "";
      for( String i : a) {
         leng += i+"\n";
      }
      System.out.println(leng);
      
      //String temp2 = recipe.replace("?", "$");
      String[] r = recipe.split(" ");
      leng = "";
      for( String i : r) {
         leng += i+"\n";
      }
      System.out.println(leng);
      
      System.out.println(m+", "+a+", "+r);
      
      String result ="";
      String recipeR = "";

      for(int i = 0; i<m.length; i++) {
         result += m[i]+" : "+a[i]+"  ";
      };
      
      for(int i = 0; i<r.length; i++) {
         recipeR += (i+1)+". "+r[i]+"\n";
      };
      
      return "<title>\n"+ title + "\n\n<material>\n"+result+ "\n\n<recipe>\n"+recipeR+"\n 더 많은 레시피는 www.recipe.co.kr";
   }

}