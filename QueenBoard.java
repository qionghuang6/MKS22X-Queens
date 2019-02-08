public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
      for(int x: board[r]){
        if(x > 0 || x == -1){
          return false;
        }
      }
      for (int[] row: board) {
        if(row[c] > 0 || row[c] == -1){
          return false;
        }
      }
      for(int row = r, col = c; col >= 0 && row >= 0; col--, row--){
        if(board[row][col] > 0 || board[row][col] == -1){
          return false;
        }
      }
      for(int row = r, col = c; col < board[0].length && row < board.length; col++, row++){
        if(board[row][col] > 0 || board[row][col] == -1){
          return false;
        }
      }
      board[r][c] = -1;
      return true;
  }

  private boolean removeQueen(int r, int c){
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
  public static void main(String[] args) {
    QueenBoard t = new QueenBoard(10);
    System.out.println(t);
    t.addQueen(1,1);
  }
}
