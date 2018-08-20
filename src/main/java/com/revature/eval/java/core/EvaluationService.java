package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

// Functions to just memorize for future
/*
 * string.length()
 * char[] var = svar.toCharArray();
 * String s = String.valueOf(charArr);
 * Parsing   String s = "apple poop--bear yo" with " " and "+" as delimiter
 * 		String delims = "[ -]+";   //delimiters go inside [], and the '+' means more than one space
 * 								  // counts only as one delimiter 
 *      String[] tokens = s.split(delims);
 * s.charAt(i) gives char at index i. Returns type char not string
 * for String[], can access length by doing sArray.length    NOT length(). thats for String
 * to turn a char to upper case or lowercase, do char newC = Character.toUpperCase(c);
 * 
 * s.substring(1);  //means 1st to End of string is returned as new string
 * s.substring(1, 9);   //means 1st to 9-1==8th is returned
 * 				// "jason".substring(0, 3) ===> "jas" ===> 0th, 1st, 2nd (But NOT 3rd)
 * 
 * String already has a toLowerCase() method ===> s.toLower/UpperCase();
 * 
 * Change character to its ascii value? Just type cast it into an int ==> (int) 'a'
 * Regex what does split("[_]+") do?   <====the _ means capital letter
 * 
 * How to get integer version of '1', '3', '5,', etc.?    ===> their unicode is also just 1, 3, 5
 * 																just use character or (int) it
 *							Can also just do char - '0'
 *							eg. '0' - '0' is 48 - 48 == 0 :D
 *							    '1' - '0'    49 - 48 == 1
 *How to convert String "-456" into integer?
 *							int saved = Integer.valueOf("-456");
 *
 */



