package model;

import utils.Util;

import java.util.Objects;

public class BucketFill implements Entity {

    private int  x;
    private int  y;
    private char character;

    public BucketFill(int x, int y, char character) {
        Util.checkValuesArePositive(x, y);
        this.x = x;
        this.y = y;
        this.character = character;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BucketFill that = (BucketFill) o;
        return x == that.x && y == that.y && character == that.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, character);
    }
}
