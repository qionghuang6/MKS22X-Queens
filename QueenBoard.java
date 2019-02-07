public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
      board[r][c] = -1;
      return true;
  }
}
