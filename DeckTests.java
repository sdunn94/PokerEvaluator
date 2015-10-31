import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeckTests 
{
	String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
	@Before
	public void setUp() throws Exception 
	{
	
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testConstructor() 
	{
		Deck d = new Deck();
		assertEquals(52, d.getCards().size());
		
		int card = 0;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 2; j < 15; j++)
			{
				assertEquals(j, d.getCards().get(card).getNumValue());
				assertEquals(suits[i], d.getCards().get(card).getSuitValue());
				card++;
			}
		}
	}
	
	@Test
	public void testShuffle() 
	{
		
	}
	
	@Test
	public void testDeal() 
	{
		
	}
	
	@Test
	public void testCardsGetterSetter() 
	{
		
	}

}
