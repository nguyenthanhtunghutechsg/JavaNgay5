package LTJava.C5.Ngay5.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import LTJava.C5.Ngay5.Services.ProductServices;
import LTJava.C5.Ngay5.models.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductServices services;
	
	@RequestMapping("/products")
	public String Home(Model model) {
		List<Product> ListProducts = services.findAll();
		model.addAttribute("Products",ListProducts);
		return "products/index";
	}
}
