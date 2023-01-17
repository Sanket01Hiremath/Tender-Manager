package Administrator;

import java.util.Scanner;

import Beans.user;
import Interface.Methods;
import Interface.Methods_Impl;

public class newVendor {

	public static void main(String[] args) {
		Methods m=new Methods_Impl();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("ID      : ");
		int id=sc.nextInt();
		System.out.print("UserName: ");
		String name=sc.next();
		System.out.print("Password: ");
		String pass=sc.next();
		System.out.print("UserType: ");
		String type=sc.next();
		
		user u=new user(id,name,pass,type);
		m.NewVendor(u);
		
	}

}
