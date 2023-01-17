package Administrator;

import java.util.List;

import Beans.user;
import Exception.UserException;
import Exception.tenderException;
import Interface.Methods;
import Interface.Methods_Impl;

public class AllVendors {

	public void getVendors(int id) throws UserException, tenderException {
		System.out.println(":------------------------------: All Vendors");
		Methods m=new Methods_Impl();
		List<user> list=m.getAllVendors();
		for(user i:list) {
			System.out.println("Vendor ID      : "+i.getId());
			System.out.println("Vendor Name    : "+i.getUsername());
			System.out.println("Vendor Password: "+i.getPassword());
			System.out.println(":------------------------------------------:");
		}
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
	
}
