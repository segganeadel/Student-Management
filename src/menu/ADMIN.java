package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Dimension;

import java.sql.*;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class ADMIN {

	private JFrame frame;
	private ResultSet rs = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMIN window = new ADMIN();
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
	public ADMIN() {
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
		panel.setBounds(0, 0, 365, 382);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBounds(0, 0, 365, 382);
		panel.add(table);
		
		JLabel lblModeADMIN = new JLabel("Vous \u00EAtes en mode ADMIN");
		lblModeADMIN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModeADMIN.setForeground(Color.WHITE);
		lblModeADMIN.setBounds(411, 11, 252, 20);
		frame.getContentPane().add(lblModeADMIN);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 177, 112, -41);
		frame.getContentPane().add(scrollPane);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 720, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnETUDIANT = new JButton("Etudiant");
		btnETUDIANT.setBounds(491, 81, 112, 23);
		frame.getContentPane().add(btnETUDIANT);
		btnETUDIANT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == btnETUDIANT) {
					try {
						
						String q = "SELECT * FROM Etudiant";
						rs = LOGIN.statement.executeQuery(q);
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		});		
		
		JButton btnENSEIGNANT = new JButton("Enseignant");
		btnENSEIGNANT.setBounds(491, 113, 112, 23);
		frame.getContentPane().add(btnENSEIGNANT);
		btnENSEIGNANT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == btnENSEIGNANT) {
					try {
				
						rs = LOGIN.statement.executeQuery("SELECT * FROM ENSEIGNANT");
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		
		
		JButton btnETUDIANTUNITE = new JButton("EtudiantUnite");
		btnETUDIANTUNITE.setBounds(491, 143, 112, 23);
		frame.getContentPane().add(btnETUDIANTUNITE);
		btnETUDIANTUNITE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == btnETUDIANTUNITE) {
					try {
				
						rs = LOGIN.statement.executeQuery("SELECT * FROM ETUDIANTUNITE");
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		
		JButton btnUNITE = new JButton("Unit\u00E9");
		btnUNITE.setBounds(491, 177, 112, 23);
		frame.getContentPane().add(btnUNITE);
		btnUNITE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == btnUNITE) {
					try {
				
						rs = LOGIN.statement.executeQuery("SELECT * FROM UNITE");
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		
		
		JButton btnREQUETE1 = new JButton(">20");
		btnREQUETE1.setBounds(491, 211, 112, 23);
		frame.getContentPane().add(btnREQUETE1);
		btnREQUETE1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == btnREQUETE1) {
					try {
				
						rs = LOGIN.statement.executeQuery("SELECT NOM_ETU,PRENOM_ETU FROM Etudiant WHERE MATRICULE_ETU IN (SELECT MATRICULE_ETU FROM ETUDIANTUNITE WHERE NOTE_EXAMEN =20)");						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		
		
		JButton btnREQUETE2 = new JButton("NO POO");
		btnREQUETE2.setBounds(491, 245, 112, 23);
		frame.getContentPane().add(btnREQUETE2);		
		btnREQUETE2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == btnREQUETE2) {
					try {
				
						rs = LOGIN.statement.executeQuery("SELECT NOM_ETU,PRENOM_ETU FROM Etudiant WHERE MATRICULE_ETU IN ((SELECT MATRICULE_ETU FROM ETUDIANT MATRICULE_ETU) MINUS (SELECT MATRICULE_ETU FROM ETUDIANTUNITE WHERE CODE_UNITE IN(SELECT CODE_UNITE FROM UNITE WHERE LIBELLE='POO')))");						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		});

	}
}
