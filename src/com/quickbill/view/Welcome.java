package com.quickbill.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Welcome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7097830616473688635L;
	private JPanel contentPane;
	private JLabel lblWelcomeToSuper;
	private JLabel labelIcon;
	private JLabel lblQuickBill;
	private JButton btnAdminLogin;
	private JButton btnCashierLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Welcome frame = new Welcome();
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
	public Welcome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Welcome.class.getResource("/icons/iconQuickbill.png")));
		setTitle("Quick Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 405);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblWelcomeToSuper());
		contentPane.add(getLabelIcon());
		contentPane.add(getLblQuickBill());
		contentPane.add(getBtnAdminLogin());
		contentPane.add(getBtnCashierLogin());
	}
	private JLabel getLblWelcomeToSuper() {
		if (lblWelcomeToSuper == null) {
			lblWelcomeToSuper = new JLabel("Welcome To Super Market Billing System");
			lblWelcomeToSuper.setForeground(SystemColor.activeCaption);
			lblWelcomeToSuper.setFont(new Font("Bitstream Vera Serif", Font.BOLD | Font.ITALIC, 25));
			lblWelcomeToSuper.setBounds(12, 12, 609, 46);
		}
		return lblWelcomeToSuper;
	}
	private JLabel getLabelIcon() {
		if (labelIcon == null) {
			labelIcon = new JLabel("");
			labelIcon.setIcon(new ImageIcon(Welcome.class.getResource("/icons/iconQuickbill.png")));
			labelIcon.setOpaque(true);
			labelIcon.setBounds(70, 108, 141, 133);
		}
		return labelIcon;
	}
	private JLabel getLblQuickBill() {
		if (lblQuickBill == null) {
			lblQuickBill = new JLabel("Quick Bill");
			lblQuickBill.setForeground(new Color(25, 25, 112));
			lblQuickBill.setFont(new Font("Dialog", Font.BOLD, 30));
			lblQuickBill.setBounds(70, 246, 190, 65);
		}
		return lblQuickBill;
	}
	private JButton getBtnAdminLogin() {
		if (btnAdminLogin == null) {
			btnAdminLogin = new JButton("Admin Login");
			btnAdminLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					
					AdminLogin cl = new AdminLogin();
					cl.setVisible(true);
					cl.setResizable(false);
										
				}
			});
			btnAdminLogin.setBounds(402, 152, 158, 40);
		}
		return btnAdminLogin;
	}
	private JButton getBtnCashierLogin() {
		if (btnCashierLogin == null) {
			btnCashierLogin = new JButton("Cashier Login");
			btnCashierLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					dispose();
					CashierLogin al = new CashierLogin();
					al.setVisible(true);
					al.setResizable(false);
					
				}
			});
			btnCashierLogin.setBounds(402, 246, 158, 40);
		}
		return btnCashierLogin;
	}
}
