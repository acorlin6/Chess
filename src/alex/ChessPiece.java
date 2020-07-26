package alex;
import java.util.HashSet;

public abstract class ChessPiece {
    Position position;
    Color color;
    public ChessPiece (Color color, Position position){
        this.color = color;
        this.position = position;
    }
    abstract HashSet<Position> availableSpots(ChessBoard board);
}
