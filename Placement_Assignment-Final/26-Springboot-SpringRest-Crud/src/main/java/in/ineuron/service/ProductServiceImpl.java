package in.ineuron.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IProductDao;
import in.ineuron.model.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao repo;

	@Override
	public Integer addProduct(Product product) {
		// TODO Auto-generated method stub
		return repo.save(product).getProductId();
	}

	@Override
	public Product getProductByName(String productName) {
		Product name = repo.findByProductName(productName);
		return name;
	}

	@Override
	public String updateProductByName(String productName, Double updatedPrice) {
		Product product = repo.findByProductName(productName);
		if (product != null) {
			product.setProductPrize(updatedPrice);
			return "updated price by Name";
		}
		return "Fail to Update";
	}

	@Override
	public String deleteByProductId(Integer productId) {

		Optional<Product> optional = repo.findById(productId);
		if (optional.isPresent()) {
			repo.deleteById(productId);
			return "Product get Deleted with id "+productId;
		}
		return "Failed to Edit the product";
	}

}
