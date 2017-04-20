package problems;

/**
 * Created by pramodvadiraj on 20/04/17.
 */
public class pathsCountInMaze {

    static  Integer[][] mazeInput ;
    static int countPaths(Integer[][] mazeInput, int x , int y,int len_x,int len_y)
    {

        if(x==len_x && y == len_y) return 1;
        if(x > len_x || y > len_y) return 0;
        if(mazeInput[x][y] == 0) return 0;
        return countPaths(mazeInput,x+1,y,len_x,len_y) + countPaths(mazeInput,x,y+1,len_x,len_y);

    }
    public static void main(String[] args) {
        mazeInput = new Integer[][]{{1,1,1,1},
                {1,1,1,1},
                {0, 1,1,1},
                {1, 1, 1, 1}};
        System.out.println("Paths Count :" + countPaths(mazeInput,0,0,mazeInput.length-1,mazeInput.length-1));
    }
}
//alternative approach would be to check if maze[i][j] can be reached by maze[i-1][j] and maze[i][j-1] , if yes maze[i][j] = maze[i][j-1]+ maze[i-1][j], finally maze[R-1][C-1] will have the result