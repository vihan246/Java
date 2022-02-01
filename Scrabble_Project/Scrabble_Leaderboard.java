package Semester2.Semester_Project;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;



public class Scrabble_Leaderboard extends JFrame {

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Scrabble_Leaderboard() {
		getContentPane().setBackground(new Color(0, 128, 0));
		setBounds(100, 100, 750, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ArrayList<Player> leaderboardtemp = new ArrayList<Player>();
		leaderboardtemp = Load();
		/*int i = leaderboardtemp.size() - 1; 
		/*
		while (i >= 1 && leaderboardtemp.get(i).getTotal() > leaderboardtemp.get(i-1).getTotal())
		{
			Player temp = leaderboardtemp.get(i -1); 
			leaderboardtemp.set(i-1, leaderboardtemp.get(i));
			leaderboardtemp.set(i, temp);
			i--; 
		}
		*/
		for (int i = 0; i<leaderboardtemp.size() -1 ; i++)
		{
			for (int f = 0; f < leaderboardtemp.size()-1; f++)
			{
			if (leaderboardtemp.get(f).getTotal() < leaderboardtemp.get(f+1).getTotal())
			{
				Player temp = leaderboardtemp.get(f+1); 
				leaderboardtemp.set(f+1, leaderboardtemp.get(f)); 
				leaderboardtemp.set(f, temp);
			}
			}
		}
		
		String[] leaderboardCurrent = new String[leaderboardtemp.size() + 1];
		leaderboardCurrent[0] = "Place" + " \t" + "Name" + " \t" + "Score";
		for (int i = 0; i<leaderboardtemp.size(); i++)
		{
			String f = i + 1 + ".     " + " \t" + leaderboardtemp.get(i).getName() + " \t" + leaderboardtemp.get(i).getTotal();
			leaderboardCurrent[i + 1] = f; 
		}
		
		
		JList list = new JList(leaderboardCurrent);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().setLayout(null);
		list.setBounds(28, 115, 692, 400);
		list.setSelectedIndex(0);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 115, 692, 400);
		scrollPane.setViewportView(list);
		getContentPane().add(scrollPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(18, 527, 131, 34);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Scrabble_Title frame = new Scrabble_Title();
				frame.setVisible(true);
			}
		});
		getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Leaderboard");
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setBackground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(283, 17, 276, 34);
		getContentPane().add(lblNewLabel);
	}

	public static ArrayList<Player> Load()
	{
		ArrayList<Player> temporary = new ArrayList<Player>();
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("ProjectLeaderboard.dat")); 
			temporary = (ArrayList<Player>)in.readObject();
			in.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return temporary; 
	}
}
