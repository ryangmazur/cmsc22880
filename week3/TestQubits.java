public class TestQubits {

    public static boolean arrEquals1d(float[] arr1, float[] arr2) {
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

    public static boolean  arrEquals2d(float[][] arr1, float[][] arr2) {
        if (arr1.length != arr2.length || arr1[0].length != arr2[0].length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != arr2[i][j]) {
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
        float[] toReturn = new float[str.length()];

        String subStr = "";
        int pos = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                toReturn[pos] = Float.parseFloat(subStr);
                pos++;
            } else {
                subStr = subStr + str.charAt(i);
            }
        }

        return toReturn;
    }

    public static int testParentQubit() {
        
        return -1;
    }

    public static int testSetValue(String[] args) {
        float val;
        int pos;

        if (args.length < 3) {
            System.out.println("Too few arguments for "+
				"testSetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        val = Float.parseFloat(args[1]);
        pos = Integer.parseInt(args[2]);

        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        if (pos < 2) {
            sq.setValue(val, pos);
        }
        dq.setValue(val, pos);

        int toReturn = 0;


        if (pos < 2 && sq.getValue(pos) == val) {
            System.out.println("SingleQubit setValue("+val+", "+pos+"): Success!");
            toReturn += 1;
        } else if (pos < 2) {
            System.out.println("SingleQubit setValue("+val+", "+pos+"): FAIL!");
            System.out.println("Expected: "+val);
            System.out.println("Actual: "+sq.getValue(pos));
        }

        if (dq.getValue(pos) == val) {
            System.out.println("DoubleQubit setValue("+val+", "+pos+"): Success!");
            toReturn += 1;
        } else {
            System.out.println("DoubleQubit setValue("+val+", "+pos+"): FAIL!");
            System.out.println("Expected: "+val);
            System.out.println("Actual: "+dq.getValue(pos));
        }
        return toReturn;
    }

    public static int testSetValues(String[] args) {
        float[] values;
        
        if (args.length < 2) {
            System.out.println("Too few arguments for "+
				"testSetValues: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        values = strToFloatArr1d(args[1]);

        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        if (values.length < 3) {
            sq.setValues(values);
        } else {
            dq.setValues(values);
        }


        int toReturn = 0;
        if (values.length == 2 || arrEquals1d(sq.getValues(), values)) {
            System.out.println("SingleQubit setValues("+arrToStr(sq.getValues())+"): Success!");
            toReturn += 1;
        } else if (values.length == 2){
            System.out.println("SingleQubit setValues("+arrToStr(sq.getValues())+"): FAIL!");
            System.out.println("Expected: "+arrToStr(values));
            System.out.println("Actual: "+arrToStr(sq.getValues()));
        }

        if (values.length == 4 || arrEquals1d(dq.getValues(), values)) {
            System.out.println("DoubleQubit setValues("+arrToStr(dq.getValues())+"): Success!");
            toReturn += 1;
        } else if (values.length == 4){
            System.out.println("DoubleQubit setValues("+arrToStr(dq.getValues())+"): FAIL!");
            System.out.println("Expected: "+arrToStr(values));
            System.out.println("Actual: "+arrToStr(dq.getValues()));
        }
        return toReturn;
    }

    public static int testGetValue(String[] args) {
        float[] values;
        int pos;

        if (args.length < 3) {
            System.out.println("Too few arguments for "+
				"testGetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        values = strToFloatArr1d(args[1]);
        pos = Integer.parseInt(args[2]);

        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        if (values.length < 3) {
            sq.setValues(values);
        } else {
            dq.setValues(values);
        }

        int toReturn = 0;
        if (values.length == 2 || sq.getValue(pos) == values[pos]) {
            System.out.println("SingleQubit getValue("+arrToStr(values)+", "+pos+"): Success!");
            toReturn += 1;
        } else if (values.length == 2){
            System.out.println("SingleQubit getValue("+arrToStr(values)+", "+pos+"): FAIL!");
            System.out.println("Expected: "+values[pos]);
            System.out.println("Actual: "+sq.getValue(pos));
        }

        if (values.length == 4 || dq.getValue(pos) == values[pos]) {
            System.out.println("DoubleQubit getValue("+arrToStr(values)+", "+pos+"): Success!");
            toReturn += 1;
        } else if (values.length == 4){
            System.out.println("DoubleQubit getValue("+arrToStr(values)+", "+pos+"): FAIL!");
            System.out.println("Expected: "+values[pos]);
            System.out.println("Actual: "+dq.getValue(pos));
        }
        return toReturn;
    }

    public static int testGetValues(String[] args) {
        float[] values;
        float[] returnedValues;
        
        if (args.length < 2) {
            System.out.println("Too few arguments for "+
				"TeststringConstructor: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        values = strToFloatArr1d(args[1]);

        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        if (values.length < 3) {
            sq.setValues(values);
            returnedValues = sq.getValues();

        } else {
            dq.setValues(values);
            returnedValues = dq.getValues();
        }

        
        int toReturn = 0;
        if (values.length == 2 || arrEquals1d(returnedValues, values)) {
            System.out.println("SingleQubit getValues("+arrToStr(values)+"): Success!");
            toReturn += 1;
        } else if (values.length == 2){
            System.out.println("SingleQubit getValues("+arrToStr(values)+"): FAIL!");
            System.out.println("Expected: "+arrToStr(values));
            System.out.println("Actual: "+arrToStr(returnedValues));
        }

        if (values.length == 4 || arrEquals1d(returnedValues, values)) {
            System.out.println("DoubleQubit getValues("+arrToStr(values)+"): Success!");
            toReturn += 1;
        } else if (values.length == 4){
            System.out.println("DoubleQubit getValues("+arrToStr(values)+"): FAIL!");
            System.out.println("Expected: "+arrToStr(values));
            System.out.println("Actual: "+arrToStr(returnedValues));
        }
        return toReturn;
    }

    public static int testSetPhase(String[] args) {
        float[] values;
        int pos;
        int expectedPhase;
        int phase;


        if (args.length < 4) {
            System.out.println("Too few arguments for "+
				"testGetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        values = strToFloatArr1d(args[1]);
        pos = Integer.parseInt(args[2]);
        expectedPhase = Integer.parseInt(args[3]);

        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        if (values.length < 3) {
            sq.setValues(values);
            sq.setPhase(expectedPhase, pos);
        } else {
            dq.setValues(values);
            sq.setPhase(expectedPhase, pos);
        }

        int toReturn = 0;
        if (values.length == 2 || sq.getValue(pos) == values[pos]) {
            System.out.println("SingleQubit getValue("+arrToStr(values)+", "+pos+"): Success!");
            toReturn += 1;
        } else if (values.length == 2){
            System.out.println("SingleQubit getValue("+arrToStr(values)+", "+pos+"): FAIL!");
            System.out.println("Expected: "+values[pos]);
            System.out.println("Actual: "+sq.getValue(pos));
        }

        if (values.length == 4 || dq.getValue(pos) == values[pos]) {
            System.out.println("DoubleQubit getValue("+arrToStr(values)+", "+pos+"): Success!");
            toReturn += 1;
        } else if (values.length == 4){
            System.out.println("DoubleQubit getValue("+arrToStr(values)+", "+pos+"): FAIL!");
            System.out.println("Expected: "+values[pos]);
            System.out.println("Actual: "+dq.getValue(pos));
        }
        return toReturn;
    }

    public static int testSetPhases(String[] args) {

        return -1;
    }

    public static int testGetPhase(String[] args) {
        return -1;
    }

    public static int testGetNumQubits(String[] args) {
        return -1;
    }

    public static int testDoubleQubit() {
        return -1;
    }

    public static int testMergeQubits(String[] args) {
        return -1;
    }

    public static int  testToBraKet(String[] args) {
        return -1;
    }

    public static int testApplyNotGate(String[] args) {
        return -1;
    }

    public static int testApplyHGate(String[] args) {
        return -1;
    }

    public static int testApplySwapGate(String[] args) {
        return -1;
    }

    public static int testSingleQubit() {
        return -1;
    }

    public static void main(String[] args) {
        int testNumber;

        testNumber = Integer.parseInt(args[0]);

        // use the testnumber to choose a test function
        switch (testNumber) {
            case(0):
                // test ParentQubit Construcor
                // visually check
                testParentQubit();
                break;
            case(1):
                // test setValue
                testSetValue(args);
                break;
            case(2):
                // test setValues
                testSetValues(args);
                break;
            case(3):
                testGetValue(args);
                break;
            case(4):
                testGetValues(args);
                break;
            case(5):
                testSetPhase(args);
                break;
            case(6):
                testSetPhases(args);
                break;
            case(7):
                testGetPhase(args);
                break;
            case(8):
                testGetNumQubits(args);
                break;
            case(9):
                // visually check
                testDoubleQubit();
                break;
            case(10):
                testMergeQubits(args);
                break;
            case(11):
                // visually check
                testToBraKet(args);
                break;
            case(12):
                testApplyNotGate(args);
                break;
            case(13):
                testApplyHGate(args);
                break;
            case(14):
                testApplySwapGate(args);
                break;
            case(15):
                // visually check
                testSingleQubit();
                break;

            default:
                System.out.println("Test " + testNumber + " not supported");
        }
    }
}
