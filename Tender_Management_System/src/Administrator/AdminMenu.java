package Administrator;

import java.util.Scanner;

import Exception.UserException;
import Exception.tenderException;
import Start.login;

public class AdminMenu {
	public void Amenu(int id) throws UserException, tenderException{
		Scanner sc=new Scanner(System.in);
		System.out.println(":------------------------------: Admin Menu");
		System.out.println("1) Register New Vendor");
		System.out.println("2) Get All Vendors");
		System.out.println("3) Create New Tendor");
		System.out.println("4) Get All Tendors");
		System.out.println("5) View Bids of Tenders");
		System.out.println("6) Assign a Tender To Vendor");
		System.out.println("7) LogOut");
		
		System.out.print("Enter Your Choice: ");
		int c=sc.nextInt();
		
		switch(c) {
		case 1:newVendor v=new newVendor();
			v.addNewVendor();
			break;
		case 2:AllVendors a=new AllVendors();
			a.getVendors(id);
			break;
		case 3:newTender n=new newTender();
			n.addnewTender(id);
			break;
		case 4:AllTenders t=new AllTenders();
			t.getTenders(id);
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:login l=new login();
			l.Login();
			break;
		}
	}
}
