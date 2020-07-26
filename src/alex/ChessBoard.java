package alex;

import java.util.Scanner;

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];
    private boolean isPlayer1Turn = true;
    public ChessBoard() {
        for(int i = 0; i<8; i++){
            Position blackPos = new Position(1, i);
            Position whitePos = new Position(6, i);
            board[i][1] = new ChessPawn(Color.black, blackPos);
            board[i][6] = new ChessPawn(Color.white, whitePos);
        }
        board[0][0] = new ChessRook(Color.black, new Position(0,0));
        board[7][0] = new ChessRook(Color.black, new Position(0,7));
        board[0][7] = new ChessRook(Color.white, new Position(7,0));
        board[7][7] = new ChessRook(Color.white, new Position(7,7));

        board[1][0] = new ChessKnight(Color.black, new Position(0, 1));
        board[6][0] = new ChessKnight(Color.black, new Position(0, 6));
        board[1][7] = new ChessKnight(Color.white, new Position(7, 1));
        board[6][7] = new ChessKnight(Color.white, new Position(7, 6));

        board[2][0] = new ChessBishop(Color.black, new Position(0,2));
        board[5][0] = new ChessBishop(Color.black, new Position(0,5));
        board[2][7] = new ChessBishop(Color.white, new Position(7,2));
        board[5][7] = new ChessBishop(Color.white, new Position(7,5));

        board[3][0] = new ChessKing(Color.black, new Position(0,3));
        board[3][7] = new ChessKing(Color.white, new Position(7,3));

        board[4][0] = new ChessQueen(Color.black, new Position(0,4));
        board[4][7] = new ChessQueen(Color.white, new Position(7,4));
    }
    public String toString(){
        String boardToPrint = "---------------------------------\n";
        for (int row = 0; row<8; row++){
            for (int col = 0; col<8; col++){
                boardToPrint += "|";
                if (board[col][row] != null){
                    boardToPrint += (board[col][row].toString());
                }else{
                    boardToPrint += "   ";
                }
                if (col ==7){
                    boardToPrint += "|\n";
                    boardToPrint += "---------------------------------\n";
                }
            }
        }
        return boardToPrint;
    }
    public Color colorOfSpot(int row, int col){
        if (board[col][row] == null) {
            return null;
        }else{
            return board[col][row].color;
        }
    }
    public boolean bothKingsAlive(){
        boolean wKingFound = false;
        boolean bKingFound = false;
        for(int rowN = 0; rowN<8; rowN++){
            for(int colN = 0; colN<8; colN++){
                if(board[colN][rowN] == null){
                    continue;
                }
                if(board[colN][rowN].toString().equals("WK ")){
                    wKingFound = true;
                }
                else if(board[colN][rowN].toString().equals("BK ")){
                    bKingFound = true;
                }
            }
        }
        return wKingFound && bKingFound;
    }
    public void promptUserMove() throws Exception {
        System.out.println("Make your next move. Format: current position (row,col), desired position (row,col)");
        System.out.println(isPlayer1Turn ? "Black player's turn":"White player's turn");
        Scanner sc = new Scanner(System.in);
        String playerMove = sc.nextLine();
        int startRow = Integer.parseInt(playerMove.substring(1,2));
        int startCol = Integer.parseInt(playerMove.substring(3,4));
        int newRow = Integer.parseInt(playerMove.substring(7,8));
        int newCol = Integer.parseInt(playerMove.substring(9,10));
        Position newPos = new Position(newRow, newCol);
        if((isPlayer1Turn && !board[startCol][startRow].color.equals(Color.black)) || (!isPlayer1Turn && !board[startCol][startRow].color.equals(Color.white))){
            System.out.println("move not valid");
            this.promptUserMove();
            return;
        }
        System.out.println(board[startCol][startRow]);
        System.out.println(board[startCol][startRow].availableSpots(this));
        if(board[startCol][startRow].availableSpots(this).contains(newPos)){
            board[newCol][newRow] = null;
            board[newCol][newRow] = ChessPieceFactory.build(board[startCol][startRow].toString(), newPos);
            board[startCol][startRow] = null;
            System.out.println ("move successful");
            isPlayer1Turn = !isPlayer1Turn;
            return;
        }
        System.out.println("move not successful");
        this.promptUserMove();
    }
}
