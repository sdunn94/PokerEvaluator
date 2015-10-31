import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EvaluatorTests 
{
	Card c1, c2, c3, c4, c5, c6, c7;
	
	@Before
	public void setUp() throws Exception 
	{
		c1 = new Card(2, "Hearts");
		c2 = new Card(3, "Hearts");
		c3 = new Card(4, "Hearts");
		c4 = new Card(5, "Hearts");
		c5 = new Card(6, "Hearts");
		c6 = new Card(7, "Hearts");
		c7 = new Card(8, "Hearts");
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testRoyalFlush() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testStraightFlush() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testFourOfAKind() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testFullHouse() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testFlush() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testStraight() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testThreeOfAKind() 
	{
		fail("Not yet implemented");
	}

	@Test
	public void testTwoPair() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testPair() 
	{
		fail("Not yet implemented");
	}
}
