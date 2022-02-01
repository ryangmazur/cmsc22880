public class TestQubits {

    public static void printArr(float[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            printArr(arr[i]);
            System.out.println('\n');
        }
    }

    public static void printArr(float[] arr) {
        String toPrint = "";
        for (int i = 0; i < arr.length; i++) {
            toPrint = toPrint + arr[i] + ", ";
        }
        toPrint = toPrint.substring(0, toPrint.length() - 2);
        System.out.println(toPrint);
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
        float expected;

        if (args.length < 4) {
            System.out.println("Too few arguments for "+
				"TeststringConstructor: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        val = Float.parseFloat(args[1]);
        pos = Integer.parseInt(args[2]);
        expected = Float.parseFloat(args[3]);

        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        if (pos < 2) {
            sq.setValue(val, pos);
        }
        dq.setValue(val, pos);

        int toReturn = 0;


        if (pos > 1 || sq.getValue(pos) == expected) {
            System.out.println("SingleQubit setValue("+val+", "+pos+"): Success!");
            toReturn += 1;
        } else {
            System.out.println("SingleQubit setPhase("+val+", "+pos+"): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+sq.getValue(pos));
        }

        if (sq.getValue(pos) == expected) {
            System.out.println("DoubleQubit setValue("+val+", "+pos+"): Success!");
            toReturn += 1;
        } else {
            System.out.println("DoubleQubit setPhase("+val+", "+pos+"): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+sq.getValue(pos));
        }
        return toReturn;
    }

    public static int testSetValues(String[] args) {
        float[] values;
        
        if (args.length < 2) {
            System.out.println("Too few arguments for "+
				"TeststringConstructor: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        

        return -1;
    }

    public static int testGetValue(String[] args) {
        return -1;
    }

    public static int testGetValues(String[] args) {
        return -1;
    }

    public static int testSetPhase(String[] args) {
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
                testSetPhase(args);
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
