package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import UI.info;
import UI.login;
import model.account;
import service.DAOaccount;
import service.DAOsinhvien;

public class control_account implements ActionListener {

	private login v;
	public control_account(login v)
	{
		this.v = v;
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String str = arg0.getActionCommand();
		if(str.equals("Login"))
		{
			DAOaccount c = DAOaccount.getInstance();
			
			String user = v.txt_username.getText();
			String pass = v.txt_pass.getText();
		    if(c.kiemtraDN(user, pass))
		    {
		    	
		       JOptionPane.showMessageDialog(v,"Đăng nhập thành công","Thông báo", JOptionPane.INFORMATION_MESSAGE);
		       new info();
		       v.setVisible(false);
		       return;
		    }
		    else
		    {
		    	JOptionPane.showMessageDialog(v,"Đăng nhập thất bại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
		    }
		    
		}
		else if(str.equals("EXIT"))
		{
			System.exit(0);
		}
		else if(str.equals("Sign up"))
		{
			if(DAOaccount.getInstance().checkTontai(v.txt_username.getText()))
			{
				JOptionPane.showMessageDialog(v,"Username đã tồn tại","Thông báo", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			DAOaccount.getInstance().them(new account(v.txt_username.getText(), v.txt_pass.getText()));
			JOptionPane.showMessageDialog(v,"Đăng kí thành công. Thực hiện đăng nhậpd để vào hệ thống","Thông báo", JOptionPane.INFORMATION_MESSAGE);
			
			return;
		}
	}

}
