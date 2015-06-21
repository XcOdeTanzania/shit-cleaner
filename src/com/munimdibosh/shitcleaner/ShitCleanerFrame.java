package com.munimdibosh.shitcleaner;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JButton;

import com.munimdibosh.shitcleaner.utils.SCFileUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.Color;


public class ShitCleanerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField inputDirPath;
	private JTextField extensionInput;
	private JPanel extensionSpecifierPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShitCleanerFrame frame = new ShitCleanerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void selectFolder(){
		File selectedDirectory = SCFileUtils.chooseFolder(this);
		inputDirPath.setText(selectedDirectory.getAbsolutePath());
		extensionSpecifierPanel.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ShitCleanerFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 640, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputDirPath = new JTextField();
		inputDirPath.setBounds(20, 90, 602, 28);
		contentPane.add(inputDirPath);
		inputDirPath.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Hey, am a Shit Cleaner");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		lblNewLabel.setBounds(20, 22, 267, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblShowMeThe = new JLabel("Show me the folder where I should start the cleanup");
		lblShowMeThe.setBounds(20, 62, 602, 16);
		contentPane.add(lblShowMeThe);
		
		JButton btnSelectFolder = new JButton("Select folder");
		btnSelectFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectFolder();
			}
		});
		btnSelectFolder.setBounds(505, 118, 117, 29);
		contentPane.add(btnSelectFolder);
		
		extensionSpecifierPanel = new JPanel();
		extensionSpecifierPanel.setVisible(false);
		extensionSpecifierPanel.setBounds(20, 157, 602, 112);
		contentPane.add(extensionSpecifierPanel);
		extensionSpecifierPanel.setLayout(null);
		
		extensionInput = new JTextField();
		extensionInput.setBounds(283, 6, 319, 33);
		extensionSpecifierPanel.add(extensionInput);
		extensionInput.setColumns(10);
		
		JLabel lblNowWhichExtensions = new JLabel("Now, which extensions should I look for?");
		lblNowWhichExtensions.setBounds(6, 14, 265, 16);
		extensionSpecifierPanel.add(lblNowWhichExtensions);
		
		JLabel lblcommaSeparatedExtension = new JLabel("(comma separated extension name without '.'  e.g. mp3, jpg, avi)");
		lblcommaSeparatedExtension.setForeground(Color.GRAY);
		lblcommaSeparatedExtension.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblcommaSeparatedExtension.setBounds(283, 40, 319, 16);
		extensionSpecifierPanel.add(lblcommaSeparatedExtension);
		
		JButton btnStartSearchingThe = new JButton("Start searching the culprits");
		btnStartSearchingThe.setBounds(405, 77, 197, 29);
		extensionSpecifierPanel.add(btnStartSearchingThe);
	}
}
