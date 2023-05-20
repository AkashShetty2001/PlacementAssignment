package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.dto.ProductDto;
import in.ineuron.service.IProductService;
import in.ineuron.utils.AppConstants;
import in.ineuron.utils.PostResponse;

@RestController
@RequestMapping(value = "/api")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	
	 @PostMapping(value = "/add")
	  public ResponseEntity<String> addProdut(@RequestBody ProductDto productDto){
		  
		  Integer id = service.addProduct(productDto);
		  
		  if (id!=null) {
			  return new ResponseEntity<>("Success",HttpStatus.OK);
		}
		  
		  return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
		  
	  }
	

	    @GetMapping(value = "/getAll")
	    public ResponseEntity<?> getAllPosts(
	            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
	            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
	            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
	            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
	    ){
		   
		   PostResponse response = service.getAllProducts(pageNo, pageSize, sortBy, sortDir);
		   
	        return new ResponseEntity<>(response,HttpStatus.OK);
	    }

}
