package utils;

public class Util {

    public static int positiveValue(String value) {
        int i = Integer.parseInt(value);
        if(i <= 0) {
            throw new IllegalArgumentException();
        }
        return i;
    }
}
