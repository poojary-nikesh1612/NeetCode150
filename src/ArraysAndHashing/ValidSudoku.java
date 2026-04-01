package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    //Solution using HashSet with TC->O(n^2) & SC->O(n)
    public static boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++){
            Set<Character> seen=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                    continue;
                if(seen.contains(board[i][j]))
                    return false;
                seen.add(board[i][j]);
            }
        }

        for(int i=0;i<9;i++){
            Set<Character> seen=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[j][i]=='.')
                    continue;
                if(seen.contains(board[j][i]))
                    return false;
                seen.add(board[j][i]);
            }
        }

        for(int square=0;square<9;square++){
            Set<Character> seen=new HashSet<>();
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    int row=(square/3)*3+i;
                    int col=(square%3)*3+j;
                    if(board[row][col]=='.')
                        continue;
                    if(seen.contains(board[row][col]))
                        return false;
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }

    //More optimized solution using Bitmask with TC->O(n^2) & SC->O(n)
    public static boolean isValidSudoku1(char[][] board) {
        int[] rows=new int[9];
        int[] cols=new int[9];
        int[] squares=new int[9];

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]=='.')continue;

                int bit=1<<(board[r][c]-'1');
                int box=(r/3)*3+(c/3);
                if((rows[r] & bit)>0 || (cols[c]& bit)>0
                        || (squares[box] & bit)>0){
                    return false;
                }
                rows[r]|=bit;
                cols[c]|=bit;
                squares[box]|=bit;
            }
        }
        return true;
    }

    public static void main(String[]args){
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku1(board));
    }
}
