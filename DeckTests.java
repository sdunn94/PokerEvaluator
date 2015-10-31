import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeckTests 
{

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
