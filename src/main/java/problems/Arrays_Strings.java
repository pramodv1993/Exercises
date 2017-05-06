package problems;

import java.util.*;

/**
 * Created by pramodvadiraj on 30/04/17.
 */

//check if a string is a permutation of a palindrome - can be done using bitVector eg : bbdada is a permutation of palindrome
//2 string are 1 edit away(edit,insert,replace eg : bale , ale
//string compression eg : aaaavcccc replace it by a4vc4


public class Arrays_Strings {

    public static void main(String[] args) {
        String a = "bbdada";
        a = a.trim();
        char a1[] = a.toCharArray();

        Map<Character,Integer> res = new HashMap<>();

        for(Character  c : a1)
        {
            if(res.containsKey(c))
                res.put(c,res.get(c)+1);
            else
                res.put(c,1);
        }
        boolean oddCount = false;
        for(Map.Entry<Character,Integer> resEntry : res.entrySet())
        {
            if((resEntry.getValue() % 2 != 0) && resEntry.getKey() != ' ')
            {
                if (!oddCount)
                {
                    oddCount = true;
                }
                else
                {
                    System.out.println("Not a palindrome");System.exit(-1);
                }
            }
        }
        System.out.println("it is a palindrome");

    }


    //check if 2 strings are 1 edit away
    //string compression
    //bqle ,pqle



}

class OneEditAway
{

    public static boolean insertTest(String smaller , String larger)
    {
        int i1= 0,i2 = 0;
        while(i1 < smaller.length() && i2 < larger.length())
        {
            if(smaller.charAt(i1) != larger.charAt(i2))
            {
                if(i1 != i2)
                    return false;
                i2++;
            }
            else
            {
                i1++;i2++;
            }
        }
        return true;

    }
    public static boolean replaceTest(String first,String second)
    {
        boolean foundDiff = false;
        for(int i = 0 ; i < first.length() ; i++)
        {
            if(first.charAt(i) != second.charAt(i))
            {
                if(!foundDiff)
                foundDiff = true;
                else
                    return false;
            }
        }
        return true;

    }
    public static boolean isOneEditAway(String first,String second)
    {
        if(first.length() == second.length())
            return replaceTest(first,second);
        else if(first.length() + 1 == second.length())
            return insertTest(first, second);
        else if(first.length() - 1 == second.length())
            return insertTest(second, first);
        return false;
    }
    public static void main(String[] args) {

        System.out.println(isOneEditAway("aple","ple"));


    }
}
