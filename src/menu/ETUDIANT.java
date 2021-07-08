package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.TextField;
import java.beans.Statement;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Dimension;

import java.sql.*;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ETUDIANT {

	private JFrame frame;
	private JTextField txtSaisieMATRICULE;

	private ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ETUDIANT window = new ETUDIANT();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ETUDIANT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(new Color(52, 82, 181));
		frame.getContentPane().setLayout(null);
		frame.setSize(new Dimension(720, 600));
		frame.setResizable(false);
				
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 357, 382);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUSTHBDATABASE = new JLabel("USTHB Data Base");
		lblUSTHBDATABASE.setForeground(new Color(51, 102, 204));
		lblUSTHBDATABASE.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblUSTHBDATABASE.setBounds(74, 273, 199, 39);
		panel.add(lblUSTHBDATABASE);
		
		JLabel lblLOGO = new JLabel("");
		lblLOGO.setIcon(new ImageIcon(ETUDIANT.class.getResource("/images/usthb.png")));
		lblLOGO.setBounds(64, 30, 225, 232);
		panel.add(lblLOGO);
		
		JLabel lblModeETUDIANT = new JLabel("Vous \u00EAtes en mode ETUDIANT");
		lblModeETUDIANT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModeETUDIANT.setForeground(Color.WHITE);
		lblModeETUDIANT.setBounds(396, 23, 287, 20);
		frame.getContentPane().add(lblModeETUDIANT);
		
		txtSaisieMATRICULE = new JTextField();
		txtSaisieMATRICULE.setForeground(Color.RED);
		txtSaisieMATRICULE.setBounds(379, 88, 218, 20);
		frame.getContentPane().add(txtSaisieMATRICULE);
		txtSaisieMATRICULE.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 221, 315, 117);
		frame.getContentPane().add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 720, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mat = txtSaisieMATRICULE.getText();
				try {
					rs = LOGIN.statement.executeQuery("SELECT * FROM Etudiant WHERE matricule_etu="+mat);
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}				
			}
		});
		btnOK.setBounds(379, 119, 62, 23);
		frame.getContentPane().add(btnOK);
		
		JButton btnRETOUR = new JButton("Retour");
		btnRETOUR.setBounds(451, 119, 89, 23);
		frame.getContentPane().add(btnRETOUR);
		btnRETOUR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == btnRETOUR) {
					try {
						frame.dispose();
						LOGIN.main(null);
						System.out.println("DISCONNECTED");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		});

		
		JLabel lblMATRICULE = new JLabel("Matricule");
		lblMATRICULE.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMATRICULE.setForeground(Color.WHITE);
		lblMATRICULE.setBounds(379, 66, 79, 20);
		frame.getContentPane().add(lblMATRICULE);
		

	}
}
