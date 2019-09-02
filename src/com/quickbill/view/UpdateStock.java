package com.quickbill.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.quickbill.controller.QuickBillController;
import com.quickbill.controller.QuickBillControllerImpl;
import com.quickbill.model.Product;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateStock extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JLabel label_1;
	private JTextField textPId;
	private JLabel label_2;
	private JTextField textPName;
	private JLabel label_3;
	private JTextField textQAvbl;
	private JLabel label_4;
	private JTextField textQAdded;
	private JLabel label_5;
	private JTextField textMRP;
	private JButton button;
	private JButton button_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblAvailableStock;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStock frame = new UpdateStock();
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
	public UpdateStock() {
		setResizable(false);
		setTitle("Update Stock");
		setBackground(new Color(219, 112, 147));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 740, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 112, 147));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabel());
		contentPane.add(getLabel_1());
		contentPane.add(getTextPId());
		contentPane.add(getLabel_2());
		contentPane.add(getTextPName());
		contentPane.add(getLabel_3());
		contentPane.add(getTextQAvbl());
		contentPane.add(getLabel_4());
		contentPane.add(getTextQAdded());
		contentPane.add(getLabel_5());
		contentPane.add(getTextMRP());
		contentPane.add(getButton());
		contentPane.add(getButton_1());
		contentPane.add(getScrollPane());
		contentPane.add(getLblAvailableStock());
		contentPane.add(getSeparator());
		
		updateTable();
	}
	private void updateTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		QuickBillController qbc = new QuickBillControllerImpl();
		List<Product> pList = qbc.getAllProducts();
		model.setRowCount(0);
		
		for(Product p : pList) {
			model.addRow(new Object[] {p.getId(), p.getName(), p.getqAvailable(), p.getMrp()});
		}
		
		
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Update Stock");
			label.setForeground(new Color(128, 0, 128));
			label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			label.setBounds(86, 12, 251, 59);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Product Id");
			label_1.setBounds(25, 116, 87, 15);
		}
		return label_1;
	}
	private JTextField getTextPId() {
		if (textPId == null) {
			textPId = new JTextField();
			textPId.setColumns(10);
			textPId.setBounds(178, 109, 164, 28);
		}
		return textPId;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Product Name");
			label_2.setBounds(25, 159, 108, 15);
		}
		return label_2;
	}
	private JTextField getTextPName() {
		if (textPName == null) {
			textPName = new JTextField();
			textPName.setColumns(10);
			textPName.setBounds(178, 152, 164, 28);
		}
		return textPName;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Quantity Available");
			label_3.setBounds(25, 201, 136, 15);
		}
		return label_3;
	}
	private JTextField getTextQAvbl() {
		if (textQAvbl == null) {
			textQAvbl = new JTextField();
			textQAvbl.setColumns(10);
			textQAvbl.setBounds(178, 194, 164, 28);
		}
		return textQAvbl;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("Quantity Added");
			label_4.setBounds(25, 239, 136, 15);
		}
		return label_4;
	}
	private JTextField getTextQAdded() {
		if (textQAdded == null) {
			textQAdded = new JTextField();
			textQAdded.setColumns(10);
			textQAdded.setBounds(178, 232, 164, 28);
		}
		return textQAdded;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("MRP");
			label_5.setBounds(25, 273, 50, 28);
		}
		return label_5;
	}
	private JTextField getTextMRP() {
		if (textMRP == null) {
			textMRP = new JTextField();
			textMRP.setColumns(10);
			textMRP.setBounds(178, 273, 164, 28);
		}
		return textMRP;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("New");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Product p = new Product();
					QuickBillController qbc = new QuickBillControllerImpl();
					
					p.setId(Integer.parseInt(textPId.getText()));
					p.setName(textPName.getText());
					p.setMrp(Float.parseFloat(textMRP.getText()));
					p.setqAvailable(Integer.parseInt(textQAvbl.getText()));
					p.setqAdded(Integer.parseInt(textQAdded.getText()));
					
					if(qbc.addProduct(p)) {
						JOptionPane.showMessageDialog(null, "Product successfully added to the database");
						updateTable();
						return;
					} else {
						JOptionPane.showMessageDialog(null, "There was an error while adding the product to the database");
						return;
					}
				}
			});
			button.setBounds(86, 333, 87, 28);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("Update");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Product p = new Product();
					QuickBillController qbc = new QuickBillControllerImpl();
					
					p.setId(Integer.parseInt(textPId.getText()));
					p.setName(textPName.getText());
					p.setMrp(Float.parseFloat(textMRP.getText()));
					p.setqAdded(Integer.parseInt(textQAdded.getText()));
					p.setqAvailable(Integer.parseInt(textQAvbl.getText()) + Integer.parseInt(textQAdded.getText()));
					
					if(qbc.updateProduct(p)) {
						JOptionPane.showMessageDialog(null, "Product " + textPName.getText() + " successfully updated in the database.");
						updateTable();
						return;
					} else {
						JOptionPane.showMessageDialog(null, "There was an error updating the product " + textPName.getText());
						return;
					}
					
				}
			});
			button_1.setBounds(230, 333, 87, 28);
		}
		return button_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(390, 57, 326, 319);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					QuickBillController qbc = new QuickBillControllerImpl();
					Product p = qbc.getProductById((int)table.getValueAt(row, 0));
					
					textPId.setText(String.valueOf(p.getId()));
					textPName.setText(p.getName());
					textQAvbl.setText(String.valueOf(p.getqAvailable()));
					textMRP.setText(String.valueOf(p.getMrp()));
				}
			});
			table.setFillsViewportHeight(true);
			table.setForeground(new Color(0, 0, 0));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Product Id", "Product Name", "Available", "MRP"
				}
			));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setBackground(new Color(0, 255, 127));
		}
		return table;
	}
	private JLabel getLblAvailableStock() {
		if (lblAvailableStock == null) {
			lblAvailableStock = new JLabel("Available Stock");
			lblAvailableStock.setForeground(new Color(175, 238, 238));
			lblAvailableStock.setBounds(486, 11, 122, 20);
		}
		return lblAvailableStock;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(458, 43, 172, 2);
		}
		return separator;
	}
}
