package Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Administrator.AdminMenu;
import Beans.Bid;
import Beans.tender;
import Beans.user;
import DBUtility.DBUtil;
import Exception.UserException;
import Exception.tenderException;
import Start.login;
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
				System.out.println("Error: User Not Found!");
				login l=new login();
				l.Login();
			}
		} catch (SQLException e) {
			System.out.println("Error: User Not Found!");
			System.out.println(e.getMessage());
			login l=new login();
			l.Login();
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
			System.out.println("New Vendor Added!");
			AdminMenu a=new AdminMenu();
			a.Amenu(User.getId());
		} catch (SQLException e) {
			System.out.println("Error: Vendor Not Added!");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<user> getAllVendors(){
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
			System.out.println("Error: Vendors Not Found!");
			System.out.println(e.getMessage());
		}
		return list;
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
			System.out.println("Error: New Tender Not Added!");
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
			System.out.println("Error: Tenders Not Found!");
			System.out.println(e.getMessage());
			
		}
		return list;
	}

	@Override
	public List<Bid> getAllBids(int id) {
		List<Bid> list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from bids where tenderID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Bid(rs.getInt("tenderID"),rs.getInt("vendorID"),rs.getInt("bidPrice")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public int[] MaxBid(int id) {
		int[] arr=new int[2];
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select vendorID,bidPrice from bids where tenderID=? order by bidPrice DESC LIMIT 1");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				arr[0]=rs.getInt("vendorID");
				arr[1]=rs.getInt("bidPrice");
			}
			return arr;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return arr;
	}

	@Override
	public void assignTender(int Tid, int Vid, int bidPrice) {
		Connection conn=DBUtil.getConnection();
		try(PreparedStatement ps=conn.prepareStatement("update tendor set vendorID=?,bidPrice=?,status=1 where ID=? AND status=0")) {
			ps.setInt(1, Vid);
			ps.setInt(2, bidPrice);
			ps.setInt(3, Tid);
			int i=ps.executeUpdate();
			if(i==1) {
				System.out.println("Tender "+Tid+" Assigned To Vendor "+Vid+" At Price "+bidPrice);
			}else {
				System.out.println("Error: Tender Not Found");
			}
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deleteTender(int Tid) {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from tendor where ID=?");
			ps.setInt(1, Tid);
			int i=ps.executeUpdate();
			if(i==0) {
				System.out.println("Tender Deleted Successfully!");
			}else {
				System.out.println("Error: Tender Not Found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteVendor(int Vid) {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from users where ID=? AND user=2");
			ps.setInt(1, Vid);
			int i=ps.executeUpdate();
			if(i==0) {
				System.out.println("Vendor Deleted Successfully!");
			}else {
				System.out.println("Error: Vendor Not Found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void deleteBidByTid(int tid) {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from bids where tenderID=?");
			ps.setInt(1, tid);
			int i=ps.executeUpdate();
			if(i==0) {
				System.out.println("Vendor Deleted Successfully!");
			}else {
				System.out.println("Error: Vendor Not Found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deleteBidByVid(int vid) {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from bids where vendorID=?");
			ps.setInt(1, vid);
			int i=ps.executeUpdate();
			if(i==0) {
				System.out.println("Vendor Deleted Successfully!");
			}else {
				System.out.println("Error: Vendor Not Found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public void deleteBid(int vid, int tid) {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from bids where vendorID=? AND tenderID=?");
			ps.setInt(1, vid);
			ps.setInt(2, tid);
			int i=ps.executeUpdate();
			if(i==0) {
				System.out.println("Vendor Deleted Successfully!");
			}else {
				System.out.println("Error: Vendor Not Found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public void placeBid(int tid,int vid,int amount) {
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("insert into bids values(?,?,?)");
			ps.setInt(1, tid);
			ps.setInt(2, vid);
			ps.setInt(3, amount);
			ps.executeUpdate();
			System.out.println("Bid Placed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<tender> openTenders() {
		List<tender> list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from tendor where status=0");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new tender(rs.getInt("ID"),rs.getString("name"),rs.getString("type"),rs.getInt("amount"),rs.getInt("bidPrice"),rs.getInt("status"),rs.getInt("vendorID")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Error: Tenders Not Found!");
			System.out.println(e.getMessage());
			
		}
		return list;
	}

	@Override
	public List<Bid> AllBidsOfVendor(int tid,int vid) {
		List<Bid> list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from bids where tenderID=? AND vendorID=?");
			ps.setInt(1, tid);
			ps.setInt(2, vid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Bid(rs.getInt("tenderID"),rs.getInt("vendorID"),rs.getInt("bidPrice")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public List<tender> AllTendersOfVendor(int id) {
		List<tender> list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from tendor where vendorID=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new tender(rs.getInt("ID"),rs.getString("name"),rs.getString("type"),rs.getInt("amount"),rs.getInt("bidPrice"),rs.getInt("status"),rs.getInt("vendorID")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Error: Tenders Not Found!");
			System.out.println(e.getMessage());
			
		}
		return list;
	}

	

}
