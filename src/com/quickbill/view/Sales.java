package com.quickbill.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.quickbill.controller.NewBillController;
import com.quickbill.controller.NewBillControllerImpl;
import com.quickbill.controller.SalesController;
import com.quickbill.controller.SalesControllerImpl;
import com.quickbill.model.Bill;

public class Sales extends JFrame {

	private JPanel contentPane;
	private JButton btnClose;
	private JLabel lblSalesReport;
	private JLabel lblBillNo;
	private JLabel labelBillno;
	private JLabel lblCustomerName;
	private JLabel labelCName;
	private JLabel lblProduct;
	private JLabel labelProduct;
	private JLabel lblDiscount;
	private JLabel labelDiscount;
	private JLabel lblDate;
	private JLabel labelDate;
	private JLabel lblTotal;
	private JLabel labelTotal;
	private JLabel labelPrevious;
	private JLabel labelNext;
	private JLabel labelNotice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales frame = new Sales();
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
	public Sales() {
		setBackground(new Color(255, 0, 0));
		setResizable(false);
		setTitle("Sales");
		setForeground(new Color(0, 191, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 127));
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnClose());
		contentPane.add(getLblSalesReport());
		contentPane.add(getLblBillNo());
		contentPane.add(getLabelBillno());
		contentPane.add(getLblCustomerName());
		contentPane.add(getLabelCName());
		contentPane.add(getLblProduct());
		contentPane.add(getLabelProduct());
		contentPane.add(getLblDiscount());
		contentPane.add(getLabelDiscount());
		contentPane.add(getLblDate());
		contentPane.add(getLabelDate());
		contentPane.add(getLblTotal());
		contentPane.add(getLabelTotal());
		contentPane.add(getLabel_6());
		contentPane.add(getLabel_1_1());
		contentPane.add(getLabelNotice());

