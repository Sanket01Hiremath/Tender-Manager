package Start;

import java.util.Scanner;

import Beans.user;
import Exception.UserException;
import Interface.Methods;
import Interface.Methods_Impl;

public class login {

	public static void main(String[] args) throws UserException {
		Scanner sc=new Scanner(System.in);
		Methods m=new Methods_Impl();
		System.out.print("Username: ");
		String username=sc.next();
		System.out.print("Password: ");
		String password=sc.next();
		user User= m.login(username, password);
		if(User.getUserType()=="Admin") {
			
		}else {
			
		}
	}

}
