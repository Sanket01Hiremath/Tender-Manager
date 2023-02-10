package Administrator;

import java.util.Scanner;

import Beans.tender;
import Interface.Methods;
import Interface.Methods_Impl;

public class newTender {
	public void addnewTender(int id){
		Methods m=new Methods_Impl();
		
		Scanner sc=new Scanner(System.in);
		System.out.println(":---------------------------: Add New Tender");
		System.out.print("Name      : ");
		String name=sc.next();
		System.out.print("type      : ");
		String type=sc.next();
		System.out.print("Amount    : ");
		int amount=sc.nextInt();
		tender t=new tender(0,name,type,amount,0,0,0);
		m.NewTender(t);
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
