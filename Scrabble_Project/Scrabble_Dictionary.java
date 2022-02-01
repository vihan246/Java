package Semester2.Semester_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.io.*; 
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font; 

public class Scrabble_Dictionary extends JFrame {

	static ArrayList<String> dictionary = new ArrayList<String>();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Scrabble_Dictionary() throws IOException {
		getContentPane().setBackground(new Color(0, 128, 0));
		setBounds(100, 100, 750, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadDict();
		Object[] WordList = dictionary.toArray(); 
		getContentPane().setLayout(null);
		JList list = new JList(WordList);
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
		
		JLabel lblDictionaryTitle = new JLabel("Dictionary");
		lblDictionaryTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblDictionaryTitle.setForeground(new Color(255, 215, 0));
		lblDictionaryTitle.setBounds(300, 20, 176, 34);
		getContentPane().add(lblDictionaryTitle);
		scrollPane.setVisible(true);
		
	}
	
	public static void loadDict() throws IOException
	{
		String Dict = "src/Semester2/Semester_Project/Resources/dictionary.txt"; 
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Dict)));
		String temp; 
		
		while ((temp = br.readLine()) != null) 
		{
			dictionary.add(temp);
		}
	    
		
	}
}
