package com.kittleapps.ExcellRecreation;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Screen;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class MainGUI extends JFrame {

	/* TO-DO:
	 * 
	 * > Make a basic Excel GUI.
	 * > Make basic rows+columns.
	 * > Make basic mechanics for input.
	 * > Make design layout for the MenuBar.
	 * > Make a general title area
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
	 * > Make a storage class to hold the values.
	 * > Make a mechanic to copy the 'Reason' column to all rows from the top-most row. (ID: 0)
	 * > Calculate the totals for 'Miles' and 'Total' areas in their own row+column values.
	 * > Ignore the general agreement on the reference page, for privacy relations
	 * > Add a signature and date field to digitally sign.
	 *   > Ask client if they want to export as an image
	 *   > If exporting as an image, create a template to export with.
	 */
	private static final long serialVersionUID = -6832975843633208549L;
	private JPanel contentPane;
	private static MainGUI frame;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setBounds(Storage.windowPositionX, Storage.windowPositionY, Storage.windowSizeX, Storage.windowSizeY);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveas = new JMenuItem("Save-As");
		mnFile.add(mntmSaveas);
		
		JMenuItem mntmProperties = new JMenuItem("Properties");
		mnFile.add(mntmProperties);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmResetSelection = new JMenuItem("Reset Selection");
		mnEdit.add(mntmResetSelection);
		
		JMenuItem mntmResetDocument = new JMenuItem("Reset Document");
		mnEdit.add(mntmResetDocument);
		
		JMenuItem mntmResetRow = new JMenuItem("Reset Row");
		mnEdit.add(mntmResetRow);
		
		JMenuItem mntmResetColumn = new JMenuItem("Reset Column");
		mnEdit.add(mntmResetColumn);
		
		JMenu mnNavigate = new JMenu("Navigate");
		menuBar.add(mnNavigate);
		
		JMenuItem mntmSetSelection = new JMenuItem("Set Selection");
		mnNavigate.add(mntmSetSelection);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAssistDialogue = new JMenuItem("Assist dialogue");
		mnHelp.add(mntmAssistDialogue);
		
		JMenuItem mntmAboutThisProgram = new JMenuItem("About this program");
		mnHelp.add(mntmAboutThisProgram);
		
		JMenu mnDebuging = new JMenu("Debuging");
		menuBar.add(mnDebuging);
		
		JMenuItem mntmPopulateTheTable = new JMenuItem("Populate the Table");
		mnDebuging.add(mntmPopulateTheTable);
		
		JMenuItem mntmTestMathTo = new JMenuItem("Test math to console");
		mnDebuging.add(mntmTestMathTo);
		
		JMenuItem mntmRandomizeMiles = new JMenuItem("Randomize miles");
		mnDebuging.add(mntmRandomizeMiles);
		
		JMenuItem mntmTestReasonCopying = new JMenuItem("Test Reason copying");
		mnDebuging.add(mntmTestReasonCopying);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(15, 15, 915, 150);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(15, 185, 915, 400);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 915, 400);
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Date", "Time", "City/State", "Miles", "Amount", "Reason", "Total"
			}
		));
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(175);
		table.getColumnModel().getColumn(2).setMaxWidth(175);
		table.getColumnModel().getColumn(3).setMinWidth(65);
		table.getColumnModel().getColumn(3).setMaxWidth(65);
		table.getColumnModel().getColumn(4).setMinWidth(75);
		table.getColumnModel().getColumn(4).setMaxWidth(75);
		table.getColumnModel().getColumn(5).setMinWidth(325);
		table.getColumnModel().getColumn(5).setMaxWidth(325);
		table.getColumnModel().getColumn(6).setMinWidth(75);
		table.getColumnModel().getColumn(6).setMaxWidth(75);
		panel_1.add(table);
	}
}
