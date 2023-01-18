package Administrator;

import java.util.List;
import java.util.Scanner;

import Beans.Bid;
import Exception.UserException;
import Exception.tenderException;
import Interface.Methods;
import Interface.Methods_Impl;

public class AllBids {
	public void getBids(int id) throws UserException, tenderException{
		System.out.println(":---------------------------------: All Bids");
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID: ");
		int Tid=sc.nextInt();
		List<Bid> list=m.getAllBids(Tid);
		System.out.println(":-----------------: All Bids for Tender:"+Tid);
		for(Bid i:list) {
			System.out.println("Tender ID       : "+i.getTid());
			System.out.println("Vendor ID       : "+i.getVid());
			System.out.println("Tender BidPrice : "+i.getBidAmount());
			System.out.println(":------------------------------------------:");
		}
		if(list.size()==0) {
			System.out.println("Error: Bids Not Found for Tender: "+Tid);
		}
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}