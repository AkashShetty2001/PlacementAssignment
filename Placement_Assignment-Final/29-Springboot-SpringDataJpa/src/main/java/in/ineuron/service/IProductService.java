package in.ineuron.service;

import in.ineuron.dto.ProductDto;
import in.ineuron.utils.PostResponse;

public interface IProductService {
	public Integer addProduct(ProductDto productDto);

	public PostResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir);

}
