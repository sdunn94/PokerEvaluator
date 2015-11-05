import java.util.ArrayList;

public class Evaluator 
{
	private int numCards;
	private int numHands;
	private ArrayList < Float > handProbabilities;
	
	public Evaluator(int n)
	{
		numCards = n;
		handProbabilities = new ArrayList < Float >();
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
	
	public ArrayList < Float > getHandProbabilities()
	{
		return handProbabilities;
	}

	public void playAndDisplay()
	{
		ArrayList < Integer > handTypeCounters = new ArrayList < Integer >();
		for(int i = 0; i < 10; i++)
			handTypeCounters.add(0);
		
		for(int i = 0; i < getNumHands(); i++)
		{
			Deck d = new Deck();
			
			d.shuffle();
			
			ArrayList < Card > hand = new ArrayList < Card >();
			
			try 
			{
				d.dealCards(getNumCards(), hand);
			} 
			catch (DeckException e) 
			{
				e.printStackTrace();
			}
			
			if(isRoyalFlush(hand))
				handTypeCounters.set(0, handTypeCounters.get(0) + 1);
			else if(isStraightFlush(hand))
				handTypeCounters.set(1, handTypeCounters.get(1) + 1);
			else if(isFourOfAKind(hand))
				handTypeCounters.set(2, handTypeCounters.get(2) + 1);
			else if(isFullHouse(hand))
				handTypeCounters.set(3, handTypeCounters.get(3) + 1);
			else if(isFlush(hand))
				handTypeCounters.set(4, handTypeCounters.get(4) + 1);
			else if(isStraight(hand))
				handTypeCounters.set(5, handTypeCounters.get(5) + 1);
			else if(isThreeOfAKind(hand))
				handTypeCounters.set(6, handTypeCounters.get(6) + 1);
			else if(isTwoPair(hand))
				handTypeCounters.set(7, handTypeCounters.get(7) + 1);
			else if(isPair(hand))
				handTypeCounters.set(8, handTypeCounters.get(8) + 1);
			else
				handTypeCounters.set(9, handTypeCounters.get(9) + 1);
		}
		
		Float probability;
		for (int i = 0; i < 10; i++)
		{
			probability = (float) ((Float)(handTypeCounters.get(i).floatValue() / getNumHands()));
			handProbabilities.add(probability * new Float(100));
		}
		
		System.out.println("The Percent Probability of a Royal Flush is: " + handProbabilities.get(0) + "%" );
		System.out.println("The Percent Probability of a Straight Flush is: " + handProbabilities.get(1) + "%" );
		System.out.println("The Percent Probability of a Four of a Kind is: " + handProbabilities.get(2) + "%" );
		System.out.println("The Percent Probability of a Full House is: " + handProbabilities.get(3) + "%" );
		System.out.println("The Percent Probability of a Flush is: " + handProbabilities.get(4) + "%" );
		System.out.println("The Percent Probability of a Straight is: " + handProbabilities.get(5) + "%" );
		System.out.println("The Percent Probability of a Three of a Kind is: " + handProbabilities.get(6) + "%" );
		System.out.println("The Percent Probability of a Two Pair is: " + handProbabilities.get(7) + "%" );
		System.out.println("The Percent Probability of a Pair is: " + handProbabilities.get(8) + "%" );
		System.out.println("The Percent Probability of a Bad Hand is: " + handProbabilities.get(9) + "%" );
	}

	public boolean isRoyalFlush(ArrayList < Card > hand)
	{
		boolean retVal = false;
		
		ArrayList < Card > flush = new ArrayList < Card >();
		
		flushFinder(flush, hand);
		
		boolean ten = false;
		boolean jack = false;
		boolean queen = false;
		boolean king = false;
		boolean ace = false;
		
		if(flush.size() > 0 && isStraight(flush))
		{
			for(int i = 0; i < flush.size(); i++)
			{
				if(flush.get(i).getNumValue() == 10)
					ten = true;
				else if(flush.get(i).getNumValue() == 11)
					jack = true;
				else if(flush.get(i).getNumValue() == 12)
					queen = true;
				else if(flush.get(i).getNumValue() == 13)
					king = true;
				else if(flush.get(i).getNumValue() == 14)
					ace = true;
			}
		}
		
		if(ten && jack && queen && king && ace)
			retVal = true;
		
		return retVal;
	}
	
	public boolean isStraightFlush(ArrayList < Card > hand)
	{
		boolean retVal = false;
		ArrayList < Card > flush = new ArrayList < Card >();
		
		flushFinder(flush, hand);
		
		if(flush.size() > 0 && isStraight(flush))
		{
			retVal = true;
		}
		
		return retVal;
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
		boolean retVal = false;
		ArrayList < Card > flush = new ArrayList < Card >();
		
		flushFinder(flush, hand);
		
		if(flush.size() > 0)
		{
			retVal = true;
		}
		
		return retVal;
	}
	
	public boolean isStraight(ArrayList < Card > hand)
	{
		boolean retVal = false;
		sortHand(hand);
		
		int counter = 0;

		//counts every time two cards are consecutive
		for(int i = 0; i < hand.size() - 1; i++)
		{
			if(hand.get(i + 1).getNumValue() - hand.get(i).getNumValue() == 1)
			{
				counter++;
			}
			else if((hand.get(i + 1).getNumValue() - hand.get(i).getNumValue() > 1) && counter < 4)
			{
				counter = 0;
			}
		}

		//if you have 5 or more consecutive cards return true, else false
		if(counter >= 4)
			retVal = true;
		else
			retVal = false;
		
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
