package gem_stones;

import java.util.HashMap;
import java.util.Scanner;

public class GemStones 
{
	public static HashMap<Character, Integer> elements = new HashMap<Character, Integer>();
	
	public static void findGemElement(String input) 
	{
		HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
		char array[] = input.toCharArray();
		int i;
		for(i = 0; i < array.length; i++)
		{
			if(!temp.containsKey(array[i]))
			{
				temp.put(array[i], 1);
			}
		}
		
		for(char c:temp.keySet())
		{
			if(elements.containsKey(c))
			{
				int val = elements.get(c);
				val++;
				elements.put(c, val);
			}
			else
			{
				elements.put(c, temp.get(c));
			}
		}
	}
	
	public static void gemElements(int count) 
	{
		int gems = 0;
		for(char c:elements.keySet())
		{
			if(elements.get(c) == count)
			{
				gems++;
			}
		}
		System.out.println(gems);
	}
	
	public static void main(String args[]) 
	{
		Scanner sr = new Scanner(System.in);
		int count = Integer.parseInt(sr.nextLine());
		String input[] = new String[count];
		for(int i = 0; i < count; i++)
		{
			input[i] = sr.nextLine();
		}
		for(int i = 0; i < count; i++)
		{
			findGemElement(input[i]);
		}
		gemElements(count);
		sr.close();
	}
}
