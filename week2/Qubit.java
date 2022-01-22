import java.util.Random;

public class Qubit{
	private float value; // either 0 (white) or 1 (black)

	/* Default Constructor
	 * Constructor without input arguments
	 * Initialize value to white or |0>, positive phase
	 */
	public Qubit()
    {
		this.value = 0;
	}

	/* Constructor with input arguments
	 * Initialize value to input value
     * check sign of float for phase
     * allow any number between -1 and 1, inclusive
	 */
	public Qubit(float v)
	{
		this.value = v;
	}

	/* Constructor with input arguments
	 * allow other ways of specifying the starting value
	 * initialize: "White" is false, "Black" is true
     * set phase to positive
	 */
	public Qubit(String v)
	{
		if (v.equals("White")) {
            this.value = 0;
        } else if (v.equals("Black")) {
            this.value = 1;
        } else {
            System.out.println("error: Initialization string must be either \"White\" or \"Black\"");
        }
	}


	/* These are standard "setters" and "getters" except that we
	 * are supporting two types for the setter. Fill these in.
     * inspect sign of float for phase
	 */
	public void setValue(float v)
	{  
		this.value = v;
	}

    /* set phase to positive
    */
	public void setValue(String v)
	{  
		if (v.equals("White")) {
            this.value = 0;
        } else if (v.equals("Black")) {
            this.value = 1;
        } else {
            System.out.println("error: Initialization string must be either \"White\" or \"Black\"");
        }
	}

    /* return probability of measuring 1 multiplied by the phase
    */
	public float getValue()
	{  
        return this.value;
	}

    /* assume -1 for negative phase, 1 for positive phase
    */
    public void setPhase(int phase)
    {
        this.value = phase * Math.abs(this.value);
    }

    /* return -1 for negative phase, 1 for positive phase
    */
    public int getPhase()
    {
        return Math.round(Math.signum(this.value));
    }

	/* not
	 * Perform a not gate on the qubit
	 * In week 1, this is only required to flip between 0 and 1
	 * Implement this without a conditional - figure out a 
	 * mathematical calculation that will work for either 0 or 1
     * make sure the implementation works for superposition and phase
     * for now, we will assume that not does not affect the phase
	 */
	public void not()
	{
        this.value = this.getPhase() * 1 - this.value;
	}

    /* support the following inputs: 0 with positive phase, 1 with positive phase
    * superposition of 50% positive phase, superposition of 50% with negative phase
    */
    public void hgate()
    {
        this.value = ((1.0f - this.value) * .5f + (0.0f + this.value) * -.5f);
    }

    /* make sure the implementation works for superposition and phase
    * Phase is swapped just as the rest of the state is swapped
    */
    public void swap(Qubit q2)
    {
        
        float temp = this.value;
        this.value = q2.getValue();
        q2.setValue(temp);
    }
    
    /* support only 0 and 1 inputs, positive phase
    * assume that 'this' is control, and q2 is the target
    */
    public void cnot(Qubit q2)
    {
        if (this.value == 1) {
            q2.not();
        }
    }

    /* this performs measurement to determine whether the 'color' is white or black
    * or the value is 0 or 1.
    * this both outoputs the mesured value and set the value in the Qubit to that result,
    * collapsing any superposition that might have been present
    */
    public int measureValue()
    {
        Random rnd = new Random();
        if (rnd.nextFloat() <= Math.abs(this.value)) {
            this.value = 1;
        } else {
            this.value = 0;
        }
        return Math.round(this.value);
    }

    /* produces a string that prints out the value in bra-ket notation
    */
    public String toBraKet()
    {
        double alpha = Math.round(Math.sqrt(1 - this.value) * 100.0) / 100.0;
        double beta = Math.round(Math.sqrt(this.value) * 100.0) / 100.0;
        if (this.value == 0) {
            return "|0>";
        } else if (this.value == 1) {
            return "|1>";
        }
        return alpha + "|0> + " + beta + "|1>";
    }

	/* These are methods we implement so that we can use Qubit with
	 * standard operations - like System.out.println and comparison 
	 * These are critical for grading, so don't change them!!!
	 */
	public String toString()
	{
	       // we put the "" before value to make it a String.	
		return "" + value;
       	} 

	public static int compare (Object obj1, Object obj2)
	{
		// first cast to Qubits - we assume we're comparing Qubits
		Qubit q1 = (Qubit) obj1;
		Qubit q2 = (Qubit) obj2;

		// if they are equal within a certain precision
		// because they are floats, we must put in a fudge factor
		if (((q1.getValue() - q2.getValue()) < 0.01) &&
		    ((q2.getValue() - q1.getValue()) < 0.01) ) 
		{
			// obj1 == obj2
			return 0;
		}
		else if (q1.getValue() > q2.getValue())
		{
			// obj1 > obj2
			return 1;
		}
		else // if (q1.getValue() < q2.getValue())
		{
			// obj1 < obj2
			return -1;
		}
		   
	}



} // end of class