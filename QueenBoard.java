public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
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
        s += x;
        s += " ";
      }
      s+= "\n";
    }
    return s;
  }
}
