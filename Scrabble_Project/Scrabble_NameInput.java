package Semester2.Semester_Project;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Scrabble_NameInput extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	static Player playerone = new Player();
	static Player playertwo = new Player();
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Scrabble_NameInput() {
		getContentPane().setBackground(new Color(0, 128, 0));
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		playerone.setScoreTotal(0);
		playertwo.setScoreTotal(0);
		playerone.clearWords();
		playertwo.clearWords();
		
		textField = new JTextField();
		textField.setBounds(155, 25, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 81, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPlayerOne = new JLabel("Player One:");
		lblPlayerOne.setForeground(new Color(255, 215, 0));
		lblPlayerOne.setBounds(31, 30, 97, 16);
		getContentPane().add(lblPlayerOne);
		
		JLabel lblPlayerTwo = new JLabel("Player Two:");
		lblPlayerTwo.setForeground(new Color(255, 215, 0));
		lblPlayerTwo.setBounds(31, 86, 97, 16);
		getContentPane().add(lblPlayerTwo);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Scrabble_Title frame = new Scrabble_Title();
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(6, 243, 117, 29);
		getContentPane().add(btnBack);
		
		JButton btnStart = new JButton("Start!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerone.setName(textField.getText());
				playertwo.setName(textField_1.getText());
				playerone.setTurn(true);
				dispose();
				Scrabble_Gameplay frame = new Scrabble_Gameplay();
				frame.setVisible(true);
			}
		});
		btnStart.setBounds(327, 243, 117, 29);
		getContentPane().add(btnStart);

	}
}
