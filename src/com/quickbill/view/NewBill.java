package com.quickbill.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.quickbill.controller.NewBillController;
import com.quickbill.controller.NewBillControllerImpl;
import com.quickbill.controller.QuickBillController;
import com.quickbill.controller.QuickBillControllerImpl;
import com.quickbill.model.Bill;
import com.quickbill.model.Product;
import com.toedter.calendar.JDateChooser;

public class NewBill extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9096865012786658158L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblDate;
	private JDateChooser dateChooser;
	private JTable table;
	private JLabel lblBillNo;
	private JTextField textBillno;
	private JLabel lblCustomerName;
	private JTextField textCustomerName;
	private JLabel lblProductId;
	private JComboBox<Integer> comboBox;
	private JLabel lblName;
	private JLabel lblMrp;
	private JLabel lblQuantity;
	private JLabel lblDiscount;
	private JTextField textProductName;
	private JTextField textMrp;
	private JTextField textQuantity;
	private JTextField textDiscount;
	private JButton btnAdd;
	private JButton btnRemove;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JButton btnPrint;
	private JLabel lblNewBill;
	private JSeparator separator;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBill frame = new NewBill();
					frame.setVisible(true);
					frame.setResizable(false);
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
	public NewBill() {
		setBackground(new Color(0, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("New Bill");
		setBounds(100, 100, 774, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblDate());
		contentPane.add(getDateChooser());
		contentPane.add(getLblBillNo());
		contentPane.add(getLblCustomerName());
		contentPane.add(getTextBillno());
		contentPane.add(getTextCustomerName());
		contentPane.add(getLblProductId());
		contentPane.add(getComboBox());
		contentPane.add(getLblName());
		contentPane.add(getLblMrp());
		contentPane.add(getLblQuantity());
		contentPane.add(getLblDiscount());
		contentPane.add(getTextProductName());
		contentPane.add(getTextMrp());
		contentPane.add(getTextQuantity());
		contentPane.add(getTextDiscount());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnRemove());
		contentPane.add(getLblTotal());
		contentPane.add(getTextTotal());
		contentPane.add(getBtnPrint());
		contentPane.add(getLblNewBill());
		contentPane.add(getSeparator());
		contentPane.add(getBtnClose());
		
		displayData();
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(395, 46, 355, 260);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setForeground(new Color(0, 255, 255));
			lblDate.setBounds(438, 19, 58, 15);
		}
		return lblDate;
	}

	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(516, 12, 168, 25);
			dateChooser.setDate(Calendar.getInstance().getTime());
		}
		return dateChooser;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					NewBillController nb = new NewBillControllerImpl();
					Bill b = nb.getBillById((int) table.getValueAt(row, 0));
					
					textBillno.setText(String.valueOf(b.getBillno()));
					textCustomerName.setText(b.getCustomer());
					
					Product p = new Product();
					p.setId(b.getProduct().getId());
					p.setName(b.getProduct().getName());
					p.setMrp(b.getProduct().getMrp());
					
					comboBox.setSelectedItem(b.getProduct().getId());
					textProductName.setText(b.getProduct().getName());
					textMrp.setText(String.valueOf(b.getProduct().getMrp()));
					textQuantity.setText(String.valueOf(b.getQuantity()));
					textDiscount.setText(String.valueOf(b.getDiscount()));
					
				}
			});
			table.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Bill no.", "Quantity", "Name", "MRP", "Price" }));
		}
		return table;
	}

	private JLabel getLblBillNo() {
		if (lblBillNo == null) {
			lblBillNo = new JLabel("Bill No.:");
			lblBillNo.setForeground(new Color(0, 255, 255));
			lblBillNo.setBounds(44, 97, 94, 15);
		}
		return lblBillNo;
	}

	private JTextField getTextBillno() {
		if (textBillno == null) {
			textBillno = new JTextField();
			textBillno.setBounds(183, 95, 43, 25);
			textBillno.setColumns(10);
		}
		return textBillno;
	}

	private JLabel getLblCustomerName() {
		if (lblCustomerName == null) {
			lblCustomerName = new JLabel("Customer Name:");
			lblCustomerName.setForeground(new Color(0, 255, 255));
			lblCustomerName.setBounds(44, 130, 129, 15);
		}
		return lblCustomerName;
	}

	private JTextField getTextCustomerName() {
		if (textCustomerName == null) {
			textCustomerName = new JTextField();
			textCustomerName.setBounds(183, 126, 175, 25);
			textCustomerName.setColumns(10);
		}
		return textCustomerName;
	}

	private JLabel getLblProductId() {
		if (lblProductId == null) {
			lblProductId = new JLabel("Product Id:");
			lblProductId.setForeground(new Color(0, 255, 255));
			lblProductId.setBounds(44, 170, 94, 15);
		}
		return lblProductId;
	}

	private JComboBox<Integer> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<Integer>();
			comboBox.setToolTipText("Select the product");
			comboBox.setBounds(183, 160, 175, 25);

			QuickBillController qb = new QuickBillControllerImpl();
			List<Product> pList = qb.getAllProducts();
			for (Product p : pList) {
				comboBox.addItem(p.getId());
			}
		
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id = (int) comboBox.getSelectedItem();
					QuickBillController qb = new QuickBillControllerImpl();
					Product p = qb.getProductById(id);
					
					textProductName.setText(p.getName());
					textMrp.setText(String.valueOf(p.getMrp()));
					textQuantity.setText(String.valueOf(p.getqAvailable()));
				}
			});
		}
		return comboBox;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name:");
			lblName.setForeground(new Color(0, 255, 255));
			lblName.setBounds(44, 205, 70, 15);
		}
		return lblName;
	}

	private JLabel getLblMrp() {
		if (lblMrp == null) {
			lblMrp = new JLabel("MRP:");
			lblMrp.setForeground(new Color(0, 255, 255));
			lblMrp.setBounds(44, 240, 70, 15);
		}
		return lblMrp;
	}

	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity:");
			lblQuantity.setForeground(new Color(0, 255, 255));
			lblQuantity.setBounds(44, 276, 70, 15);
		}
		return lblQuantity;
	}

	private JLabel getLblDiscount() {
		if (lblDiscount == null) {
			lblDiscount = new JLabel("Discount:");
			lblDiscount.setForeground(new Color(0, 255, 255));
			lblDiscount.setBounds(44, 313, 94, 15);
		}
		return lblDiscount;
	}

	private JTextField getTextProductName() {
		if (textProductName == null) {
			textProductName = new JTextField();
			textProductName.setEditable(false);
			textProductName.setBounds(183, 195, 175, 25);
			textProductName.setColumns(10);
		}
		return textProductName;
	}

	private JTextField getTextMrp() {
		if (textMrp == null) {
			textMrp = new JTextField();
			textMrp.setEditable(false);
			textMrp.setBounds(183, 230, 175, 25);
			textMrp.setColumns(10);
		}
		return textMrp;
	}

	private JTextField getTextQuantity() {
		if (textQuantity == null) {
			textQuantity = new JTextField();
			textQuantity.setBounds(183, 266, 175, 25);
			textQuantity.setColumns(10);
		}
		return textQuantity;
	}

	private JTextField getTextDiscount() {
		if (textDiscount == null) {
			textDiscount = new JTextField();
			textDiscount.setBounds(183, 303, 175, 25);
			textDiscount.setColumns(10);
		}
		return textDiscount;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Bill newBill = new Bill();
					newBill.setBillno(Integer.parseInt(textBillno.getText()));
					newBill.setCustomer(textCustomerName.getText());

					Product newProduct = new Product();
					newProduct.setId((int) comboBox.getSelectedItem());
					newProduct.setName(textProductName.getText());
					newProduct.setMrp(Float.parseFloat((textMrp.getText())));
					newBill.setProduct(newProduct);

					newBill.setQuantity(Integer.parseInt(textQuantity.getText()));
					newBill.setDiscount(Float.parseFloat((textDiscount.getText())));
					
					float total = newProduct.getMrp() * (float) (newBill.getQuantity() - newBill.getDiscount());
					newBill.setTotal(total);
					textTotal.setText(String.valueOf(total));
					
					newBill.setDate(new Date(dateChooser.getDate().getTime()));

					NewBillController nbc = new NewBillControllerImpl();
					if (nbc.addBill(newBill)) {
						JOptionPane.showMessageDialog(null, "New bill successfully added in the database");
						displayData();
						return;
					} else {
						JOptionPane.showMessageDialog(null,
								"An error prevented the new Bill from adding to the database. Please try again");
						return;
					}

				}
			});
			btnAdd.setIcon(new ImageIcon(NewBill.class.getResource("/icons/iconAdd.png")));
			btnAdd.setBounds(81, 362, 104, 25);
		}
		return btnAdd;
	}

	protected void displayData() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		NewBillController nbc = new NewBillControllerImpl();
		List<Bill> bList = nbc.getAllBills();
		
		model.setRowCount(0);
		for(Bill b : bList) {
			model.addRow(new Object[] {b.getBillno(), b.getQuantity(), b.getProduct().getName(), b.getProduct().getMrp(), (b.getProduct().getMrp()-b.getDiscount())});
		}
		
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Remove");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NewBillController nbc = new NewBillControllerImpl();
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "Please select the row you want to remove");
						return;
					}
					
					if(nbc.deleteBill((int)table.getValueAt(table.getSelectedRow(), 0))) {
						JOptionPane.showMessageDialog(null, "Selected row deleted successfully!");
						displayData();
						return;
					} else {
						JOptionPane.showMessageDialog(null, "An error prevented the record from deleting");
						return;
					}
					
				}
			});
			btnRemove.setIcon(new ImageIcon(NewBill.class.getResource("/icons/cancelIcon.png")));
			btnRemove.setBounds(220, 362, 117, 25);
		}
		return btnRemove;
	}

	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total");
			lblTotal.setForeground(new Color(0, 255, 255));
			lblTotal.setBounds(570, 320, 70, 15);
		}
		return lblTotal;
	}

	private JTextField getTextTotal() {
		if (textTotal == null) {
			textTotal = new JTextField();
			textTotal.setEnabled(false);
			textTotal.setBounds(636, 318, 114, 19);
			textTotal.setColumns(10);
		}
		return textTotal;
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
						JOptionPane.showMessageDialog(null, "An error occured while printing the table. Please try again!\n" + e1.getMessage());
						e1.printStackTrace();
					}
				}
			});
			btnPrint.setIcon(new ImageIcon(NewBill.class.getResource("/icons/iconPrinter.png")));
			btnPrint.setBounds(444, 357, 104, 34);
		}
		return btnPrint;
	}

	private JLabel getLblNewBill() {
		if (lblNewBill == null) {
			lblNewBill = new JLabel("New Bill");
			lblNewBill.setForeground(new Color(255, 255, 0));
			lblNewBill.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			lblNewBill.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewBill.setBounds(94, 12, 168, 35);
		}
		return lblNewBill;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(377, -14, 12, 424);
		}
		return separator;
	}

	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnClose.setBounds(653, 357, 80, 34);
		}
		return btnClose;
	}
}
