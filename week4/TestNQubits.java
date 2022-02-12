public class TestNQubits {
    
    public static void testNQubit(String[] args) {
        int numqubits;
        
        if (args.length < 2) {
            System.out.println("Too few arguments for "+
				"testSetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
            return;
        }

        numqubits = Integer.parseInt(args[1]);
        float[] expected = new float[(int) Math.pow(2, numqubits)];
        expected[0] = 1.0f;


        NQubit nq = new NQubit(numqubits);

        if (nq.getNumQubits() == numqubits && TestUtils.arrEquals1d(nq.getValues(), expected)) {
            System.out.println("NQubit constructor("+numqubits+"): Success");
            return;
        } else if (nq.getNumQubits() == numqubits) {
            System.out.println("NQubit constructor("+numqubits+"): FAIL");
            System.out.println("Expected intial values: "+TestUtils.arrToStr(expected));
            System.out.println("Actual intial values: "+TestUtils.arrToStr(nq.getValues()));
        } else if (TestUtils.arrEquals1d(nq.getValues(), expected)) {
            System.out.println("NQubit constructor("+numqubits+"): FAIL");
            System.out.println("Expected numqubits: "+numqubits);
            System.out.println("Actual numqubits: "+nq.getNumQubits());
        } else {
            System.out.println("NQubit constructor("+numqubits+"): FAIL");
            System.out.println("Expected intial values: "+TestUtils.arrToStr(expected)+" and numqubits: "+numqubits);
            System.out.println("Actual intial values: "+TestUtils.arrToStr(nq.getValues())+" and numqubits: "+nq.getNumQubits());
        }
    }

    public static void testToBraKet(String[] args) {
        int numqubits;
        float[] values;
        
        if (args.length < 3) {
            System.out.println("Too few arguments for "+
				"testSetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
            return;
        }

        numqubits = Integer.parseInt(args[1]);
        values = TestUtils.strToFloatArr1d(args[2]);

        NQubit nq = new NQubit(numqubits);
        nq.setValues(values);

        System.out.println(nq.toBraKet());
    }

    public static void testApplyNotGate(String[] args) {
        int numqubits;
        float[] values;
        float[] expected;
        
        if (args.length < 4) {
            System.out.println("Too few arguments for "+
				"testSetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
            return;
        }

        numqubits = Integer.parseInt(args[1]);
        values = TestUtils.strToFloatArr1d(args[2]);
        expected = TestUtils.strToFloatArr1d(args[3]);

        NQubit nq = new NQubit(numqubits);
        nq.setValues(values);

        if (args.length == 4) {
            nq.applyNotGate();

            if (TestUtils.arrEquals1d(nq.getValues(), expected)) {
                System.out.println("NQubit applyNotGate(): Success");
            } else {
                System.out.println("NQubit applyNotGate(): FAIL");
                System.out.println("Expected: "+TestUtils.arrToStr(expected));
                System.out.println("Actual: "+TestUtils.arrToStr(nq.getValues()));
            }
        } else {
            int qb = Integer.parseInt(args[4]);

            nq.applyNotGate(qb);

            if (TestUtils.arrEquals1d(nq.getValues(), expected)) {
                System.out.println("NQubit applyNotGate("+qb+"): Success");
            } else {
                System.out.println("NQubit applyNotGate("+qb+"): FAIL");
                System.out.println("Expected: "+TestUtils.arrToStr(expected));
                System.out.println("Actual: "+TestUtils.arrToStr(nq.getValues()));
            }
        }
    }

    public static void testApplyHGate(String[] args) {
        int numqubits;
        float[] values;
        float[] expected;
        
        if (args.length < 4) {
            System.out.println("Too few arguments for "+
				"testSetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
            return;
        }

        numqubits = Integer.parseInt(args[1]);
        values = TestUtils.strToFloatArr1d(args[2]);
        expected = TestUtils.strToFloatArr1d(args[3]);

        NQubit nq = new NQubit(numqubits);
        nq.setValues(values);

        if (args.length == 4) {
            nq.applyHGate();

            if (TestUtils.arrEquals1d(nq.getValues(), expected)) {
                System.out.println("NQubit applyHGate(): Success");
            } else {
                System.out.println("NQubit applyHGate(): FAIL");
                System.out.println("Expected: "+TestUtils.arrToStr(expected));
                System.out.println("Actual: "+TestUtils.arrToStr(nq.getValues()));
            }
        } else {
            int qb = Integer.parseInt(args[4]);

            nq.applyHGate(qb);

            if (TestUtils.arrEquals1d(nq.getValues(), expected)) {
                System.out.println("NQubit applyHGate("+qb+"): Success");
            } else {
                System.out.println("NQubit applyHGate("+qb+"): FAIL");
                System.out.println("Expected: "+TestUtils.arrToStr(expected));
                System.out.println("Actual: "+TestUtils.arrToStr(nq.getValues()));
            }
        }
    }

    public static void testApplySwapGate(String[] args) {
        int numqubits;
        float[] values;
        float[] expected;
        int qb1;
        int qb2;
        
        if (args.length < 6) {
            System.out.println("Too few arguments for "+
				"testSetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
            return;
        }

        numqubits = Integer.parseInt(args[1]);
        values = TestUtils.strToFloatArr1d(args[2]);
        expected = TestUtils.strToFloatArr1d(args[3]);
        qb1 = Integer.parseInt(args[4]);
        qb2 = Integer.parseInt(args[5]);

        NQubit nq = new NQubit(numqubits);
        nq.setValues(values);

        nq.applySwapGate(qb1, qb2);

        if (TestUtils.arrEquals1d(nq.getValues(), expected)) {
            System.out.println("NQubit applySwapGate("+qb1+", "+qb2+"): Success");
        } else {
            System.out.println("NQubit applySwapGate("+qb1+", "+qb2+"): FAIL");
            System.out.println("Expected: "+TestUtils.arrToStr(expected));
            System.out.println("Actual: "+TestUtils.arrToStr(nq.getValues()));
        }
    }

    public static void testSameEntangle(String[] args) {
        float[] values;
        float[] expected;

        if (args.length < 3) {
            System.out.println("Too few arguments for "+
				"testSetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
            return;
        }

        values = TestUtils.strToFloatArr1d(args[1]);
        expected = TestUtils.strToFloatArr1d(args[2]);

        DoubleQubit dq = new DoubleQubit();
        dq.setValues(values);
        
        QCircuit.sameEntangle(dq);

        if (TestUtils.arrEquals1d(dq.getValues(), expected)) {
            System.out.println("NQubit sameEntangle(): Success");
        } else {
            System.out.println("NQubit sameEntangle(): FAIL");
            System.out.println("Expected: "+TestUtils.arrToStr(expected));
            System.out.println("Actual: "+TestUtils.arrToStr(dq.getValues()));
        }
    }

    public static void testBernvaz(String[] args) {
        float[] expected;
        int code;

        if (args.length < 3) {
            System.out.println("Too few arguments for "+
				"testSetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
            return;
        }

        expected = TestUtils.strToFloatArr1d(args[1]);
        code = Integer.parseInt(args[2]);

        NQubit nq = new NQubit(4);
        nq.setValue(0.0f, 0);
        nq.setValue(1.0f, 1);

        QOracle bv = new QOracle();
        bv.setBernVaz(code);

        QCircuit.bernvaz(nq, bv);

        if (TestUtils.arrEquals1d(nq.getValues(), expected)) {
            System.out.println("NQubit bernvaz("+code+"): Success");
        } else {
            System.out.println("NQubit bernvaz("+code+"): FAIL");
            System.out.println("Expected: "+TestUtils.arrToStr(expected));
            System.out.println("Actual: "+TestUtils.arrToStr(nq.getValues()));
        }
    }

    public static void testArchimedes(String[] args) {
        float[] expected;
        int[] codes;

        if (args.length < 3) {
            System.out.println("Too few arguments for "+
				"testSetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
            return;
        }

        expected = TestUtils.strToFloatArr1d(args[1]);
        codes = TestUtils.strToIntArr1d(args[2]);

        NQubit nq = new NQubit(4);
        nq.setValue(0.0f, 0);
        nq.setValue(1.0f, 1);

        QOracle a = new QOracle();
        a.setArchimedes(codes);

        QCircuit.archimedes(nq, a);

        if (TestUtils.arrEquals1d(nq.getValues(), expected)) {
            System.out.println("NQubit archimedes("+TestUtils.arrToStr(codes)+"): Success");
        } else {
            System.out.println("NQubit archimedes("+TestUtils.arrToStr(codes)+"): FAIL");
            System.out.println("Expected: "+TestUtils.arrToStr(expected));
            System.out.println("Actual: "+TestUtils.arrToStr(nq.getValues()));
        }
    }

    public static void main(String[] args) {
        int testNumber;

        testNumber = Integer.parseInt(args[0]);

        // use the testnumber to choose a test function
        switch (testNumber) {
            case(0):
                testNQubit(args);
                break;
            case(1):
                testToBraKet(args);
                break;
            case(2):
                testApplyNotGate(args);
                break;
            case(3):
                testApplyHGate(args);
                break;
            case(4):
                testApplySwapGate(args);
                break;
            case(5):
                testSameEntangle(args);
                break;
            case(6):
                testBernvaz(args);
                break;
            case(7):
                testArchimedes(args);
                break;
            default:
                System.out.println("Test " + testNumber + " not supported");
        }
    }
}