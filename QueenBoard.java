public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  public boolean addQueen(int r, int c){
      if(board[r][c] > 0 || board[r][c] == -1){
        return false;
      }
      for(int x = 0; x < board.length; x++){
        board[r][x] ++;
      }

      for (int[] row: board) {
        row[c] += 1;
      }

      for(int row = r, col = c; col >= 0 && row >= 0; col--, row--){
        board[row][col] += 1;
      }
      for(int row = r, col = c; col < board[0].length && row >= 0; col++, row--){
        board[row][col] += 1;
      }
      for(int row = r, col = c; col < board[0].length && row < board.length; col++, row++){
        board[row][col] += 1;
      }
      for(int row = r, col = c; col >= 0 && col < board.length; col--, row++){
        board[row][col] += 1;
      }
      board[r][c] = -1;
      return true;
  }

  public  boolean removeQueen(int r, int c){
      if(board[r][c] != -1){
        return false;
      }
      for(int x = 0; x < board.length; x++){
        board[r][x] --;
      }
      for (int[] row: board) {
        row[c] -= 1;
      }
      for(int row = r, col = c; col >= 0 && row >= 0; col--, row--){
        board[row][col] -= 1;
      }
      for(int row = r, col = c; col < board[0].length && row < board.length; col++, row++){
        board[row][col] -= 1;
      }
      board[r][c] = 0;
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
}
