package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import JDBCconnection.SQLconnection;
import model.account;

public class DAOaccount implements DAOinterface<account>{

	public static DAOaccount getInstance()
	{
		return new DAOaccount();
	}
	public void them(account t) {
		// TODO Auto-generated method stub
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "insert into account values (?,?)";
			PreparedStatement p = con.prepareStatement(sql);
		    p.setString(1, t.getUsername());
		    p.setString(2, t.getPassword());
		
			int ck = p.executeUpdate();
			if(ck > 0)
			{
				System.out.println("Insert thanh cong");
			}
			else
			{
				System.out.println("Insert that bai");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void xoa(account t) {
		// TODO Auto-generated method stub
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "delete from account where username = ?";
			PreparedStatement p = con.prepareStatement(sql);
		    p.setString(1, t.getUsername());
		
			int ck = p.executeUpdate();
			if(ck > 0)
			{
				System.out.println("Insert thanh cong");
			}
			else
			{
				System.out.println("Insert that bai");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ArrayList<account> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<account> arr = new ArrayList<account>();
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "select * from account";
			PreparedStatement p = con.prepareStatement(sql);
		    
			ResultSet rs = p.executeQuery();
			while(rs.next())
			{
				arr.add(new account(rs.getString(1), rs.getString(2)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arr;
	}

	public void sua(account t) {
		// TODO Auto-generated method stub
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "update account set password = ? where username = ?";
			PreparedStatement p = con.prepareStatement(sql);
		    p.setString(2, t.getUsername());
		    p.setString(1, t.getPassword());
		
			int ck = p.executeUpdate();
			if(ck > 0)
			{
				System.out.println("cap nhat thanh cong");
			}
			else
			{
				System.out.println("cap nhat that bai");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean checkTontai(String ma) {
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "select * from account where username = ? ";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, ma);
			ResultSet rs = p.executeQuery();
			return rs.next();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return false;
	}
	
	public boolean kiemtraDN(String username, String pass)
	{
		try {
			System.out.println(username + " " + pass);
			Connection con = SQLconnection.getConnection();
			String sql = "select * from account where username = ? and pass = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, username);
			p.setString(2, pass);

			ResultSet rs = p.executeQuery();
			//System.out.println(rs.next() + "");
			
			return rs.next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	

}
