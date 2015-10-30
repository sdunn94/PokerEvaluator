import java.util.ArrayList;

public class Deck 
{
	private ArrayList < Card > cards = new ArrayList < Card >();
	
	public Deck()
	{
		String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};

		//sets a normal 52 cards deck with 52 unique cards
		for(int j = 0; j <= 3; j++)
		{
			for(int i = 2; i <= 14; i++)
			{
				Card c = new Card(i, suits[j]);
				cards.add(c);
			}
		}
	}

	public ArrayList<Card> getCards() 
	{
		return cards;
	}
	
	public void dealCards(int numCards, ArrayList < Card > myHand)
	{
		
	}
	
	public void suffle()
	{
		
	}
}
