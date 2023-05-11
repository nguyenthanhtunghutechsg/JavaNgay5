package LTJava.C5.Ngay5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import LTJava.C5.Ngay5.models.Product;
import LTJava.C5.Ngay5.models.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;
	@Autowired
	private ProductRepository productRepository;
	@Test
	public void TestCreate() {
		Product product = new Product();
		product.setName("Non Bao Hiem");
		product.setBrand("Non Son");
		product.setPrice(100000l);
		
		productRepository.save(product);
		Product selectProduct = testEntityManager.find(Product.class,product.getId());
		assertThat(product.getName()).isEqualTo(selectProduct.getName());
		
	}
}
