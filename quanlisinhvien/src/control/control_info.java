package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import UI.info;
import model.sinhvien;
import service.DAOlop;
import service.DAOsinhvien;

public class control_info implements ActionListener{

	private info in;
	public control_info(info in)
	{
		this.in = in;
	}
    
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if(str.equals("INSERT"))
		{
		  String id = in.txt_sv.getText();
		  String hoten = in.txt_hoten.getText();
		  String diachi = in.txt_diachi.getText();
		  String malop = in.txt_malop.getText();
		  
		  
		  if(DAOsinhvien.getInstance().checkTontai(id))
		  {
			  JOptionPane.showMessageDialog(null,"ID bị trùng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			  return;
		  }
		  
		  if(!DAOlop.getInstance().checkTontai(malop))
		  {
			  JOptionPane.showMessageDialog(null,"Mã lớp không tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			  return;
		  }
		  DAOsinhvien.getInstance().them(new sinhvien(id,hoten,diachi,malop));
		  in.hienthi();
		}
		else if(str.equals("DELETE"))
		{
			  String id = in.txt_sv.getText();
			  String hoten = in.txt_hoten.getText();
			  String diachi = in.txt_diachi.getText();
			  String malop = in.txt_malop.getText();
			  
			  if(!DAOsinhvien.getInstance().checkTontai(id))
			  {
				  JOptionPane.showMessageDialog(null,"ID khong ton tai", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				  return;
			  }
			  DAOsinhvien.getInstance().xoa(new sinhvien(id, hoten, diachi, malop));
			  in.hienthi();
		}
		else if(str.equals("EDIT"))
		{
			 String id = in.txt_sv.getText();
			  String hoten = in.txt_hoten.getText();
			  String diachi = in.txt_diachi.getText();
			  String malop = in.txt_malop.getText();
			  
			 DAOsinhvien.getInstance().sua(new sinhvien(id, hoten, diachi, malop));
			 in.hienthi();	  
		}
		else if(str.equals("EXPORT"))
		{
			String s = JOptionPane.showInputDialog(null, "Nhập tên file txt cần export");
			try {
				PrintWriter p = new PrintWriter(s + ".txt");
				ArrayList<sinhvien> arr = DAOsinhvien.getInstance().selectAll();
				for(sinhvien sv : arr)
				{
					p.println(sv.getMasv() + ", " + sv.getTensv() + ", " + sv.getDiachi() + ", " + sv.getMalop());
				}
				
				if(p != null)
				{
					p.close();
				}
				 JOptionPane.showMessageDialog(null,"Export thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
			
	}

}
