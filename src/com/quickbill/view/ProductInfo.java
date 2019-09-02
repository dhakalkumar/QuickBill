package com.quickbill.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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

import com.quickbill.controller.QuickBillController;
import com.quickbill.controller.QuickBillControllerImpl;
import com.quickbill.model.Product;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductInfo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2022569518790438716L;
	private JPanel contentPane;
	private JLabel lblProductInformation;
	private JLabel lblProduct;
	private JTextField textField;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductInfo frame = new ProductInfo();
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
	public ProductInfo() {
		setResizable(false);
		setTitle("Product Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 468, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblProductInformation());
		contentPane.add(getLblProduct());
		contentPane.add(getTextField());
		contentPane.add(getBtnSearch());
		contentPane.add(getScrollPane());

		displayData();
	}

	private JLabel getLblProductInformation() {
		if (lblProductInformation == null) {
			lblProductInformation = new JLabel("Product Information");
			lblProductInformation.setForeground(new Color(30, 144, 255));
			lblProductInformation.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			lblProductInformation.setBounds(78, 25, 302, 55);
		}
		return lblProductInformation;
	}

	private JLabel getLblProduct() {
		if (lblProduct == null) {
			lblProduct = new JLabel("Product");
			lblProduct.setForeground(new Color(192, 192, 192));
			lblProduct.setFont(new Font("Dialog", Font.BOLD, 15));
			lblProduct.setBounds(50, 119, 88, 15);
		}
		return lblProduct;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
//					QuickBillController qb = new QuickBillControllerImpl();
//					qb.searchProduct(textField.getText());

				}
			});
			textField.setBounds(145, 113, 168, 28);
			textField.setColumns(10);
		}
		return textField;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuickBillController qb = new QuickBillControllerImpl();
					displayData(qb.searchProduct(textField.getText()));
				}
			});
			btnSearch.setIcon(new ImageIcon(new ImageIcon(ProductInfo.class.getResource("/icons/iconSearch1.png"))
					.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
			btnSearch.setBounds(326, 114, 107, 25);
		}
		return btnSearch;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 161, 397, 293);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setFillsViewportHeight(true);
			table.setBackground(new Color(124, 252, 0));
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Product Id", "Product Name", "Available Quantity", "MRP" }));
		}
		return table;
	}

	private void displayData() {
		QuickBillController qb = new QuickBillControllerImpl();
		List<Product> pList = qb.getAllProducts();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Product p : pList) {
			model.addRow(new Object[] { p.getId(), p.getName(), p.getqAvailable(), p.getMrp() });
		}

	}
	private void displayData(List<Product> searchProduct) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Product p : searchProduct) {
			model.addRow(new Object[] { p.getId(), p.getName(), p.getqAvailable(), p.getMrp() });
		}
		
	}
}
