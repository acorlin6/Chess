package alex;

public class Main {

    public static void main(String[] args) throws Exception{
        ChessBoard board = new ChessBoard();
        System.out.println(board.toString());
        while (board.bothKingsAlive()){
            board.promptUserMove();
            System.out.println(board.toString());
        }
        //end game message
    }
}
