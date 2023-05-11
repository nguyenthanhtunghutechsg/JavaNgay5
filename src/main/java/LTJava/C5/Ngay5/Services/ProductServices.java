package LTJava.C5.Ngay5.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LTJava.C5.Ngay5.models.Product;
import LTJava.C5.Ngay5.models.ProductRepository;

@Service
@Transactional
public class ProductServices {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Product get(Integer ID) {
		return productRepository.findById(ID).get();
	}

}
