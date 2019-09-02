package com.quickbill.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.quickbill.controller.NewBillController;
import com.quickbill.controller.NewBillControllerImpl;
import com.quickbill.controller.QuickBillController;
import com.quickbill.controller.QuickBillControllerImpl;
import com.quickbill.model.Bill;
import com.quickbill.model.Product;
import java.awt.Rectangle;
import java.awt.Dimension;

public class SearchBill extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -523287734255860389L;
	private JPanel contentPane;
	private JLabel lblSearchBill;
	private JLabel lblBillNo;
	private JTextField textBillno;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBill frame = new SearchBill();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchBill() {
		setResizable(false);
		setTitle("Search Bill");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 99, 71));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblSearchBill());
		contentPane.add(getLblBillNo());
		contentPane.add(getTextBillno());
		contentPane.add(getBtnSearch());
		contentPane.add(getScrollPane());
		contentPane.add(getLabel_1());

		displayData();
	}

	private JLabel getLblSearchBill() {
		if (lblSearchBill == null) {
			lblSearchBill = new JLabel("Search Bill");
			lblSearchBill.setForeground(new Color(128, 0, 128));
			lblSearchBill
					.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			lblSearchBill.setBounds(137, 12, 165, 34);
		}
		return lblSearchBill;
	}
	private JLabel getLblBillNo() {
		if (lblBillNo == null) {
			lblBillNo = new JLabel("Bill no.");
			lblBillNo.setBounds(45, 76, 78, 23);
		}
		return lblBillNo;
	}
	private JTextField getTextBillno() {
		if (textBillno == null) {
			textBillno = new JTextField();
			textBillno.setBounds(107, 78, 55, 21);
			textBillno.setColumns(10);
		}
		return textBillno;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NewBillController nbc = new NewBillControllerImpl();
					String search = textBillno.getText();
					if(search.isEmpty()) {
						displayData();
					} else {
						Bill searchBill = nbc.getBillById(Integer.parseInt(search));						
						displayData(searchBill);
					}
					
				}
			});
			btnSearch.setIcon(new ImageIcon(new ImageIcon(
					SearchBill.class.getResource("/icons/iconSearch1.png"))
							.getImage()
							.getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
			btnSearch.setBounds(186, 75, 124, 24);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 132, 414, 288);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBackground(new Color(0, 206, 209));
			table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{
					"Bill no.", "Customer Name", "Amount", "Date"}));
		}
		return table;
	}

	protected void displayData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		NewBillController nbc = new NewBillControllerImpl();
		List<Bill> bList = nbc.getAllBills();

		model.setRowCount(0);
		label.setVisible(false);
		for (Bill b : bList) {
			model.addRow(new Object[]{b.getBillno(), b.getCustomer(),
					b.getQuantity(), b.getDate()});
		}

	}
	protected void displayData(Bill searchBill) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		label.setVisible(false);
		if (searchBill != null) {
			model.addRow(new Object[]{searchBill.getBillno(),
					searchBill.getCustomer(), searchBill.getQuantity(),	searchBill.getDate()});
		} else {
			label.setText("[No data found]");
			label.setVisible(true);
		}
	}
	private JLabel getLabel_1() {
		if (label == null) {
			label = new JLabel("");
			label.setForeground(Color.YELLOW);
			label.setBounds(new Rectangle(100, 10, 200, 20));
			label.setBounds(149, 103, 141, 20);
		}
		label.setVisible(false);
		return label;
	}
}
