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

    }

    public static void testApplyNotGate(String[] args) {

    }

    public static void testApplyHGate(String[] args) {

    }

    public static void testApplySwapGate(String[] args) {

    }

    public static void testSameEntangle(String[] args) {

    }

    public static void testBernvaz(String[] args) {

    }

    public static void testArchimedes(String[] args) {

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