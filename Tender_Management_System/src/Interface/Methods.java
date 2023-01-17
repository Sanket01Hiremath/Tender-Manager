package Interface;

import java.util.List;

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
}
