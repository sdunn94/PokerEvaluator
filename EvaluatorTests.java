import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EvaluatorTests 
{
	Card c1, c2, c3, c4, c5, c6, c7;
	Evaluator e5;
	Evaluator e7;
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
		
		e5 = new Evaluator(5);
		e7 = new Evaluator(7);
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
		ArrayList< Card > hand = new ArrayList < Card >();
		
		//2h, 3h, 4h, 5h, 6h
		hand.add(c1);
		hand.add(c2);
		hand.add(c3);
		hand.add(c4);
		hand.add(c5);
		assertEquals(false, e5.isFourOfAKind(hand));
		try
		{
			c2.setNumValue(2);
			c2.setSuitValue("Spades");
			c3.setNumValue(2);
			c3.setSuitValue("Clubs");
			c4.setNumValue(2);
			c4.setSuitValue("Diamonds");
		}
		catch (CardException e)
		{
			fail();
		}
		
		//2h, 2s, 2c, 2d, 6h
		assertEquals(true, e5.isFourOfAKind(hand));
		
		hand.add(c6);
		hand.add(c7);
		//2h, 2s, 2c, 2d, 6h, 7h, 8h
		assertEquals(true, e7.isFourOfAKind(hand));
		try
		{
			c2.setNumValue(3);
		}
		catch (CardException e)
		{
			fail();
		}
		
		//2h, 3s, 2c, 2d, 6h, 7h, 8h
		assertEquals(false, e7.isFourOfAKind(hand));
	}
	
	@Test
	public void testFullHouse() 
	{
		ArrayList< Card > hand = new ArrayList < Card >();
		
		//2h, 3h, 4h, 5h, 6h
		hand.add(c1);
		hand.add(c2);
		hand.add(c3);
		hand.add(c4);
		hand.add(c5);
		assertEquals(false, e5.isFullHouse(hand));
		try
		{
			c2.setNumValue(2);
			c2.setSuitValue("Clubs");
			c3.setNumValue(3);
			c4.setNumValue(3);
			c4.setSuitValue("Clubs");
			c5.setNumValue(3);
			c5.setSuitValue("Spades");
		}
		catch (CardException e)
		{
			fail();
		}
		//2h, 2c, 3h, 3c, 3s
		assertEquals(true, e5.isFullHouse(hand));
		
		hand.add(c6);
		hand.add(c7);
		//2h, 2c, 3h, 3c, 3s, 7h, 8h
		assertEquals(true, e7.isFullHouse(hand));
		
		try
		{
			c6.setNumValue(2);
			c6.setSuitValue("Spades");
		}
		catch (CardException e)
		{
			fail();
		}
		//2h, 2c, 3h, 3c, 3s, 2s, 8h
		assertEquals(true, e7.isFullHouse(hand));
		
		
		try
		{
			c7.setNumValue(2);
			c7.setSuitValue("Diamonds");
		}
		catch (CardException e)
		{
			fail();
		}
		//2h, 2c, 3h, 3c, 3s, 2s, 2d
		assertEquals(true, e7.isFullHouse(hand));
		
		try
		{
			c2.setNumValue(4);
			c6.setNumValue(5);
			c7.setNumValue(6);
		}
		catch (CardException e)
		{
			fail();
		}
		//2h, 4c, 3h, 3c, 3s, 5s, 6d
		assertEquals(false, e7.isFullHouse(hand));
	}
	
	@Test
	public void testFlush() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testStraight() 
	{
		ArrayList < Card > hand = new ArrayList < Card >();
		
		//2h, 3h, 4h, 5h, 6h
		hand.add(c1);
		hand.add(c2);
		hand.add(c3);
		hand.add(c4);
		hand.add(c5);
		assertEquals(true, e5.isStraight(hand));
		
		try
		{
			c2.setNumValue(12);
		}
		catch (CardException e)
		{
			fail();
		}
		//2h, 12h, 4h, 5h, 6h
		assertEquals(false, e5.isStraight(hand));
		
		
		hand.add(c7);
		hand.add(c6);
		//2h, 12h, 4h, 5h, 6h, 8h, 7h
		assertEquals(true, e7.isStraight(hand));
		
		try
		{
			c6.setNumValue(14);
		}
		catch (CardException e)
		{
			fail();
		}
		//2h, 12h, 4h, 5h, 6h, 8h, 14h
		assertEquals(false, e7.isStraight(hand));
		
		try
		{
			c2.setNumValue(3);
			c6.setNumValue(7);
		}
		catch (CardException e)
		{
			fail();
		}
		
		//2h, 3h, 4h, 5h, 6h, 8h, 7h
		assertEquals(true, e7.isStraight(hand));
		
	}
	
	@Test
	public void testThreeOfAKind() 
	{
		ArrayList< Card > hand = new ArrayList < Card >();
		
		//2h, 3h, 4h, 5h, 6h
		hand.add(c1);
		hand.add(c2);
		hand.add(c3);
		hand.add(c4);
		hand.add(c5);
		assertEquals(false, e5.isThreeOfAKind(hand));
		try
		{
			c2.setNumValue(2);
			c2.setSuitValue("Spades");
			c3.setNumValue(2);
			c3.setSuitValue("Clubs");
		}
		catch (CardException e)
		{
			fail();
		}
		
		//2h, 2s, 2c, 5h, 6h
		assertEquals(true, e5.isThreeOfAKind(hand));
		
		hand.add(c6);
		hand.add(c7);
		//2h, 2s, 2c, 5h, 6h, 7h, 8h
		assertEquals(true, e7.isThreeOfAKind(hand));
		try
		{
			c2.setNumValue(3);
		}
		catch (CardException e)
		{
			fail();
		}
		
		//2h, 3s, 2c, 5h, 6h, 7h, 8h
		assertEquals(false, e7.isThreeOfAKind(hand));
	}

	@Test
	public void testTwoPair() 
	{
		ArrayList < Card > hand = new ArrayList < Card >();
		
		try 
		{
			c2.setNumValue(2);
			c2.setSuitValue("Clubs");
			
			c3.setNumValue(3);
			c4.setNumValue(3);
			c4.setSuitValue("Clubs");
		} 
		catch (CardException e) 
		{
			fail();
		}
		
		hand.add(c1);
		hand.add(c2);
		hand.add(c3);
		hand.add(c4);
		hand.add(c5);
		//2h, 2c, 3h, 3c, 6h
		assertEquals(true, e5.isTwoPair(hand));
		
		try 
		{
			c2.setNumValue(4);
		} 
		catch (CardException e) 
		{
			fail();
		}
		//2h, 4c, 3h, 3c, 6h
		assertEquals(false, e5.isTwoPair(hand));
		
		hand.add(c6);
		hand.add(c7);
		//2h, 4c, 3h, 3c, 6h, 7h, 8h
		assertEquals(false, e7.isTwoPair(hand));
		
		try 
		{
			c2.setNumValue(2);
		} 
		catch (CardException e) 
		{
			fail();
		}
		//2h, 2c, 3h, 3c, 6h, 7h, 8h
		assertEquals(true, e7.isTwoPair(hand));
	}
	
	@Test
	public void testPair() 
	{
		ArrayList < Card > hand = new ArrayList < Card >();
		
		try 
		{
			c2.setNumValue(2);
			c2.setSuitValue("Clubs");
		} 
		catch (CardException e) 
		{
			fail();
		}
		//2h, 2c, 4h, 5h, 6h
		hand.add(c1);
		hand.add(c2);
		hand.add(c3);
		hand.add(c4);
		hand.add(c5);
		
		assertEquals(true, e5.isPair(hand));
		
		try 
		{
			c2.setNumValue(3);
		} 
		catch (CardException e) 
		{
			fail();
		}
		//2h, 3c, 4h, 5h, 6h
		assertEquals(false, e5.isPair(hand));
		
		hand.add(c6);
		hand.add(c7);
		//2h, 3c, 4h, 5h, 6h, 7h, 8h
		assertEquals(false, e7.isPair(hand));
		
		try 
		{
			c2.setNumValue(2);
		} 
		catch (CardException e) 
		{
			fail();
		}
		//2h, 2c, 4h, 5h, 6h, 7h, 8h
		assertEquals(true, e7.isPair(hand));
	}
	
	@Test
	public void testSortHand() 
	{
		ArrayList < Card > hand = new ArrayList < Card >();
		
		hand.add(c4);
		hand.add(c1);
		hand.add(c3);
		hand.add(c2);
		hand.add(c5);
		
		e5.sortHand(hand);
		
		for(int i = 0; i < hand.size() - 1; i++)
		{
			if(hand.get(i).getNumValue() > hand.get(i + 1).getNumValue())
			{
				fail();
			}
		}
		
		hand.add(c7);
		hand.add(c6);
		
		e7.sortHand(hand);
		
		for(int i = 0; i < hand.size() - 1; i++)
		{
			if(hand.get(i).getNumValue() > hand.get(i + 1).getNumValue())
			{
				fail();
			}
		}
	}
	
	@Test
	public void testPairCounter() 
	{
		ArrayList < Card > hand = new ArrayList < Card >();
		
		//2h, 3h, 4h, 5h, 6h
		hand.add(c1);
		hand.add(c2);
		hand.add(c3);
		hand.add(c4);
		hand.add(c5);
		
		assertEquals(0, e5.pairCounter(hand));
		
		try 
		{
			c2.setNumValue(2);
			c2.setSuitValue("Clubs");
		} 
		catch (CardException e) 
		{
			fail();
		}
		
		//2h, 2c, 4h, 5h, 6h
		assertEquals(1, e5.pairCounter(hand));
		
		try 
		{
			c3.setNumValue(2);
			c3.setSuitValue("Diamonds");
		} 
		catch (CardException e) 
		{
			fail();
		}
		
		//2h, 2c, 2d, 5h, 6h
		assertEquals(1, e5.pairCounter(hand));
		
		try 
		{
			c4.setNumValue(2);
			c4.setSuitValue("Spades");
		} 
		catch (CardException e) 
		{
			fail();
		}
		
		//2h, 2c, 2d, 2s, 6h
		assertEquals(2, e5.pairCounter(hand));
		
		hand.add(c6);
		hand.add(c7);
		//2h, 2c, 2d, 2s, 6h, 7h, 8h
		assertEquals(2, e7.pairCounter(hand));
		
		try 
		{
			c3.setNumValue(4);
			c3.setSuitValue("Hearts");
		} 
		catch (CardException e) 
		{
			fail();
		}
		//2h, 2c, 4h, 2s, 6h, 7h, 8h
		assertEquals(1, e7.pairCounter(hand));
		
		try 
		{
			c2.setNumValue(10);
			c1.setNumValue(5);
		} 
		catch (CardException e) 
		{
			fail();
		}
		//5h, 10c, 4h, 2s, 6h, 7h, 8h
		assertEquals(0, e7.pairCounter(hand));
	}
	
	@Test
	public void testNumericValueCounter() 
	{
		
	}
	
	@Test
	public void testFlushFinder() 
	{
		ArrayList < Card > hand = new ArrayList < Card >();
		//2h, 2h, 4h, 5h, 6h
		hand.add(c4);
		hand.add(c1);
		hand.add(c3);
		hand.add(c2);
		hand.add(c5);
		
		ArrayList < Card > flush = new ArrayList < Card >();
		
		e5.flushFinder(flush, hand);
		assertEquals(5, flush.size());
		for(int i = 0; i < flush.size() - 1; i++)
		{
			if(!flush.get(i).getSuitValue().equals(flush.get(i + 1).getSuitValue()))
			{
				fail();
			}
		}
		
		ArrayList < Card > flush2 = new ArrayList < Card >();
		try 
		{
			c2.setSuitValue("Clubs");
		} 
		catch (CardException e) 
		{
			fail();
		}
		//2h, 3c, 4h, 5h, 6h
		e5.flushFinder(flush2, hand);
		assertEquals(0, flush2.size());
		
		hand.add(c6);
		hand.add(c7);
		//2h, 3c, 4h, 5h, 6h, 7h, 8h
		e7.flushFinder(flush2, hand);
		assertEquals(6, flush2.size());
		
		ArrayList < Card > flush3 = new ArrayList < Card >();
		try 
		{
			c3.setSuitValue("Clubs");
			c4.setSuitValue("Clubs");
		} 
		catch (CardException e) 
		{
			fail();
		}
		//2h, 3c, 4c, 5c, 6h, 7h, 8h
		e7.flushFinder(flush3, hand);
		assertEquals(0, flush3.size());
	}
}
