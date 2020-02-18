package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//dao 클래스 권장 (@Component : 모든 클래스 권장) 
@Repository
public class ProductDAO {

	@Autowired
	//@Qualifier("v")
	ProductVO vo; //1.ProductVO 객체 (이름 X) "자동전달"

//	public void setVo(ProductVO vo) {
//		this.vo = vo;
//	}
	
	public ProductVO sell(double sale, int coupon) {
		//ProductVO vo = new ProductVO();
		//vo.setCode(100);
		//vo.setName("멀티컴퓨터");
		//vo.setPrice(1000000);
		vo.setSale(sale);
		vo.setCoupon(coupon);
		return vo;
	}
}





