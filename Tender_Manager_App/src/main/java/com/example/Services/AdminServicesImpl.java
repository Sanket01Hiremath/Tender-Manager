package com.example.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.TenderException;
import com.example.Exceptions.UserException;
import com.example.Repositories.BidsRepository;
import com.example.Repositories.TendersRepository;
import com.example.Repositories.UserRepository;
import com.example.entities.Bids;
import com.example.entities.Tenders;
import com.example.entities.Users;

@Service
public class AdminServicesImpl implements AdminServices{
	@Autowired
	private TendersRepository tenderRepo;
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Tenders AddNewTender(Tenders t) throws TenderException {
		if(tenderRepo.findByname(t.getName())==null) {
			t.setStatus(1);
			t.setBids(new ArrayList<Bids>());
			return tenderRepo.save(t);
		}else {
			throw new TenderException("Tender already Present!");
		}
	}

	@Override
	public Users AddNewVendor(Users v) throws UserException {
		if(userRepo.findAllByusername(v.getUsername())==null) {
		v.setBids(new ArrayList<Bids>());
		v.setTenders(new ArrayList<Tenders>());
		return userRepo.save(v);
		}else {
			throw new UserException("Vendor is already Present!");
		}
	}

//	@Override
//	public List<Bids> getAllBids(Tenders t) {
//		return bidsRepo.findAll();
//	}

	@Override
	public List<Tenders> getAllTenders() throws TenderException {
		// TODO Auto-generated method stub
		List<Tenders> list= tenderRepo.findAll();
		if(list.isEmpty()) {
			throw new TenderException("No Tenders Are Present!");
		}else {
			return list;
		}
	}

	@Override
	public List<Users> getAllVendors() throws UserException {
		List<Users> list= userRepo.findAll();
		if(list.isEmpty()) {
			throw new UserException("No Vendors Are Present!");
		}else {
			return list;
		}
	}

//	@Override
//	public Tenders updateTender(Tenders t) {
//		return null;
//	}
//
//	@Override
//	public Users updateVendor(Users v) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Tenders deleteTender(Tenders t) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Users deleteVendor(Users v) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
