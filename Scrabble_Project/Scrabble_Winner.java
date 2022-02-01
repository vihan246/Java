package Semester2.Semester_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Scrabble_Winner extends JFrame {

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Scrabble_Winner() {
		getContentPane().setBackground(new Color(0, 128, 0));
		setBounds(100, 100, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Scrabble_Title frame = new Scrabble_Title();
				frame.setVisible(true);
			}
		});
		btnDone.setBounds(560, 430, 117, 29);
		getContentPane().add(btnDone);
		
		JLabel lblPlayerOneName = new JLabel();
		lblPlayerOneName.setText(Scrabble_Gameplay.playerone.getName());
		lblPlayerOneName.setForeground(new Color(255, 215, 0));
		lblPlayerOneName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblPlayerOneName.setBounds(100, 50, 481, 16);
		getContentPane().add(lblPlayerOneName);
		
		JLabel lblPlayerOneScore = new JLabel();
		lblPlayerOneScore.setText("Score: " + Scrabble_Gameplay.playerone.getTotal());
		lblPlayerOneScore.setForeground(new Color(255, 215, 0));
		lblPlayerOneScore.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblPlayerOneScore.setBounds(100, 78, 481, 16);
		getContentPane().add(lblPlayerOneScore);
		
		JLabel lblPlayerTwoName = new JLabel();
		lblPlayerTwoName.setText(Scrabble_Gameplay.playertwo.getName());
		lblPlayerTwoName.setForeground(new Color(255, 215, 0));
		lblPlayerTwoName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblPlayerTwoName.setBounds(100, 116, 481, 16);
		getContentPane().add(lblPlayerTwoName);
		
		JLabel lblPlayerTwoScore = new JLabel();
		lblPlayerTwoScore.setText("Score: " + Scrabble_Gameplay.playertwo.getTotal());
		lblPlayerTwoScore.setForeground(new Color(255, 215, 0));
		lblPlayerTwoScore.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblPlayerTwoScore.setBounds(100, 144, 481, 16);
		getContentPane().add(lblPlayerTwoScore);
		
		JLabel lblWinnerName = new JLabel();
		lblWinnerName.setForeground(new Color(255, 215, 0));
		lblWinnerName.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblWinnerName.setBounds(100, 215, 481, 29);
		getContentPane().add(lblWinnerName);
		
		if (Scrabble_Gameplay.playerone.getTotal() == Scrabble_Gameplay.playertwo.getTotal())
		{
			lblWinnerName.setText("This game was a tie");
		}
		else if (Scrabble_Gameplay.playerone.getTotal() > Scrabble_Gameplay.playertwo.getTotal())
		{
			lblWinnerName.setText(Scrabble_Gameplay.playerone.getName() + " is the winner!");
		}
		else 
		{
			lblWinnerName.setText(Scrabble_Gameplay.playertwo.getName() + " is the winner!");
		}

	}
}
