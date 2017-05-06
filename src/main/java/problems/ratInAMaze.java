package problems;

/**
 * Created by pramodvadiraj on 17/04/17.
 */
public class ratInAMaze {
    static Integer[][] mazeInput;
    public static void displayMaze(Integer[][] inp)
    {
        for(int i = 0 ; i< inp.length; i++)
        {
            for(int j = 0 ; j < inp.length ;j++)
            {
                System.out.print(inp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    public static boolean isSafe(int x,int y,Integer[][] inp)
    {
        return x >= 0 && y >= 0 && x < inp.length && y < inp.length &&inp[x][y] == 1 ;

    }
    public static boolean solveMaze(Integer[][] inp,Integer[][] res ,int x , int y )
    {
        if(x == inp.length -1 && y == inp.length -1)
        {
            res[x][y] = 1;
            return true;
        }
        else
        if(isSafe(x,y,inp))
        {
            res[x][y] = 1;
            if(solveMaze(inp,res,x+1,y))
                return true;
             if(solveMaze(inp,res,x,y+1))
                return true;
            res[x][y] = 0;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        mazeInput = new Integer[][]{{1,1,1,1},
                {1,0,1,1},
                {1, 1,1,1},
                {1, 1, 1, 1}};
       displayMaze(mazeInput);
        System.out.println("_________RESULT_________");
        Integer[][] res = new Integer[][]{{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        solveMaze(mazeInput,res,0,0);
        displayMaze(res);
    }

}
