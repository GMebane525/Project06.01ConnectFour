/**
 * This class initializes a Position object, creates its accessor methods (which allow you to return the Col and Row), and allow you to compare two position objects by using the equals method
 * @author 24scurria
 * @version 5/16/23
 */
public class Position {
    private int col;
    private int row;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean equals(Object other) {
        if(other instanceof Position) {
            Position temp = (Position)other;
            return this.row == temp.row && this.col == temp.col;
        }
        return false;
    }
}
