package com.techelevator;

import org.junit.Assert;
import org.junit.Test;


public class CigarPartyTests
{
	@Test
	public void haveParty_shouldReturnFalse_whenFewerThan30CigarsOnWeekday()
	{
		// arrange
		CigarParty party = new CigarParty(); // object under test
		int numberOfCigars = 30;
		boolean isWeekend = false;
		
		boolean expected = false;
		
		
		// act
		// call the function of the object under test
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		
		// assert
		Assert.assertFalse("Because parties with < 40 cigars suck ", actual);

	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan30CigarsOnWeekday()
	{
		// arrange
		CigarParty party = new CigarParty();
		int numberOfCigars = 50;
		boolean isWeekend = true;
		
		
		// act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		
		
		// assert
		Assert.assertTrue("Because you need more squirrels for cigar fun ", actual);
	
	}
	
	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan70CigarsOnWeekday()
	{
		// arrange
		CigarParty party = new CigarParty();
		int numberOfCigars = 70;
		boolean isWeekend = true;
		
		
		// act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
				
				
				
		// assert
		Assert.assertTrue("Because you need more squirrels for cigar fun ", actual);
		
	}

	@Test
	public void haveParty_shouldReturnTrue_whenMoreThan70CigarsOnWeekend()
	{
		// arrange
		CigarParty party = new CigarParty();
		int numberOfCigars = 70;
		boolean isWeekend = true;
		
		
		// act
		boolean actual = party.haveParty(numberOfCigars, isWeekend);
		
		
		
		// assert
		Assert.assertTrue("Because you need more squirrels for cigar fun ", actual);
	
	}
	
	
}