package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Administrator.AdminMenu;
import Beans.tender;
import Beans.user;
import DBUtility.DBUtil;
import Exception.UserException;
import Exception.tenderException;
import Vendor.VendorMenu;


public class Methods_Impl implements Methods{

	@Override
	public void login(String username, String password) throws UserException, tenderException {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from users where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("Welcome "+rs.getString("username"));
				if(rs.getInt("user")==1) {
					AdminMenu a=new AdminMenu();
					a.Amenu(rs.getInt("ID"));
				}else {
					VendorMenu v=new VendorMenu();
					v.Vmenu(rs.getInt("ID"));
				}
			}else {
				throw new UserException("ERROR: User Not Found!");
			}
		} catch (SQLException e) {
			throw new UserException("ERROR: User Not Found!");
		}
	}

	@Override
	public void NewVendor(user User) throws UserException, tenderException {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("Insert into users values(?,?,?,?)");
			ps.setInt(1, User.getId());
			ps.setString(2, User.getUsername());
			ps.setString(3, User.getPassword());
			ps.setInt(4, User.getUserType());
			ps.executeUpdate();
			System.out.println("New User Added!");
			AdminMenu a=new AdminMenu();
			a.Amenu(User.getId());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<user> getAllVendors() throws UserException {
		List<user> list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from users where user=2");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new user(rs.getInt("ID"),rs.getString("username"),rs.getString("password"),rs.getInt("user")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new UserException("ERROR: Users Not Found!");
		}
	}

	@Override
	public void NewTender(tender t,int id) throws UserException, tenderException {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("Insert into tendor(ID,name,type,amount,status) values(?,?,?,?,0)");
			ps.setInt(1, t.getId());
			ps.setString(2, t.getName());
			ps.setString(3, t.getType());
			ps.setInt(4, t.getAmount());
			ps.executeUpdate();
			System.out.println("New Tender Added!");
			AdminMenu a=new AdminMenu();
			a.Amenu(id);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<tender> getAllTenders() throws tenderException {
		List<tender> list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from tendor");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new tender(rs.getInt("ID"),rs.getString("name"),rs.getString("type"),rs.getInt("amount"),rs.getInt("bidPrice"),rs.getInt("status"),rs.getInt("vendorID")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new tenderException("ERROR: Tenders Not Found!");
		}
	}

}
