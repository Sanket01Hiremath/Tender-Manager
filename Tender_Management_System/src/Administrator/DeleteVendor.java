package Administrator;

import java.util.Scanner;

import Exception.UserException;
import Exception.tenderException;
import Interface.Methods;
import Interface.Methods_Impl;

public class DeleteVendor {
	public void deleteVendor(int id) throws UserException, tenderException {
		System.out.println(":---------------------------: Delete Vendors");
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter VendorID: ");
		int Vid=sc.nextInt();
		m.deleteVendor(Vid);;
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
