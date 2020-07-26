package alex;

import java.util.HashSet;

public class ChessPawn extends ChessPiece {
    public ChessPawn(Color color, Position position) {
        super(color, position);
    }

    @Override
    public String toString() {
        String color;
        if (this.color.equals(Color.white)) {
            color = "W";
        } else {
            color = "B";
        }
        return color + "P ";
    }

    @Override
    HashSet<Position> availableSpots(ChessBoard board) {
        HashSet<Position> spotsToMove = new HashSet<Position>();
        int col = this.position.col;
        int row = this.position.row;
        if (this.color.equals(Color.black)) {
            if (this.position.row == 1) {
                if(board.board[col][row+1]==null) {
                    spotsToMove.add(new Position(2, this.position.col));
                    if(board.board[col][row+2]==null) {
                        spotsToMove.add(new Position(3, this.position.col));
                    }
                }
            } else if (this.position.row < 7) {
                if (board.board[col][row + 1] == null) {
                    spotsToMove.add(new Position(this.position.row + 1, this.position.col));
                }
            }
            if (0<this.position.col && this.position.col<7 && this.position.row<7) {
                if (board.board[col - 1][row + 1] != null && board.colorOfSpot(row+1,col-1).equals(Color.white)){
                    spotsToMove.add(new Position(row + 1, col - 1));
                }
                if (board.board[col + 1][row + 1] != null && board.colorOfSpot(row+1,col+1).equals(Color.white)) {
                    spotsToMove.add(new Position(row + 1, col + 1));
                }
            } else if (this.position.col == 0 && this.position.row < 7) {
                if (board.board[1][row + 1] != null && board.colorOfSpot(row+1,1).equals(Color.white)) {
                    spotsToMove.add(new Position(row + 1, 1));
                }
            } else if (this.position.col == 7 && this.position.row < 7) {
                if (board.board[6][row + 1] != null&& board.colorOfSpot(row+1,6).equals(Color.white)) {
                    spotsToMove.add(new Position(row + 1, 6));
                }
            }
        } else {
            if (this.position.row == 6) {
                if(board.board[col][row-1]==null) {
                    spotsToMove.add(new Position(5, this.position.col));
                    if(board.board[col][row-2]==null) {
                        spotsToMove.add(new Position(4, this.position.col));
                    }
                }
            } else if (this.position.row > 0) {
                if(board.board[col][row-1]==null) {
                    spotsToMove.add(new Position(this.position.row - 1, this.position.col));
                }
            }
            if (0 < this.position.col && this.position.col< 7) {
                if (board.board[col - 1][row - 1] != null && board.colorOfSpot(row-1,col-1).equals(Color.black)) {
                    spotsToMove.add(new Position(row - 1, col - 1));
                }
                if (board.board[col + 1][row - 1] != null && board.colorOfSpot(row-1,col+1).equals(Color.black)) {
                    spotsToMove.add(new Position(row - 1, col + 1));
                }
            } else if (this.position.col == 0) {
                if (board.board[1][row - 1] != null && board.colorOfSpot(row-1,1).equals(Color.black)) {
                    spotsToMove.add(new Position(row - 1, 1));
                }
            } else if (this.position.col == 7) {
                if (board.board[6][row - 1] != null && board.colorOfSpot(row-1,6).equals(Color.black)) {
                    spotsToMove.add(new Position(row - 1, 6));
                }
            }
        }
        return spotsToMove;
    }
}
