package com.quickbill.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.quickbill.model.Bill;

public class QuickBill_Cashier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7123225150894452390L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblQuickBill;
	private JLabel lblCreateBill;
	private JLabel lblSearchBill;
	private JLabel lblProductInformation;
	private JLabel lblSales;
	private JLabel lblExit;
	private JPanel panel_2;
	private JPopupMenu popupMenu;
	private JMenuItem mntmHome;
	private JSeparator separator;
	private JMenuItem mntmAbout;
	private JSeparator separator_1;
	private JMenuItem mntmExit;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmHome_1;
	private JMenu mnCashier;
	private JMenuItem mntmCreateBill;
	private JMenuItem mntmSearchBill;
	private JMenuItem mntmProductInfo;
	private JMenuItem mntmSales;
	private JMenuItem mntmAdminLogin;
	private JSeparator separator_2;
	private JMenuItem mntmExit_1;
	private JMenu mnHelp;
	private JMenuItem mntmTutorial;
	private JSeparator separator_3;
	private JMenuItem mntmAbout_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuickBill_Cashier frame = new QuickBill_Cashier();
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
	 * 
	 * @throws PropertyVetoException
	 */
	public QuickBill_Cashier() {
		setTitle("Quick Bill - Cashier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1157, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		contentPane.add(getPanel_2());
		contentPane.add(getMenuBar_1());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(139, 0, 139));
			panel.setBounds(0, 81, 1157, 511);
			panel.setBackground(new Color(139, 0, 139));
			panel.setLayout(null);
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(250, 250, 210));
			panel_1.setBounds(0, 23, 1157, 83);
			panel_1.setLayout(null);
			panel_1.add(getLblQuickBill());
			panel_1.add(getLblCreateBill());
			panel_1.add(getLblSearchBill());
			panel_1.add(getLblProductInformation());
			panel_1.add(getLblSales());
			panel_1.add(getLblExit());
		}
		return panel_1;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(139, 0, 139));
			panel_2.setBounds(0, 108, 1157, 484);
		}
		return panel_2;
	}
	private JLabel getLblQuickBill() {

		if (lblQuickBill == null) {
			lblQuickBill = new JLabel("Quick Bill");
			lblQuickBill.setToolTipText("Click to open menu");
			lblQuickBill
					.setIcon(new ImageIcon(new ImageIcon(QuickBill_Admin.class
							.getResource("/icons/iconQuickbill.png")).getImage()
									.getScaledInstance(40, 40,
											Image.SCALE_DEFAULT)));
			lblQuickBill.setForeground(new Color(25, 25, 112));
			lblQuickBill.setFont(new Font("Dialog", Font.BOLD, 20));
			lblQuickBill.setBounds(12, 15, 181, 54);

			addPopup(lblQuickBill, getPopupMenu());
		}
		return lblQuickBill;

	}

	private JLabel getLblCreateBill() {
		if (lblCreateBill == null) {
			lblCreateBill = new JLabel("Create Bill");
			lblCreateBill.setBounds(205, 12, 125, 57);
			lblCreateBill.setToolTipText("Create new Bill");
			lblCreateBill.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreateBill.setIcon(new ImageIcon(new ImageIcon(
					QuickBill_Cashier.class.getResource("/icons/iconNew.png"))
							.getImage()
							.getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
			lblCreateBill.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					NewBill cb = new NewBill();
					cb.setVisible(true);
					cb.setResizable(false);

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblCreateBill
							.setBorder(new BevelBorder(BevelBorder.RAISED));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblCreateBill.setBorder(null);
				}
			});

		}
		return lblCreateBill;
	}

	private JLabel getLblSearchBill() {
		if (lblSearchBill == null) {
			lblSearchBill = new JLabel("Search Bill");
			lblSearchBill.setBounds(342, 12, 139, 57);
			lblSearchBill.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblSearchBill
							.setBorder(new BevelBorder(BevelBorder.RAISED));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblSearchBill.setBorder(null);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					SearchBill sb = new SearchBill();
					sb.setVisible(true);
					sb.setResizable(false);

				}
			});
			lblSearchBill.setToolTipText("Search Bill");
			lblSearchBill.setHorizontalAlignment(SwingConstants.CENTER);
			lblSearchBill
					.setIcon(new ImageIcon(new ImageIcon(QuickBill_Cashier.class
							.getResource("/icons//iconSearch.png")).getImage()
									.getScaledInstance(40, 40,
											Image.SCALE_DEFAULT)));

		}
		return lblSearchBill;
	}

	private JLabel getLblProductInformation() {
		if (lblProductInformation == null) {
			lblProductInformation = new JLabel("Product Information");
			lblProductInformation.setBounds(478, 15, 204, 57);
			lblProductInformation.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblProductInformation
							.setBorder(new BevelBorder(BevelBorder.RAISED));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblProductInformation.setBorder(null);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					ProductInfo pi = new ProductInfo();
					pi.setVisible(true);
					pi.setResizable(false);

				}
			});
			lblProductInformation
					.setIcon(new ImageIcon(new ImageIcon(QuickBill_Cashier.class
							.getResource("/icons/iconBasket1.png")).getImage()
									.getScaledInstance(40, 40,
											Image.SCALE_DEFAULT)));
			lblProductInformation.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblProductInformation;
	}

	private JLabel getLblSales() {
		if (lblSales == null) {
			lblSales = new JLabel("Sales");
			lblSales.setBounds(694, 12, 100, 57);
			lblSales.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblSales.setBorder(new BevelBorder(BevelBorder.RAISED));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblSales.setBorder(null);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					Sales s = new Sales();
					s.setVisible(true);
					s.setResizable(false);

				}
			});
			lblSales.setHorizontalAlignment(SwingConstants.CENTER);
			lblSales.setIcon(new ImageIcon(new ImageIcon(QuickBill_Cashier.class
					.getResource("/icons/iconDollar3d.png")).getImage()
							.getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

		}
		return lblSales;
	}

	private JLabel getLblExit() {
		if (lblExit == null) {
			lblExit = new JLabel("Exit");
			lblExit.setBounds(995, 15, 139, 57);
			lblExit.setHorizontalAlignment(SwingConstants.CENTER);
			lblExit.setToolTipText("Close the application");
			lblExit.setIcon(new ImageIcon(new ImageIcon(
					QuickBill_Cashier.class.getResource("/icons/iconExit.png"))
							.getImage()
							.getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
			lblExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblExit.setBorder(new BevelBorder(BevelBorder.RAISED));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblExit.setBorder(null);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					int exit = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to exit?", "Exit?",
							JOptionPane.YES_NO_OPTION);
					if (exit == 0) {
						System.exit(0);
					} else {
						return;
					}
				}
			});
		}
		return lblExit;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmHome());
			popupMenu.add(getSeparator());
			popupMenu.add(getMntmAbout());
			popupMenu.add(getSeparator_1());
			popupMenu.add(getMntmExit());
		}
		return popupMenu;
	}
	private /* static */ void addPopup(Component component,
			final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				showMenu(e);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblQuickBill.setBorder(new LineBorder(Color.RED));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblQuickBill.setBorder(null);
			}
		});
	}
	private JMenuItem getMntmHome() {
		if (mntmHome == null) {
			mntmHome = new JMenuItem("Home");
			mntmHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Welcome wl = new Welcome();
					wl.setVisible(true);
					wl.setResizable(false);
					wl.setLocationRelativeTo(null);
				}
			});
		}
		return mntmHome;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About ...");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					About about = new About();
					about.setVisible(true);
					about.setResizable(false);
					about.setLocationRelativeTo(null);
				}
			});
		}
		return mntmAbout;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int exit = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to exit?", "Exit?",
							JOptionPane.YES_NO_OPTION);
					if (exit == 0) {
						System.exit(0);
					} else {
						return;
					}
				}
			});
		}
		return mntmExit;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(12, 0, 129, 21);
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmHome_1());
			mnFile.add(getMnCashier());
			mnFile.add(getMntmAdminLogin());
			mnFile.add(getSeparator_2());
			mnFile.add(getMntmExit_1());
		}
		return mnFile;
	}
	private JMenuItem getMntmHome_1() {
		if (mntmHome_1 == null) {
			mntmHome_1 = new JMenuItem("Home");
			mntmHome_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Welcome w = new Welcome();
					w.setVisible(true);
					w.setResizable(false);
					w.setLocationRelativeTo(null);
				}
			});
		}
		return mntmHome_1;
	}
	private JMenu getMnCashier() {
		if (mnCashier == null) {
			mnCashier = new JMenu("Cashier");
			mnCashier.add(getMntmCreateBill());
			mnCashier.add(getMntmSearchBill());
			mnCashier.add(getMntmProductInfo());
			mnCashier.add(getMntmSales());
		}
		return mnCashier;
	}
	private JMenuItem getMntmCreateBill() {
		if (mntmCreateBill == null) {
			mntmCreateBill = new JMenuItem("Create Bill");
			mntmCreateBill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NewBill b = new NewBill();
					b.setVisible(true);
					b.setResizable(false);
					b.setLocationRelativeTo(null);
				}
			});
		}
		return mntmCreateBill;
	}
	private JMenuItem getMntmSearchBill() {
		if (mntmSearchBill == null) {
			mntmSearchBill = new JMenuItem("Search Bill");
			mntmSearchBill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SearchBill sb = new SearchBill();
					sb.setVisible(true);
					sb.setResizable(false);
					sb.setLocationRelativeTo(null);
				}
			});
		}
		return mntmSearchBill;
	}
	private JMenuItem getMntmProductInfo() {
		if (mntmProductInfo == null) {
			mntmProductInfo = new JMenuItem("Product Info");
			mntmProductInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProductInfo pi = new ProductInfo();
					pi.setVisible(true);
					pi.setResizable(false);
					pi.setLocationRelativeTo(null);
				}
			});
		}
		return mntmProductInfo;
	}
	private JMenuItem getMntmSales() {
		if (mntmSales == null) {
			mntmSales = new JMenuItem("Sales");
			mntmSales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Sales s = new Sales();
					s.setVisible(true);
					s.setResizable(false);
					s.setLocationRelativeTo(null);
				}
			});
		}
		return mntmSales;
	}
	private JMenuItem getMntmAdminLogin() {
		if (mntmAdminLogin == null) {
			mntmAdminLogin = new JMenuItem("Admin Login");
			mntmAdminLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					AdminLogin al = new AdminLogin();
					al.setVisible(true);
					al.setResizable(false);
					al.setLocationRelativeTo(null);
				}
			});
		}
		return mntmAdminLogin;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
		}
		return separator_2;
	}
	private JMenuItem getMntmExit_1() {
		if (mntmExit_1 == null) {
			mntmExit_1 = new JMenuItem("Exit");
			mntmExit_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int exit = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to exit?", "Exit?",
							JOptionPane.YES_NO_OPTION);
					if (exit == 0) {
						System.exit(0);
					} else {
						return;
					}
				}
			});
		}
		return mntmExit_1;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmTutorial());
			mnHelp.add(getSeparator_3());
			mnHelp.add(getMntmAbout_1());
		}
		return mnHelp;
	}
	private JMenuItem getMntmTutorial() {
		if (mntmTutorial == null) {
			mntmTutorial = new JMenuItem("Tutorial");
			mntmTutorial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "No help available. You are on your own!!");
					return;
				}
			});
		}
		return mntmTutorial;
	}
	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
		}
		return separator_3;
	}
	private JMenuItem getMntmAbout_1() {
		if (mntmAbout_1 == null) {
			mntmAbout_1 = new JMenuItem("About");
			mntmAbout_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					About a = new About();
					a.setVisible(true);
					a.setResizable(false);
					a.setLocationRelativeTo(null);
				}
			});
		}
		return mntmAbout_1;
	}
}
