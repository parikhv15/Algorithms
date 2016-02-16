package ArraysAndStrings;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Created by vrajp on 2/12/2016.
 */
public class LangtonsAnt {

    public static void main (String[] a) {
        LangtonsAnt la = new LangtonsAnt();


    }
}

class Grid {
    private boolean[][] grid;

    Ant ant = new Ant();

    public Grid() {
        grid = new boolean[1][1];
    }
}

class Ant {
    Position position = new Position(0, 0);
    Orientation orientation = Orientation.right;

    public void turn(boolean clockwise) {
        orientation = orientation.getTurn(clockwise);
    }

    public void move() {
        if (orientation == Orientation.right)
            position.setColumn(position.getColumn()+1);
        else if (orientation == Orientation.left)
            position.setColumn(position.getColumn()-1);
        else if (orientation == Orientation.up)
            position.setRow(position.getRow()+1);
        else
            position.setRow(position.getRow()-1);
    }

    public void adjustPosition(int shiftRow, int shiftColumn) {
        position.setColumn(shiftColumn + position.getColumn());
        position.setRow(shiftRow + position.getRow());
    }
}

class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

enum Orientation {
    left, right, up, down;

    public Orientation getTurn(boolean clockwise) {
        if (this == left)
            return clockwise ? up : down;
        else if (this == right)
            return clockwise ? down : up;
        else if (this == up)
            return clockwise ? right : left;
        else
            return clockwise ? left : right;
    }
}
