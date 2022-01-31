public class SingleQubit {
    
    // Constructor: initialize bit to |0>
    public SingleQubit() {

    }

    // this merges two sets of qubits and returns a new one that has
    // a number of qubits that is the sum of the two. You are implementing
    // merging a SingleQubit with another SingleQubit. You will need to verify
    // that the input only has one Qubit. If it has more than one qubit, then
    // return null. Otherwise, create a DoubleQubit object and fill it in
    // with the proper values.
    ParentQubit mergeQubits(ParentQubit pq) {

    }

    // this prints out the state in bra-ket notation, like last week
    public String toBraKet() {
        
    }

    // apply a not gate to the qubit
    public void applyNotGate() {

    }

    // apply a not gate to the qubit in position qb, where numbering starts at 0
    // only do so if qb = 0 (since, in this case, we have only 1 qb)
    public void applyNotGate(int qb) {

    }

    // apply an H gate to the qubit
    public void applyHGate() {
        
    }

    // apply an H gate to the qubit in position qb, where numbering starts at 0
    // only do so if qb = 0
    public void applyHGate(int qb) {

    }

    // do nothing
    public void applySwapGate(int qubit1, int qubit2) {

    }
}
