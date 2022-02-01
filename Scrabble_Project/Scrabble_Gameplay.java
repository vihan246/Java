package Semester2.Semester_Project;
import javax.swing.ImageIcon; 
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import TCWBD_VIZKRFT.FactoryComm_Main;
import java.awt.Color;
import java.awt.Font;

public class Scrabble_Gameplay extends JFrame {
	
	static Letter[][] board = new Letter[15][15];
	static JButton[][] buttonBoard = new JButton[15][15];
	static String Dict = "src/Semester2/Semester_Project/Resources/dictionary.txt";  
	static Letter[] one_available = new Letter[7]; 
	static Letter[] two_available = new Letter[7]; 
	static Letter[] tileBag = new Letter[27]; 
	static JButton[] playerRack = new JButton[7];
	static Letter empty = new Letter(0, ' ', 0); 
	static int selected=7; 
	static Player playerone = Scrabble_NameInput.playerone;
	static Player playertwo = Scrabble_NameInput.playertwo;
	static int p = 0; 
	static ArrayList<Integer> turnpositions = new ArrayList<Integer>();
	static JTextArea textArea_playerone = new JTextArea();
	static JTextArea textArea_playertwo = new JTextArea();
	static JLabel lblTurnView = new JLabel("");
	static Letter blank = new Letter(0, ' ', 2);
	static ArrayList<Player> leaderboard = new ArrayList<Player>();
	
	 
/* Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Scrabble_Gameplay() {
		getContentPane().setBackground(new Color(0, 128, 0));
		setBounds(100, 100, 1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Random rand = new Random();
		newGame();
		
		//loop to create rack buttons
				for (p = 0; p < 7; p++)
				{
					playerRack[p] = new JButton(" "); 
					playerRack[p].setBounds(105 + ((p-1)*70), 700, 70, 70);
					playerRack[p].setVisible(true);
					getContentPane().add(playerRack[p]);
				}
				playerRack[0].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected==7)
						{
						selected = 0; 
						playerRack[selected].setEnabled(false);
						}
						}});
				playerRack[1].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected == 7)
						{
						selected = 1; 
						playerRack[selected].setEnabled(false);
						}
						}});
				playerRack[2].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected==7)
						{
						selected = 2; 
						playerRack[selected].setEnabled(false);
						}
						}});
				playerRack[3].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected==7)
						{
						selected = 3; 
						playerRack[selected].setEnabled(false);
						}
						}});
				playerRack[4].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						selected = 4; 
						playerRack[selected].setEnabled(false);
						}});
				playerRack[5].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected == 7)
						{
						selected = 5; 
						playerRack[selected].setEnabled(false);
						}
						}});
				playerRack[6].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (selected == 7)
						{
						selected = 6; 
						playerRack[selected].setEnabled(false);
						}
						}});
				//loop to create board buttons
		for (int i =0; i < 15; i++)
		{
			for (int f = 0; f<15; f++)
			{
				board[i][f] = empty; 
				buttonBoard[i][f] = new JButton(" ");
				buttonBoard[i][f].setBounds(82 + ((f-1)*40), 105 + ((i-1)*40), 40, 40);
				buttonBoard[i][f].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object source = e.getSource();
						int row = 0;
						int column = 0;
						for (int r = 0; r < 15; r++)
						{
							for (int c = 0; c < 15; c++)
							{
								if (source == buttonBoard[r][c])
								{
									row = r;
									column = c; 
								}
							}
						}
						
						if (playerone.getTurn() == true && board[row][column] == empty && adjCheck(row,column)==true)
						{
							Letter temp = one_available[selected];
							if (temp == blank)
							{
								String newL = JOptionPane.showInputDialog(null, "What's your desired letter?");
							    JOptionPane.showMessageDialog(null,"the entered letter was : "+ newL);
							    char tempL = newL.charAt(0);
							    for (int i = 0; i < 27; i++)
							    {
							    	if (tempL == tileBag[i].getLetter())
							    	{
							    		temp = tileBag[i]; 
							    	}
							    }
							    
							}
							board[row][column] = temp;
							buttonBoard[row][column].setIcon(resize(temp.getTile()));
							turnpositions.add(row);
							turnpositions.add(column);
							selected = 7; 
						}
						else if (board[row][column]==empty && adjCheck(row,column)==true) 
						{
							Letter temp = two_available[selected];
							if (temp == blank)
							{
								String newL = JOptionPane.showInputDialog(null, "What's your desired letter?");
							    JOptionPane.showMessageDialog(null,"the entered letter was : "+ newL);
							    char tempL = newL.charAt(0);
							    for (int i = 0; i < 27; i++)
							    {
							    	if (tempL == tileBag[i].getLetter())
							    	{
							    		temp = tileBag[i]; 
							    	}
							    }
							    
							}
							board[row][column] = temp;
							buttonBoard[row][column].setIcon(resize(temp.getTile()));
							turnpositions.add(row);
							turnpositions.add(column);
							selected = 7; 
						}
					}
				});
				buttonBoard[i][f].setVisible(true);
				getContentPane().add(buttonBoard[i][f]);
			}
		}
		
		int temp = rand.nextInt(26);
		board[7][7] = tileBag[temp]; 
		buttonBoard[7][7].setIcon(resize(tileBag[temp].getTile()));
		
	
		
		//method to set icons to the rack 
		setRack();
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playerone.getTotal() > 0 || playertwo.getTotal() > 0)
				{
					leaderboard = Scrabble_Leaderboard.Load();
					leaderboard.add(playerone); 
					leaderboard.add(playertwo);
					save(); 
					dispose();
					Scrabble_Winner frame = new Scrabble_Winner();
					frame.setVisible(true); 
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"No Scores");
					dispose();
					Scrabble_Title frame = new Scrabble_Title();
					frame.setVisible(true);
				}
			}
		});
		btnExit.setBounds(6, 6, 145, 35);
		getContentPane().add(btnExit);
		textArea_playerone.setEditable(false);
		
		
		textArea_playerone.setBounds(725, 45, 269, 306);
		getContentPane().add(textArea_playerone);
		textArea_playertwo.setEditable(false);
		
		
		textArea_playertwo.setBounds(725, 375, 269, 306);
		getContentPane().add(textArea_playertwo);
		
		JButton btnNext = new JButton("Next ");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String checkw = ""; 
				int wtotal = 0;
				boolean allCheck = true; 
				
				//horizontal word
				if (turnpositions.get(0) == turnpositions.get(turnpositions.size()-2))
				{
					System.out.println("yes");
					int start = 0; 
					int end = 0;
					if (turnpositions.get(1)< turnpositions.get(turnpositions.size()-1))
					{
						start = turnpositions.get(1);
						end = turnpositions.get(turnpositions.size()-1);
						
						while (start - 1 >= 0 && board[turnpositions.get(0)][start - 1] != empty)
						{
							start--;
						}
						while (end + 1 <15 && board[turnpositions.get(0)][end + 1] != empty)
						{
							end++;
						}
						for (int i = start; i <= end; i++)
						{
						checkw = checkw + board[turnpositions.get(0)][i].getLetter();	
						wtotal = wtotal + board[turnpositions.get(0)][i].getValue();
						}
					}
				
					
					else if (turnpositions.get(1)< turnpositions.get(turnpositions.size()-1))
					{
						end = turnpositions.get(1);
						start = turnpositions.get(turnpositions.size()-1);
						while (end + 1 < 15 && board[turnpositions.get(0)][end + 1] != empty)
						{
							end++;
						}
						while (start - 1 >= 0 && board[turnpositions.get(0)][start - 1] != empty)
						{
							start--;
						}
						for (int i = start; i <= end; i++)
						{
						checkw = checkw + board[turnpositions.get(0)][i].getLetter();	
						wtotal = wtotal + board[turnpositions.get(0)][i].getValue();
						}

					}
					
					//When only one block is placed (horizontal word)
					else if (board[turnpositions.get(0)][turnpositions.get(1)-1] != empty && board[turnpositions.get(0)][turnpositions.get(1)+1] != empty)
					{
						start = turnpositions.get(1);
						end = turnpositions.get(turnpositions.size()-1);
						while (start -1 >=0 && board[turnpositions.get(0)][start-1] != empty)
						{
							start--;
						}
						while (end + 1 < 15 && board[turnpositions.get(0)][end + 1] != empty)
						{
							end++;
						}
						System.out.println(start);
						for (int i = start; i <= end; i++)
						{
						checkw = checkw + board[turnpositions.get(0)][i].getLetter();	
						wtotal = wtotal + board[turnpositions.get(0)][i].getValue();
						}
					}
					
					else if (board[turnpositions.get(0)][turnpositions.get(1)-1] != empty || board[turnpositions.get(0)][turnpositions.get(1)+1] != empty)
					{
						start = turnpositions.get(1);
						end = turnpositions.get(turnpositions.size()-1);
						while (start -1 >=0 && board[turnpositions.get(0)][start-1] != empty)
						{
							start--;
						}
						while (end + 1 < 15 && board[turnpositions.get(0)][end + 1] != empty)
						{
							end++;
						}
						System.out.println(start);
						for (int i = start; i <= end; i++)
						{
						checkw = checkw + board[turnpositions.get(0)][i].getLetter();	
						wtotal = wtotal + board[turnpositions.get(0)][i].getValue();
						}
					}
					
					
					//When only one block is place (vertical word)
					else if (board[turnpositions.get(0) - 1][turnpositions.get(1)] != empty && board[turnpositions.get(0) + 1][turnpositions.get(1)] != empty)
					{
						System.out.print("one");
						start = turnpositions.get(0);
						end = turnpositions.get(0);
						while (start -1 >= 0 && board[start-1][turnpositions.get(1)] != empty )
						{
							start--;
						}
						while (end + 1 < 15 && board[end + 1][turnpositions.get(1)] != empty)
						{
							end++;
						}
						System.out.println(start);
						for (int i = start; i <= end; i++)
						{
							checkw = checkw + board[i][turnpositions.get(1)].getLetter();
							wtotal = wtotal + board[i][turnpositions.get(1)].getValue();
							}
					}
					
					else if (board[turnpositions.get(0) - 1][turnpositions.get(1)] != empty || board[turnpositions.get(0) + 1][turnpositions.get(1)] != empty)
					{
						System.out.print("one");
						start = turnpositions.get(0);
						end = turnpositions.get(0);
						while (start -1 >= 0 && board[start-1][turnpositions.get(1)] != empty )
						{
							start--;
						}
						while (end + 1 < 15 && board[end + 1][turnpositions.get(1)] != empty)
						{
							end++;
						}
						System.out.println(start);
						for (int i = start; i <= end; i++)
						{
							checkw = checkw + board[i][turnpositions.get(1)].getLetter();
							wtotal = wtotal + board[i][turnpositions.get(1)].getValue();
							}
					}
					
					
 
				}
				
				//vertical word
				else if (turnpositions.get(1) == turnpositions.get(turnpositions.size()-1))
				{
					System.out.println("yes");
					System.out.println(turnpositions.get(1)+ " " + turnpositions.get(0));
					int start = 0; 
					int end = 0;
					if (turnpositions.get(0)< turnpositions.get(turnpositions.size()-2))
					{
						start = turnpositions.get(0);
						end = turnpositions.get(turnpositions.size()-2);
						while (start - 1 >=0 && board[start-1][turnpositions.get(1)] != empty)
						{
							start--;
						}
						while (end + 1 < 15 && board[end + 1][turnpositions.get(1)] != empty)
						{
							end++;
						}
					}
					else 
					{
						end = turnpositions.get(0);
						start = turnpositions.get(turnpositions.size()-2);
						while (end + 1< 15 && board[end+1][turnpositions.get(1)] != empty)
						{
							end++;
						}
						while (start-1 >= 0 && board[start-1][turnpositions.get(1)] != empty)
						{
							start--;
						}
					}
					
					for (int i = start; i <= end; i++)
					{
						checkw = checkw + board[i][turnpositions.get(1)].getLetter();
						wtotal = wtotal + board[i][turnpositions.get(1)].getValue();
						}
				}
				
				System.out.println(checkw);
				try {
					if (checkDict(checkw)==true && playerone.getTurn()==true)
					{
						playerone.addScoreTotal(wtotal);
						playerone.addWord(checkw);
						for (int i = 0;i<7;i++)
						{
							if (playerRack[i].isEnabled() == false)
							{
								one_available[i] = empty; 
								playerRack[i].setEnabled(true);
							}
						}
						playerone.setTurn(false);
						playertwo.setTurn(true);
						fillPlayer();
					}
					else if (checkDict(checkw) == true && playertwo.getTurn()==true && allCheck == true)
					{
						playertwo.addScoreTotal(wtotal);
						playertwo.addWord(checkw);
						for (int i = 0;i<7;i++)
						{
							if (playerRack[i].isEnabled() == false)
							{
								two_available[i] = empty; 
								playerRack[i].setEnabled(true);
							}
						}
						playertwo.setTurn(false);
						playerone.setTurn(true);
						fillPlayer();
					}
					else if (checkDict(checkw)==false)
					{
						cancel();
						if (playerone.getTurn() == true)
						{
							playerone.setTurn(false);
							playertwo.setTurn(true);
						}
						else 
						{
							playerone.setTurn(true);
							playertwo.setTurn(false);
						}
					}
					turnpositions.clear();
					updateView();
					setRack();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNext.setBounds(780, 702, 170, 43);
		getContentPane().add(btnNext);
		
		ImageIcon boardpic = new ImageIcon("src/Semester2/Semester_Project/Resources/Screenshot 2019-04-18 at 4.56.49 PM.png");
		Image image = boardpic.getImage(); 
		Image newimg = image.getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH);   
		boardpic = new ImageIcon(newimg);
		JLabel lblBoardLabel = new JLabel(boardpic);
		lblBoardLabel.setBounds(16, 38, 650, 650);
		getContentPane().add(lblBoardLabel);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnCancel.setBounds(527, 709, 117, 29);
		getContentPane().add(btnCancel);
		lblTurnView.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		
		lblTurnView.setBounds(320, 14, 197, 27);
		getContentPane().add(lblTurnView);
		
		updateView();
		//need to add this into the action event of the 'next' button 
        /*T
         Timer visual = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                tickTock();
            }
        });
        visual.setRepeats(true);
        visual.setCoalesce(true);
        visual.setInitialDelay(0);
        
        Timer actual = new Timer(120000, new ActionListener() 
        {
        visual.start();
        }
        actual.setCoalesce(true);
        actual.setInitialDelay(0);
        actual.start();
*/

	}
	
	
	public boolean checkDict(String temp) throws IOException
	{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Dict)));
		String check; 
		
		while ((check = br.readLine()) != null) 
		{
			if (temp.equals(check))
			{
				return true; 
			}

		}
		return false; 
	    
		
	}
	
	
	public static void fillBag()

	{
		String ref = "src/Semester2/Semester_Project/Resources/Letter Tiles/";
		
		Letter a = new Letter(1, 'a', 9);
		ImageIcon aIcon = new ImageIcon(ref + "AIcon.jpg");
		a.setTile(aIcon);
		tileBag[0] = a; 
		
		Letter b = new Letter(3, 'b', 2);
		ImageIcon bIcon = new ImageIcon(ref + "BIcon.jpg");
		b.setTile(bIcon);
		tileBag[1] = b; 
		
		Letter c = new Letter(3, 'c', 2);
		ImageIcon cIcon = new ImageIcon(ref + "CIcon.jpg");
		c.setTile(cIcon);
		tileBag[2] = c; 
		
		Letter d = new Letter(2, 'd', 4);
		ImageIcon dIcon = new ImageIcon(ref + "DIcon.jpg");
		d.setTile(dIcon);
		tileBag[3] = d; 
		
		Letter e = new Letter(1, 'e', 12);
		ImageIcon eIcon = new ImageIcon(ref + "EIcon.jpg");
		e.setTile(eIcon);
		tileBag[4] = e; 
		
		Letter f = new Letter(4, 'f', 2);
		ImageIcon fIcon = new ImageIcon(ref + "FIcon.jpg");
		f.setTile(fIcon);
		tileBag[5] = f; 
		
		Letter g = new Letter(2, 'g', 3);
		ImageIcon gIcon = new ImageIcon(ref + "GIcon.jpg");
		g.setTile(gIcon);
		tileBag[6] = g; 
		
		Letter h = new Letter(4, 'h', 2);
		ImageIcon hIcon = new ImageIcon(ref + "HIcon.jpg");
		h.setTile(hIcon);
		tileBag[7] = h; 
		
		Letter i = new Letter(1, 'i', 9);
		ImageIcon iIcon = new ImageIcon(ref + "IIcon.jpg");
		i.setTile(iIcon);
		tileBag[8] = i; 
		
		Letter j = new Letter(8, 'j', 1);
		ImageIcon jIcon = new ImageIcon(ref + "JIcon.jpg");
		j.setTile(jIcon);
		tileBag[9] = j; 
		
		Letter k = new Letter(4, 'k', 1);
		ImageIcon kIcon = new ImageIcon(ref + "KIcon.jpg");
		k.setTile(kIcon);
		tileBag[10] = k; 
		
		Letter l = new Letter(1, 'l', 4);
		ImageIcon lIcon = new ImageIcon(ref + "LIcon.jpg");
		l.setTile(lIcon);
		tileBag[11] = l; 
		
		Letter m = new Letter(3, 'm', 2);
		ImageIcon mIcon = new ImageIcon(ref + "MIcon.jpg");
		m.setTile(mIcon);
		tileBag[12] = m; 
		
		Letter n = new Letter(1, 'n', 6);
		ImageIcon nIcon = new ImageIcon(ref + "NIcon.jpg");
		n.setTile(nIcon);
		tileBag[13] = n; 
		
		Letter o = new Letter(1, 'o', 8);
		ImageIcon oIcon = new ImageIcon(ref + "OIcon.jpg");
		o.setTile(oIcon);
		tileBag[14] = o; 
		
		Letter p = new Letter(3, 'p', 2);
		ImageIcon pIcon = new ImageIcon(ref + "PIcon.jpg");
		p.setTile(pIcon);
		tileBag[15] = p; 
		
		Letter q = new Letter(10, 'q', 1);
		ImageIcon qIcon = new ImageIcon(ref + "QIcon.jpg");
		q.setTile(qIcon);
		tileBag[16] = q; 
		
		Letter r = new Letter(1, 'r', 6);
		ImageIcon rIcon = new ImageIcon(ref + "RIcon.jpg");
		r.setTile(rIcon);
		tileBag[17] = r; 
		
		Letter s = new Letter(1, 's', 4);
		ImageIcon sIcon = new ImageIcon(ref + "SIcon.jpg");
		s.setTile(sIcon);
		tileBag[18] = s; 
		
		Letter t = new Letter(1, 't', 6);
		ImageIcon tIcon = new ImageIcon(ref + "TIcon.jpg");
		t.setTile(tIcon);
		tileBag[19] = t; 
		
		Letter u = new Letter(1, 'u', 4);
		ImageIcon uIcon = new ImageIcon(ref + "UIcon.jpg");
		u.setTile(uIcon);
		tileBag[20] = u;
		
		Letter v = new Letter(4, 'v', 2);
		ImageIcon vIcon = new ImageIcon(ref + "VIcon.png");
		v.setTile(vIcon);
		tileBag[21] = v; 
		
		Letter w = new Letter(4, 'w', 2);
		ImageIcon wIcon = new ImageIcon(ref + "WIcon.jpg");
		w.setTile(wIcon);
		tileBag[22] = w; 
		
		Letter x = new Letter(8, 'x', 1);
		ImageIcon xIcon = new ImageIcon(ref + "XIcon.jpg");
		x.setTile(xIcon);
		tileBag[23] = x; 
		
		Letter y = new Letter(4, 'y', 2);
		ImageIcon yIcon = new ImageIcon(ref + "YIcon.jpg");
		y.setTile(yIcon);
		tileBag[24] = y; 
		
		Letter z = new Letter(10, 'z', 1);
		ImageIcon zIcon = new ImageIcon(ref + "ZIcon.jpg");
		z.setTile(zIcon);
		tileBag[25] = z; 
		
		ImageIcon blankIcon = new ImageIcon(ref + "BlankIcon.jpg");
		blank.setTile(blankIcon);
		tileBag[26] = blank; 
		
	}

	public static void fillPlayer()
	{
		Random rand = new Random(); 
		for (int l = 0; l < 7; l++)
		{
			int temp = rand.nextInt(27);
			while (tileBag[temp].getAmount() == 0)
			{
				temp = rand.nextInt(27);
			}
			
			if (one_available[l] == empty && tileBag[temp].getAmount()!=0)
			{
			one_available[l] = tileBag[temp];
			tileBag[temp].setAmount(1);
			}
			
			temp = rand.nextInt(27);
			while (tileBag[temp].getAmount() == 0)
			{
				temp = rand.nextInt(27);
			}
			
			if (two_available[l] == empty && tileBag[temp].getAmount() != 0)
			{ 
			two_available[l] = tileBag[temp];
			tileBag[temp].setAmount(1);
			}
		}
	}
	
	public static void setRack()
	{
		for (int l = 0; l < 7; l++)
		{
			if (playerone.getTurn() == true)
			{
				playerRack[l].setIcon(one_available[l].getTile());
			}
			else 
			{
				playerRack[l].setIcon(two_available[l].getTile());
			}
		}
	}

	public static ImageIcon resize(ImageIcon ii)
	{
		Image image = ii.getImage(); // transform it 
		Image newimg = image.getScaledInstance(47, 40,  java.awt.Image.SCALE_SMOOTH);   
		ii = new ImageIcon(newimg);
		return ii; 
	}
	
	public static void newGame()
	{
		Random rand = new Random();
		fillBag(); 
		for (int l = 0; l< 7; l++)
		{
			one_available[l] = empty; 
			two_available[l] = empty; 
		}
		fillPlayer(); 
		
		playerone.setTurn(true);
		for (int l = 0; l< 7; l++)
		{
			System.out.println(one_available[l].getLetter());
		}
		
	}

	public static boolean adjCheck(int y, int x) throws IndexOutOfBoundsException
	{
		int edgeD = y+1; 
		int edgeU = y-1; 
		int edgeL = x - 1; 
		int edgeR = x+1; 
		
		if (edgeD == 15)
		{
			edgeD = y;
		}
		else if (edgeU == -1)
		{
			edgeU = y;
		}
		if (edgeL == -1)
		{
			edgeL = x; 
		}
		else if (edgeR == 15)
		{
			edgeR = x; 
		}
		
		if (board[edgeD][x] != empty)
		{
			return true;
		}
		else if (board[edgeU][x] !=empty)
		{
			return true;
		}
		else if (board[y][edgeR] != empty)
		{
			return true; 
		}
		else if (board[y][edgeL] != empty)
		{
			return true; 
		}
		return false; 
	}
	public static void save()
	{
		try 
		{ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream("ProjectLeaderboard.dat")); 
		out.writeObject(leaderboard);
		out.close(); 
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void cancel()
	{
		ImageIcon blank = new ImageIcon("src/Semester2/Semester_Project/Resources/blank.png");
		for (int i = 0; i < turnpositions.size(); i+=2 )
		{
			board[turnpositions.get(i)][turnpositions.get(i+1)] = empty; 
			buttonBoard[turnpositions.get(i)][turnpositions.get(i+1)].setIcon(resize(blank));
			
		}
		turnpositions.clear();
		for (int i = 0; i<7;i++)
		{
			playerRack[i].setEnabled(true);
		}
	}
	public static void updateView()
	{
		if (playerone.getTurn()==true)
		{
		lblTurnView.setText( playerone.getName() +"'s turn");
		}
		else
		{
			lblTurnView.setText(playertwo.getName() +"'s turn");
		}
		
		String p1words = playerone.getName() + "\t" + "Score: " + playerone.getTotal() + "\n" + "Words:"; 
		for (int i=0; i< playerone.getWords().size(); i++)
		{
			p1words+= "\n" + playerone.getWords().get(i);
		}
		textArea_playerone.setText(p1words);
		
		String p2words = playertwo.getName() + "\t" + "Score: " + playertwo.getTotal() + "\n" + "Words:"; 
		for (int i=0; i< playertwo.getWords().size(); i++)
		{
			p2words+= "\n" + playertwo.getWords().get(i);
		}
		textArea_playertwo.setText(p2words);
	}
}
