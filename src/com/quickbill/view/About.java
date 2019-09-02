/**
 * @author Kumar Dhakal
 * @email  dhakalkumar10[AT]gmail[DOT]com
 */

package com.quickbill.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.activation.MailcapCommandMap;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class About extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2391484426379881450L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setTitle("About ...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSimpleInterestAnd = new JLabel("Quick Bill for supermarkets");
		lblSimpleInterestAnd.setForeground(new Color(46, 139, 87));
		lblSimpleInterestAnd.setFont(new Font("Dialog", Font.BOLD, 25));
		lblSimpleInterestAnd.setBounds(12, 12, 416, 32);
		contentPane.add(lblSimpleInterestAnd);

		JLabel lblVersion = new JLabel("Version 1.0.0");
		lblVersion.setBounds(12, 56, 111, 22);
		contentPane.add(lblVersion);

		JLabel lblDesignedByKumar = new JLabel("Designed by: Kumar Dhakal");
		lblDesignedByKumar.setBounds(12, 108, 222, 15);
		contentPane.add(lblDesignedByKumar);

		JLabel lblEmailDhakalkukmargmailcom = new JLabel("Email: ");
		lblEmailDhakalkukmargmailcom.setBounds(12, 135, 46, 15);
		contentPane.add(lblEmailDhakalkukmargmailcom);

		JLabel lblCopyrightc = new JLabel("Copyright (C) 2019");
		lblCopyrightc.setBounds(12, 162, 150, 22);
		contentPane.add(lblCopyrightc);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(93, 213, 85, 32);
		contentPane.add(btnClose);

		JLabel label = new JLabel("");
		label.setFocusable(false);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setToolTipText("Kumar Dhakal");
		label.setIcon(new ImageIcon(new ImageIcon(About.class.getResource("/images/kumar.jpg"))
				.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		label.setBounds(261, 56, 150, 152);
		contentPane.add(label);

		JLabel lblDhakalkumargmailcom = new JLabel("dhakalkumar10@gmail.com");
		lblDhakalkumargmailcom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				URI url;
				try {
					url = new URI("mailto:dhakalkumar10@gmail.com");
					Desktop.getDesktop().mail(url);

				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblDhakalkumargmailcom.setText("<html><a href=''>dhakalkumar10@gmail.com</a></html");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblDhakalkumargmailcom.setText("dhakalkumar10@gmail.com");
			}
		});
		lblDhakalkumargmailcom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDhakalkumargmailcom.setToolTipText("Send an Email to dhakalkumar10@gmail.com");
		lblDhakalkumargmailcom.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDhakalkumargmailcom.setForeground(new Color(0, 0, 255));
		lblDhakalkumargmailcom.setBounds(58, 131, 207, 22);
		contentPane.add(lblDhakalkumargmailcom);
	}
}
