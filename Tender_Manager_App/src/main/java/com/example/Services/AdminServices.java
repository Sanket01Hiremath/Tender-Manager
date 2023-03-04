package com.example.Services;

import java.util.List;

import com.example.Exceptions.TenderException;
import com.example.Exceptions.UserException;
import com.example.entities.Tenders;
import com.example.entities.Users;

public interface AdminServices {
//	public List<Bids> getAllBids(Tenders t);
	public List<Tenders> getAllTenders() throws TenderException;
	public List<Users> getAllVendors() throws UserException;
//	public Tenders updateTender(Tenders t);
//	public Users updateVendor(Users v);
//	public Tenders deleteTender(Tenders t);
//	public Users deleteVendor(Users v);
	public Tenders AddNewTender(Tenders t) throws TenderException;
	public Users AddNewVendor(Users v) throws UserException;
}
