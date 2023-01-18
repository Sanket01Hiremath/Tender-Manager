package Vendor;

import java.util.Scanner;

import Exception.UserException;
import Exception.tenderException;
import Start.login;

public class VendorMenu {
	public void Vmenu(int id) throws UserException, tenderException{
		Scanner sc=new Scanner(System.in);
		System.out.println(":------------------------------: Vendor Menu");
		System.out.println("1) Get All Tendors");
		System.out.println("2) Place Bid For Tenders");
		System.out.println("3) View status of a Bid");
		System.out.println("4) View his own Bid History");
		System.out.println("5) LogOut");
		
		System.out.print("Enter Your Choice: ");
		int c=sc.nextInt();
		
		switch(c) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:login l=new login();
			l.Login();
			break;
		}
	}
}
