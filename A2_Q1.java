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
	int xPlayer, oPlayer = 10;
	//char tl,tm,tr,cl,cm,cr,bl,bm,br;
	final char X = 'X';
	final char O = 'O';
	final char open = '_';
	char[] scores =  new char[9]; 
    char[] moves = new char[9];
	char[] state = new char[9]; //new char array
	public TTT(char[] init)
	{
		for(int i = 0; i<init.length; i++)
			state[i] = init[i];
		
		if(validate())
			println("Valid inital game state.");
		
		println("" +results(state));
		
		 minimax(state);
		
	}
	
	//optimio!
	public int minimax(char[] game, char turn)
	{
		
		if(results(game) != 0)
		{
			return results(game);
		
		}
		int[] scores;
		int[] moves;
		
		for(int i = 0; i<game.length; i++)
		{
			//try every move
			if (game[i] == open)
			{
			 char[] temp = copyOf(game, 9); //copy array
			 temp[i] = x; 					//make a move
			 minimax(temp, o); 				//recurse
			}
		}
		//if it is  your turn do max calc
			 if(turn == x)
			 {
				 results
			 }
			 else 	//if it is their turn do min calculation
				 
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
	
	public int results(char[] game)
	{
		//top right
		//H
		if(game[0] == game[1] && game[1] == game[2]) //i.e., same char
		{
			if(game[0] == 'X') //if its x, then I win
				return 10;
			if(game[0] == 'O') // if its y then you win
				return -10;	
		}
		
		//V
		if(game[0] == game[3] && game[3] == game[6])
		{
			if(game[0] == 'X')
				return 10;
			if(game[0] == 'O')
				return -10;	
		}
		//D
		if(game[0] == game[4] && game[4] == game[8])
		{
			if(game[0] == 'X')
				return 10;
			if(game[0] == 'O')
				return -10;	
		}
		
		//bottom right
		//V
		if(game[8] == game[5] && game[5] == game[2])
		{
			if(game[0] == 'X')
				return 10;
			if(game[0] == 'O')
				return -10;	
		}
		
		//H
		if(game[8] == game[7] && game[7] == game[6])
		{
			if(game[0] == 'X')
				return 10;
			if(game[0] == 'O')
				return -10;	
		}
		//other diag
		//D
		if(game[6] == game[4] && game[4] == game[2])
		{
			if(game[0] == 'X')
				return 10;
			if(game[0] == 'O')
				return -10;	
		}
		//cross
		//V
		if(game[1] == game[4] && game[4] == game[7])
		{
			if(game[0] == 'X')
				return 10;
			if(game[0] == 'O')
				return -10;	
		}
		
		//H
		if(game[3] == game[4] && game[4] == game[5])
		{
			if(game[0] == 'X')
				return 10;
			if(game[0] == 'O')
				return -10;	
		}

		return 0;
			
	}
	
	//wrapper for silly java namespaces
	public void println(String str)
	{
		System.out.println(str);
	}
	
	
	
	  
}