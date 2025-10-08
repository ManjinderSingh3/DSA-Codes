
public class e_Surrounded_Regions {

    private void floodFill(int m, int n, int i, int j, char[][] board){
        //Boundry condition
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]!='O'){
            return;
        }
        board[i][j] = 'V';
        floodFill(m, n, i+1, j, board);
        floodFill(m, n, i-1, j, board);
        floodFill(m, n, i, j+1, board);
        floodFill(m, n, i, j-1, board);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Step 1 : Converting all the boundry 0s to V
        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                floodFill(m, n, i, 0, board);
            }
            if(board[i][n-1]=='O'){
                floodFill(m,n,i,n-1,board);
            }
        }

        for (int j=0;j<n; j++){
            if(board[0][j]=='O'){
                floodFill(m,n,0,j, board);
            }
            if(board[m-1][j]=='O'){
                floodFill(m,n,m-1,j,board);
            }
        }

        // Step 2 : Coneret leftover Os to X
        for (int i=0; i<m ;i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

        // Step 3 : Convert Vs to Os
        for (int i=0; i<m ;i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='V'){
                    board[i][j]='O';
                }
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        e_Surrounded_Regions solver = new e_Surrounded_Regions();

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        System.out.println("Before solving:");
        printBoard(board);
        System.out.println();
        solver.solve(board);

        System.out.println("After solving:");
        printBoard(board);

    }

}
