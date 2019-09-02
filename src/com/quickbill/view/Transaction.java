package com.quickbill.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.quickbill.controller.NewBillController;
import com.quickbill.controller.NewBillControllerImpl;
import com.quickbill.model.Bill;
import com.quickbill.model.Product;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transaction extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5627752486967387007L;
	private JPanel contentPane;
	private JLabel lblTransactionDetails;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnPrint;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction frame = new Transaction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Transaction() {
		setTitle("Transaction");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblTransactionDetails());
		contentPane.add(getBtnPrint());
		contentPane.add(getBtnNewButton());
	}
	private JLabel getLblTransactionDetails() {
		if (lblTransactionDetails == null) {
			lblTransactionDetails = new JLabel("Transaction Details");
			lblTransactionDetails.setForeground(new Color(255, 255, 0));
			lblTransactionDetails
					.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			lblTransactionDetails.setBounds(175, 0, 301, 48);
		}
		return lblTransactionDetails;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(0, 255, 0));
			scrollPane.setForeground(new Color(0, 0, 0));
			scrollPane.setVerticalScrollBarPolicy(
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(12, 61, 627, 381);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFillsViewportHeight(true);
			table.setForeground(new Color(50,50,50));
			table.setBackground(new Color(200, 200, 200));

			table.setModel(new DefaultTableModel(new Object[][]{},
					new String[]{"Bill no.", "Customer", "Quantity", "Name",
							"MRP", "Discount", "Price", "Date"}));
		}
		displayData();
		return table;
	}

	private void displayData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		NewBillController nbc = new NewBillControllerImpl();
		List<Bill> bList = nbc.getAllBills();

		model.setRowCount(0);

		for (Bill b : bList) {
			model.addRow(new Object[]{b.getBillno(), b.getCustomer(),
					b.getQuantity(), b.getProduct().getName(),
					b.getProduct().getMrp(), b.getDiscount(),
					b.getProduct().getMrp() - b.getDiscount(), b.getDate()});
		}
	}
	private JButton getBtnPrint() {
		if (btnPrint == null) {
			btnPrint = new JButton("Print");
			btnPrint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						table.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnPrint.setBounds(368, 454, 117, 25);
		}
		return btnPrint;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Close");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(498, 454, 117, 25);
		}
		return btnNewButton;
	}
}
