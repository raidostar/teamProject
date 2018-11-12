package global.sesoc.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import global.sesoc.team.dao.SpecialProductBoardRepository;
import global.sesoc.team.vo.Products;

@Controller
public class SpecialProductBoardController {

	@Autowired
	SpecialProductBoardRepository specialProductrepository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody List<Products> productList(String productsLocation) {
		System.out.println(productsLocation);
		if(productsLocation.equals("Shinjuku")) {
			System.out.println(productsLocation);
			List<Products> everyProList = specialProductrepository.everyProductList();
			return everyProList;
		}else {
		System.out.println(productsLocation);
		List<Products> allProList = specialProductrepository.allProductList(productsLocation);
		System.out.println(allProList);

		return allProList;}
	}

	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public @ResponseBody List<Products> getReplyList(int productsNum) {
		System.out.println(productsNum);
		List<Products> productDetailList = specialProductrepository.productDetail(productsNum);
		System.out.println(productDetailList);

		return productDetailList;
	}
	@RequestMapping(value = "/productsAll", method = RequestMethod.GET)
	public @ResponseBody List<Products> getAllReplyList() {
		List<Products> everyProList = specialProductrepository.everyProductList();
		System.out.println(everyProList);

		return everyProList;
	}
}
