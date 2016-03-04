import java.util.*;

/***************************************************
* Date: 3/2/2016
* Author: Thomas Veale
* Reference: http://neverstopbuilding.com/minimax
* Input: A string of length 9 with only 'X', 'O',
* and '_' characters.
* Output: A gameboard of tic tac toe and the victor
***************************************************/



public class A2_Q1
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); 	  //input tokenizer for player input
		StringBuilder init = new StringBuilder(args[0]); //input args to stringbuilder obj
		char[] game = new char[9];				  //char array for storing game
		if(init.length() != 9)
		{
			System.out.println(init.length());
			System.out.println("Invalid initial game state.");
		}
		else
		{
			for(int i = 0; i<init.length(); i++)
			{
				game[i] = init.charAt(i);
			}
			
			TTT ttt = new TTT(game);
			System.out.println(ttt);
		}//end else
	}


}

class TTT
{
	int xPlayer, oPlayer = 0;
	//bool tl,tm,tr,cl,cm,cr,bl,bm,br;
	char[] state = new char[9]; //new char array
	public TTT(char[] init)
	{
		for(int i = 0; i<init.length; i++)
			state[i] = init[i];
		
		if(validate())
			println("Valid inital game state.");
		
	}
	
	
	public void minmax(char[] state)
	{
			
	}
	
	public void maxmin(char[] state)
	{
			
	}
	
	
	public boolean validate()
	{
		int xct=0;
		int oct=0;
		for(char c: state)
		{
			//count Xs
			if(c == 'X')
				xct++;
			//count Os
			else if(c == 'O')
				oct++;
		}
		
		//validate first player X
		if(oct > xct)
			return false;
		//validate fairness (i.e., not too many extra Xs)
		else if((xct - oct) > 1)
			return false;
		//validate chars
		for (char c: state) {
            if(c == '_' || c == 'X' || c == 'O')
				return true;
			else
				return false;
        }
		
		return true;
	}
	
	
	
	public String toString()
	{
		String str = new String("The current game state: \n");
		str += state[0] +  "\t" + state[1] + "\t" + state[2] + "\n";
		str += state[3] +  "\t" + state[4] + "\t" + state[5] + "\n";
		str += state[6] +  "\t" + state[7] + "\t" + state[8] + "\n";
		return str;
	}
	
	public void results(char[] state)
	{
		
		
	}
	
	//wrapper for silly java namespaces
	public void println(String str)
	{
		System.out.println(str);
	}
	

	
	  
}