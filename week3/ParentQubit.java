public abstract class ParentQubit {
    // make the data strcuture, it think it needs to be an array of floats

    // Constructor: initialize all bits to |0>
    public ParentQubit(int numqubits) {

    }

    // The value in v is the probability of the ith value measuring that combination.
    // Combinations are always ordered in increasing order from 0 to (2^numqubits)-1.
    // Values are negative if the phase should be negative.
    public void setValue(float v, int i) {

    }

    // v is the length equal to the number of qubit combinations (2^numqubits).
    // The value in v[i] is the probability of measuring that combination.
    // Combinations are always ordered in increasing order from 0 to (2^numqubits)-1.
    // Values are negative if the phase should be negative.
    public void setValues(float[] v) {

    }

    public float getValue(int i) {

    }

    public float[] getValues() {

    }

    /* Phase: Any term that is a 0 will be assumed to be positive phase. This holds
    * for both setPhase and getPhase. For setPhase, ignore any command for a term
    * that is 0. For getPhase, always response 1 for a term that is 0.
    * These methods are similar to the value functions, but for phase. */    
    public void setPhase(int p, int i) {

    }

    public void setPhases(int[] p) {

    }

    public int getPhase(int i) {

    }

    // returns the number of qubits this object represents
    public int getNumQubits() {

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
