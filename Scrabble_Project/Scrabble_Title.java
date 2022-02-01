package Semester2.Semester_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Scrabble_Title extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scrabble_Title frame = new Scrabble_Title();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Scrabble_Title() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scrabble");
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setBounds(288, 10, 125, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Scrabble_NameInput frame = new Scrabble_NameInput(); 
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(215, 80, 260, 70);
		contentPane.add(btnNewButton);
		
		JButton btnInstructions = new JButton("Instructions");
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Scrabble_Instructions frame = new Scrabble_Instructions();
				frame.setVisible(true);
			}
		});
		btnInstructions.setBounds(215, 173, 260, 70);
		contentPane.add(btnInstructions);
		
		JButton btnLeaderboard = new JButton("Leaderboard");
		btnLeaderboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Scrabble_Leaderboard frame = new Scrabble_Leaderboard();
				frame.setVisible(true);
			}
		});
		btnLeaderboard.setBounds(215, 259, 260, 70);
		contentPane.add(btnLeaderboard);
		
		JButton btnDictionary = new JButton("Dictionary");
		btnDictionary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Scrabble_Dictionary frame;
				try {
					frame = new Scrabble_Dictionary();
					frame.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDictionary.setBounds(215, 358, 260, 70);
		contentPane.add(btnDictionary);
	}
}
