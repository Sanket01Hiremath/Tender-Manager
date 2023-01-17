package Administrator;

import java.util.Scanner;

import Beans.tender;
import Exception.UserException;
import Exception.tenderException;
import Interface.Methods;
import Interface.Methods_Impl;

public class newTender {
	public void addnewTender(int i) throws UserException, tenderException {
		Methods m=new Methods_Impl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println(":---------------------------: Add New Tender");
		System.out.print("ID        : ");
		int id=sc.nextInt();
		System.out.print("Name      : ");
		String name=sc.next();
		System.out.print("type      : ");
		String type=sc.next();
		System.out.print("Min Amount: ");
		int amount=sc.nextInt();
		tender t=new tender(id,name,type,amount,0,0,0);
		m.NewTender(t,i);
	}
}
