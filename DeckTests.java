import static org.junit.Assert.*;

import java.util.ArrayList;

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
		Deck d = new Deck();
		d.shuffle();
		
		for(int i = 0; i < d.getCards().size(); i++)
		{
			d.getCards().get(i).printCard();
		}
		System.out.println();
	}
	
	@Test
	public void testDeal5Cards() 
	{
		Deck d = new Deck();
		d.shuffle();
		ArrayList < Card > hand = new ArrayList < Card >();
		try
		{
			d.dealCards(5, hand);
		}
		catch (DeckException e)
		{
			fail();
		}
		assertEquals(5, hand.size());
		assertEquals(47, d.getCards().size());
		
		ArrayList < Card > hand2 = new ArrayList < Card >();
		try
		{
			d.dealCards(5, hand2);
		}
		catch (DeckException e)
		{
			fail();
		}
		assertEquals(5, hand2.size());
		assertEquals(42, d.getCards().size());
		
		for(int i = 0; i < 5; i++)
		{
			assertNotEquals(hand.get(i), hand2.get(i));
		}
		
		try
		{
			d.dealCards(-4, hand);
			fail();
		}
		catch (DeckException e)
		{
		}
		
		try
		{
			d.dealCards(78, hand);
			fail();
		}
		catch (DeckException e)
		{
		}
	}

	@Test
	public void testDeal7Cards() 
	{
		Deck d = new Deck();
		d.shuffle();
		ArrayList < Card > hand = new ArrayList < Card >();
		
		try
		{
			d.dealCards(7, hand);
		}
		catch (DeckException e)
		{
			fail();
		}
		assertEquals(7, hand.size());
		assertEquals(45, d.getCards().size());
		
		ArrayList < Card > hand2 = new ArrayList < Card >();
		try
		{
			d.dealCards(7, hand2);
		}
		catch (DeckException e)
		{
			fail();
		}
		assertEquals(7, hand2.size());
		assertEquals(38, d.getCards().size());
		
		for(int i = 0; i < 7; i++)
		{
			assertNotEquals(hand.get(i), hand2.get(i));
		}
	}
}
