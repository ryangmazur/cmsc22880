public class TestQubits {
    
    public static int testParentQubit() {
        return -1;
    }

    public static int testSetValue(String[] args) {
        return -1;
    }

    public static int testSetValues(String[] args) {
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
