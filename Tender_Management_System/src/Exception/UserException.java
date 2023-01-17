package Exception;

import Start.login;

public class UserException extends Exception{
	public UserException(String s) {
		System.out.println(s);
	}
}
