public class QueenBoard{
  private int[][] board;
  private int[][] solved;
  public QueenBoard(int size){
    board = new int[size][size];
    solved = new int[size][size];
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
    int sols = solveHelper(0,0,0,true);
    if(sols <= 0){
      for (int[] row :board) {
        for(int c = 0; c < board.length; c++){
          row[c] = 0;
        }
      }
    }
    board = solved;
    return sols > 0;
  }
  public int countSolutions(){
    for (int[] row: board) {
      for (int val : row ) {
        if(val != 0){
          throw new IllegalStateException();
        }
      }
    }
    int sols = solveHelper(0,0,0,false);
    board = solved;
    return sols;
  }
  private int solveHelper(int r, int c, int sols, boolean firstSol){
    if(c == board.length -1){
      if(board[r][c] == 0){
        addQueen(r,c);
        sols ++;
        for (int x = 0; x< board.length ;x++ ) {
          for (int y = 0; y < board.length; y++) {
            solved[x][y] = board[x][y];
          }
        }
        if(firstSol){
          return sols;
        }
        removeQueen(r,c);
        return solveHelper(0,c-1, sols,firstSol);
      }
    }
    if(board[r][c] == 0){
      addQueen(r,c);
      return solveHelper(0,c+1,sols,firstSol);
    } else{
      if(board[r][c] == -1){
        removeQueen(r,c);
        if(r == board.length-1 && c == 0){
          r = 0;
          c = 0;
          return sols;
        }
      }
      if(r == board.length -1 && c > 0){
        return solveHelper(0,c-1,sols,firstSol);
      }
      if(r < board.length - 1){
        return solveHelper(r+1, c, sols,firstSol);
      }
    }
    return sols;
  }
}
