package Semester2.Semester_Project;
import java.io.Serializable;
import java.util.ArrayList; 

public class Player implements Serializable{

	private String name; 
	private int scoretotal; 
	private ArrayList<String> words = new ArrayList<String>(); 
	private boolean turn; 

public Player(String n)
{
	name = n; 
}

public Player() {
	name = ""; 
	scoretotal = 0;
	turn = false; 
}

public void addWord(String w)
{
	words.add(w);
}

public void setName(String n)
{
	name = n; 
}

public String getName()
{
	return name; 
}

public ArrayList<String> getWords()
{
	return words;
}

public void addScoreTotal(int s)
{
	scoretotal = scoretotal + s; 
	
}

public void setScoreTotal(int s)
{
	scoretotal = s; 
}

public void setTurn(boolean t)
{
	turn = t; 
}

public boolean getTurn()
{
	return turn; 
}

public int getTotal()
{
	return scoretotal; 
}

public void clearWords()
{
	words.clear();
}


}