public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	
	public void swapChar(char a, char b)
	{
		char c = a;
		a = b;
		b = c;
	}
	
	public String reverse(String string) {
		int len = string.length();
		if(len == 0)
			return string;   	//             01234
		char[] charCopy = new char[len];  //robot  --> tobar
		char[] charRev = new char [len];
		charCopy = string.toCharArray();
		
		for(int i = 0; i < len; i++)
			charRev[i] = charCopy[len - i - 1];
		String stringReversed = String.valueOf(charRev);
		
//		len--;
//		for(int i = 0; i <= len/2; i++)
//		{
//			swapChar(charCopy[i], charCopy[len - i]);
//		}
//		String stringReversed = String.valueOf(charRev);
		
		return stringReversed;
//		return null;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String delims = "[ -]+";
		String[] tokens = phrase.split(delims); 
		String acrnym = "";
		for(int i = 0; i < tokens.length; i++)
			acrnym += Character.toUpperCase(tokens[i].charAt(0));
		return acrnym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(sideOne != sideTwo)
				return false;
			if(sideOne != sideThree)
				return false;
			if(sideTwo != sideThree)
				return false;
			return true;
		}

		public boolean isIsosceles() {
			if(sideOne == sideTwo)
				return true;
			if(sideOne == sideThree)
				return true;
			if(sideTwo == sideThree)
				return true;
			return false;
		}

		public boolean isScalene() {
			if(sideOne == sideTwo)
				return false;
			if(sideOne == sideThree)
				return false;
			if(sideTwo == sideThree)
				return false;
			return true;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		char[] charCopy = string.toCharArray();
		int score = 0;
		boolean nextCharCopy;
		
		int[] scorePoints = {1, 2, 3, 4, 5, 8, 10};
		char[][] scoreKey = {{'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'}, {'D', 'G'},
				          {'B', 'C', 'M', 'P'}, {'F', 'H', 'V', 'W', 'Y'}, {'K'}, {'J', 'X'},
				          {'Q', 'Z'}};
		
		for(int k = 0; k < charCopy.length; k++)
		{
			nextCharCopy = false;
			charCopy[k] = Character.toUpperCase(charCopy[k]);
			for(int i = 0; i < scorePoints.length; i++)
			{
				for(int j = 0; j < scoreKey[i].length; j++)
					if(charCopy[k] == scoreKey[i][j])
					{
						score += scorePoints[i];	//update the score
						nextCharCopy = true;		//set flag to break j loop
						break;
					}
				
				if(nextCharCopy == true)		//if no break, keep going thru scoreKey
					break;
			}
		}
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253    613-995-0253   1 613 995 0253    613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		int index = 0;
		boolean flagLeading1 = false;
		
		for(int i = 0; i < string.length(); i++)
			if(Character.isDigit(string.charAt(i)))
			{
				if(index == 0 && string.charAt(i) == '1')
					flagLeading1 = true;
				index++;
			}
		
		if(index > 11)	//more than 11 numbers, gen exception
			throw new IllegalArgumentException("Too many numbers");
		
		if(index == 11 && !flagLeading1)
			throw new IllegalArgumentException("11 numbers is too many if the first is not 1");
		if(index < 10)
			throw new IllegalArgumentException("Enter only numbers and 10-11");
		
		char[] charCleaned = new char[index];
		int pos = 0;
		for(int i = 0; i < string.length(); i++)
			if(Character.isDigit(string.charAt(i)))
				charCleaned[pos++] = string.charAt(i);
		//FIXMME.....THIS WAS GIVING ME SO MANY ERRORS >:OOO SOO DUMB
//		charCleaned[pos] = '\0';			//getting spaces afterwards?? :( cuz same length as string FIXME question
		
		//remove any '1' if index == 11 
		if(charCleaned[0] == '1' && index == 11)
		{
			for(int i = 0; i < index-1; i++)	//move every char down once
				charCleaned[i] = charCleaned[i + 1];
			index--;
		}
			
		char[] cleaned2 = new char[index];			//recopying but with correct size to have correct sized array
		for(int i = 0; i < index; i++)
			cleaned2[i] = charCleaned[i];
		
		//change back to string
		String cleanedNumber = String.valueOf(cleaned2);
		//return string
		return cleanedNumber;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
//		char[] charCopy = new char[string.length()];
//		charCopy = string.toCharArray();
		String delimiter = "[ ,\n]+";
		String[] words = string.split(delimiter);
		//Must call HashMap because Map is an Interface, can't be instantiated
		Map<String, Integer> wordOccurrenceMap = new HashMap<String, Integer>();
		for(int i = 0; i < words.length; i++)
			if(!wordOccurrenceMap.containsKey(words[i]))
				wordOccurrenceMap.put(words[i],  1);
			else
				wordOccurrenceMap.replace(words[i], wordOccurrenceMap.get(words[i]) + 1);
		
		return wordOccurrenceMap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable> {
		private List<T> sortedList;

		public int helper(T t, int first, int last)
		{
			if(last - first == 0)
				if(sortedList.get(first).toString().equals(t.toString()))
					return first;
				else
					return -1;
			
			int halfway = (first + last) / 2;
			String tString = t.toString();
			String elemStr = sortedList.get(halfway).toString();
			if( elemStr.equals(tString) )
				return halfway;
			else
			{ //make the sorted list in half
				if(halfway == 0)
					return -1;
				if( t.compareTo(sortedList.get(halfway)) < 0 ) //search key less than middle elem
					return helper(t, first, halfway - 1);
				
				else //return other half
					return helper(t, halfway + 1, last);
			}
		}
		public int indexOf(T t) {
			if(sortedList.isEmpty())
				return -1;					//not found
			
			return helper(t, 0, sortedList.size() - 1);
			
			/*
			int halfway = sortedList.size() / 2;
			String tString = t.toString();
			System.out.println(tString);
			String elemStr = sortedList.get(halfway).toString();
			System.out.println(elemStr);
			if( elemStr.equals(tString) )
				return halfway;
			else
			{ //make the sorted list in half
				if( t.compareTo(sortedList.get(halfway)) < 0 ) //search key less than middle elem
				{
					System.out.println("goes here?");
					List<T> half1 = new LinkedList<T> ();
					for(int i = 0; i <= halfway; i++)
						half1.add(sortedList.get(i));
					System.out.println(half1);
					setSortedList(half1);
					return indexOf(t);
				}
				
				else //return other half
				{
					System.out.println("goes here???");
					List<T> half2 = new LinkedList<T> ();
					for(int i = halfway; i < getSortedList().size(); i++)
						half2.add(sortedList.get(i));
					System.out.println(half2);
					setSortedList(half2);
					return indexOf(t);
				}
			}
			
//			return 0;   //i will be the position...
 
 		*/
		}
		
		/* have a priivate helper method binSearch(int first, int last, int[] arr)
		 * calculate midpoint
		 * if 
		 */

		public BinarySearch(List<T> sortedList) { //constructor
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {  //access the list
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) { //reassign the list
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String rtnString = "";
		//need to define array of string consonants
		String[] cons = {"th", "sch", "y", "qu", "f", "r"};
		//need to define array of string vowels
		char[] vow = {'a', 'i', 'o', 'e', 'u' };  //char arr because vowels are 1 character, .charAt(0)
		
		Boolean vowelsFlag;
		String delimiters = "[ ]+";
		String[] words = string.split(delimiters);
		int i;
		for(i = 0; i < words.length; i++ )
		{		
			vowelsFlag  = false;
			for(char j : vow) //Go through the vowels to see if starts with a vowel
				if(j == words[i].charAt(0))
				{
					words[i] = words[i] + "ay";			//just add "ay"
					vowelsFlag = true;	//mark the flag
					break;	
				}
			
			if(vowelsFlag == false)	//then it is a consonant, so go thru string consonants
				for( String k : cons )
				{
					if( k.equals( words[i].substring(0, k.length() ) ) )
						words[i] = words[i].substring( k.length() ) + k + "ay";
				}
			//put words back into one string
			if(i < words.length - 1)
				rtnString += words[i] + " ";
			else
				rtnString += words[i];
		}
		
		
		return rtnString;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int sum = 0;
		String s = String.valueOf(input);		//new, put in note comments
		int digitCount = s.length();
		if(digitCount == 1)
			return true;
		if(digitCount == 2)
			return false;
		for(int i = 0; i < digitCount; i++)
			sum +=  Math.pow( Character.digit(s.charAt(i), 10), digitCount);	//put in note both	
		if(sum == input)
			return true;
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */								//FIXME idk wats wrong...skipping
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> primes = new LinkedList<Long> ();
		primes.add((long) 2);
		
		List<Long> p = new LinkedList<Long> ();
		p.add(l);
		System.out.println("This is long: "+ p.toString());
		
		//generate primes from 2 to l
		for(long possiblePrime = 3; possiblePrime < l; possiblePrime++)
		{
			for(Long prime : primes)
			{
				if(possiblePrime % prime != 0) 	//uneven division
				{
					primes.add((long)possiblePrime);	//add to the list
					System.out.println("This is long: "+ primes.toString());
				}
			}
		}
		String a = primes.toString();
		System.out.println(a);
		
//		for(Long prime : primes)
//			if(l % prime != 0)	// if prime is not a factor of l
//				primes.remove(prime);

		return primes;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			char[] copy = new char[string.length()];
		
			for(int i = 0; i < string.length(); i++)
			{
				char curr = string.charAt(i);	//save the character value
				int currInt = (int) curr;	//save the ascii code value of character
				
				if( !Character.isAlphabetic(curr) ) //numbers, space, punctuation 
					copy[i] = curr;					//no change
				
				//deal with uppercase letters
				else if (currInt < (int)'Z')	
					//would adding the key stay in bounds?
					if(currInt + key > 'Z')
						copy[i] = (char) (currInt + key - 26 );
					else
						copy[i] = (char) (currInt + key);	
				
				else //currInt is lowercase
					if(currInt + key > 'z')
						copy[i] = (char) (currInt + key - 26 );
					else
						copy[i] = (char) (currInt + key);
			}
			
			return String.valueOf(copy);	
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		int index = 1;
		int[] primes = new int[i];	//array will be of i length. each index holds the next prime
		boolean soFarStillPrime = true;
		if(i == 0)
			throw new IllegalArgumentException("No 0th prime. First prime starts at 2.");
		
		if(i == 1)
			return 2;
		
		//otherwise do regular
		primes[0] = 2;
		for(int num = 3; index < i ; num++)//while array not full with primes yet
		{
			for(int p = 0; p < index; p++)	//no for each, if not filled yet completely
				if(num % primes[p] == 0) // current num isn't prime, since divisible by other prime
				{
					soFarStillPrime = false;
					break;
				}
			
			if(soFarStillPrime == true)	//never got marked as false in for
				primes[index++] = num;
			else		//marked as false, so reset
				soFarStillPrime = true;
		}
		
		
		return primes[i - 1];		//rtn primes[i - 1];
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 *         0123456789012 3456789012345   0->25 for index, 26 numbers/length
	 * Plain:  abcdefghijklm nopqrstuvwxyz 
	 * Cipher: zyxwvutsrqpon mlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			int length;
//			string = string.toLowerCase();
			String cleanedString = "";
			//remove original spaces and punctuation from string with split, Array
			String[] cleanedChunks = string.split("[ ,!.?()*%#-]+");
			//DONT PUT AN UNDERSCORE unless u wanna parse uppercase ltters lol
			
			for(String chunk : cleanedChunks) //loop through array to add up into 1 string again
				cleanedString += chunk;
				
			//calculate length of copy array. (string's length + length/5)
			length = cleanedString.length();
			char[] charCopy = new char[length + length / 5];
			
			int i, ind = 0;	//ind will track charCopy indices, which go up differently
			for(i = 0; i < length; i++)	//go through character by character and copy/edit
			{		
				//every 5 characters add a space
				if(i > 0 && i % 5 == 0)
					charCopy[ ind++ ] = ' ';	//process this space index, then move on
				
				if( Character.isDigit(cleanedString.charAt(i)) ) //if isDigit, just copy 
					charCopy[ ind++ ] = cleanedString.charAt(i);
				//else is character, copy a toLowerCase(), ciphered version
				else
				{	//make things simpler, work with just lower cased version
					char saved = Character.toLowerCase( cleanedString.charAt(i) );
					//(25 - (letter - 'a')) + 'a'		
					int aAsciiStartIndex = 'a';			//saving the ascii index of 'a' for readability
					int index = saved - aAsciiStartIndex; //get number 0 -> 25 which is letter of saved
					saved = (char) (25 - index + aAsciiStartIndex);
					charCopy[ ind++ ] = saved;
				}
			}
			return String.valueOf(charCopy).trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			//remove spaces
			String cleaned = "";
			String[] tokens = string.split("[ ]+");	//
			for (String t: tokens)
				cleaned += t;
			
			char[] deciphered = new char[cleaned.length()];
			for(int i = 0; i < cleaned.length(); i++)
				if(Character.isDigit(cleaned.charAt(i)))
					deciphered[i] = cleaned.charAt(i);	//copy opver numbers
				else //alphabet
				{
					int aAsciiStartIndex = 'a';			//saving the ascii index of 'a' for readability
					int index = cleaned.charAt(i) - aAsciiStartIndex; //get number 0 -> 25 which is letter of saved
					char saved = (char) (25 - index + aAsciiStartIndex);
					deciphered[i] = saved;
				}
			
			return String.valueOf(deciphered);
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
	//clean the string: 
		String nodash = "";
		String[] chunks = string.split("[-]+"); //remove -'s
		for(String chunk : chunks)
			nodash += chunk;
		
		if(nodash.length() != 10)	//must have 9 digits and (1 more digit or 'X')
			return false;
		
		//only numbers until last char check
		int i, length = nodash.length();
		for(i = 0; i < length - 1; i++)
			if( !Character.isDigit( nodash.charAt(i) ) ) 
				return false; 			
		if(!Character.isDigit( nodash.charAt(i) ) )	//last digit not digit AND not 'X' check
		   if(nodash.charAt(i) != 'X')				
			   return false;       
		
		
		//plug into formula
		int sum = 0;
		for(int formula = 10; formula > 1; formula--)	//formula goes 10 -> 2
		{
			sum += formula * Character.getNumericValue( nodash.charAt(10 - formula) );
		}
		
		//deal with last character and last string item	
		char lastChar = nodash.charAt(length - 1);
		if(lastChar != 'X')
			sum += Character.getNumericValue(lastChar); 		//last * 1
		else		//treat 'X' like 10
			sum += 10;
				
		if(sum % 11 == 0)
			return true;
		else
			return false;
		
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		Vector v = new Vector();
		String formatted, nospace = "";
		
		if(string == null)
			return false;
		
		String[] tokens = string.split("[ ]+");
		for(String t : tokens)
			nospace += t;
		
		if(nospace.length() < 26) //need at least all the characters	
			return false;
		
		//lowercase everything
		formatted = nospace.toLowerCase();
		v.add(formatted.charAt(0));		//add the first char to vector to have something to compare
		
		boolean alreadyCounted = false;
		for(int i = 1; i < formatted.length(); i++)
		{
			for(int vIndex = 0; vIndex < v.size(); vIndex++)
				if( formatted.charAt(i) == (char) v.get(vIndex) )	//returns Object, just typecast
				{
					alreadyCounted = true;
					break;
				}
			
			if(alreadyCounted == true)		//don't change the vector
				alreadyCounted = false;		//resetting flag
			else						//unique letter so add to vector
				v.add( formatted.charAt(i) );
		}
		
		if(v.size() < 26)
			return false;
		else
			return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.now().getMonth());
		
//	given.plus
		if(given instanceof LocalDateTime)
		{
			LocalDateTime n = (LocalDateTime) given;
			return n.plus(1000000000, ChronoUnit.SECONDS);
			
		}
		if(given instanceof LocalDate)
		{
			System.out.println("here");
			LocalDate n = (LocalDate) given;
			LocalDateTime b = n.atStartOfDay();
			return (b.plus(1000000000, ChronoUnit.SECONDS));
			
//			return n.plus(1000000000, ChronoUnit.SECONDS);
		}
//		rn n.plus(1000000000, ChronoUnit.SECONDS);
		
		System.out.println("Wasnt caught");
		return given.plus((long) 1000000000, ChronoUnit.DAYS);
//		System.out.println(LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40));
//		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		ArrayList<Integer> toBeSummed = new ArrayList<Integer> ();
		//go up to i, but not including i. so 1 --> i-1;
		for(int number = 1; number < i; number++)
			for(int s = 0; s < set.length; s++)		//nested forloop through set array
			//if is multiple, add to sum array and break;
				if(number % set[s] == 0)
				{
					toBeSummed.add(number);
					break;	//dont want to add multiple times
				}
		
		int sum = 0;
		for(Object integer : toBeSummed)
			sum += (Integer) integer;
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		///rtn false for !isDigit, !isWhiteSpace
		for(int i = 0; i < string.length(); i++)
			if( !Character.isDigit( string.charAt(i) ) )
				if( !Character.isWhitespace( string.charAt(i) ) )
					return false;
		
		String clean = parse(string, "[ ]+");
		
		//array with changes
		int[] doubled = new int [clean.length()];
		int count = 1;		
		
		//read characters from (length-2) of string to 0th. Decrement by 2
		for(int i = (clean.length() - 1); i >= 0; i --)
		{
			int toInt = clean.charAt(i) - '0'; //for each character, get int version
			if(count % 2 == 0) //every other
			{
				//double it, and check if in bounds
				toInt *= 2;
				if(toInt > 9)
					toInt = toInt - 9;
				//resave into other array
				doubled[i] = toInt;
			}
			
			else //just copy
				doubled[i] = toInt;
			
			count++;
		}	//for()
		
		//sum up doubled and see if it's evenly divisible by 10
		int sum = 0;
		for(int i : doubled)
			sum += i;
		
		if(sum % 10 == 0)
			return true;
		return false;		
	}

	public String parse(String string, String regexpression)
	{
		//clean up string
		String clean = "";
		String[] despacedChunks = string.split(regexpression);
		for(String chunk : despacedChunks)
			clean += chunk;
		return clean;
	}
	
	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		int[] twoNumbers = new int[2];
		int index = 0;
		String[] operations = new String[5]; //up to 5, but we're only doing 1
		int indexOp = 0;
		
		//parse the string for spaces
		String[] words = string.split("[ ?]+");
		for(String word : words)
			if( checkIsNumber(word) )	//process a number
				twoNumbers[index++] = Integer.valueOf(word);
			else if(returnKeyword(word) != null) //process a keyword
				operations[indexOp++] = returnKeyword(word);
			else			//anything else
				continue;
		
		//now do operation
		int count = 0, countOp = 0;
		int rounds = index / 2;
		
		for(int i = 0; i < rounds; i++)
		{
			switch(operations[countOp])
			{
			case "plus":
				return twoNumbers[count++] + twoNumbers[count++];
			case "minus":
				return twoNumbers[count++] - twoNumbers[count++];
			case "multiplied":
				return twoNumbers[count++] * twoNumbers[count++];
			case "divided":
				return twoNumbers[count++] / twoNumbers[count++];
			}
			
			countOp++;
		}
		
		return 0;
	}
	
	public String returnKeyword(String s)
	{
		String[] keywords = {"plus", "minus", "multiplied", "divided"};
		for(String key : keywords)
			if(s.equals(key))
				return key;
		return null;
	}
	public boolean checkIsNumber(String string)
	{
		for(int i = 0; i < string.length(); i++)
			if( !Character.isDigit( string.charAt(i) ) )
				if(string.charAt(i) == '-')
					return true;
				else
					return false;
		return true;
	}

}
