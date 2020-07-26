package alex;

public class Position {
    public int row;
    public int col;
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }
    @Override
    public boolean equals(Object other){
        if(other instanceof Position) {
            return (((Position) other).row == row && ((Position) other).col == col);
        }
        return false;
    }
    @Override
    public String toString(){
        String toPrint = "(row:"+this.row+", col:"+this.col+")";
        return toPrint;
    }
    @Override
    public int hashCode(){
        return (10*row)+col;
    }
}
