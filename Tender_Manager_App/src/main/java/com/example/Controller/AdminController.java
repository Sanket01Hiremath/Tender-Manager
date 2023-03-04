package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exceptions.TenderException;
import com.example.Exceptions.UserException;
import com.example.Services.AdminServices;
import com.example.Services.VendorServices;
import com.example.entities.Tenders;
import com.example.entities.Users;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
	public AdminServices adminService;
	
	@Autowired
	public VendorServices vendorService; 
	
	
	@PostMapping("/NewTender")
	public ResponseEntity<Tenders> AddNewTender(@RequestBody Tenders t) throws TenderException{
		Tenders saved=adminService.AddNewTender(t);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@PostMapping("/NewVendor")
	public ResponseEntity<Users> get(@RequestBody Users v) throws UserException{
		Users saved=adminService.AddNewVendor(v);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@GetMapping("/getTenders")
	public ResponseEntity<List<Tenders>> getAllTenders() throws TenderException{
		List<Tenders> list=adminService.getAllTenders();
		return new ResponseEntity<>(list,HttpStatus.FOUND);
	}
	
	@GetMapping("/getVendors")
	public ResponseEntity<List<Users>> getAllVendors() throws UserException{
		List<Users> list=adminService.getAllVendors();
		return new ResponseEntity<>(list,HttpStatus.FOUND);
	}
}
