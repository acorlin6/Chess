package alex;

public class ChessPieceFactory {
    public static ChessPiece build(String info, Position newPos) throws Exception {
        char color = info.charAt(0);
        Color c = null;
        if (color == 'B'){
            c = Color.black;
        }else if(color == 'W'){
            c = Color.white;
        }
        String pieceType = info.substring(1);
        switch(pieceType){
            case "Q ":
                return new ChessQueen(c, newPos);
            case "Kn":
                return new ChessKnight(c, newPos);
            case "B ":
                return new ChessBishop(c, newPos);
            case "R ":
                return new ChessRook(c, newPos);
            case "P ":
                return new ChessPawn(c, newPos);
            case "K ":
                return new ChessKing(c, newPos);
            default:
                throw new Exception("unrecognized piece:" + pieceType);
        }
    }
}
