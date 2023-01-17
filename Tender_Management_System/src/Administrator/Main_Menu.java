package Administrator;

import java.util.Scanner;

public class Main_Menu {
	public static void menu(int id){
		Scanner sc=new Scanner(System.in);
		System.out.print(":------------------------------: Main Menu");
		System.out.print("1) Register New Vendor");
		System.out.print("2) Get All Vendors");
		System.out.print("3) Create New Tendor");
		System.out.print("4) Get All Tendors");
		System.out.print("5) View Bids of Tenders");
		System.out.print("6) Assign a Tender To Vendor");
		System.out.print("7) LogOut");
		
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
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
		}
	}
}
