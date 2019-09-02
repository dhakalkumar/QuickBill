package com.quickbill.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.quickbill.controller.LoginController;

public class AdminLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7799987998364590716L;
	private JPanel contentPane;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton button;
	private JButton btnLogin;
	private JLabel lblClickHere;
	private JLabel lblToCreateA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AdminLogin.class.getResource("/icons/iconQuickbill.png")));
		setResizable(false);
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getTextField());
		contentPane.add(getPasswordField());
		contentPane.add(getButton());
		contentPane.add(getBtnLogin());
		contentPane.add(getLblClickHere());
		contentPane.add(getLblToCreateA());
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setFont(new Font("Dialog", Font.BOLD, 16));
			lblUsername.setForeground(new Color(255, 255, 255));
			lblUsername.setBounds(39, 54, 123, 25);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password: ");
			lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
			lblPassword.setForeground(new Color(255, 255, 255));
			lblPassword.setBounds(39, 103, 123, 25);
		}
		return lblPassword;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBackground(new Color(128, 128, 128));
			textField.setForeground(new Color(127, 255, 212));
			textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
					null, null));
			textField.setBounds(168, 54, 208, 25);
			textField.setColumns(10);
		}
		return textField;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setForeground(new Color(127, 255, 212));
			passwordField.setBackground(new Color(128, 128, 128));
			passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
					null, null, null));
			passwordField.setBounds(168, 103, 208, 25);
		}
		return passwordField;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Cancel");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Welcome w = new Welcome();
					w.setVisible(true);
					w.setResizable(false);

				}
			});
			button.setBackground(new Color(255, 70, 0));
			button.setForeground(Color.WHITE);
			button.setBounds(144, 157, 91, 37);
		}
		return button;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String username = textField.getText();

					char[] psw = passwordField.getPassword();
					String password = new String(psw);

					LoginController lc = new LoginController();
					if (lc.adminLogin(username, password)) {
						dispose();
						try {
							QuickBill_Admin qba = new QuickBill_Admin();
							qba.setVisible(true);
							qba.setResizable(false);
							qba.setLocationRelativeTo(null);

						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(btnLogin,
								"You have entered invalid username or password."
										+ " Please check your input and try again",
								"Invalid Credentials",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			});
			btnLogin.setForeground(new Color(255, 255, 255));
			btnLogin.setBackground(new Color(65, 105, 225));
			btnLogin.setBounds(275, 157, 81, 37);
		}
		return btnLogin;
	}
	private JLabel getLblClickHere() {
		if (lblClickHere == null) {
			lblClickHere = new JLabel("Click here");
			lblClickHere
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblClickHere.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					Register r = new Register();
					r.setResizable(false);
					r.setVisible(true);

				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lblClickHere.setText(
							"<html><a href=''>Click here</a></html>");
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblClickHere.setText("Click here");
				}
			});
			lblClickHere.setForeground(new Color(255, 0, 255));
			lblClickHere.setBounds(110, 243, 81, 15);
		}
		return lblClickHere;
	}
	private JLabel getLblToCreateA() {
		if (lblToCreateA == null) {
			lblToCreateA = new JLabel("to create a new account");
			lblToCreateA.setForeground(new Color(127, 255, 212));
			lblToCreateA.setBounds(185, 243, 191, 15);
		}
		return lblToCreateA;
	}
}
