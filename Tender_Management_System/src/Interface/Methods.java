package Interface;

import Beans.user;
import Exception.UserException;

public interface Methods {
	public user login(String username,String password) throws UserException;
	public void NewVendor(user User);
}
