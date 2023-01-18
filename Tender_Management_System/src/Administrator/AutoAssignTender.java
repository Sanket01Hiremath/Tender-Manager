package Administrator;

import java.util.Scanner;

import Exception.UserException;
import Exception.tenderException;
import Interface.Methods;
import Interface.Methods_Impl;

public class AutoAssignTender {
	public void getMaxBid(int id) throws UserException, tenderException {
		System.out.println(":---------------------------: Assign Tender");
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID: ");
		int Tid=sc.nextInt();
		int[] arr=m.MaxBid(Tid);
		int Vid=arr[0];
		int BidPrice=arr[1];
		m.assignTender(Tid, Vid, BidPrice);
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
