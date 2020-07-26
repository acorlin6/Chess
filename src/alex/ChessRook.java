package alex;

import java.util.HashSet;

public class ChessRook extends ChessPiece{
    public ChessRook (Color color, Position position){
        super(color, position);
    }
    @Override
    public String toString(){
        String color;
        if(this.color == Color.white){
            color = "W";
        }else{
            color = "B";
        }
        return color + "R ";
    }
    @Override
    HashSet<Position> availableSpots(ChessBoard board) {
        return null;
    }
}
