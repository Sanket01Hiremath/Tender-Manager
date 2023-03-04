package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exceptions.BidException;
import com.example.Exceptions.TenderException;
import com.example.Exceptions.UserException;
import com.example.Repositories.BidsRepository;
import com.example.Repositories.TendersRepository;
import com.example.Repositories.UserRepository;
import com.example.entities.Bids;
import com.example.entities.Tenders;
import com.example.entities.Users;

@Service
public class VendorServicesImpl implements VendorServices{
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BidsRepository bidRepo;
	@Autowired
	private TendersRepository tendersRepo;
	
	private Users user;
	
	@Override
	public Users Login(String u, String p) throws UserException {
		Users foundUser=userRepo.findAllByusername(u);
		if(foundUser!=null) {
			this.user=foundUser;
			return foundUser;
		}else {
			throw new UserException("Error: UserNotFound!");
		}
	}
	
	@Override
	public void Logout() throws UserException {
		if(user!=null) {
			this.user=null;
		}else {
			throw new UserException("Error: UserNotLogedIn!");
		}
	}
	
	@Override
	public Bids addNewBid(Bids b,Integer tid) throws TenderException, UserException {
		if(user==null) {
			throw new UserException("Error: UserNotLogedIn!");
		}
		Tenders t=tendersRepo.findById(tid).orElseThrow(()-> new TenderException("Error: TenderNotFound!"));
		List<Bids> list=bidRepo.findBidsByvendor(user).stream().filter(i->i.getTender().equals(t)).toList();
		System.out.println(list.size());
		if(list.size()==0) {
			b.setVendor(user);
			b.setTender(t);
			return bidRepo.save(b);
		}else {
			list.get(0).setBidAmount(b.getBidAmount());
			list.get(0).setTender(t);
			list.get(0).setVendor(user);
			return bidRepo.save(list.get(0));
		}
	}

	@Override
	public List<Bids> getAllBids() throws BidException, UserException {
		if(user==null) {
			throw new UserException("Error: UserNotLogedIn!");
		}
		List<Bids> list=bidRepo.findBidsByvendor(user);
		if(list.isEmpty()) {
			throw new BidException("Error: BidsNotFound!");
		}else {
			return list;
		}
	}

	@Override
	public Bids updateBid(Bids b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bids DeleteBid(Bids b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tenders> getAllTenders() throws TenderException, UserException {
		if(user==null) {
			throw new UserException("Error: UserNotLogedIn!");
		}
		List<Tenders> list=tendersRepo.findByVendor(user);
		if(list.isEmpty()) {
			throw new TenderException("Error: TendersNotFound!");
		}else {
			return list;
		}
	}

	

	

}
