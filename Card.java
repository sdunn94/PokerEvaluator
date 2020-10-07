
public class Card 
{
//made a change to test
	private int numValue;
	private String suitValue;
	
	public Card(int n, String s) 
	{
		numValue = n;
		suitValue = s;
	}

	public int getNumValue() 
	{
		return numValue;
	}

	public void setNumValue(int numValue)  throws CardException
	{
		if(numValue >= 2 && numValue <= 14)
		{
			this.numValue = numValue;
		}
		else
		{
			CardException c = new CardException();
			throw c;
		}
	}

	public String getSuitValue() 
	{
		return suitValue;
	}

	public void setSuitValue(String suitValue) throws CardException
	{
		if(suitValue == "Hearts" || suitValue == "Spades" || suitValue == "Diamonds" || suitValue == "Clubs")
		{
			this.suitValue = suitValue;
		}
		else
		{
			CardException c = new CardException();
			throw c;
		}
	}
	
	public void printCard()
	{
		System.out.println(getNumValue() + " of " + getSuitValue());
	}
	
	@Override
	public boolean equals(Object other)
	{
		boolean retVal = false;
		
		Card c = (Card)other;
		if(getNumValue() == c.getNumValue() && getSuitValue() == c.getSuitValue())
		{
			retVal = true;
		}
		
		return retVal;
	}
}
