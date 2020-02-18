package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service3")
public class ProductService05 implements ProductService {
	@Autowired //<bean태그 x, @Repository
	ProductDAO dao;//타입 동일 객체 자동 전달
	
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public ProductVO sell() {
		System.out.println("5월은 30% 세일중입니다.");
		return dao.sell(0.3, 1);
		
	}

}
