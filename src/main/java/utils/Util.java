package utils;

import java.util.Arrays;

public class Util {

    public static int positiveValue(String value) {
        int i = Integer.parseInt(value);
        if(i <= 0) {
            throw new IllegalArgumentException();
        }
        return i;
    }

    public static void checkValuesArePositive(int... params) {
        Arrays.stream(params)
                .forEach(
                        param -> {
                            if(param < 0) {
                                throw new IllegalArgumentException("Number must be greater than 0, the param value is ");
                            }
                        }
                );
    }
}
