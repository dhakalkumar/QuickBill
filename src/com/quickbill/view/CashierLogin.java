package com.quickbill.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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

public class CashierLogin extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					CashierLogin frame = new CashierLogin();
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
	public CashierLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				CashierLogin.class.getResource("/icons/iconQuickbill.png")));
		setResizable(false);
		setTitle("Cashier Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 287);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getTextField());
		contentPane.add(getPasswordField());
		contentPane.add(getButton());
		contentPane.add(getBtnLogin());
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Cashier Email:");
			lblUsername.setFont(new Font("Dialog", Font.BOLD, 16));
			lblUsername.setForeground(new Color(255, 255, 255));
			lblUsername.setBounds(39, 61, 137, 25);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password: ");
			lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
			lblPassword.setForeground(new Color(255, 255, 255));
			lblPassword.setBounds(39, 110, 123, 25);
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
			textField.setBounds(185, 55, 208, 31);
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
			passwordField.setBounds(185, 104, 208, 31);
		}
		return passwordField;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Cancel");
			button.setIcon(new ImageIcon(
					CashierLogin.class.getResource("/icons/cancelIcon.png")));
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
			button.setBounds(107, 170, 123, 37);
		}
		return button;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.setIcon(new ImageIcon(new ImageIcon(
					CashierLogin.class.getResource("/icons/iconCashier.jpg"))
							.getImage()
							.getScaledInstance(40, 30, Image.SCALE_DEFAULT)));
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String username = textField.getText();
					String password = new String(passwordField.getPassword());

					LoginController lc = new LoginController();
					if (lc.userLogin(username, password)) {
						dispose();
						QuickBill_Cashier qb = new QuickBill_Cashier();
						qb.setVisible(true);
						qb.setResizable(false);

					} else {
						JOptionPane.showMessageDialog(btnLogin,
								"You have entered invalid username or password."
										+ " Please check your input and try again",
								"Invalid Credentials",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			});
			btnLogin.setForeground(new Color(255, 255, 255));
			btnLogin.setBackground(new Color(65, 105, 225));
			btnLogin.setBounds(286, 170, 137, 37);
		}
		return btnLogin;
	}
}
