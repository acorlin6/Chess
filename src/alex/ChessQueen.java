package alex;

import java.util.HashSet;

public class ChessQueen extends ChessPiece {
    public ChessQueen (Color color, Position position){
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
        return color + "Q ";
    }
    @Override
    HashSet<Position> availableSpots(ChessBoard board) {
        return null;
    }
}