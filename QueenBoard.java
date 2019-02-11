public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
    return changeQueen(r,c,1,-1);
  }
  private boolean removeQueen(int r, int c){
    return changeQueen(r,c,-1,0);
  }
  private boolean changeQueen(int r, int c, int change, int queen){
      if(board[r][c] > 0 || board[r][c] == queen){
        return false;
      }
      for(int x = 0; x < board.length; x++){
        board[r][x] += change;
      }

      for (int[] row: board) {
        row[c] += change;
      }

      for(int row = r, col = c; col >= 0 && row >= 0; col--, row--){
        board[row][col] += change;
      }
      for(int row = r, col = c; col < board[0].length && row >= 0; col++, row--){
        board[row][col] += change;
      }
      for(int row = r, col = c; col < board[0].length && row < board.length; col++, row++){
        board[row][col] += change;
      }
      for(int row = r, col = c; col >= 0 && row < board.length; col--, row++){
        board[row][col] += change;
      }
      board[r][c] = queen;
      return true;
  }

  public String toString(){
    String s = "";
    for (int a = 0; a < board.length; a++) {
      for(int x = 0; x < board[a].length; x++){
        if (board[a][x] > -1){
            s+= "_";
        } else{
          s += "Q";
        }
        if(x < board[a].length -1){
          s += " ";
        }
      }
      if(a < board.length){
        s+= "\n";
      }
    }
    return s;
  }
  public String toStringDebug(){
    String s = "";
    for (int[] row: board) {
      for (int x : row ) {
        s += x;
        s += "  ";
      }
      s += "\n";
    }
    return s;
  }
  public boolean solve(){
    for (int[] row: board) {
      for (int val : row ) {
        if(val != 0){
          throw new IllegalStateException();
        }
      }
    }
    return solveR(0);
  }
  private boolean solveR(int col){
    if (col >= board.length){
      return true;
    }
    for(int x = 0; x < board.length; x++){
      if(addQueen(x,col)){
        if(solveR(col + 1)){
          return true;
        }
        removeQueen(x,col);
      }
    }
    return false;
  }
  public int countSolutions(){
    for (int[] row: board) {
      for (int val : row ) {
        if(val != 0){
          throw new IllegalStateException();
        }
      }
    }
    return 0;
  }
  private int countSolsR(int col){
    int sols = 0;
    if (col >= board.length){
      sols++;
    }
    for(int x = 0; x < board.length; x++){
      if(addQueen(x,col)){
        sols += countSolsR(col + 1);
        removeQueen(x,col);
      }
    }
    return sols;
  }
}
