package Semester2.Semester_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Scrabble_Instructions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Scrabble_Instructions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrTheGameIs = new JTextArea();
		txtrTheGameIs.setEditable(false);
		txtrTheGameIs.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtrTheGameIs.setForeground(new Color(255, 215, 0));
		txtrTheGameIs.setBackground(new Color(0, 128, 0));
		txtrTheGameIs.setText("The game is played on a 15 by 15 grid, with words being created either from \nleft to right or from up to down. \n\nPlayers can build on each other's words, which creates an interesting and \ncompetitive fight for space on the board. \n\na player can play a word parallel and immediately adjacent to an existing \nword provided that all crossing words formed are valid.\n\nEach word has to be a word in the dictionary, meaning that no invalid words \nwill be accepted in order to give points. \n\nConditions: \nA letter tile HAS to be placed adjacent to another letter tile; the game will \nnot allow you to place it otherwise \n\nA player HAS to play a tile in order to end their turn, even if they cannot \nmake a word \n\n");
		txtrTheGameIs.setBounds(6, 6, 738, 508);
		contentPane.add(txtrTheGameIs);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Scrabble_Title frame = new Scrabble_Title();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(627, 543, 117, 29);
		contentPane.add(btnNewButton);
	}
}
