package com.kittleapps.ExcellRecreation;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	/* TO-DO:
	 * > Make a general input lines using:
	 *   > 'Client Name'		 (String; unlimited length; Single-line)
	 *   > 'Driver Name(s)'		 (String; unlimited length; Single-line; Optional parsing commas)
	 *   > 'Program Name'		 (String; unlimited length; Single-line)
	 *   > 'Headquarter Address' (String; Unlimited length; Single-line)
	 * > Make a general column layout like: 
	 *   > 'Date'		(String value; Add as a calendar selector)
	 *   > 'Time'		(String input; Temporary saved as a number value)
	 *   > 'City/State'	(String; State optional)
	 *   > 'Miles'		(2-decimal double; Money value)
	 *   > 'Amount'		(2-decimal Double; Money value)
	 *   > 'Reason'		(String; Unlimited length)
	 *   > 'Total'		(Same mechanics as 'Amount')
	 * > Add a signature and date field to digitally sign.
	 *   > Ask client if they want to export as an image
	 *   > If exporting as an image, create a template to export with.
	 */
	private static final long serialVersionUID = -6832975843633208549L;
	private JPanel contentPane;
	private static MainGUI frame;
	private static JTable table;
	private JTextField
				textField,
				textField_1,
				textField_2,
				textField_3
	;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					frame = new MainGUI();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Storage.init();
		UIManager.put("ScrollBar.track", Color.WHITE);
		setBounds(Storage.windowPositionX, Storage.windowPositionY, 950, 650);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveas = new JMenuItem("Save-As");
		mntmSaveas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnFile.add(mntmSaveas);
		
		JMenuItem mntmProperties = new JMenuItem("Properties");
		mntmProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnFile.add(mntmProperties);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmResetSelection = new JMenuItem("Reset Selection");
		mntmResetSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnEdit.add(mntmResetSelection);
		
		JMenuItem mntmResetDocument = new JMenuItem("Reset Document");
		mntmResetDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.isEditing()) {
					System.out.println("Bump 1.");
					table.getCellEditor().cancelCellEditing();
				}
				if (table.getSelectedRowCount() > 0 || table.getSelectedColumnCount() > 0) {
					System.out.println("Bump 2.");
					table.getSelectionModel().clearSelection();
					textField.requestFocus();
				}

				for (int Row = 0; Row < table.getRowCount(); Row++) {
					for (int Column = 0; Column < table.getColumnCount(); Column++) {
						table.setValueAt("", Row, Column);
					}
				}
			}
		});
		mnEdit.add(mntmResetDocument);
		
		JMenuItem mntmResetRow = new JMenuItem("Reset Row");
		mntmResetRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.isEditing()) {
					System.out.println("Bump 1.");
					table.getCellEditor().cancelCellEditing();
				}
				if (table.getSelectedRowCount() > 0 || table.getSelectedColumnCount() > 0) {
					System.out.println("Bump 2.");
					for (int Column = 0; Column < table.getColumnCount(); Column++) {
						table.setValueAt("", table.getSelectedRow(), Column);
					}
					table.getSelectionModel().clearSelection();
					textField.requestFocus();
				}
			}
		});
		mnEdit.add(mntmResetRow);
		
		JMenuItem mntmResetColumn = new JMenuItem("Reset Column");
		mntmResetColumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.isEditing()) {
					System.out.println("Bump 1.");
					table.getCellEditor().cancelCellEditing();
				}
				if (table.getSelectedRowCount() > 0 || table.getSelectedColumnCount() > 0) {
					System.out.println("Bump 2.");
					for (int Row = 0; Row < table.getRowCount(); Row++) {
						table.setValueAt("", Row, table.getSelectedColumn());
					}
					table.getSelectionModel().clearSelection();
					textField.requestFocus();
				}
			}
		});
		mnEdit.add(mntmResetColumn);
		
		JMenu mnNavigate = new JMenu("Navigate");
		menuBar.add(mnNavigate);
		
		JMenuItem mntmSetSelection = new JMenuItem("Set Selection");
		mntmSetSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnNavigate.add(mntmSetSelection);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAssistDialogue = new JMenuItem("Assist dialogue");
		mntmAssistDialogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnHelp.add(mntmAssistDialogue);
		
		JMenuItem mntmAboutThisProgram = new JMenuItem("About this program");
		mntmAboutThisProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnHelp.add(mntmAboutThisProgram);
		
		JMenu mnDebuging = new JMenu("Debuging");
		menuBar.add(mnDebuging);
		
		JMenuItem mntmPopulateTheTable = new JMenuItem("Populate the Program");
		mntmPopulateTheTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("Jon Doe");
				textField_1.setText("Jon Deere Transport");
				textField_2.setText("Jon Deere Manufacturing & Transport");
				textField_3.setText("One John Deere Place, Moline Illinois 61265");
				if (table.isEditing()) {
					table.getCellEditor().cancelCellEditing();
				}
				double DemoHourPay = 8.25, DemoMilePay = 0.75, DemoGrossPay = 0.00;
				for (int Row = 0; Row < table.getRowCount(); Row++) {
					int StartHour = (int) (18*Math.random()), EndHour = StartHour+6;
					String StartingHour = "00:00", EndingHour = "00:00";
					if (StartHour > 0 && StartHour < 10) {
						StartingHour = "0"+StartHour+":00";
					} else if (StartHour > 10) {
						StartingHour = StartHour+":00";
					}
					if (EndHour < 10) {
						EndingHour = "0"+EndHour+":00";
					} else if (StartHour+6 > 10) {
						EndingHour = EndHour+":00";
					}
					int Miles = (int) (45*Math.random());
					double TodaysPay = (6*DemoHourPay)+(Miles+DemoMilePay);
					DemoGrossPay += TodaysPay;
					table.setValueAt("12/"+(Row+1)+"/2017", Row, 0);
					table.setValueAt(StartingHour+" - "+EndingHour, Row, 1);
					table.setValueAt("Moline Illinois", Row, 2);
					table.setValueAt(Miles, Row, 3);
					table.setValueAt("$"+TodaysPay, Row, 4);
					table.setValueAt("Worked really well for 6 hours today.", Row, 5);
					table.setValueAt("$"+DemoGrossPay, Row, 6);
				}
				textField.requestFocus();
			}
		});
		mnDebuging.add(mntmPopulateTheTable);
		
		JMenuItem mntmTestMathTo = new JMenuItem("Test math to console");
		mntmTestMathTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnDebuging.add(mntmTestMathTo);
		
		JMenuItem mntmRandomizeMiles = new JMenuItem("Randomize miles");
		mntmRandomizeMiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.isEditing()) {
					table.getCellEditor().cancelCellEditing();
				}
				for (int Row = 0; Row < table.getRowCount(); Row++) {
					table.setValueAt((double) 9999*Math.random(), Row, 3);
				}
				textField.requestFocus();
			}
		});
		mnDebuging.add(mntmRandomizeMiles);
		
		JMenuItem mntmTestReasonCopying = new JMenuItem("Test Reason copying");
		mntmTestReasonCopying.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnDebuging.add(mntmTestReasonCopying);		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(15, 15, 915, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblClientName = new JLabel("Client Name:");
		lblClientName.setBounds(10, 10, 140, 15);
		panel.add(lblClientName);
		
		JLabel lblDriverNames = new JLabel("Driver Name(s):");
		lblDriverNames.setBounds(10, 35, 140, 15);
		panel.add(lblDriverNames);
		
		JLabel lblProgramName = new JLabel("Program Name: ");
		lblProgramName.setBounds(10, 60, 140, 15);
		panel.add(lblProgramName);
		
		JLabel lblHeadquartersAddress = new JLabel("Headquarters Address:");
		lblHeadquartersAddress.setBounds(10, 85, 140, 15);
		panel.add(lblHeadquartersAddress);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField.setBounds(150, 10, 755, 15);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBounds(150, 35, 755, 15);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_2.setBounds(150, 60, 755, 15);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_3.setBounds(150, 85, 755, 15);
		panel.add(textField_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, 185, 915, 400);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[31][7],
			new String[] {
				"Date", "Time", "City/State", "Miles", "Pay", "Reason", "Gross Pay"
			}
		));
		table.getColumnModel().getColumn(0).setMaxWidth(75);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setMaxWidth(75);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setMaxWidth(125);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setMaxWidth(45);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setMaxWidth(45);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setMaxWidth(475);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setMaxWidth(60);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDragEnabled(false);
		
		JScrollPane TableScrollPane = new JScrollPane(table);
		TableScrollPane.setBounds(0, 0, 915, 400);
		TableScrollPane.setBorder(new LineBorder(new Color(45,45,45)));
		panel_1.add(TableScrollPane);
	}
}
