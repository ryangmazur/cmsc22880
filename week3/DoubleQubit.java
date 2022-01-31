public class DoubleQubit {
    
    // Constructor: initialize to |00>
    public DoubleQubit() {

    }

    // this merges two sets of qubits and returns a new one that has
    // a number of qubits that is the sum of the two. Next week, you will
    // merge a DoubleQubit to something of any size and create an NQubit.
    // This week, you merely return null.
    ParentQubit mergeQubits(ParentQubit pq) {

    }

    // this prints out the state in bra-ket notation, like last week
    // see notes on ParentQubit to make sure you do this accurately.
    public String toBraKet() {

    }

    // apply a not gate to all qubits
    // I highly recommend writing a generic vector (with probability magnitudes a, b, c, d)
    // and calculating where they all end up using a not gate.
    public void applyNotGate() {

    }

    // apply a not gate to the qubit in position qb, where numbering starts at 0
    // only do so if qb = 0 or 1
    // derive the matrix by writing out the start and end states and mapping back to matrix.
    // this video goes over this process.
    public void applyNotGate(int qb) {

    }

    // apply an H gate to every qubit
    // as we went over in class, when you derive the amtrices for H gates,
    // here is what you get:
    public void applyHGate() {

    }

    // apply an H gate to the qubit in position qb, where numbering starts at 0
    // only do so if qb = 0 or 1
    public void applyHGate(int qb) {

    }

    // apply swap gate to the two qubits, where the inputs are the qubit positions of the two qubits.
    //Given that this is DoubleQubit class, the only valid inputs are 0 and 1 (in ascending order).
    public void applySwapGate(int qubit1, int qubit2) {

    }
}
