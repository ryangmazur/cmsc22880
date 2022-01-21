import java.util.Random;

public class Qubit{
	private float value; // either 0 (white) or 1 (black)
    private int phase;

	/* Default Constructor
	 * Constructor without input arguments
	 * Initialize value to white or |0>
	 */
	public Qubit(){
		this.value = 0;
        this.phase = 1;
	}

	/* Constructor with input arguments
	 * Initialize value to inputed value
	 */
	public Qubit(float v)
	{
		this.value = v;
        this.phase = Math.round(Math.abs(v)/v);
	}

	/* Constructor with input arguments
	 * allow other ways of specifying the starting value
	 * initialize: "White" is false, "Black" is true
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
        this.phase = 1;
	}


	/* These are standard "setters" and "getters" except that we
	 * are supporting two types for the setter. Fill these in.
	 */
	public void setValue(float v)
	{  
		this.value = v;
        this.phase = (int) Math.round(Math.abs(v)/v);
	}

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

	public float getValue()
	{  
        return this.phase * this.value;
	}

    public void setPhase(int phase) {
        this.phase = phase;
        this.value = this.phase * this.value;
    }

    public int getPhase() {
        return this.phase;
    }

	/* not
	 * Perform a not gate on the qubit
	 * In week 1, this is only required to flip between 0 and 1
	 * Implement this without a conditional - figure out a 
	 * mathematical calculation that will work for either 0 or 1
	 */
	public void not()
	{
        this.value = this.phase * 1 - this.value;
	}

    public void hgate() {

    }

    public void swap(Qubit q2) {
        
        this.phase = -1 * this.phase * Math.abs(this.phase);
    }
    
    public void cnot(Qubit q2) {

    }

    public int measureValue() {
        Random rnd = new Random();
        if (rnd.nextFloat() <= Math.abs(this.value)) {
            this.value = 1;
        } else {
            this.value = 0;
        }
        return Math.round(this.value);
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