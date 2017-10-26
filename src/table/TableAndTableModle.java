package table;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdk.internal.dynalink.beans.StaticClass;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class TableAndTableModle implements ActionListener{
	private static DefaultTableModel tableModel;
	private static JTable table;
	
	public  static  void main(String[] args){
		
		JFrame frame = new JFrame();
		
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		
		//model
		Vector data = new Vector();
		Vector columnNames = new Vector();
		columnNames.add("Name");
		columnNames.add("Sex");
		
		Vector row = new Vector();
//		String[] row = {"����","��"};
		row.add("����");
		row.add("��");
		data.add(row);
		Object[][] data2 = {
				{"����","��"},
				{"����","��"}
		};
		
		Object[] col2 = {"����","�Ա�"};
		
//		DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
		 tableModel = new DefaultTableModel(data2,col2);
		//table
		  table = new JTable(tableModel);
		//show
		
		frame.add(new JScrollPane(table));
		TableAndTableModle listener = new TableAndTableModle();
		
		JButton b1 = new JButton("���һ��");
		b1.addActionListener(listener);
		JButton b2 = new JButton("ɾ��һ��");
		JButton b3 = new JButton("��ȡ����");
		JButton b4 = new JButton("��������");
		b2.addActionListener(listener);
		b3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				System.out.println(table.getValueAt(row, 0));
			}
		});
		b4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int row = table.getSelectedRow();
				table.setValueAt("zhuxi",row, 0);
			}
		});
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		if(command.equals("ɾ��һ��")){
			tableModel.removeRow(1);
		}else if(command.equals("���һ��")){
			Object[] rowData ={"����","Ů"};
			tableModel.addRow(rowData);
		}
	}
}
