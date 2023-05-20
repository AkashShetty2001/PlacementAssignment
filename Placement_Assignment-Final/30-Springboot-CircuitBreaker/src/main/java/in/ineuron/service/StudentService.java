package in.ineuron.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class StudentService {
	
	 RestTemplate restTemplate = new RestTemplate();

	  @HystrixCommand(fallbackMethod = "fallBackService")
	  public String getAllStudents() {
	    URI uri = URI.create("http://localhost:8000/getAll");

	    return this.restTemplate.getForObject(uri, String.class);
	  }

	  public String fallBackService() {
	    return "fallback happen! server under maitainance please try after 5pm";
	  }

}