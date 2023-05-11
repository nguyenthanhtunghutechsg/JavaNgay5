package LTJava.C5.Ngay5.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import LTJava.C5.Ngay5.Services.ProductServices;
import LTJava.C5.Ngay5.models.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductServices services;

	@RequestMapping("/products")
	public String Home(Model model) {
		List<Product> ListProducts = services.findAll();
		model.addAttribute("Products", ListProducts);
		return "products/index";
	}

	@RequestMapping("/products/create")
	public String Create(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "products/create";
	}

	@RequestMapping(value = "/products/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		services.save(product);
		return "redirect:/products";
	}
}
