import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CardTests 
{

	@Before
	public void setUp() throws Exception 
	{
		asdfs
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testConstructor() 
	{
		Card c1 = new Card(5, "Hearts");
		assertEquals(5, c1.getNumValue());
		assertEquals("Hearts", c1.getSuitValue());
	}

	@Test
	public void testNumValueGetterSetter()
	{
		Card c1 = new Card(5, "Hearts");
		c1.setNumValue(7);
		
		assertEquals(7, c1.getNumValue());
		assertEquals("Hearts", c1.getSuitValue());
		
		Card c2 = new Card(5, "Hearts");
		c2.setNumValue(1);
		
		assertEquals(5, c2.getNumValue());
		assertEquals("Hearts", c2.getSuitValue());
		
		Card c3 = new Card(5, "Hearts");
		c3.setNumValue(15);
		
		assertEquals(5, c3.getNumValue());
		assertEquals("Hearts", c3.getSuitValue());
	}
	
	@Test
	public void testSuitValueGetterSetter()
	{
		Card c1 = new Card(5, "Hearts");
		c1.setSuitValue("Clubs");
		
		assertEquals(5, c1.getNumValue());
		assertEquals("Clubs", c1.getSuitValue());
		
		Card c2 = new Card(5, "Hearts");
		c2.setSuitValue("Cats");
		
		assertEquals(5, c2.getNumValue());
		assertEquals("Hearts", c2.getSuitValue());
	}
}
