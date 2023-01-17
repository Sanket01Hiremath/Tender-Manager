package Administrator;

import java.util.Scanner;

import Beans.user;
import Exception.UserException;
import Exception.tenderException;
import Interface.Methods;
import Interface.Methods_Impl;

public class newVendor {

	public void addNewVendor() throws UserException, tenderException {
		Methods m=new Methods_Impl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println(":----------------------: Register New Vendor");
		System.out.print("ID      : ");
		int id=sc.nextInt();
		System.out.print("UserName: ");
		String name=sc.next();
		System.out.print("Password: ");
		String pass=sc.next();
		int type=2;
		
		user u=new user(id,name,pass,type);
		m.NewVendor(u);
	}

}
