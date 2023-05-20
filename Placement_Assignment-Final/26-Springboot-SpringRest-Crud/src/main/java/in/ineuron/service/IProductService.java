package in.ineuron.service;
import in.ineuron.model.Product;

public interface IProductService {
	public Integer addProduct(Product product);

	public Product getProductByName(String productName);

	public String updateProductByName(String productName, Double updatedPrice);

	public String deleteByProductId(Integer productId);

}
