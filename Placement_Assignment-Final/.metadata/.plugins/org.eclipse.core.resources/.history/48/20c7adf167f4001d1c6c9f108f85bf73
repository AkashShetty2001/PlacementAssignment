package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristService;
import lombok.Delegate;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
	
	@Autowired
	private ITouristService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		try {
			String resultMsg = service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Problem in tourist Enrollment",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayTouristDetails(){
		try {
			 List<Tourist> list = service.fetchAllDetails();
			 list.forEach(System.out::println);
			return new ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("Problem in fetching tourist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{tid}")
	public ResponseEntity<?> displayTouristById(@PathVariable Integer tid){
		try {
			Tourist tourist = service.fetchTouristById(tid);
			System.out.println(tourist);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){
		try {
			String msg = service.updateTouristDetails(tourist);
			System.out.println(msg);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/budgetmodify/{id}/{hike}")
	public ResponseEntity<String> updateTouristById(@PathVariable("id") Integer id,@PathVariable("hike")  Float hikePercent){
		try {
			String msg = service.updateTouristById(id, hikePercent);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> removeTouristById(@PathVariable("id") Integer id) {
		try {
			String msg = service.deleteTouristById(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
