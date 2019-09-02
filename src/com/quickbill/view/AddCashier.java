package com.quickbill.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.quickbill.controller.QuickBillController;
import com.quickbill.controller.QuickBillControllerImpl;
import com.quickbill.model.Cashier;

public class AddCashier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4489885827081918922L;
	private JPanel contentPane;
	private JLabel lblAddCashierDetails;
	private JLabel lblCashierId;
	private JTextField textCId;
	private JLabel lblCashierName;
	private JLabel lblMobileNumber;
	private JTextField textCName;
	private JTextField textCMobile;
	private JLabel lblAddress;
	private JTextField textCAddress;
	private JLabel lblEmailId;
	private JTextField textCEmail;
	private JLabel lblPassword;
	private JPasswordField textCPassword;
	private JButton btnAddNew;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCashier frame = new AddCashier();
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
	public AddCashier() {
		setResizable(false);
		setTitle("Add Cashier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 845, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAddCashierDetails());
		contentPane.add(getLblCashierId());
		contentPane.add(getTextCId());
		contentPane.add(getLblCashierName());
		contentPane.add(getLblMobileNumber());
		contentPane.add(getTextCName());
		contentPane.add(getTextCMobile());
		contentPane.add(getLblAddress());
		contentPane.add(getTextCAddress());
		contentPane.add(getLblEmailId());
		contentPane.add(getTextCEmail());
		contentPane.add(getLblPassword());
		contentPane.add(getTextCPassword());
		contentPane.add(getBtnAddNew());
		contentPane.add(getBtnUpdate());
		contentPane.add(getBtnDelete());
		contentPane.add(getSeparator());
		contentPane.add(getScrollPane());

		displayData();
	}

	private JLabel getLblAddCashierDetails() {
		if (lblAddCashierDetails == null) {
			lblAddCashierDetails = new JLabel("Add Cashier Details");
			lblAddCashierDetails.setForeground(new Color(128, 0, 128));
			lblAddCashierDetails.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			lblAddCashierDetails.setBounds(35, 20, 294, 40);
		}
		return lblAddCashierDetails;
	}

	private JLabel getLblCashierId() {
		if (lblCashierId == null) {
			lblCashierId = new JLabel("Cashier Id");
			lblCashierId.setBounds(52, 93, 117, 15);
		}
		return lblCashierId;
	}

	private JTextField getTextCId() {
		if (textCId == null) {
			textCId = new JTextField();
			textCId.setBounds(188, 80, 196, 28);
			textCId.setColumns(10);
		}
		return textCId;
	}

	private JLabel getLblCashierName() {
		if (lblCashierName == null) {
			lblCashierName = new JLabel("Cashier Name");
			lblCashierName.setBounds(52, 128, 117, 28);
		}
		return lblCashierName;
	}

	private JLabel getLblMobileNumber() {
		if (lblMobileNumber == null) {
			lblMobileNumber = new JLabel("Mobile number");
			lblMobileNumber.setBounds(52, 179, 117, 25);
		}
		return lblMobileNumber;
	}

	private JTextField getTextCName() {
		if (textCName == null) {
			textCName = new JTextField();
			textCName.setBounds(188, 128, 196, 28);
			textCName.setColumns(10);
		}
		return textCName;
	}

	private JTextField getTextCMobile() {
		if (textCMobile == null) {
			textCMobile = new JTextField();
			textCMobile.setBounds(188, 176, 196, 28);
			textCMobile.setColumns(10);
		}
		return textCMobile;
	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setBounds(52, 237, 117, 15);
		}
		return lblAddress;
	}

	private JTextField getTextCAddress() {
		if (textCAddress == null) {
			textCAddress = new JTextField();
			textCAddress.setBounds(188, 224, 196, 28);
			textCAddress.setColumns(10);
		}
		return textCAddress;
	}

	private JLabel getLblEmailId() {
		if (lblEmailId == null) {
			lblEmailId = new JLabel("Email Id");
			lblEmailId.setBounds(52, 285, 117, 15);
		}
		return lblEmailId;
	}

	private JTextField getTextCEmail() {
		if (textCEmail == null) {
			textCEmail = new JTextField();
			textCEmail.setBounds(188, 272, 196, 28);
			textCEmail.setColumns(10);
		}
		return textCEmail;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(52, 333, 117, 15);
		}
		return lblPassword;
	}

	private JPasswordField getTextCPassword() {
		if (textCPassword == null) {
			textCPassword = new JPasswordField();
			textCPassword.setBounds(188, 320, 196, 28);
		}
		return textCPassword;
	}

	private JButton getBtnAddNew() {
		if (btnAddNew == null) {
			btnAddNew = new JButton("Add New");
			btnAddNew.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cashier c = new Cashier();
					c.setId(Integer.parseInt(textCId.getText()));
					c.setName(textCName.getText());
					c.setAddress(textCAddress.getText());
					c.setNumber(textCMobile.getText());
					c.setEmail(textCEmail.getText());
					c.setPassword(new String(textCPassword.getPassword()));

					QuickBillController qb = new QuickBillControllerImpl();
					if (qb.addCashier(c)) {
						JOptionPane.showMessageDialog(null, "New cashier successfully added to the database.");

						textCId.setText("");
						textCName.setText("");
						textCAddress.setText("");
						textCMobile.setText("");
						textCEmail.setText("");
						textCPassword.setText("");

						displayData();

						return;

					} else {
						JOptionPane.showMessageDialog(null, "An error was encountered. Please try again");
						return;
					}

				}
			});
			btnAddNew.setIcon(new ImageIcon(AddCashier.class.getResource("/icons/iconNewUser.png")));
			btnAddNew.setBounds(12, 368, 132, 28);
		}
		return btnAddNew;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cashier c = new Cashier();
					c.setId(Integer.parseInt(textCId.getText()));
					c.setName(textCName.getText());
					c.setAddress(textCAddress.getText());
					c.setNumber(textCMobile.getText());
					c.setEmail(textCEmail.getText());
					c.setPassword(new String(textCPassword.getPassword()));

					QuickBillController qb = new QuickBillControllerImpl();
					if (qb.updateCashier(c)) {
						JOptionPane.showMessageDialog(null,
								"Cashier " + textCName.getText() + " successfully update in the database.");

						textCId.setText("");
						textCName.setText("");
						textCAddress.setText("");
						textCMobile.setText("");
						textCEmail.setText("");
						textCPassword.setText("");

						displayData();

						return;
					}

				}
			});
			btnUpdate.setIcon(new ImageIcon(AddCashier.class.getResource("/icons/iconUpdate.png")));
			btnUpdate.setBounds(157, 368, 117, 28);
		}
		return btnUpdate;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(null, "Please select the row whose data you want to delete!");
						return;
					} else {
						int id = (int) table.getValueAt(row, 0);
						int response = JOptionPane.showConfirmDialog(null,
								"Are you sure you want to delete this record?", "Are you sure?",
								JOptionPane.YES_NO_OPTION);
						if (response == 0) {

							QuickBillController qbc = new QuickBillControllerImpl();
							if (qbc.deleteById(id)) {
								displayData();
								JOptionPane.showMessageDialog(null, "Record deleted successfully!");
								return;
							} else {
								JOptionPane.showMessageDialog(null,
										"An error prevented the record from deleting. Please try again!");
								return;
							}
						} else if (response == 1) {
							return;
						}
					}

				}
			});
			btnDelete.setIcon(new ImageIcon(AddCashier.class.getResource("/icons/iconTrash.png")));
			btnDelete.setBounds(286, 368, 117, 28);
		}
		return btnDelete;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(421, 12, 14, 384);
		}
		return separator;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(447, 20, 386, 365);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();

			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "id", "Name", "Number", "Address", "Email", "Password" }));
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				int id = (int) table.getValueAt(row, 0);
				QuickBillController qb = new QuickBillControllerImpl();
				Cashier c = new Cashier();
				c = qb.getCashierById(id);
				textCId.setText(String.valueOf(c.getId()));
				textCName.setText(c.getName());
				textCMobile.setText(c.getNumber());
				textCAddress.setText(c.getAddress());
				textCEmail.setText(c.getEmail());
				textCPassword.setText(c.getPassword());

			}
		});
		return table;
	}

	void displayData() {
		QuickBillController qb = new QuickBillControllerImpl();
		List<Cashier> cList = qb.getAllCashiers();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Cashier c : cList) {
			model.addRow(new Object[] { c.getId(), c.getName(), c.getNumber(), c.getAddress(), c.getEmail(),
					c.getPassword() });
		}
	}
}
