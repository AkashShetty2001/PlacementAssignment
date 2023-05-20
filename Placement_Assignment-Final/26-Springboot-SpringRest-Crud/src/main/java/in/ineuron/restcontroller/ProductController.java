package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Product;
import in.ineuron.service.IProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private IProductService service;

	@PostMapping(value = "/add")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {

		String msg = "";

		Integer productId = service.addProduct(product);

		if (productId != null) {
			msg += "Product Details Saved Successfully with id :: " + productId;
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			msg += "Sorry for inconveinience but now we are not able to add product";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/get/{productName}")
	public ResponseEntity<?> getProductByName(@PathVariable String productName) {

		Product product = service.getProductByName(productName);

		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Product Not found by " + productName, HttpStatus.BAD_REQUEST);

	}

	@PutMapping(value = "/update/{productName}/{productPrize}")
	public ResponseEntity<String> updatePrice(@PathVariable String productName, @PathVariable Double productPrize) {

		String status = service.updateProductByName(productName, productPrize);

		if (status.equalsIgnoreCase("success")) {
			return new ResponseEntity<String>("Product price Updated Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Product Not exist with productname :: " + productName, HttpStatus.NOT_FOUND);

	}

	@DeleteMapping(value = "/del/{id}")
	public ResponseEntity<String> deleteByProductId(@PathVariable("id") Integer productId) {

		String status = service.deleteByProductId(productId);

		if (status.equalsIgnoreCase("success")) {

			return new ResponseEntity<String>("Product data with Id:: " + productId + " Deleted Successfully",
					HttpStatus.OK);
		}

		return new ResponseEntity<String>("Product Not exist with product Id :: " + productId, HttpStatus.NOT_FOUND);

	}

}
