package com.techelevator;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class Exercises
{

	/*
	 * Given the name of an animal, return the name of a group of that animal (e.g.
	 * "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash 
	 * Giraffe -> Tower 
	 * Elephant -> Herd 
	 * Lion -> Pride 
	 * Crow -> Murder
	 * Pigeon -> Kit 
	 * Flamingo -> Pat 
	 * Deer -> Herd 
	 * Dog -> Pack 
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") -> "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	
	// go into excel to make a visual map of the key value pairs
	
	// goal is to return the associated group name for the animal.
	// deal with lowercase and uppercase
	// make all the keys lowercase (Gregor suggestion)
	
	// for the return unkown part, try using
	// if(animalName == null)
//		{
//			animalName = "unknown";
//		}
	
	

	public String animalGroupName(String animalName)
	{
		
		
		if(animalName == null || animalName == "")
		{
			return "unknown";
		}
		
		
		// create animalMap and add all above searches
		Map<String, String> animalMap = new HashMap<String, String>();
		
		// ADD ALL GIVEN KEY, VALUE PAIRS
		animalMap.put("rhino", "Crash");
		animalMap.put("giraffe", "Tower");
		animalMap.put("elephant", "Herd");
		animalMap.put("lion", "Pride");
		animalMap.put("crow", "Murder");
		animalMap.put("pigeon", "Kit");
		animalMap.put("flamingo", "Pat");
		animalMap.put("deer", "Herd");
		animalMap.put("dog", "Pack");
		animalMap.put("crocodile", "Float");
		
		String lowerCaseAnimalNames = animalName.toLowerCase();			
			
			if(animalMap.get(lowerCaseAnimalNames) == null)
			{
				return "unknown";
			}
		return animalMap.get(lowerCaseAnimalNames);
		
	}

	
	
	
	
	
	
	
	/*
	 * Given a String item number (a.k.a. SKU),
	 * return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM" -> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive
	 * so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") -> 0.20
	 * isItOnSale("") -> 0.00
	 * isItOnSale("GARAGE1070") -> 0.15
	 * isItOnSale("dungeon9999") -> 0.00
	 *
	 */
	
	
	
	public double isItOnSale(String itemNumber)
	{
		if(itemNumber == null || itemNumber == "")
		{
			return 0.00;
		}
		
		Map<String, Double> isItOnSale = new HashMap<String,Double>();
		
		isItOnSale.put("kitchen4001", 0.20);
		isItOnSale.put("garage1070", 0.15);
		isItOnSale.put("livingroom", 0.10);
		isItOnSale.put("kitchen6073", 0.40);
		isItOnSale.put("bedroom3434", 0.60);
		isItOnSale.put("bath0073", 0.15);
		
		String noCaseSKU = itemNumber.toLowerCase();
		
		if(isItOnSale.get(noCaseSKU) == null)
		{
			return 0.00;
		}
		return isItOnSale.get(noCaseSKU);
	}

	
	
	
	
	/*
	 * Modify and return the given Map as follows:
	 * if "Peter" has more than 0 money,
	 * transfer half of it to "Paul",
	 * but only if Paul has less than $10.00.
	 *
	 * Note, monetary amounts are specified in cents:
	 * penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) 
	 * 					-> {"Peter": 1000, "Paul": 1099}
	 * 
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000})
	 * 					 -> {"Peter": 2000, "Paul": 30000}
	 *
	 */
	
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul)
	{
		int petersMoney = peterPaul.get("Peter");
		int paulsMoney = peterPaul.get("Paul");
		
		boolean paulNeedsMoney = paulsMoney < 1000;
		
		//1. Does Paul need money?
		if(paulNeedsMoney)
		{
			//2. Yes? Then, get half of Peter's wallet
			int halfPeter = petersMoney / 2;
			
			
			
			//3. Update both wallets
			paulsMoney += halfPeter;
			petersMoney -= halfPeter;
			
			peterPaul.put("Peter", petersMoney);
			peterPaul.put("Paul", paulsMoney);
		}
		
		
		return peterPaul;
	}

	
	
	
	
	
	/*
	 * Modify and return the given Map as follows:
	 * if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a
	 * combined contribution of a quarter of each partner's current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) ->
	 * {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * 
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) ->
	 * {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul)
	{
		int petersNetWorth = peterPaul.get("Peter");
		int paulsNetWorth = peterPaul.get("Paul");
		
		boolean peterWillContribute = petersNetWorth >= 5000;
		boolean paulWillContribute = paulsNetWorth >= 10000;
		
		if(peterWillContribute && paulWillContribute)
		{
			int petersContribution = petersNetWorth / 4;
			int paulsContribution = paulsNetWorth / 4;
			int combinedContribution = (petersContribution + paulsContribution);
			
			int petersLesserWorth = petersNetWorth - petersContribution;
			int paulsLesserWorth = paulsNetWorth - paulsContribution;
			
			peterPaul.put("Peter", petersLesserWorth);
			peterPaul.put("Paul", paulsLesserWorth);
			peterPaul.put("PeterPaulPartnership", combinedContribution);
			
		}
		
		
		return peterPaul;
	}

	
	
	
	
	
	/*
	 * Given an array of non-empty Strings,
	 * return a Map<String, String> where
	 * for every different String in the array,
	 * there is a key of its first character
	 * with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) -> {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) -> {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) -> {"m": "y", "g": "d", "m": "t", "n": "t"}
	 */
	
	public Map<String, String> beginningAndEnding(String[] words)
	{
		// Declare a Map
		Map<String, String> wordsMap = new HashMap<String, String>();
		
		for (String wordsForMap : words)
		{
			wordsMap.put(wordsForMap.substring(0, 1), wordsForMap.substring(wordsForMap.length() -1));
		}
		
		
		return wordsMap;
		// have to return a Map
	}

	
	

	
	
	/*
	 * Given an array of Strings,
	 * 
	 * return a Map<String, Integer> with a key for each different String,
	 * with the value the number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) -> {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) -> {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) -> {}
	 * wordCount(["c", "b", "a"]) -> {"b": 1, "c": 1, "a": 1}
	 *
	 */
	
	
	public Map<String, Integer> wordCount(String[] words)
	{
		//create HashMap to return
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		
		//create a count variable for when the value is in the hashmap
		int count = 0;
		
		//loop through the array and determine if String exists in the hashmap
		for (String wordsToCount : words)
		{
			if(!wordsMap.containsKey(wordsToCount))
			{
				wordsMap.put(wordsToCount, 1);
			}
			else 
			{
				count = wordsMap.get(wordsToCount) + 1;
				wordsMap.put(wordsToCount, count);
			}
		}
		// if it doesn't, add it and set the count to 1. If it does exist, set count to ++.
		
		
		return wordsMap;
	}

	
	
	
	/*
	 * Given an array of int values,
	 * 
	 * return a Map<Integer, Integer> with a key for each int,
	 * with the value the number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) -> {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) -> {33: 4, 106: 1, 107: 3}
	 * intCount([]) -> {}
	 *
	 */
	
	public Map<Integer, Integer> integerCount(int[] ints)
	{
		Map<Integer, Integer> myIntsMap = new HashMap<Integer, Integer>();
		
		int count = 0;
		
		for (int intPassed : ints)
		{
			if (!myIntsMap.containsKey(intPassed))
			{
				myIntsMap.put(intPassed, 1);
			}
			else
			{
				count = myIntsMap.get(intPassed) + 1;
				myIntsMap.put(intPassed, count);
			}
		}
		
		return myIntsMap;
	}

	
	
	
	
	
	/*
	 * Given an array of Strings,
	 * 
	 * return a Map<String, Boolean>
	 * where each different String is a key and value is true only if that String appears 2 or more times
	 * in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) -> {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) -> {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) -> {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words)
	{
		Map<String, Boolean> myWordsMap = new HashMap<String, Boolean>();
		Map<String, Integer> storageForCount = new HashMap<String, Integer>();
		
		for (String wordsPassed: words)
		{
			if(storageForCount.containsKey(wordsPassed))
			{
				int count = storageForCount.get(wordsPassed);
				count++;
				
				if(count > 1)
				{
					myWordsMap.put(wordsPassed, true);
				}
				else
				{
					myWordsMap.put(wordsPassed, false);
				}
				
			} 
			else
			{
				storageForCount.put(wordsPassed, 1);
				myWordsMap.put(wordsPassed, false);
			}
		
		}
		
		
		return myWordsMap;
		
	
	
	}

	
	
	
	
	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map,
	 * Map<String, Integer> where keys in Map2, and their int values,
	 * are added to the int values of matching keys in Map1.
	 * 
	 * Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 						-> {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse)
	{
		Map<String, Integer> mergedMaps = new HashMap<String, Integer>();
		
		for (String mapOne : mainWarehouse.keySet())
		{
			if(remoteWarehouse.containsKey(mapOne))
			{
				mergedMaps.put(mapOne, (mainWarehouse.get(mapOne) + remoteWarehouse.get(mapOne)));
			}
			else
			{
				mergedMaps.put(mapOne, mainWarehouse.get(mapOne));
			}
		}
		for (String mapTwo : remoteWarehouse.keySet())
		{
			if (!(mainWarehouse.containsKey(mapTwo)))
			{
				mergedMaps.put(mapTwo, remoteWarehouse.get(mapTwo));
			}
		}
		
		
		return mergedMaps;
	}

	
	
	
	
	
	/*
	 * Just when you thought it was safe to get back in the water ---
	 * last2Revisited!!!!
	 *
	 * Given an array of Strings,
	 * for each String, the count of the number of times
	 * that a substring length 2 appears in the String
	 * and also as the last 2 chars of the String,
	 * 
	 * so "hixxxhi" yields 1.
	 *
	 * We don't count the end substring,
	 * but the substring may overlap a prior position by one.
	 * For instance, "xxxx" has a count of 2, one pair at position 0,
	 * and the second at position 1.
	 * The third pair at position 2 is the end substring, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its
	 * last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"])
	 * -> {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	
	public Map<String, Integer> last2Revisited(String[] words)
	{
		Map<String, Integer> last2Map = new HashMap<String, Integer>();
		
		String lastTwoLetters;
		
		for(String word: words)
		{
			Integer count = 0;
			
			lastTwoLetters = word.substring(word.length() -2);
			
			for (int i = 0; i < word.length() -2; i++)
			{
				String countLast2 = word.substring(i, i+2);
				if(countLast2.equals(lastTwoLetters))
				{
					count++;
				}
			}
			last2Map.put(word, count);
		}
		return last2Map;
	}

}
