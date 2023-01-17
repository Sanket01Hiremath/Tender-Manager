package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.user;
import DBUtility.DBUtil;
import Exception.UserException;

public class Methods_Impl implements Methods{

	@Override
	public user login(String username, String password) throws UserException {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from users where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new user(rs.getInt("ID"),rs.getString("username"),rs.getString("password"),rs.getString("user"));
			}else {
				throw new UserException("User Not Found!");
			}
		} catch (SQLException e) {
			throw new UserException("User Not Found!");
		}
	}

	@Override
	public void NewVendor(user User) {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("Insert into users values(?,?,?,?)");
			ps.setInt(1, User.getId());
			ps.setString(2, User.getUsername());
			ps.setString(3, User.getPassword());
			ps.setString(4, User.getUserType());
			ps.executeUpdate();
			System.out.println("New User Added!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
