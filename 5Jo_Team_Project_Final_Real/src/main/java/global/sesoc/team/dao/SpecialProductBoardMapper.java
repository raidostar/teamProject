package global.sesoc.team.dao;

import java.util.List;

import global.sesoc.team.vo.Products;

public interface SpecialProductBoardMapper {

	List<Products> everyProductList();

	List<Products> allProductList(String productsLocation);

	List<Products> productDetail(int productsNum);

}