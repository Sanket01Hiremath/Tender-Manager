package Start;

import java.util.Scanner;
import Exception.UserException;
import Exception.tenderException;
import Interface.Methods;
import Interface.Methods_Impl;

public class login {

	public void Login() throws UserException, tenderException {
		Scanner sc=new Scanner(System.in);
		Methods m=new Methods_Impl();
		System.out.println(":----------------------------------: Login");
		System.out.print("Username: ");
		String username=sc.next();
		System.out.print("Password: ");
		String password=sc.next();
		m.login(username, password);
	}

}
