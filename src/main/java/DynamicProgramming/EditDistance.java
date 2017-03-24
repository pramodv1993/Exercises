package DynamicProgramming;

import java.util.Scanner;

/**
 * Created by pramodvadiraj on 15/02/17.
 */

//Gives s1,s2
//eg:sunday,saturday
//op:min of  3 steps are required to convert sunday to saturday(insert a and r, replace n with t)
public class EditDistance {
    public static  int  solve(String s1 , String s2, int s1_l,int s2_l)
    {

        if(s1_l > 0)
            System.out.print(s1.charAt(s1_l - 1));
        if(s2_l > 0)
            System.out.println("  "+s2.charAt(s2_l - 1));

        if(s1_l == 0)
            return s2_l;
        if(s2_l == 0)
            return  s1_l;
        if(s1.charAt(s1_l - 1) == s2.charAt(s2_l-1))
            return solve(s1,s2,s1_l-1,s2_l-1);
        else
        //min(replace,insert,remove)
        //insert:adding the character of String s2 to String s1
        return 1+min(solve(s1,s2,s1_l-1,s2_l-1),solve(s1,s2,s1_l,s2_l-1),solve(s1,s2,s1_l-1,s2_l));
    }
    public static int min(int v1,int v2,int v3)
    {
        if(v1<v2 && v1 <v3)
            return v1;
        else if(v2<v3 && v2<v1)
            return v2;
        else return v3;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 =scanner.next();
        String s2 =scanner.next();
        System.out.println(solve(s1, s2, s1.length(), s2.length()));

    }

}
