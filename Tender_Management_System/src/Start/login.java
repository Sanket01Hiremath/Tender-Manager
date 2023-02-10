package Start;

import java.util.Scanner;
import Interface.Methods;
import Interface.Methods_Impl;

public class login {

	public void Login(){
		Scanner sc=new Scanner(System.in);
		Methods m=new Methods_Impl();
		System.out.println(":--------------------------------------------------------------------------------:");
		System.out.println(":                        Online Tender Management System                         :");
		System.out.println(":--------------------------------------------------------------------------------:");
		System.out.println(":----------------------------------: Login");
		System.out.print("Username: ");
		String username=sc.next();
		System.out.print("Password: ");
		String password=sc.next();
		m.login(username, password);
	}

}
