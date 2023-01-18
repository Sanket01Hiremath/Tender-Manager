package Administrator;

import java.util.Scanner;

import Exception.UserException;
import Exception.tenderException;
import Interface.Methods;
import Interface.Methods_Impl;

public class deleteTender {
	public void deletetender(int id) throws UserException, tenderException {
		System.out.println(":---------------------------: Delete Tenders");
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter TenderID: ");
		int Tid=sc.nextInt();
		m.deleteTender(Tid);
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
