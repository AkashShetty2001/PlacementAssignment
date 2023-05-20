package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IProductDao;
import in.ineuron.dto.ProductDto;
import in.ineuron.model.Product;
import in.ineuron.utils.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao repo;

	@Override
	public PostResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir) {
		   Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
	                : Sort.by(sortBy).descending();
		   


	        // create Pageable instance
		    Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

	         Page<Product> products = repo.findAll(pageable);

	        // get content for page object
	        List<Product> listOfProduct = products.getContent();
	        

	        List<ProductDto> content= listOfProduct.stream().map(p -> mapToDTO(p)).collect(Collectors.toList());

	        PostResponse postResponse = new PostResponse();
	        postResponse.setContent(content);
	        postResponse.setPageNo(products.getNumber());
	        postResponse.setPageSize(products.getSize());
	        postResponse.setTotalElements(products.getTotalElements());
	        postResponse.setTotalPages(products.getTotalPages());
	        postResponse.setLast(products.isLast());

	        return postResponse;
	}
	
	
	 private ProductDto mapToDTO(Product product){
		 ProductDto productDto = new ProductDto();
		 productDto.setProductId(product.getProductId());
		 productDto.setProductName(product.getProductName());
		 productDto.setProductPrize(product.getProductPrize());
	        return productDto;
	    }


	@Override
	public Integer addProduct(ProductDto productDto) {
    
		 Product product = mapToEntity(productDto);

		return repo.save(product).getProductId();
	}

	    // convert DTO to entity
	    private Product mapToEntity(ProductDto productDto){
	        Product product = new Product();
	       
	        product.setProductId(productDto.getProductId());
	        product.setProductName(productDto.getProductName());
	        product.setProductPrize(productDto.getProductPrize());
	        
	       return product;
	    }

	

}
