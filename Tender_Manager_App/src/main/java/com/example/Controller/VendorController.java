package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exceptions.BidException;
import com.example.Exceptions.TenderException;
import com.example.Exceptions.UserException;
import com.example.Services.VendorServices;
import com.example.entities.Bids;
import com.example.entities.Tenders;
import com.example.entities.Users;

@RestController
public class VendorController {
	@Autowired
	private VendorServices vendorService;
	
	@PostMapping("/Login")
	public ResponseEntity<Users> Login(@RequestParam("username") String username,@RequestParam("password") String password) throws UserException{
		Users user=vendorService.Login(username, password);
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/Logout")
	public ResponseEntity<String> Logout() throws UserException{
		vendorService.Logout();
		return new ResponseEntity<>("LogOutSuccess",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getBids")
	public ResponseEntity<List<Bids>> getAllBids() throws BidException, UserException{
		List<Bids> list=vendorService.getAllBids();
		return new ResponseEntity<>(list,HttpStatus.FOUND);
	}
	
	@GetMapping("/getTenders")
	public ResponseEntity<List<Tenders>> getAlltenders() throws TenderException, UserException{
		List<Tenders> list=vendorService.getAllTenders();
		return new ResponseEntity<>(list,HttpStatus.FOUND);
	}
	
	@PostMapping("/NewBid")
	public ResponseEntity<Bids> addNewBid(@RequestBody Bids b,@RequestParam("TenderId") Integer Tid) throws TenderException, UserException{
		Bids bid=vendorService.addNewBid(b, Tid);
		return new ResponseEntity<>(bid,HttpStatus.CREATED);
	}
	
}
