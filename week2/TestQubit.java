
public class TestQubit
{
    public static int TeststringConstructor (Qubit expected, String[] args) {
        String val;
        // make sure the degrees input is there
        if (args.length < 4) {
            System.out.println("Too few arguments for "+
				"TeststringConstructor: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        // read the command-line argument
        val = args[3];
        // perform the opertation
        Qubit test = new Qubit(val);

        // check the result and report
        if (Qubit.compare(test, expected) == 0) {
            System.out.println("Qubit stringConstructor(" + val + "): Success!");
            return 1;
        } else {
            System.out.println("Qubit stringConstructor(" + val + "): FAIL!");
            System.out.println("Expected: "+ expected);
            System.out.println("Actual: "+ test);
            return 0;
        }
    }

	/* TestsetValue
	 * receives user input for testing one call of setValue
	 * on a Qubit with a float input
	 *
	 * inputs:
	 *  Qubit start - the starting state of a sprite to test on
	 *  Qubit expected - the expected end state of the sprite
	 *  string[] args - it contains {"float"}
	 * outputs:
 	 *  returns 1 for success, 0 for failure
	 *  also prints results to the console
	 */
	public static int TestsetValueFloat (Qubit start, Qubit expected, 
						String[] args)
	{
		float val;
		// make sure the degrees input is there
		if (args.length < 4)	
		{
			System.out.println("Too few arguments for "+
				"TestsetValueFloat: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

		// read the command-line argument
		val = Float.parseFloat(args[3]);
		// perform the operation
		start.setValue(val);

		// check the result and report
		if (Qubit.compare(start, expected) == 0)
		{
			System.out.println("Qubit setValue("+val+
						"): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit setValue("+val+
				"): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
	}

    public static int TestsetValueString (Qubit start, Qubit expected, String[] args) {
        String val;
        // make sure the degrees input is there
        if (args.length < 4) {
            System.out.println("Too few arguments for "+
				"TestsetValueString: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
        }

        // read the command-line argument
        val = args[3];
        // perform operation
        start.setValue(val);

        // check the result and report
        if (Qubit.compare(start, expected) == 0)
		{
			System.out.println("Qubit setValue("+val+
						"): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit setValue("+val+
				"): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
    }

    public static int TestgetValue (Qubit start, String[] args) {
        float val, expectedVal;
        // make sure the degrees input is there
        if (args.length < 4)	
		{
			System.out.println("Too few arguments for "+
				"TestgetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

        // perform the operation
        val = start.getValue();
        expectedVal = Float.parseFloat(args[1]);

        // check the result and report
        if (val == expectedVal) {
            System.out.println("Qubit getValue(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit getValue(): FAIL!");
			System.out.println("Expected: "+expectedVal);
			System.out.println("Actual: "+val);
			return 0;
		}
    }

    public static int TestsetPhase(Qubit start, Qubit expected, String[] args)
    {
        int val;
        // make sure the degrees input is there
        if (args.length < 4)	
		{
			System.out.println("Too few arguments for "+
				"TestsetValueFloat: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

        // read the command-line argument
        val = Integer.parseInt(args[3]);
        // perfomr the operation
        start.setPhase(val);

        // check the result and report
        if (Qubit.compare(start, expected) == 0)
        {
            System.out.println("Qubit setPhase("+val+"): Success!");
            return 1;
        } else {
            System.out.println("Qubit setPhase("+val+"): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+start);
            return 0;
        }
    }

    public static int TestgetPhase(Qubit start, String[] args)
    {
        int val, expectedVal;
        // make sure the degrees input is there
        if (args.length < 4)	
		{
			System.out.println("Too few arguments for "+
				"TestgetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

        // perform the operation
        val = start.getPhase();
        expectedVal = Integer.parseInt(args[1]);

        // check the result and report
        if (val == expectedVal) {
            System.out.println("Qubit getPhase(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit getPhase(): FAIL!");
			System.out.println("Expected: "+expectedVal);
			System.out.println("Actual: "+val);
			return 0;
		}
    }

    public static int Testnot(Qubit start, Qubit expected, String[] args) {
        // perform the operation
        start.not();

        if (Qubit.compare(start, expected) == 0)
		{
			System.out.println("Qubit not(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit not(): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
    }

    public static int Testhgate(Qubit start, Qubit expected, String[] args)
    {
        // perform the operation
        start.hgate();

        if (Qubit.compare(start, expected) == 0)
		{
			System.out.println("Qubit not(): Success!");
			return 1;
		}
		else
		{
			System.out.println("Qubit not(): FAIL!");
			System.out.println("Expected: "+expected);
			System.out.println("Actual: "+start);
			return 0;
		}
    }

    public static int Testswap(Qubit q1, Qubit q2, String[] args)
    {
        float expQ1Val, expQ2Val;
        // make sure the degrees input is there
        if (args.length < 5)	
		{
			System.out.println("Too few arguments for "+
				"TestgetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

        // perform the operation
        q1.swap(q2);
        expQ1Val = Float.parseFloat(args[3]);
        expQ2Val = Float.parseFloat(args[4]);

        // check te result and report
        if ((q1.getValue() == expQ1Val) && (q2.getValue() == expQ2Val)) {
            System.out.println("Qubit swap(): Success!");
            return 1;
        } else if (q1.getValue() == expQ1Val) {
            System.out.println("Qubit swap(): FAIL!");
            System.out.println("Expected: "+expQ2Val+" for q2");
            System.out.println("Actual: "+q2.getValue()+" for q2");
            return 0;
        } else if (q2.getValue() == expQ2Val) {
            System.out.println("Qubit swap(): FAIL!");
            System.out.println("Expected: "+expQ1Val+" for q1");
            System.out.println("Actual: "+q1.getValue()+" for q1");
            return 0;
        } else {
            System.out.println("Qubit swap(): FAIL!");
            System.out.println("Expected: "+expQ1Val+" for q1 and "+expQ2Val+" for q2");
            System.out.println("Actual: "+q1.getValue()+" for q1 and "+q2.getValue()+" for q2");
            return 0;
        }
    }

    // q2 is the control bit
    public static int Testcnot(Qubit q1, Qubit q2, String[] args)
    {
        float expQ1Val, expQ2Val;
        // make sure the degrees input is there
        if (args.length < 5)	
		{
			System.out.println("Too few arguments for "+
				"TestgetValue: " +args.length);
			System.out.println("Missing value input");
			System.out.println("Test FAILED");
			return 0;
		}

        // perform the operation
        q2.cnot(q1);
        expQ1Val = Float.parseFloat(args[3]);
        expQ2Val = Float.parseFloat(args[4]);

         // check te result and report
        if ((q1.getValue() == expQ1Val) && (q2.getValue() == expQ2Val)) {
            System.out.println("Qubit swap(): Success!");
            return 1;
        } else if (q1.getValue() == expQ1Val) {
            System.out.println("Qubit swap(): FAIL!");
            System.out.println("Expected: "+expQ2Val+" for q2");
            System.out.println("Actual: "+q2.getValue()+" for q2");
            return 0;
        } else if (q2.getValue() == expQ2Val) {
            System.out.println("Qubit swap(): FAIL!");
            System.out.println("Expected: "+expQ1Val+" for q1");
            System.out.println("Actual: "+q1.getValue()+" for q1");
            return 0;
        } else {
            System.out.println("Qubit swap(): FAIL!");
            System.out.println("Expected: "+expQ1Val+" for q1 and "+expQ2Val+" for q2");
            System.out.println("Actual: "+q1.getValue()+" for q1 and "+q2.getValue()+" for q2");
            return 0;
        }
    }

    public static int TestmeasureValue()
    {
        // TODO
        return -1;
    }

    public static double TestmeasureValueMany()
    {
        // TODO
        return -1.0;
    }

    public static int TesttoBraKet()
    {
        // TODO
        return -1;
    }

	public static void main(String[] args)
	{
		int testNumber = 2;
		Qubit testQubit = new Qubit();
		Qubit expectedQubit = new Qubit();
		// make sure there are enough arguments
		if (args.length < 3)	
		{
			System.out.println("Too few arguments: "+args.length);
			System.out.println("Usage: TestQubit.exe start_state "
				+"expected_end_state testNumber inputs " 
				+"expected_ret_val");
			System.exit(0);
		}

		// get the starting state, ending state, and test number
		testQubit.setValue( Float.parseFloat(args[0]));
		expectedQubit.setValue( Float.parseFloat(args[1]));
		testNumber = Integer.parseInt(args[2]);

		// use the testnumber to choose a test function
		switch (testNumber)
		{
			case (0):
                // test String constructor
				TeststringConstructor(expectedQubit, args);
				break;
			case (1):
				// test setValue with float input
                TestsetValueFloat(testQubit, expectedQubit, args);
				break;
			case (2):
				// test setValue with String input
                TestsetValueString(testQubit, expectedQubit, args);
				break;
			case (3):
				// test getValue
                TestgetValue(testQubit, args);
				break;
			case (4):
				// test not
                Testnot(testQubit, expectedQubit, args);
				break;
            case(5):
                // test setPhase
                TestsetPhase(testQubit, expectedQubit, args);
                break;
            case (6):
                // test getPhase
                TestgetPhase(testQubit, args);
                break;
            case(7):
                // test hgate
                Testhgate(testQubit, expectedQubit, args);
                break;
            case(8):
                // test swap
                Testswap(testQubit, expectedQubit, args);
                break;
            case(9):
                // test cnot
                Testcnot(testQubit, expectedQubit, args);
                break;
            case(10):
                TestmeasureValue();
                break;
            case(11):
                TesttoBraKet();
                break;
            
			default:
				System.out.println("Test "+testNumber+" not supported");
		}
	}
}