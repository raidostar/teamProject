package global.sesoc.team.vo;

public class Products {

	private int productsNum;			// 특산품 번호
	private String productsNameKor;		// 특산품 이름 한국어
	private String productsNameJap;		// 특산품 이름 일본어
	private String productsFeatureKor;	// 특산품 특징 한국어
	private String productsFeatureJap;	// 특산품 특징 일본어
	private String ProductsLocation;	// 특산품 위치
	private String ProductsPicture;		// 특산품 사진

	public Products() {
		super();
	}

	public Products(int productsNum, String productsNameKor, String productsNameJap, String productsFeatureKor,
			String productsFeatureJap, String productsLocation, String productsPicture) {
		super();
		this.productsNum = productsNum;
		this.productsNameKor = productsNameKor;
		this.productsNameJap = productsNameJap;
		this.productsFeatureKor = productsFeatureKor;
		this.productsFeatureJap = productsFeatureJap;
		ProductsLocation = productsLocation;
		ProductsPicture = productsPicture;
	}

	public int getProductsNum() {
		return productsNum;
	}

	public void setProductsNum(int productsNum) {
		this.productsNum = productsNum;
	}

	public String getProductsNameKor() {
		return productsNameKor;
	}

	public void setProductsNameKor(String productsNameKor) {
		this.productsNameKor = productsNameKor;
	}

	public String getProductsNameJap() {
		return productsNameJap;
	}

	public void setProductsNameJap(String productsNameJap) {
		this.productsNameJap = productsNameJap;
	}

	public String getProductsFeatureKor() {
		return productsFeatureKor;
	}

	public void setProductsFeatureKor(String productsFeatureKor) {
		this.productsFeatureKor = productsFeatureKor;
	}

	public String getProductsFeatureJap() {
		return productsFeatureJap;
	}

	public void setProductsFeatureJap(String productsFeatureJap) {
		this.productsFeatureJap = productsFeatureJap;
	}

	public String getProductsLocation() {
		return ProductsLocation;
	}

	public void setProductsLocation(String productsLocation) {
		ProductsLocation = productsLocation;
	}

	public String getProductsPicture() {
		return ProductsPicture;
	}

	public void setProductsPicture(String productsPicture) {
		ProductsPicture = productsPicture;
	}

	@Override
	public String toString() {
		return "Products [productsNum=" + productsNum + ", productsNameKor=" + productsNameKor + ", productsNameJap="
				+ productsNameJap + ", productsFeatureKor=" + productsFeatureKor + ", productsFeatureJap="
				+ productsFeatureJap + ", ProductsLocation=" + ProductsLocation + ", ProductsPicture=" + ProductsPicture
				+ "]";
	}

}
