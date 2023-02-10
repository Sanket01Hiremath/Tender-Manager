package Administrator;

import java.util.List;
import java.util.Scanner;

import Beans.tender;
import Interface.Methods;
import Interface.Methods_Impl;

public class deleteVendor {
	public void DeleteVendor(int id){
		System.out.println(":---------------------------: Delete Vendors");
		Methods m=new Methods_Impl();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter VendorID: ");
		int Vid=sc.nextInt();
		List<tender> list=m.AllTendersOfVendor(Vid);
		if(list.size()==0) {
			m.deleteBidByVid(Vid);
			m.deleteVendor(Vid);
		}else {
			System.out.println("Error: Vendor Has Active/Assigned Tenders Can't Delete!");
		}
		AdminMenu a=new AdminMenu();
		a.Amenu(id);
	}
}
