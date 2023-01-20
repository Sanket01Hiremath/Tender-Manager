package Vendor;

import java.util.Scanner;

import Exception.UserException;
import Exception.tenderException;
import Interface.Methods;
import Interface.Methods_Impl;

public class deleteBids {
	public void DeleteBids(int id) throws UserException, tenderException {
		System.out.println(":-----------------------------: Open Tenders");
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID  : ");
		int tid=sc.nextInt();
		m.deleteBid(tid, id);
		VendorMenu vm=new VendorMenu();
		vm.Vmenu(id);
	}
}
