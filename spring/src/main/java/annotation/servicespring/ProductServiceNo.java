package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service1")
public class ProductServiceNo implements ProductService {
	@Autowired
	ProductDAO dao;
	
//	public void setDao(ProductDAO dao) {
//		this.dao = dao;
//	}

	@Override
	public ProductVO sell() {
		System.out.println("정상판매중입니다.");
		return dao.sell(0.0, 5);
		
	}

}
