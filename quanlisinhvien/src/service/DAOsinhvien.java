package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import JDBCconnection.SQLconnection;
import model.sinhvien;

public class DAOsinhvien implements DAOinterface<sinhvien>{

	public static DAOsinhvien getInstance()
	{
		return new DAOsinhvien();
	}
	public void them(sinhvien t) {
		// TODO Auto-generated method stub
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "insert into sinhvien values (?,?,?,?)";
			PreparedStatement p = con.prepareStatement(sql);
			
			p.setString(1, t.getMasv());
			p.setString(2, t.getTensv());
			p.setString(3, t.getDiachi());
			p.setString(4, t.getMalop());
			
			
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

	public void xoa(sinhvien t) {
		// TODO Auto-generated method stub
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "delete from sinhvien where ma = ?";
			PreparedStatement p = con.prepareStatement(sql);
			
			p.setString(1, t.getMasv());
		
			int ck = p.executeUpdate();
			if(ck > 0)
			{
				System.out.println("Delete thanh cong");
			}
			else
			{
				System.out.println("Delete that bai");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ArrayList<sinhvien> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<sinhvien> arr  = new ArrayList<sinhvien>();
		
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "select * from sinhvien";
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while(rs.next())
			{
				arr.add(new sinhvien(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arr;
	}

	public void sua(sinhvien t) {
		// TODO Auto-generated method stub
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "update sinhvien set ten = ? , diachi = ? , malop = ? where ma = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, t.getTensv());
			p.setString(2, t.getDiachi());
			p.setString(3, t.getMalop());
			p.setString(4, t.getMasv());
		
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
			String sql = "select * from sinhvien where ma = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, ma);
			ResultSet rs = p.executeQuery();
			return rs.next();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return true;
	}
	
	
}
