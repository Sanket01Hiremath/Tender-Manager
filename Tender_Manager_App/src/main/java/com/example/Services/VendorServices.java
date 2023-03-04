package com.example.Services;

import java.util.List;

import com.example.Exceptions.BidException;
import com.example.Exceptions.TenderException;
import com.example.Exceptions.UserException;
import com.example.entities.Bids;
import com.example.entities.Tenders;
import com.example.entities.Users;

public interface VendorServices {
	public Users Login(String u,String p)throws UserException;
	public void Logout()throws UserException;
	public Bids addNewBid(Bids b,Integer tid)throws TenderException,UserException;
	public List<Bids> getAllBids()throws BidException,UserException;
	public Bids updateBid(Bids b)throws BidException,UserException;
	public Bids DeleteBid(Bids b)throws BidException,UserException;
	public List<Tenders> getAllTenders()throws TenderException,UserException;
}
