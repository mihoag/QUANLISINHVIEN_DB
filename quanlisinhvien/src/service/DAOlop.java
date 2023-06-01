package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import JDBCconnection.SQLconnection;
import model.lophoc;

public class DAOlop implements DAOinterface<lophoc>{

	public static DAOlop getInstance()
	{
		return new DAOlop();
	}
	public void them(lophoc t) {
		// TODO Auto-generated method stub
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "insert into lop values (?,?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1,t.getMalop());
			p.setString(2, t.getTenlop());
			
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

	public void xoa(lophoc t) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "delete from lop where malop = ?";
			
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1,t.getMalop());
			
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

	public ArrayList<lophoc> selectAll() {
		// TODO Auto-generated method stub
         ArrayList<lophoc> arr = new ArrayList<lophoc>();
         
         
         try {
 			Connection con = SQLconnection.getConnection();
 			String sql = "select * from lop";
 			
 			PreparedStatement p = con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next())
            {
               arr.add(new lophoc(rs.getString(1), rs.getString(2)));	
            }
 		} catch (Exception e) {
 			// TODO: handle exception
 			e.printStackTrace();
 		}
         return arr;
	}

	public void sua(lophoc t) {
		// TODO Auto-generated method stub
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "update lop set tenlop = ? where malop = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(2,t.getMalop());
			p.setString(1, t.getTenlop());
			
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
		// TODO Auto-generated method stub
		try {
			Connection con = SQLconnection.getConnection();
			String sql = "select * from lop where malop = ?";
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
}
