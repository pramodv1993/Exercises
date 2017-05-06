package problems;

import java.util.*;

/**
 * Created by pramodvadiraj on 30/04/17.
 */
public class Arrays_Strings {
    public static void main(String[] args) {
        String a = "oooooolooooooloooooo";
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
}
