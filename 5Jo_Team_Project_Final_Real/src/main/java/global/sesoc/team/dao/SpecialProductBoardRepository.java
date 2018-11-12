package global.sesoc.team.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.team.vo.Products;

@Repository
public class SpecialProductBoardRepository {

	@Autowired
	SqlSession session;

	public List<Products> everyProductList() {
		List<Products> list = new ArrayList<Products>();
		SpecialProductBoardMapper mapper = session.getMapper(SpecialProductBoardMapper.class);
		list = mapper.everyProductList();
		return list;
	}

	public List<Products> allProductList(String productsLocation) {
		List<Products> list = new ArrayList<Products>();
		SpecialProductBoardMapper mapper = session.getMapper(SpecialProductBoardMapper.class);
		list = mapper.allProductList(productsLocation);
		return list;
	}

	public List<Products> productDetail(int productsNum) {
		List<Products> list = new ArrayList<Products>();
		SpecialProductBoardMapper mapper = session.getMapper(SpecialProductBoardMapper.class);
		list = mapper.productDetail(productsNum);
		return list;
	}

}
