
public class Card 
{
	int numValue;
	String suitValue;
	
	public Card(int n, String s) 
	{
		setNumValue(n);
		setSuitValue(s);
	}

	public int getNumValue() 
	{
		return numValue;
	}

	public void setNumValue(int numValue) 
	{
		if(numValue > 2 && numValue < 14)
		{
			this.numValue = numValue;
		}
	}

	public String getSuitValue() 
	{
		return suitValue;
	}

	public void setSuitValue(String suitValue) 
	{
		if(suitValue == "Hearts" || suitValue == "Spades" || suitValue == "Diamonds" || suitValue == "Clubs")
		{
			this.suitValue = suitValue;
		}
	}
	
	public void printCard()
	{
		System.out.println(getNumValue() + " of " + getSuitValue());
	}
}
