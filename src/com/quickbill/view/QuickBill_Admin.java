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

public class QuickBill_Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7123225150894452390L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblQuickBill;
	private JLabel lblCashier;
	private JLabel lblTransaction;
	private JLabel lblStock;
	private JLabel lblSales;
	private JLabel lblExit;

	private JPopupMenu popupMenu;
	private JMenuItem mntmHome;
	private JSeparator separator;
	private JMenuItem mntmAbout;
	private JSeparator separator_1;
	private JMenuItem mntmExit;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmCashierLogin;
	private JSeparator separator_2;
	private JMenuItem mntmExit_1;
	private JMenu mnHelp;
	private JMenuItem mntmTutorial;
	private JSeparator separator_3;
	private JMenuItem mntmAbout_1;
	private JMenuItem mntmHome_1;
	private JMenu mnAdmin;
	private JMenuItem mntmCashier;
	private JMenuItem mntmTransaction;
	private JMenuItem mntmStock;
	private JMenuItem mntmSales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuickBill_Admin frame = new QuickBill_Admin();
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
	 * 
	 * @throws PropertyVetoException
	 */
	public QuickBill_Admin() throws PropertyVetoException {
		setResizable(false);
		setTitle("Quick Bill - Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1191, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		contentPane.add(getMenuBar_1());
	}

	private JPanel getPanel() throws PropertyVetoException {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panel.setBackground(new Color(139, 0, 139));
			panel.setBounds(0, 108, 1191, 510);
			panel.setLayout(null);
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(250, 250, 210));
			panel_1.setBounds(0, 23, 1191, 81);
			panel_1.setLayout(null);
			panel_1.add(getLblQuickBill());
			panel_1.add(getLblCashier());
			panel_1.add(getLblTransaction());
			panel_1.add(getLblStock());
			panel_1.add(getLblSales());
			panel_1.add(getLblExit());
		}
		return panel_1;
	}

	private JLabel getLblQuickBill() {
		if (lblQuickBill == null) {
			lblQuickBill = new JLabel("Quick Bill");
			lblQuickBill.setBorder(null);
			lblQuickBill
					.setIcon(new ImageIcon(new ImageIcon(QuickBill_Admin.class
							.getResource("/icons/iconQuickbill.png")).getImage()
									.getScaledInstance(40, 40,
											Image.SCALE_DEFAULT)));
			lblQuickBill.setForeground(new Color(25, 25, 112));
			lblQuickBill.setFont(new Font("Dialog", Font.BOLD, 20));
			lblQuickBill.setBounds(12, 12, 181, 54);

			addPopup(lblQuickBill, getPopupMenu());
		}
		return lblQuickBill;
	}

	private JLabel getLblCashier() {
		if (lblCashier == null) {
			lblCashier = new JLabel("Cashier");
			lblCashier.setBounds(205, 12, 125, 54);
			lblCashier.setToolTipText("View Cashiers");
			lblCashier.setHorizontalAlignment(SwingConstants.CENTER);
			lblCashier.setIcon(new ImageIcon(new ImageIcon(
					QuickBill_Admin.class.getResource("/icons/iconNew.png"))
							.getImage()
							.getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
			lblCashier.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					AddCashier cb = new AddCashier();
					cb.setVisible(true);
					cb.setResizable(false);
					cb.setLocationRelativeTo(null);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblCashier.setBorder(new BevelBorder(BevelBorder.RAISED));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblCashier.setBorder(null);
				}
			});

		}
		return lblCashier;
	}

	private JLabel getLblTransaction() {
		if (lblTransaction == null) {
			lblTransaction = new JLabel("Transaction");
			lblTransaction.setBounds(342, 12, 139, 54);
			lblTransaction.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblTransaction
							.setBorder(new BevelBorder(BevelBorder.RAISED));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblTransaction.setBorder(null);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					Transaction t = new Transaction();
					t.setVisible(true);
					t.setResizable(false);
					t.setLocationRelativeTo(null);
				}
			});
			lblTransaction.setToolTipText("View Transactions");
			lblTransaction.setHorizontalAlignment(SwingConstants.CENTER);
			lblTransaction.setIcon(new ImageIcon(new ImageIcon(
					QuickBill_Admin.class.getResource("/icons//iconSearch.png"))
							.getImage()
							.getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

		}
		return lblTransaction;
	}

	private JLabel getLblStock() {
		if (lblStock == null) {
			lblStock = new JLabel("Stock");
			lblStock.setToolTipText("View Stock");
			lblStock.setBounds(490, 12, 100, 54);
			lblStock.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					lblStock.setBorder(new BevelBorder(BevelBorder.RAISED));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblStock.setBorder(null);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					UpdateStock us = new UpdateStock();
					us.setVisible(true);
					us.setResizable(false);
					us.setLocationRelativeTo(null);

				}
			});
			lblStock.setIcon(new ImageIcon(new ImageIcon(
					QuickBill_Admin.class.getResource("/icons/iconBasket1.png"))
							.getImage()
							.getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
			lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblStock;
	}

	private JLabel getLblSales() {
		if (lblSales == null) {
			lblSales = new JLabel("Sales");
			lblSales.setToolTipText("View Sales");
			lblSales.setBounds(617, 15, 100, 54);
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
					Sales sales = new Sales();
					sales.setVisible(true);
					sales.setResizable(false);
					sales.setLocationRelativeTo(null);
				}
			});
			lblSales.setHorizontalAlignment(SwingConstants.CENTER);
			lblSales.setIcon(new ImageIcon(new ImageIcon(QuickBill_Admin.class
					.getResource("/icons/iconDollar3d.png")).getImage()
							.getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

		}
		return lblSales;
	}

	private JLabel getLblExit() {
		if (lblExit == null) {
			lblExit = new JLabel("Exit");
			lblExit.setBounds(1021, 15, 113, 54);
			lblExit.setHorizontalAlignment(SwingConstants.CENTER);
			lblExit.setToolTipText("Close the application");
			lblExit.setIcon(new ImageIcon(new ImageIcon(
					QuickBill_Admin.class.getResource("/icons/iconExit.png"))
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
			mnFile.add(getMnAdmin());
			mnFile.add(getMntmCashierLogin());
			mnFile.add(getSeparator_2());
			mnFile.add(getMntmExit_1());
		}
		return mnFile;
	}
	private JMenuItem getMntmCashierLogin() {
		if (mntmCashierLogin == null) {
			mntmCashierLogin = new JMenuItem("Cashier login");
			mntmCashierLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					CashierLogin cl = new CashierLogin();
					cl.setVisible(true);
					cl.setResizable(false);
					cl.setLocationRelativeTo(null);
				}
			});
		}
		return mntmCashierLogin;
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
					JOptionPane.showMessageDialog(null, "There is no help available. You are on your own.");
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
					About about = new About();
					about.setVisible(true);
					about.setResizable(false);
					about.setLocationRelativeTo(null);
				}
			});
		}
		return mntmAbout_1;
	}
	private JMenuItem getMntmHome_1() {
		if (mntmHome_1 == null) {
			mntmHome_1 = new JMenuItem("Home");
		}
		mntmHome_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Welcome w = new Welcome();
				w.setVisible(true);
				w.setResizable(false);
				w.setLocationRelativeTo(null);
			}
		});
		return mntmHome_1;
	}
	private JMenu getMnAdmin() {
		if (mnAdmin == null) {
			mnAdmin = new JMenu("Admin");
			mnAdmin.add(getMntmCashier());
			mnAdmin.add(getMntmTransaction());
			mnAdmin.add(getMntmStock());
			mnAdmin.add(getMntmSales());
		}
		return mnAdmin;
	}
	private JMenuItem getMntmCashier() {
		if (mntmCashier == null) {
			mntmCashier = new JMenuItem("Cashier");
			mntmCashier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddCashier cb = new AddCashier();
					cb.setVisible(true);
					cb.setResizable(false);
					cb.setLocationRelativeTo(null);
				}
			});
		}
		return mntmCashier;
	}
	private JMenuItem getMntmTransaction() {
		if (mntmTransaction == null) {
			mntmTransaction = new JMenuItem("Transaction");
			mntmTransaction.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Transaction t = new Transaction();
					t.setVisible(true);
					t.setResizable(false);
					t.setLocationRelativeTo(null);
				}
			});
		}
		return mntmTransaction;
	}
	private JMenuItem getMntmStock() {
		if (mntmStock == null) {
			mntmStock = new JMenuItem("Stock");
			mntmStock.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UpdateStock us = new UpdateStock();
					us.setVisible(true);
					us.setResizable(false);
					us.setLocationRelativeTo(null);
				}
			});
		}
		return mntmStock;
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
}
