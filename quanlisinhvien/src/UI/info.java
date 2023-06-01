package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import JDBCconnection.SQLconnection;
import control.control_info;
import model.lophoc;
import model.sinhvien;
import service.DAOlop;
import service.DAOsinhvien;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class info extends JFrame {

	public DefaultMutableTreeNode root;
	public JTree tree;
	public JTable tbSV;
	public DefaultTableModel tb;
	public JTextField txt_sv;
	public JTextField txt_hoten;
	public JTextField txt_diachi;
	public JTextField txt_malop;
	
	
	public void hienthi()
	{
		DAOlop d = DAOlop.getInstance();
		DAOsinhvien ds = DAOsinhvien.getInstance();
	    ArrayList<lophoc> arr = d.selectAll();
	    ArrayList<sinhvien> arrSV = ds.selectAll();
	    root.removeAllChildren();
	    for(lophoc l : arr)
	    {
	    	DefaultMutableTreeNode nd = new DefaultMutableTreeNode(l);
	    	for(sinhvien s : arrSV)
	    	{
	    		if(s.getMalop().equals(l.getMalop()))
	    		{
	    			DefaultMutableTreeNode nd1 = new DefaultMutableTreeNode(s);
	    			nd.add(nd1);
	    		}
	    	}
	    	root.add(nd);
	    } 
	}
	
	public void addControl()
	{
	   tbSV.addMouseListener(new MouseListener()
			   {

				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					int cnt = tbSV.getSelectedRow();
					txt_sv.setText((String) tbSV.getValueAt(cnt, 0));
					txt_hoten.setText((String) tbSV.getValueAt(cnt, 1));
					txt_diachi.setText((String) tbSV.getValueAt(cnt, 2));
					txt_malop.setText((String) tbSV.getValueAt(cnt, 3));	
				}

				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
		   
			   }
			   
      );
	   
		
	   tree.addMouseListener(new MouseListener() {
		
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		    DefaultMutableTreeNode nd =  (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		     if(nd == root)
		     {
		    	 return;
		     }
		    
		    lophoc l = (lophoc) nd.getUserObject();
		    ArrayList<sinhvien> arr = DAOsinhvien.getInstance().selectAll();
		    tb.setRowCount(0);
		    for(sinhvien s : arr)
		    {
		    	if(s.getMalop().equals(l.getMalop()))
		    	{
		    		String a[] = {s.getMasv(),s.getTensv(),s.getDiachi(),s.getMalop()};
		    		tb.addRow(a);
		    	}
		    }
		}
	});
	   
	   
	   
	   
	}
	
	public info() {
		this.setTitle("Thông tin sinh viên");
		this.setLocationRelativeTo(null);
		this.setSize(900,690);
		///////////
		/////////
		this.setResizable(false);
       getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN SINH VIÊN");
		lblNewLabel.setForeground(new Color(184, 44, 14));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(267, 10, 357, 48);
		getContentPane().add(lblNewLabel);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 68, 886, 593);
		getContentPane().add(pn1);
		pn1.setLayout(new BorderLayout());
		/////////////////////
		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(275, 0));
		JPanel right = new JPanel();
		
	    JSplitPane slp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,right);
	    pn1.add(slp, BorderLayout.CENTER);
	    
	    JPanel right_top = new JPanel();
	    right_top.setPreferredSize(new Dimension(0, 320));
	    JPanel right_bot = new JPanel();
	    right_bot.setBackground(new Color(254, 254, 199));
	    right_top.setLayout(new BorderLayout());
	    right_bot.setLayout(null);
	    right.setLayout(new BorderLayout());
	    JSplitPane spl1= new JSplitPane(JSplitPane.VERTICAL_SPLIT, right_top, right_bot);
	    
	    JLabel lblNewLabel_1 = new JLabel("Mã SV");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel_1.setBounds(10, 22, 75, 40);
	    right_bot.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Họ tên");
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel_1_1.setBounds(10, 73, 75, 40);
	    right_bot.add(lblNewLabel_1_1);
	    
	    JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ");
	    lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel_1_2.setBounds(10, 123, 75, 40);
	    right_bot.add(lblNewLabel_1_2);
	    
	    JLabel lblNewLabel_1_3 = new JLabel("Mã lớp");
	    lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel_1_3.setBounds(10, 173, 75, 40);
	    right_bot.add(lblNewLabel_1_3);
	    
	    txt_sv = new JTextField();
	    txt_sv.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txt_sv.setBounds(113, 22, 225, 34);
	    right_bot.add(txt_sv);
	    txt_sv.setColumns(10);
	    
	    txt_hoten = new JTextField();
	    txt_hoten.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txt_hoten.setColumns(10);
	    txt_hoten.setBounds(113, 73, 225, 34);
	    right_bot.add(txt_hoten);
	    
	    txt_diachi = new JTextField();
	    txt_diachi.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txt_diachi.setColumns(10);
	    txt_diachi.setBounds(113, 123, 225, 34);
	    right_bot.add(txt_diachi);
	    
	    txt_malop = new JTextField();
	    txt_malop.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    txt_malop.setColumns(10);
	    txt_malop.setBounds(113, 179, 225, 34);
	    right_bot.add(txt_malop);
	    
	    JButton btn_insert = new JButton("INSERT");
	    btn_insert.setBackground(new Color(255, 139, 83));
	    btn_insert.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btn_insert.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    	}
	    });
	    btn_insert.setBounds(414, 22, 147, 40);
	    right_bot.add(btn_insert);
	    
	    JButton btn_delete = new JButton("DELETE");
	    btn_delete.setBackground(new Color(255, 139, 83));
	    btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btn_delete.setBounds(414, 73, 147, 40);
	    right_bot.add(btn_delete);
	    
	    JButton btn_edit = new JButton("EDIT");
	    btn_edit.setBackground(new Color(255, 139, 83));
	    btn_edit.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btn_edit.setBounds(414, 123, 147, 40);
	    right_bot.add(btn_edit);
	    
	    JButton btn_export = new JButton("EXPORT");
	    btn_export.setBackground(new Color(255, 139, 83));
	    btn_export.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btn_export.setBounds(414, 173, 147, 40);
	    right_bot.add(btn_export);
	    right.add(spl1, BorderLayout.CENTER);
	    
		/////////////////////////////////
	    tb = new DefaultTableModel();
	    tb.addColumn("Mã SV");
	    tb.addColumn("Họ tên");
	    tb.addColumn("Địa chỉ");
	    tb.addColumn("Mã lớp");
	    
	    tbSV = new JTable(tb);
	    JScrollPane sc = new JScrollPane(tbSV,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        right_top.add(sc,BorderLayout.CENTER);   	    
        ///////////////////////////////////////////////////////////////
        
        root = new DefaultMutableTreeNode("Danh sách lớp học");
        
        tree = new JTree(root);
        tree.setBackground(new Color(233, 254, 177));
        tree.setFont(new Font("Tahoma", Font.PLAIN, 20));
        left.setLayout(new BorderLayout());
        left.add(tree, BorderLayout.CENTER);
        left.setBackground(new Color(233, 254, 177));
         
        
        ////////////////////////////////
        control_info ac = new control_info(this);
        btn_insert.addActionListener(ac);
        btn_delete.addActionListener(ac);
        btn_edit.addActionListener(ac);
        btn_export.addActionListener(ac);
        
        
        ////////////////////
        
        hienthi();
        addControl();
        
		///////////////////////////
		this.setVisible(true);
	}
}
