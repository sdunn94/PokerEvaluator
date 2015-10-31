import java.util.ArrayList;

public class Evaluator 
{
	private int numCards;
	private int numHands;
	
	public Evaluator(int n)
	{
		numCards = n;
	}
	
	public int getNumCards()
	{
		return numCards;
	}
	
	public void setNumCards(int numCards)
	{
		this.numCards = numCards;
	}
	
	public int getNumHands() 
	{
		return numHands;
	}

	public void setNumHands(int numHands) 
	{
		this.numHands = numHands;
	}

	public void playAndDisplay()
	{
		
	}

	public boolean isRoyalFlush(ArrayList < Card > hand)
	{
		return false;
		
	}
	
	public boolean isStraightFlush(ArrayList < Card > hand)
	{
		return false;
		
	}
	
	public boolean isFourOfAKind(ArrayList < Card > hand)
	{
		boolean retVal = false;
		ArrayList < Integer > counters = new ArrayList < Integer >();
				
		numericValueCounter(counters, hand);
		for(int i = 0; i < counters.size(); i++)
		{
			if(counters.get(i) >= 4)
			{
				retVal = true;
			}
		}
		return retVal;
	}
	
	public boolean isFullHouse(ArrayList < Card > hand)
	{
		//counter keeps track of number of times each numeric 
		//value appears in the hand
		ArrayList < Integer > counters = new ArrayList < Integer >();
		numericValueCounter(counters, hand);
		
		boolean isThree = false;
		boolean isTwo = false;
		int threeOfAKindPos = 0;
		
		//checks to see if there were 3 of any card
		for(int i = 0; i < counters.size(); i++)
		{
			if(counters.get(i) >= 3)
			{
				isThree = true;
				threeOfAKindPos = i;
			}
		}
		
		//checks to see if there were 2 of any card
		for(int i = 0; i < counters.size(); i++)
		{
			if((counters.get(i) >= 2 && i != threeOfAKindPos))
				isTwo = true;
		}
		
		return isThree && isTwo ? true : false;
	}
	
	public boolean isFlush(ArrayList < Card > hand)
	{
		return false;
	}
	
	public boolean isStraight(ArrayList < Card > hand)
	{
		boolean retVal = false;
		sortHand(hand);
		
		if(hand.size() == 5 && hand.get(4).getNumValue() - hand.get(0).getNumValue() == 4)
		{
			retVal = true;
		}
		else if(hand.size() == 7)
		{
			if(hand.get(4).getNumValue() - hand.get(0).getNumValue() == 4 || 
					hand.get(5).getNumValue() - hand.get(1).getNumValue() == 4 || 
					hand.get(6).getNumValue() - hand.get(2).getNumValue() == 4)
			{
				retVal = true;
			}
		}
		
		return retVal;
	}
	
	public boolean isThreeOfAKind(ArrayList < Card > hand)
	{
		boolean retVal = false;
		ArrayList < Integer > counters = new ArrayList < Integer >();
				
		numericValueCounter(counters, hand);
		for(int i = 0; i < counters.size(); i++)
		{
			if(counters.get(i) >= 3)
			{
				retVal = true;
			}
		}
		return retVal;
	}
	
	public boolean isTwoPair(ArrayList < Card > hand)
	{
		int numPairs = pairCounter(hand);
		
		return numPairs > 1 ? true : false;
	}
	
	public boolean isPair(ArrayList < Card > hand)
	{
		int numPairs = pairCounter(hand);
		
		return numPairs > 0 ? true : false;
	}
	
	public int pairCounter(ArrayList < Card > hand)
	{
		int retVal = 0;
		
		ArrayList < Integer > counters = new ArrayList < Integer >();
		numericValueCounter(counters, hand);
		
		for(int i = 0; i < counters.size(); i++)
		{
			if(counters.get(i) == 2 || counters.get(i) == 3)
			{
				retVal++;
			}
			else if(counters.get(i) == 4)
			{
				retVal += 2;
			}
		}
		
		return retVal;
	}
	
	public void numericValueCounter(ArrayList < Integer > counters, ArrayList < Card > hand)
	{
		for(int i = 0; i <= 14; i++)
			counters.add(0);
		
		for(int i = 0; i < hand.size(); i++)
		{
			counters.set(hand.get(i).getNumValue(), counters.get(hand.get(i).getNumValue()) + 1);
		}
	}
	
	public void sortHand(ArrayList < Card > hand)
	{
		for(int i = 0; i < hand.size(); i++)
		{
			for(int j = i + 1; j < hand.size(); j++)
			{
				if(hand.get(i).getNumValue() > hand.get(j).getNumValue())
				{
					Card c = hand.get(i);
					hand.set(i, hand.get(j));
					hand.set(j, c);
				}
			}
		}
	}
	
	public void flushFinder(ArrayList < Card > flush, ArrayList < Card > hand)
	{
		int suitCounter[] = { 0, 0, 0, 0};
		
		//this loop goes through the hand and adds to the suit 
		//counter each time it reaches a certain suit
		for(int i = 0; i < hand.size(); i++)
		{
			if(hand.get(i).getSuitValue() == "Hearts")
				suitCounter[0]++;
			else if(hand.get(i).getSuitValue() == "Clubs")
				suitCounter[1]++;
			else if(hand.get(i).getSuitValue() == "Spades")
				suitCounter[2]++;
			else if(hand.get(i).getSuitValue() == "Diamonds")
				suitCounter[3]++;
		}
		
		String suit;

		//determines if it is a flush and also determines what 
		//suit the flush is made up of
		for(int i = 0; i < 4; i++)
		{
			if(suitCounter[i] >= 5)
			{
				if(i == 0)
					suit = "Hearts";
				else if(i == 1)
					suit = "Clubs";
				else if(i == 2)
					suit = "Spades";
				else
					suit = "Diamonds";
				
				//puts the flush cards into a new ArrayList with only those cards
				for(int j = 0; j < hand.size(); j++)
				{
					if(hand.get(j).getSuitValue().equals(suit))
					{
						flush.add(hand.get(j));
					}
				}
				
				break;
			}
		}
	}
}
