package com.quickbill.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.quickbill.controller.QuickBillController;
import com.quickbill.controller.QuickBillControllerImpl;
import com.quickbill.model.Admin;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8435977441688166987L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblFirstName;
	private JTextField textFname;
	private JLabel lblLastName;
	private JTextField textLname;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JLabel lblRetypePassword;
	private JLabel lblBirthdate;
	private JLabel lblAddress;
	private JTextField textUsername;
	private JPasswordField textPass;
	private JPasswordField textRePass;
	private JDateChooser date;
	private JTextArea textAddress;
	private JButton btnCancel;
	private JButton btnRegister;
	private JLabel lblRegisterANew;
	private JLabel lblAlreadyHaveAn;
	private JLabel lblLogin;
	private JLabel labelPswCheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("Register");
		setBounds(new Rectangle(50, 30, 0, 0));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setForeground(new Color(0, 0, 255));
			panel.setBackground(new Color(220, 20, 60));
			panel.setBounds(0, 0, 467, 534);
			panel.setLayout(null);
			panel.add(getLblFirstName());
			panel.add(getTextFname());
			panel.add(getLblLastName());
			panel.add(getTextLname());
			panel.add(getLblUser());
			panel.add(getLblPassword());
			panel.add(getLblRetypePassword());
			panel.add(getLblBirthdate());
			panel.add(getLblAddress());
			panel.add(getTextUsername());
			panel.add(getTextPass());
			panel.add(getTextRePass());
			panel.add(getDate());
			panel.add(getTextAddress());
			panel.add(getBtnCancel());
			panel.add(getBtnRegister());
			panel.add(getLblRegisterANew());
			panel.add(getLblAlreadyHaveAn());
			panel.add(getLblLogin());
			panel.add(getLabelPswCheck());
		}
		return panel;
	}

	private JLabel getLblFirstName() {
		if (lblFirstName == null) {
			lblFirstName = new JLabel("First Name:");
			lblFirstName.setForeground(new Color(173, 216, 230));
			lblFirstName.setBounds(92, 94, 90, 15);
		}
		return lblFirstName;
	}

	private JTextField getTextFname() {
		if (textFname == null) {
			textFname = new JTextField();
			textFname.setForeground(new Color(255, 240, 245));
			textFname.setBackground(new Color(128, 128, 128));
			textFname.setBounds(200, 84, 192, 25);
			textFname.setColumns(10);
		}
		return textFname;
	}

	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name:");
			lblLastName.setForeground(new Color(173, 216, 230));
			lblLastName.setBounds(92, 141, 90, 15);
		}
		return lblLastName;
	}

	private JTextField getTextLname() {
		if (textLname == null) {
			textLname = new JTextField();
			textLname.setForeground(new Color(255, 240, 245));
			textLname.setBackground(new Color(128, 128, 128));
			textLname.setBounds(200, 131, 192, 25);
			textLname.setColumns(10);
		}
		return textLname;
	}

	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("Username:");
			lblUser.setForeground(new Color(173, 216, 230));
			lblUser.setBounds(92, 186, 90, 15);
		}
		return lblUser;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setForeground(new Color(173, 216, 230));
			lblPassword.setBounds(99, 231, 83, 15);
		}
		return lblPassword;
	}

	private JLabel getLblRetypePassword() {
		if (lblRetypePassword == null) {
			lblRetypePassword = new JLabel("Retype Password:");
			lblRetypePassword.setForeground(new Color(173, 216, 230));
			lblRetypePassword.setBounds(53, 276, 129, 15);
		}
		return lblRetypePassword;
	}

	private JLabel getLblBirthdate() {
		if (lblBirthdate == null) {
			lblBirthdate = new JLabel("Date of Birth:");
			lblBirthdate.setForeground(new Color(173, 216, 230));
			lblBirthdate.setBounds(73, 321, 110, 15);
		}
		return lblBirthdate;
	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setForeground(new Color(173, 216, 230));
			lblAddress.setBounds(110, 356, 73, 15);
		}
		return lblAddress;
	}

	private JTextField getTextUsername() {
		if (textUsername == null) {
			textUsername = new JTextField();
			textUsername.setForeground(new Color(255, 240, 245));
			textUsername.setBackground(new Color(128, 128, 128));
			textUsername.setBounds(200, 176, 192, 25);
			textUsername.setColumns(10);
		}
		return textUsername;
	}

	private JPasswordField getTextPass() {
		if (textPass == null) {
			textPass = new JPasswordField();
			textPass.setForeground(new Color(255, 240, 245));
			textPass.setBackground(new Color(128, 128, 128));
			textPass.setBounds(200, 221, 192, 25);
		}
		return textPass;
	}

	private JPasswordField getTextRePass() {
		if (textRePass == null) {
			textRePass = new JPasswordField();
			textRePass.setForeground(new Color(255, 240, 245));
			textRePass.setBackground(new Color(128, 128, 128));
			textRePass.setBounds(200, 266, 192, 25);
		}
		return textRePass;
	}

	private JDateChooser getDate() {
		if (date == null) {
			date = new JDateChooser();
			date.setForeground(new Color(255, 240, 245));
			date.setBackground(new Color(128, 128, 128));
			date.setBounds(200, 311, 192, 25);
		}
		return date;
	}

	private JTextArea getTextAddress() {
		if (textAddress == null) {
			textAddress = new JTextArea();
			textAddress.setForeground(new Color(255, 240, 245));
			textAddress.setBackground(new Color(128, 128, 128));
			textAddress.setBounds(200, 356, 198, 70);
		}
		return textAddress;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Welcome wl = new Welcome();
					wl.setVisible(true);
					wl.setResizable(false);

				}
			});
			btnCancel.setBackground(new Color(255, 70, 0));
			btnCancel.setBounds(110, 455, 117, 25);
		}
		return btnCancel;
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Register");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Admin admin = new Admin();
					admin.setFname(textFname.getText());
					admin.setLname(textLname.getText());
					admin.setUsername(textUsername.getText());
					admin.setPassword(new String(textPass.getPassword()));
					admin.setDob(date.getDate());
					admin.setAddress(textAddress.getText());

					String p1 = new String(textPass.getPassword());
					String p2 = new String(textRePass.getPassword());

					if (!p1.equals(p2)) {
						labelPswCheck.setVisible(true);
						JOptionPane.showMessageDialog(null, "The two passwords do not match. Please try again");
						return;
					}

					QuickBillController qbc = new QuickBillControllerImpl();
					if (qbc.addAdmin(admin)) {
						JOptionPane.showMessageDialog(null, "New admin successfully created! Now you can login");
						dispose();
						Welcome w = new Welcome();
						w.setVisible(true);
						w.setResizable(false);

					} else {
						JOptionPane.showMessageDialog(null, "There was an error processing your request. Please try again!");
						return;
					}

				}
			});
			btnRegister.setBackground(new Color(65, 105, 225));
			btnRegister.setBounds(281, 455, 117, 25);
		}
		return btnRegister;
	}

	private JLabel getLblRegisterANew() {
		if (lblRegisterANew == null) {
			lblRegisterANew = new JLabel("Register a new Account");
			lblRegisterANew.setForeground(new Color(255, 255, 0));
			lblRegisterANew.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			lblRegisterANew.setBounds(53, 25, 364, 32);
		}
		return lblRegisterANew;
	}

	private JLabel getLblAlreadyHaveAn() {
		if (lblAlreadyHaveAn == null) {
			lblAlreadyHaveAn = new JLabel("Already have an account?  Please ");
			lblAlreadyHaveAn.setForeground(new Color(0, 191, 255));
			lblAlreadyHaveAn.setBounds(104, 492, 249, 15);
		}
		return lblAlreadyHaveAn;
	}

	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("login ");
			lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblLogin.setText("<html><a href=''>login</a></html>");
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblLogin.setText("login");
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					AdminLogin al = new AdminLogin();
					al.setVisible(true);
					al.setResizable(false);
				}
			});
			lblLogin.setForeground(new Color(0, 0, 128));
			lblLogin.setBounds(344, 492, 54, 15);
		}
		return lblLogin;
	}

	private JLabel getLabelPswCheck() {
		if (labelPswCheck == null) {
			labelPswCheck = new JLabel("");
			labelPswCheck.setIcon(new ImageIcon(Register.class.getResource("/icons/cancelIcon.png")));
			labelPswCheck.setBounds(399, 261, 40, 30);
			labelPswCheck.setVisible(false);
		}
		return labelPswCheck;
	}
}
