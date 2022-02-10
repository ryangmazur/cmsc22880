public class TestUtils {
    public static boolean arrEquals1d(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean arrEquals1d(float[] arr1, float[] arr2) {
        final float EPSILON = .0001f;
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (Math.abs(arr1[i] - arr2[i]) > EPSILON) {
                return false;
            }
        }

        return true;
    }

    public static boolean arrEquals2d(float[][] arr1, float[][] arr2) {
        final float EPSILON = .0001f;
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (Math.abs(arr1[i][j] - arr2[i][j]) > EPSILON) {
                    return false;
                }
            }
        }

        return true;
    }

    public static String arrToStr(float[][] arr) {
        String toReturn = "";
        for (int i = 0; i < arr.length; i++) {
            toReturn = toReturn + arrToStr(arr[i]) + "\n";
        }
        return toReturn;
    }

    public static String arrToStr(float[] arr) {
        String toReturn = "";
        for (int i = 0; i < arr.length; i++) {
            toReturn = toReturn + arr[i] + ", ";
        }
        return toReturn.substring(0, toReturn.length() - 2);
    }

    public static String arrToStr(int[] arr) {
        String toReturn = "";
        for (int i = 0; i < arr.length; i++) {
            toReturn = toReturn + arr[i] + ", ";
        }
        return toReturn.substring(0, toReturn.length() - 2);
    }

    public static float[][] fillRow(float[][] arr, float[] subArr, int row) {
        for (int i = 0; i < subArr.length; i++) {
            arr[row][i] = subArr[i];
        }
        return arr;
    }
    
    public static float[][] strToFloatArr2d(String str) {
        int rows = 0;
        int cols = 0;
        int numCommas = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                numCommas++;
            } else if (str.charAt(i) == ';') {
                rows++;
                if (cols == 0) {
                    cols = numCommas + 1;
                }
            }
        }

        rows++;
        float[][] toReturn = new float[rows][cols];
        String subStr = "";
        int i = 0;
        int currRow = 0;
        while(i < str.length()) {
            if (str.charAt(i) == ';') {
                toReturn = fillRow(toReturn, strToFloatArr1d(subStr), currRow);
                subStr = "";
                currRow++;
            } else {
                subStr = subStr + str.charAt(i);
            }
            i++;
        }

        return toReturn;
    }

    public static float[] strToFloatArr1d(String str) {
        int numCommas = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                numCommas++;
            }
        }
        numCommas++;
        float[] toReturn = new float[numCommas];

        String subStr = "";
        int pos = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                toReturn[pos] = Float.parseFloat(subStr);
                subStr = "";
                pos++;
            } else {
                subStr = subStr + str.charAt(i);
            }
        }
        toReturn[pos] = Float.parseFloat(subStr);
        return toReturn;
    }

    public static int[][] fillRow(int[][] arr, int[] subArr, int row) {
        for (int i = 0; i < subArr.length; i++) {
            arr[row][i] = subArr[i];
        }
        return arr;
    }
    
    public static int[][] strToIntArr2d(String str) {
        int rows = 0;
        int cols = 0;
        int numCommas = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                numCommas++;
            } else if (str.charAt(i) == ';') {
                rows++;
                if (cols == 0) {
                    cols = numCommas + 1;
                }
            }
        }

        rows++;
        int[][] toReturn = new int[rows][cols];
        String subStr = "";
        int i = 0;
        int currRow = 0;
        while(i < str.length()) {
            if (str.charAt(i) == ';') {
                toReturn = fillRow(toReturn, strToIntArr1d(subStr), currRow);
                subStr = "";
                currRow++;
            } else {
                subStr = subStr + str.charAt(i);
            }
            i++;
        }

        return toReturn;
    }

    public static int[] strToIntArr1d(String str) {
        int numCommas = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                numCommas++;
            }
        }
        numCommas++;
        int[] toReturn = new int[numCommas];

        String subStr = "";
        int pos = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                toReturn[pos] = Integer.parseInt(subStr);
                subStr = "";
                pos++;
            } else {
                subStr = subStr + str.charAt(i);
            }
        }
        toReturn[pos] = Integer.parseInt(subStr);
        return toReturn;
    }
}
