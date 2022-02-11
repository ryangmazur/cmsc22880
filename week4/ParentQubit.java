public abstract class ParentQubit {
    // make the data strcuture, it think it needs to be an array of floats
    protected float[] values;

    // Constructor: initialize all bits to |0>
    public ParentQubit(int numqubits) {
        this.values = new float[(int) Math.pow(2.0, Double.valueOf(numqubits))];
        this.values[0] = 1.0f;
        for (int i = 1; i < this.values.length; i++) {
            values[i] = 0.0f;
        }
    }

    // The value in v is the probability of the ith value measuring that combination.
    // Combinations are always ordered in increasing order from 0 to (2^numqubits)-1.
    // Values are negative if the phase should be negative.
    public void setValue(float v, int i) {
        this.values[i] = Math.signum(v) * (float) Math.sqrt(Math.abs(v));
    }

    // v is the length equal to the number of qubit combinations (2^numqubits).
    // The value in v[i] is the probability of measuring that combination.
    // Combinations are always ordered in increasing order from 0 to (2^numqubits)-1.
    // Values are negative if the phase should be negative.
    public void setValues(float[] v) {
        for (int i = 0; i < v.length; i++) {
            this.values[i] = Math.signum(v[i]) * (float) Math.sqrt(Math.abs(v[i]));
        }
    }

    public float getValue(int i) {
        return (float) Math.signum(this.values[i]) * (float) Math.pow(this.values[i], 2);
    }

    public float[] getValues() {
        float[] toReturn = new float[this.values.length];
        for (int i = 0; i < this.values.length; i ++) {
            toReturn[i] = (float) Math.signum(this.values[i]) * (float) Math.pow(this.values[i], 2);
        }
        return toReturn;
    }

    /* Phase: Any term that is a 0 will be assumed to be positive phase. This holds
    * for both setPhase and getPhase. For setPhase, ignore any command for a term
    * that is 0. For getPhase, always response 1 for a term that is 0.
    * These methods are similar to the value functions, but for phase. */    
    public void setPhase(int p, int i) {
        if (this.values[i] != 0.0) {
            this.values[i] = Math.signum(p) * Math.abs(this.values[i]);
            
        }
    }

    public void setPhases(int[] p) {
        for (int i = 0; i < p.length; i++) {
            if (this.values[i] != 0.0) {
                this.values[i] = Math.signum(p[i]) * Math.abs(this.values[i]);
            }
        }
    }

    public int getPhase(int i) {
        if (this.values[i] == 0) {
            return 1;
        }
        return (int) Math.signum(this.values[i]);
    }

    // returns the number of qubits this object represents
    public int getNumQubits() {
        return (int) (Math.log(this.values.length)/Math.log(2));
    }

    // citation for inspiration for this function: https://stackoverflow.com/questions/2406432/converting-an-int-to-a-binary-string-representation-in-java
    protected String getBinary(int i, int len) {
        String toReturn = "";
        while (i > 0) {
            int num = i % 2;
            if (num == 0) {
                toReturn = "0" + toReturn;
            } else {
                toReturn = "1" + toReturn;
            }
            i = i/2;
        }
        
        while (toReturn.length() < len) {
            toReturn = "0" + toReturn;
        }

        return toReturn;
    }

    public float[] getAmpValues() {
        return this.values;
    }

    public void setAmpValues(float[] new_vals) {
        this.values = new_vals;
    }

    // this merges two sets of qubits and returns a new one that has
    // a number of qubits that is the sum of the two. For example, we could
    // merge two SingleQubit objects to become one DoubleQubit object.
    // this is not implemented in ParentQubit but in the subclasses
    // for this week, you will only implement merging two singles into a double.
    abstract ParentQubit mergeQubits(ParentQubit pq);

    abstract String toBraKet();

    // apply a not gate to each qubit
    abstract void applyNotGate();

    // apply a not gate to the qubit in position qb, where numbering starts at 0
    abstract void applyNotGate(int qb);

    // apply an H gate to each qubit
    abstract void applyHGate();

    // apply an H gate to the qubit in position qb, where numbering starts at 0    
    abstract void applyHGate(int qb);

    // apply a swap gate between qubit1 and qubit2, where numbering starts at 0
    abstract void applySwapGate(int qubit1, int qubit2);
}
