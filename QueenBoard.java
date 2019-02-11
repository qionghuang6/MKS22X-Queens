public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  public boolean addQueen(int r, int c){
    return changeQueen(r,c,1,-1);
  }
  public boolean removeQueen(int r, int c){
    return changeQueen(r,c,-1,0);
  }
  public boolean changeQueen(int r, int c, int change, int queen){
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
    for (int[] row: board) {
      for(int x: row){
        if(x > -1){
            s+= "_";
        } else{
          s += "Q";
        }
        s += " ";
      }
      s+= "\n";
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
    int sols = solveHelper(0,0,0);
    for (int[] row :board) {
      for(int c = 0; c < board.length; c++){
        row[c] = 0;
      }
    }
    return sols > 0;
  }
  public int solveHelper(int r, int c, int sols){
    System.out.println(toString());
    System.out.println(toStringDebug());
    System.out.println(r);
    System.out.println(c);
    if(c == board.length -1){
      if(board[r][c] == 0){
        sols ++;
        System.out.println(" NEW SOL");
        return solveHelper(0,c-1, sols);
      }
    }
    if(board[r][c] == 0){
      System.out.println("added queen" + r + "  " + c);
      addQueen(r,c);
      return solveHelper(0,c+1,sols);
    } else{
      if(board[r][c] == -1){
        removeQueen(r,c);
        System.out.println("queen removed");
        System.out.println("row col" + r + " " + c);
        if(r == board.length-1 && c == 0){
          System.out.println("YEET");
          r = 0;
          c = 0;
          System.out.println("sols " + sols);
          return sols;
        }
      }
      if(r == board.length -1 && c > 0){
        return solveHelper(0,c-1,sols);
      }
      if(r < board.length - 1){
        return solveHelper(r+1, c, sols);
      }
    }
    return sols;
  }
}
