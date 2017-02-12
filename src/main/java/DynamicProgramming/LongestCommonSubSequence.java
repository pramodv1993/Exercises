package DynamicProgramming;

/**
 * Created by pramodvadiraj on 13/02/17.
 */

import java.util.Scanner;

/**
 * eg:inp1:AGGTAB inp2:GXTXAYB op:length : 4(GTAB)
 */
public class LongestCommonSubSequence {
    private static  long lcs(int l_s1 , int l_s2)
    {
        if(l_s1 == -1 || l_s2 == -1)
            return 0;
        if(s1.toCharArray()[l_s1] == s2.toCharArray()[l_s2])
          return 1+lcs(l_s1 - 1,l_s2-1);
        else
            return max(lcs(l_s1-1,l_s2),lcs(l_s1,l_s2-1));


    }
    static  String s1;
    static  String s2;

    static long max(long s1 , long s2)
    {
        if(s1 > s2)
            return s1;
        else
            return s2;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         s1= scanner.next();
        s2 = scanner.next();
        System.out.println(lcs(s1.length() - 1,s2.length() - 1));
    }
}
