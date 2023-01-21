package Vendor;

import java.util.Scanner;

import Exception.UserException;
import Exception.tenderException;
import Interface.Methods;
import Interface.Methods_Impl;

public class updatePassword {
	public void UpdatePassword(int id) throws UserException, tenderException {
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter New Password: ");
		String pass=sc.next();
		m.UpdatePassword(id, pass);
		VendorMenu vm=new VendorMenu();
		vm.Vmenu(id);
	}
}
