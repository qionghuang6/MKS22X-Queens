public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
      if(board[r][c] > 0 || board[r][c] == -1){
        return false;
      }
      for(int x: board[r]){
        x++;
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

  private boolean removeQueen(int r, int c){
      if(board[r][c] != -1){
        return false;
      }
      for(int x: board[r]){
        x -= 1;
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
  public static void main(String[] args) {
    QueenBoard t = new QueenBoard(10);
    System.out.println(t);
    t.addQueen(1,1);
      System.out.println(t);
    System.out.println(t.toStringDebug());
    t.addQueen(1,2);
    t.addQueen(2,2);
    t.addQueen(2,1);
    t.addQueen(2,3);
    System.out.println(t);
    System.out.println(t.toStringDebug());
    t.removeQueen(2,3);
    System.out.println(t.toStringDebug());
    System.out.println(t);
  }
}
