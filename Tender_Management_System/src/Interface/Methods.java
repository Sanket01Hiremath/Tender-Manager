package Interface;

import java.util.List;

import Beans.Bid;
import Beans.tender;
import Beans.user;
import Exception.UserException;
import Exception.tenderException;

public interface Methods {
	public void login(String username,String password) throws UserException, tenderException;
	public void NewVendor(user User) throws UserException, tenderException;
	public List<user> getAllVendors() throws UserException;
	public void NewTender(tender t,int id) throws UserException, tenderException;
	public List<tender> getAllTenders() throws tenderException;
	public List<Bid> getAllBids(int id);
	public int[] MaxBid(int id);
	public void assignTender(int Tid,int Vid,int bidPrice);
	public void deleteTender(int Tid);
	public void deleteVendor(int Vid);
	public void deleteBidByTid(int tid);
	public void deleteBidByVid(int vid);
	public void deleteBid(int vid,int tid);
	public List<tender> openTenders();
	public void placeBid(int tid,int vid,int amount);
	public List<Bid> AllBidsOfVendor(int tid,int vid);
	public List<tender> AllTendersOfVendor(int id);
	
}
