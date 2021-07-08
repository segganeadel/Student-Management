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

public class ENSEIGNANT {

	private JFrame frame;
	private ResultSet rs = null;
	private JTable table;
	private JTextField textMATRICULE;
	private JTextField textNOM;
	private JTextField textPRENOM;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ENSEIGNANT window = new ENSEIGNANT();
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
	public ENSEIGNANT() {
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
				
		JTable table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBounds(0, 0, 402, 382);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 177, 112, -41);
		frame.getContentPane().add(scrollPane);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 720, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblModeADMIN = new JLabel("Vous \u00EAtes en mode ENSEIGNANT");
		lblModeADMIN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblModeADMIN.setForeground(Color.WHITE);
		lblModeADMIN.setBounds(386, 36, 308, 20);
		frame.getContentPane().add(lblModeADMIN);
		
		JButton btnETUDIANT = new JButton("Etudiant");
		btnETUDIANT.setBounds(386, 124, 112, 23);
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
		btnENSEIGNANT.setBounds(560, 124, 112, 23);
		frame.getContentPane().add(btnENSEIGNANT);
		btnENSEIGNANT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == btnENSEIGNANT) {
					try {
						
						String q = "SELECT * FROM ENSEIGNANT";
						rs = LOGIN.statement.executeQuery(q);
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		});

		
		JLabel lblNewLabel = new JLabel("Matricule");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(386, 207, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textMATRICULE = new JTextField();
		textMATRICULE.setBounds(386, 232, 139, 20);
		frame.getContentPane().add(textMATRICULE);
		textMATRICULE.setColumns(10);
		
		JLabel lblAFFICHAGE = new JLabel("Affichage");
		lblAFFICHAGE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAFFICHAGE.setForeground(Color.WHITE);
		lblAFFICHAGE.setBounds(386, 93, 69, 20);
		frame.getContentPane().add(lblAFFICHAGE);
		
		JLabel lblNOM = new JLabel("Nom");
		lblNOM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNOM.setForeground(Color.WHITE);
		lblNOM.setBounds(386, 263, 69, 14);
		frame.getContentPane().add(lblNOM);
		
		textNOM = new JTextField();
		textNOM.setBounds(386, 288, 139, 20);
		frame.getContentPane().add(textNOM);
		textNOM.setColumns(10);
		
		JLabel lblPRENOM = new JLabel("Pr\u00E9nom");
		lblPRENOM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPRENOM.setForeground(Color.WHITE);
		lblPRENOM.setBounds(386, 319, 67, 14);
		frame.getContentPane().add(lblPRENOM);
		
		textPRENOM = new JTextField();
		textPRENOM.setColumns(10);
		textPRENOM.setBounds(386, 339, 139, 20);
		frame.getContentPane().add(textPRENOM);
		
		JButton btnAJOUT = new JButton("Ajout");
		btnAJOUT.setBounds(567, 338, 105, 23);
		frame.getContentPane().add(btnAJOUT);
		btnAJOUT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == btnAJOUT) {
					
					if(!textMATRICULE.getText().isEmpty() && !textMATRICULE.getText().isEmpty() && !textMATRICULE.getText().isEmpty()) {
					try {
						
						int mat = Integer.parseInt(textMATRICULE.getText());
						String n = textNOM.getText();
						String p = textPRENOM.getText();
						String q = "INSERT INTO ENSEIGNANT VALUES ("+mat+",'"+n+"','"+p+"')";
						rs = LOGIN.statement.executeQuery(q);
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					}
				}
			}
			
		});
		
		JButton btnSUPRESSION = new JButton("Supression");
		btnSUPRESSION.setBounds(567, 287, 105, 23);
		frame.getContentPane().add(btnSUPRESSION);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 720, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnSUPRESSION.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getSource() == btnSUPRESSION) {
					
					if(!textMATRICULE.getText().isEmpty()) {
					try {
						
						String mat = textMATRICULE.getText();
						String q = "DELETE FROM ENSEIGNANT WHERE MATRICULE_ENS="+mat;
						rs = LOGIN.statement.executeQuery(q);
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					}
				}
			}
			
		});

	}
}
