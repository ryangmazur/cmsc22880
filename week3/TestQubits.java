public class TestQubits {

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

    public static int[] strToIntArr(String str) {
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
        if (values.length == 2 && arrEquals1d(sq.getValues(), values)) {
            System.out.println("SingleQubit setValues("+arrToStr(sq.getValues())+"): Success!");
            toReturn += 1;
        } else if (values.length == 2){
            System.out.println("SingleQubit setValues("+arrToStr(values)+"): FAIL!");
            System.out.println("Expected: "+arrToStr(values));
            System.out.println("Actual: "+arrToStr(sq.getValues()));
        }

        if (values.length == 4 && arrEquals1d(dq.getValues(), values)) {
            System.out.println("DoubleQubit setValues("+arrToStr(dq.getValues())+"): Success!");
            toReturn += 1;
        } else if (values.length == 4){
            System.out.println("DoubleQubit setValues("+arrToStr(values)+"): FAIL!");
            System.out.println("Expected: "+arrToStr(values));
            System.out.println("Actual: "+arrToStr(dq.getValues()));
        }
        return toReturn;
    }

    public static int testGetValue(String[] args) {
        final float EPSILON = .0001f;
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
        if (values.length == 2 && Math.abs(sq.getValue(pos) - values[pos]) < EPSILON) {
            System.out.println("SingleQubit getValue("+arrToStr(values)+", "+pos+"): Success!");
            toReturn += 1;
        } else if (values.length == 2){
            System.out.println("SingleQubit getValue("+arrToStr(values)+", "+pos+"): FAIL!");
            System.out.println("Expected: "+values[pos]);
            System.out.println("Actual: "+sq.getValue(pos));
        }

        if (values.length == 4 && dq.getValue(pos) == values[pos]) {
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
				"testGetValues: " +args.length);
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
        if (values.length == 2 && arrEquals1d(returnedValues, values)) {
            System.out.println("SingleQubit getValues("+arrToStr(values)+"): Success!");
            toReturn += 1;
        } else if (values.length == 2){
            System.out.println("SingleQubit getValues("+arrToStr(values)+"): FAIL!");
            System.out.println("Expected: "+arrToStr(values));
            System.out.println("Actual: "+arrToStr(returnedValues));
        }

        if (values.length == 4 && arrEquals1d(returnedValues, values)) {
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
				"testSetPhase: " +args.length);
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
            phase = sq.getPhase(pos);
        } else {
            dq.setValues(values);
            dq.setPhase(expectedPhase, pos);
            phase = dq.getPhase(pos);
        }

        int toReturn = 0;
        if (values.length == 2 && phase == expectedPhase) {
            System.out.println("SingleQubit setPhase("+pos+"): Success!");
            toReturn += 1;
        } else if (values.length == 2){
            System.out.println("SingleQubit setPhase("+pos+"): FAIL!");
            System.out.println("Expected: "+expectedPhase);
            System.out.println("Actual: "+phase);
        }

        if (values.length == 4 && phase == expectedPhase) {
            System.out.println("DoubleQubit getValue("+pos+"): Success!");
            toReturn += 1;
        } else if (values.length == 4){
            System.out.println("DoubleQubit setPhase("+pos+"): FAIL!");
            System.out.println("Expected: "+expectedPhase);
            System.out.println("Actual: "+phase);
        }
        return toReturn;
    }

    public static int testSetPhases(String[] args) {
        float[] values;
        int[] phases;
        
        if (args.length < 3) {
            System.out.println("Too few arguments for "+
				"testSetValues: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        values = strToFloatArr1d(args[1]);
        phases = strToIntArr(args[2]);

        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        int[] returnPhases = new int[values.length];

        if (values.length < 3) {
            sq.setValues(values);
            sq.setPhases(phases);
            for (int i = 0; i < values.length; i++) {
                returnPhases[i] = sq.getPhase(i);
            }
        } else {
            dq.setValues(values);
            dq.setPhases(phases);
            for (int i = 0; i < values.length; i++) {
                returnPhases[i] = dq.getPhase(i);
            }
        }

        int toReturn = 0;
        if (values.length == 2 && arrEquals1d(returnPhases, phases)) {
            System.out.println("SingleQubit setPhases("+arrToStr(values)+", "+arrToStr(phases)+"): Success!");
            toReturn += 1;
        } else if (values.length == 2){
            System.out.println("SingleQubit setPhases("+arrToStr(values)+", "+arrToStr(phases)+"): FAIL!");
            System.out.println("Expected: "+arrToStr(phases));
            System.out.println("Actual: "+arrToStr(returnPhases));
        }

        if (values.length == 4 && arrEquals1d(returnPhases, phases)) {
            System.out.println("DoubleQubit setValues("+arrToStr(values)+", "+arrToStr(phases)+"): Success!");
            toReturn += 1;
        } else if (values.length == 4){
            System.out.println("DoubleQubit setValues("+arrToStr(values)+", "+arrToStr(phases)+"): FAIL!");
            System.out.println("Expected: "+arrToStr(phases));
            System.out.println("Actual: "+arrToStr(returnPhases));
        }
        return toReturn;
    }

    public static int testGetPhase(String[] args) {
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
        int expectedPhase = (int) Math.signum(values[pos]);
        if (values[pos] == 0) {
            expectedPhase = 1;
        }

        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        if (values.length < 3) {
            sq.setValues(values);
        } else {
            dq.setValues(values);
        }

        int toReturn = 0;
        if (values.length == 2 && sq.getPhase(pos) == expectedPhase) {
            System.out.println("SingleQubit getPhase("+arrToStr(values)+", "+pos+"): Success!");
            toReturn += 1;
        } else if (values.length == 2){
            System.out.println("SingleQubit getPhase("+arrToStr(values)+", "+pos+"): FAIL!");
            System.out.println("Expected: "+expectedPhase);
            System.out.println("Actual: "+sq.getPhase(pos));
        }

        if (values.length == 4 && dq.getPhase(pos) == expectedPhase) {
            System.out.println("DoubleQubit getPhase("+arrToStr(values)+", "+pos+"): Success!");
            toReturn += 1;
        } else if (values.length == 4){
            System.out.println("DoubleQubit getPhase("+arrToStr(values)+", "+pos+"): FAIL!");
            System.out.println("Expected: "+expectedPhase);
            System.out.println("Actual: "+dq.getPhase(pos));
        }
        return toReturn;
    }

    public static int testGetNumQubits() {
        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        int toReturn = 0;
        if (sq.getNumQubits() == 1) {
            System.out.println("SingleQubit getNumQubits(): Success!");
            toReturn += 1;
        } else {
            System.out.println("SingleQubit getPhase(): FAIL!");
            System.out.println("Expected: 1");
            System.out.println("Actual: "+sq.getNumQubits());
        }

        if (dq.getNumQubits() == 2) {
            System.out.println("DoubleQubit getNumQubits(): Success!");
            toReturn += 1;
        } else {
            System.out.println("DoubleQubit getPhase(): FAIL!");
            System.out.println("Expected: 2");
            System.out.println("Actual: "+dq.getNumQubits());
        }
        return toReturn;
    }

    public static int testDoubleQubit() {
        DoubleQubit dq = new DoubleQubit();

        float[] check = new float[]{1f, 0f, 0f, 0f};

        if (dq.getNumQubits() == 2 && arrEquals1d(dq.getValues(), check)) {
            System.out.println("DoubleQubit Consutrctor: Success!");
            return 1;
        } else {
            System.out.println("DoubleQubit Constructor: FAIL!");
            return 0;
        }
    }

    public static int testMergeQubits(String[] args) {
        float[] vals1;
        float[] vals2;
        float[] expected;

        if (args.length < 4) {
            System.out.println("Too few arguments for "+
				"testSetValues: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        vals1 = strToFloatArr1d(args[1]);
        vals2 = strToFloatArr1d(args[2]);
        expected = strToFloatArr1d(args[3]);

        SingleQubit sq1 = new SingleQubit();
        SingleQubit sq2 = new SingleQubit();

        sq1.setValues(vals1);
        sq2.setValues(vals2);

        DoubleQubit dq = sq1.mergeQubits(sq2);

        if (arrEquals1d(dq.getValues(), expected)) {
            System.out.println("SingleQubit mergeQubits: Success!");
            return 1;
        } else {
            System.out.println("SingleQubit mergeQubits: FAIL!");
            System.out.println("Expected: "+arrToStr(expected));
            System.out.println("Actual: "+arrToStr(dq.getValues()));
            return 0;
        }
    }

    public static int  testToBraKet(String[] args) {
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
            System.out.println(sq.toBraKet());
        } else {
            dq.setValues(values);
            System.out.println(dq.toBraKet());
        }

        return 1;
    }

    public static int testApplyNotGate(String[] args) {
        float[] values;
        float[] expected;
        int pos = 0;

        if (args.length < 3) {
            System.out.println("Too few arguments for "+
				"testGetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        values = strToFloatArr1d(args[1]);
        expected = strToFloatArr1d(args[2]);
        if (args.length == 4) {
            pos = Integer.parseInt(args[3]);
        }

        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        if (values.length < 3) {
            sq.setValues(values);
        } else {
            dq.setValues(values);
        }

        if (args.length == 3) {
            int toReturn = 0;
            sq.applyNotGate();
            dq.applyNotGate();
            if (values.length == 2 && arrEquals1d(sq.getValues(), expected)) {
                System.out.println("SingleQubit applyNotGate(): Success!");
                toReturn += 1;
            } else if (values.length == 2){
                System.out.println("SingleQubit applyNotGate(): FAIL!");
                System.out.println("Expected: "+arrToStr(expected));
                System.out.println("Actual: "+arrToStr(sq.getValues()));
            }
    
            if (values.length == 4 && arrEquals1d(dq.getValues(), expected)) {
                System.out.println("DoubleQubit applyNotGate(): Success!");
                toReturn += 1;
            } else if (values.length == 4){
                System.out.println("DoubleQubit applyNotGate(): FAIL!");
                System.out.println("Expected: "+arrToStr(expected));
                System.out.println("Actual: "+arrToStr(dq.getValues()));
            }
            return toReturn;
        } else {
            int toReturn = 0;
            sq.applyNotGate(pos);
            dq.applyNotGate(pos);
            if (values.length == 2 && arrEquals1d(sq.getValues(), expected)) {
                System.out.println("SingleQubit applyNotGate("+pos+"): Success!");
                toReturn += 1;
            } else if (values.length == 2){
                System.out.println("SingleQubit applyNotGate("+pos+"): FAIL!");
                System.out.println("Expected: "+arrToStr(expected));
                System.out.println("Actual: "+arrToStr(sq.getValues()));
            }
    
            if (values.length == 4 && arrEquals1d(dq.getValues(), expected)) {
                System.out.println("DoubleQubit applyNotGate("+pos+"): Success!");
                toReturn += 1;
            } else if (values.length == 4){
                System.out.println("DoubleQubit applyNotGate("+pos+"): FAIL!");
                System.out.println("Expected: "+arrToStr(expected));
                System.out.println("Actual: "+arrToStr(dq.getValues()));
            }
            return toReturn;
        }
    }

    public static int testApplyHGate(String[] args) {
        float[] values;
        float[] expected;
        int pos = 0;

        if (args.length < 3) {
            System.out.println("Too few arguments for "+
				"testGetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        values = strToFloatArr1d(args[1]);
        expected = strToFloatArr1d(args[2]);
        if (args.length == 4) {
            pos = Integer.parseInt(args[3]);
        }

        SingleQubit sq = new SingleQubit();
        DoubleQubit dq = new DoubleQubit();

        if (values.length < 3) {
            sq.setValues(values);
        } else {
            dq.setValues(values);
        }

        if (args.length == 3) {
            int toReturn = 0;
            sq.applyHGate();
            dq.applyHGate();
            if (values.length == 2 && arrEquals1d(sq.getValues(), expected)) {
                System.out.println("SingleQubit applyHGate(): Success!");
                toReturn += 1;
            } else if (values.length == 2){
                System.out.println("SingleQubit applyHGate(): FAIL!");
                System.out.println("Expected: "+arrToStr(expected));
                System.out.println("Actual: "+arrToStr(sq.getValues()));
            }
    
            if (values.length == 4 && arrEquals1d(dq.getValues(), expected)) {
                System.out.println("DoubleQubit applyHGate(): Success!");
                toReturn += 1;
            } else if (values.length == 4){
                System.out.println("DoubleQubit applyHGate(): FAIL!");
                System.out.println("Expected: "+arrToStr(expected));
                System.out.println("Actual: "+arrToStr(dq.getValues()));
            }
            return toReturn;
        } else {
            int toReturn = 0;
            sq.applyHGate(pos);
            dq.applyHGate(pos);
            if (values.length == 2 && arrEquals1d(sq.getValues(), expected)) {
                System.out.println("SingleQubit applyHGate("+pos+"): Success!");
                toReturn += 1;
            } else if (values.length == 2){
                System.out.println("SingleQubit applyHGate("+pos+"): FAIL!");
                System.out.println("Expected: "+arrToStr(expected));
                System.out.println("Actual: "+arrToStr(sq.getValues()));
            }
    
            if (values.length == 4 && arrEquals1d(dq.getValues(), expected)) {
                System.out.println("DoubleQubit applyHGate("+pos+"): Success!");
                toReturn += 1;
            } else if (values.length == 4){
                System.out.println("DoubleQubit applyHGate("+pos+"): FAIL!");
                System.out.println("Expected: "+arrToStr(expected));
                System.out.println("Actual: "+arrToStr(dq.getValues()));
            }
            return toReturn;
        }
    }

    public static int testApplySwapGate(String[] args) {
        float[] values;
        float[] expected;

        if (args.length < 3) {
            System.out.println("Too few arguments for "+
				"testGetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        values = strToFloatArr1d(args[1]);
        expected = strToFloatArr1d(args[2]);

        DoubleQubit dq = new DoubleQubit();
        dq.setValues(values);
        dq.applySwapGate(0, 1);

        if (arrEquals1d(dq.getValues(), expected)) {
            System.out.println("DoubleQubit applySwapGate("+arrToStr(values)+"): Success!");
            return 1;
        } else {
            System.out.println("DoubleQubit applySwapGate("+arrToStr(values)+"): FAIL!");
            System.out.println("Expected: "+arrToStr(expected));
            System.out.println("Actual: "+arrToStr(dq.getValues()));
            return 0;
        }
    }

    public static int testSingleQubit() {
        SingleQubit sq = new SingleQubit();

        float[] check = new float[]{1f, 0f};

        if (sq.getNumQubits() == 1 && arrEquals1d(sq.getValues(), check)) {
            System.out.println("SingleQubit Consutrctor: Success!");
            return 1;
        } else {
            System.out.println("SingleQubit Constructor: FAIL!");
            return 0;
        }
    }

    public static void main(String[] args) {
        int testNumber;

        testNumber = Integer.parseInt(args[0]);

        // use the testnumber to choose a test function
        switch (testNumber) {
            case(0):
                // not actually using this one
                testParentQubit();
                break;
            case(1):
                testSetValue(args);
                break;
            case(2):
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
                testGetNumQubits();
                break;
            case(9):
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
                testSingleQubit();
                break;

            default:
                System.out.println("Test " + testNumber + " not supported");
        }
    }
}