		displayData(1);
	}

	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("Close");
			btnClose.setForeground(new Color(255, 255, 0));
			btnClose.setBackground(new Color(0, 0, 255));
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnClose.setBounds(184, 352, 83, 25);
		}
		return btnClose;
	}

	private JLabel getLblSalesReport() {
		if (lblSalesReport == null) {
			lblSalesReport = new JLabel("Sales Report");
			lblSalesReport
					.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
			lblSalesReport.setForeground(new Color(139, 69, 19));
			lblSalesReport.setBounds(123, 12, 204, 27);
		}
		return lblSalesReport;
	}

	private JLabel getLblBillNo() {
		if (lblBillNo == null) {
			lblBillNo = new JLabel("Bill no.");
			lblBillNo.setForeground(new Color(128, 0, 128));
			lblBillNo.setBounds(51, 65, 139, 15);
		}
		return lblBillNo;
	}

	private JLabel getLabelBillno() {
		if (labelBillno == null) {
			labelBillno = new JLabel("");
			labelBillno.setForeground(new Color(128, 0, 128));
			labelBillno.setBounds(240, 65, 132, 15);
		}
		return labelBillno;
	}

	private JLabel getLblCustomerName() {
		if (lblCustomerName == null) {
			lblCustomerName = new JLabel("Customer Name");
			lblCustomerName.setForeground(new Color(128, 0, 128));
			lblCustomerName.setBounds(51, 99, 139, 15);
		}
		return lblCustomerName;
	}

	private JLabel getLabelCName() {
		if (labelCName == null) {
			labelCName = new JLabel("");
			labelCName.setForeground(new Color(128, 0, 128));
			labelCName.setBounds(240, 104, 132, 15);
		}
		return labelCName;
	}

	private JLabel getLblProduct() {
		if (lblProduct == null) {
			lblProduct = new JLabel("Product");
			lblProduct.setForeground(new Color(128, 0, 128));
			lblProduct.setBounds(51, 136, 139, 15);
		}
		return lblProduct;
	}

	private JLabel getLabelProduct() {
		if (labelProduct == null) {
			labelProduct = new JLabel("");
			labelProduct.setForeground(new Color(128, 0, 128));
			labelProduct.setBounds(240, 136, 132, 15);
		}
		return labelProduct;
	}

	private JLabel getLblDiscount() {
		if (lblDiscount == null) {
			lblDiscount = new JLabel("Discount");
			lblDiscount.setForeground(new Color(128, 0, 128));
			lblDiscount.setBounds(51, 175, 139, 15);
		}
		return lblDiscount;
	}

	private JLabel getLabelDiscount() {
		if (labelDiscount == null) {
			labelDiscount = new JLabel("");
			labelDiscount.setForeground(new Color(128, 0, 128));
			labelDiscount.setBounds(240, 175, 132, 15);
		}
		return labelDiscount;
	}

	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setForeground(new Color(128, 0, 128));
			lblDate.setBounds(51, 214, 139, 15);
		}
		return lblDate;
	}

	private JLabel getLabelDate() {
		if (labelDate == null) {
			labelDate = new JLabel("");
			labelDate.setForeground(new Color(128, 0, 128));
			labelDate.setBounds(240, 214, 132, 15);
		}
		return labelDate;
	}

	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total");
			lblTotal.setForeground(new Color(128, 0, 128));
			lblTotal.setBounds(51, 254, 139, 15);
		}
		return lblTotal;
	}

	private JLabel getLabelTotal() {
		if (labelTotal == null) {
			labelTotal = new JLabel("");
			labelTotal.setForeground(new Color(128, 0, 128));
			labelTotal.setBounds(240, 254, 132, 15);
		}
		return labelTotal;
	}

	private JLabel getLabel_6() {
		if (labelPrevious == null) {
			labelPrevious = new JLabel("<<< Previous");
			labelPrevious.setHorizontalTextPosition(SwingConstants.CENTER);
			labelPrevious.setHorizontalAlignment(SwingConstants.CENTER);
			labelPrevious
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			labelPrevious.setForeground(new Color(128, 0, 128));
			labelPrevious.setBounds(12, 309, 107, 37);
			labelPrevious.setBorder(new BevelBorder(BevelBorder.RAISED));

			labelPrevious.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					labelPrevious.setOpaque(true);
					labelPrevious.setBackground(Color.DARK_GRAY);
					labelPrevious.setForeground(Color.WHITE);

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					int currentId = Integer.parseInt(labelBillno.getText());
					
					if(currentId == 1) {
						displayData(1);
						labelNotice.setText("This is the first record!");						
					} else {
						labelNotice.setText("");
						displayData(--currentId);
					}

				}

				@Override
				public void mouseExited(MouseEvent e) {
					labelPrevious.setBackground(new Color(0, 255, 127));
					labelPrevious.setForeground(new Color(0, 0, 128));

				}
			});

		}
		return labelPrevious;
	}

	private JLabel getLabel_1_1() {
		if (labelNext == null) {
			labelNext = new JLabel("Next >>>");
			labelNext.setHorizontalTextPosition(SwingConstants.CENTER);
			labelNext.setHorizontalAlignment(SwingConstants.CENTER);
			labelNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			labelNext.setBorder(new BevelBorder(BevelBorder.RAISED));
			labelNext.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					labelNext.setOpaque(true);
					labelNext.setBackground(Color.DARK_GRAY);
					labelNext.setForeground(Color.WHITE);

				}

				@Override
				public void mouseClicked(MouseEvent e) {

					int currentId = Integer.parseInt(labelBillno.getText());
					NewBillController s = new NewBillControllerImpl();
					Bill b = s.getBillById(currentId+1);
					
					if(b == null) {
						displayData(currentId);
						labelNotice.setText("This is the last record!");						
					} else {
						labelNotice.setText("");
						displayData(++currentId);
					}

				}

				@Override
				public void mouseExited(MouseEvent e) {
					labelNext.setBackground(new Color(0, 255, 127));
					labelNext.setForeground(new Color(0, 0, 128));
				}
			});
			labelNext.setForeground(new Color(128, 0, 128));
			labelNext.setBounds(354, 309, 83, 37);
		}
		return labelNext;
	}

	private void displayData(int id) {
		
		labelNotice.setText("");

		NewBillController sales = new NewBillControllerImpl();
		Bill b = sales.getBillById(id);
		labelBillno.setText(String.valueOf(b.getBillno()));
		labelCName.setText(b.getCustomer());
		labelProduct.setText(b.getProduct().getName());
		labelDiscount.setText(String.valueOf(b.getDiscount()));
		labelDate.setText(String.valueOf(b.getDate()));
		labelTotal.setText(String.valueOf(b.getTotal()));

	}

	private JLabel getLabelNotice() {
		if (labelNotice == null) {
			labelNotice = new JLabel("");
			labelNotice.setBounds(156, 309, 186, 25);
		}
		return labelNotice;
	}
}
