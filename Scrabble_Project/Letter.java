package Semester2.Semester_Project; 
import javax.swing.ImageIcon;

public class Letter {

	private int value; 
	private char letter; 
	private int amount; 
	private ImageIcon tile = new ImageIcon();

	
	public Letter(int v, char l, int a)

	{
		value = v;
		letter = l;
		amount = a; 
		
	}

	public int getValue()
	{
		return value; 
	}
	
	public char getLetter()
	{
		return letter; 
	}
	
	public int getAmount()
	{
		return amount; 
	}
	
	public void setValue(int v)
	{
		value = v;
	}
	
	public void setLetter(char l)
	{
		letter = l;
	}
	
	public void setAmount(int a)
	{
		amount = amount - a; 
	}
	
	public void setTile(ImageIcon t)
	{
		tile = t; 
	}
	
	public ImageIcon getTile()
	{
		return tile; 
	}
	

}

