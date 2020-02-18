package servicespring;

public class ProductServiceNo implements ProductService {
	ProductDAO dao;
	
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public ProductVO sell() {
		System.out.println("정상판매중입니다.");
		return dao.sell(0.0, 5);
		
	}

}
