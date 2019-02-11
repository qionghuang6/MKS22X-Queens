public class Driver{
  public static void main(String[] args) {
    QueenBoard t = new QueenBoard(4);
    System.out.println(t);
    /*
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
    */
    System.out.println(t.solve());
    System.out.println(t);
    t = new QueenBoard(10);
    System.out.println(t.countSolutions());
    t = new QueenBoard(15);
    System.out.println(t.solve());
    System.out.println(t);
  }
}
