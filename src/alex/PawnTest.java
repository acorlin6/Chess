package alex;
import java.util.HashSet;

public class PawnTest {
    public void runTests(){
        this.testPawnStartingMoves();
    }
    private void testPawnStartingMoves(){
        System.out.println("starting test");
        ChessBoard testBoard = new ChessBoard();
        Position testPawnPosition = new Position(1,4);
        ChessPawn testPawn = new ChessPawn(Color.black, testPawnPosition);
        HashSet<Position> correctSpots = new HashSet<Position>();
        correctSpots.add(new Position(2,4));
        correctSpots.add(new Position(3,4));
        System.out.println(testPawn.availableSpots(testBoard));
        System.out.println(correctSpots);
        System.out.println(correctSpots.getClass());
        System.out.println(testPawn.availableSpots(testBoard).getClass());
        System.out.println(testPawn.availableSpots(testBoard).equals(correctSpots));
        assert (testPawn.availableSpots(testBoard).equals(correctSpots));

    }

}
