import java.util.ArrayList;
import java.util.Random;

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
		for(int i = 0; i < numCards; i++)
		{
			myHand.add(cards.get(i));
			cards.remove(i);
		}
	}
	
	public void shuffle()
	{
		Random randomGenerator = new Random();
		for(int i = 0; i < cards.size(); i++)
		{
			int x = randomGenerator.nextInt(52);
			Card c = cards.get(i);
			cards.set(i, cards.get(x));
			cards.set(x, c);
		}
	}
}
