public class DoubleQubit extends ParentQubit {
    
    // Constructor: initialize to |00>
    public DoubleQubit() {
        super(2);
    }

    // this merges two sets of qubits and returns a new one that has
    // a number of qubits that is the sum of the two. Next week, you will
    // merge a DoubleQubit to something of any size and create an NQubit.
    // This week, you merely return null.
    ParentQubit mergeQubits(ParentQubit pq) {
        return null;
    }

    // this prints out the state in bra-ket notation, like last week
    // see notes on ParentQubit to make sure you do this accurately.
    public String toBraKet() {
        String toReturn = "";

        for (int i = 0; i < this.values.length; i++) {
            if (i != 0 || this.getPhase(i) == -1) {
                if (this.getPhase(i) == -1) {
                    toReturn = toReturn + " - ";
                    //toReturn.concat(" - ");
                } else {
                    toReturn = toReturn + " + ";
                    //toReturn.concat(" + ");
                }
            }
            toReturn = toReturn + String.format("%.2f", Math.abs(this.values[i])) + "|" + getBinary(i, 2) + ">";
            //toReturn.concat(String.format("%.2f", vals[i]))
                    //.concat("|")
                    //.concat(getBinary(i, 2))
                    //.concat(">");
        }
        
        return toReturn;
    }

    // apply a not gate to all qubits
    // I highly recommend writing a generic vector (with probability magnitudes a, b, c, d)
    // and calculating where they all end up using a not gate.
    public void applyNotGate() {
        float[][] notGate = GenGates.genNotGate(2);
        
        this.values = MatrixMath.matrixMult(notGate, this.values);
    }

    // apply a not gate to the qubit in position qb, where numbering starts at 0
    // only do so if qb = 0 or 1
    // derive the matrix by writing out the start and end states and mapping back to matrix.
    // this video goes over this process.
    public void applyNotGate(int qb) {
        float[][] gate;
        if (qb == 0) {
            gate = GenGates.genNotGate(1);
        } else {
            gate = GenGates.genIdentityGate(1);
        }

        for (int i = 1; i < this.getNumQubits(); i++) {
            if (i == qb) {
                gate = MatrixMath.tensorProd(gate, GenGates.genNotGate(1));
            } else {
                gate = MatrixMath.tensorProd(gate, GenGates.genIdentityGate(1));
            }
        }
        this.values = MatrixMath.matrixMult(gate, this.values);
    }

    // apply an H gate to every qubit
    // as we went over in class, when you derive the a matrix for H gates,
    // here is what you get:
    public void applyHGate() {
        float[][] gate = GenGates.genHGate();

        for (int i = 1; i < this.getNumQubits(); i++) {
            gate = MatrixMath.tensorProd(gate, GenGates.genHGate());
        }

        this.values = MatrixMath.matrixMult(gate, this.values);
    }

    // apply an H gate to the qubit in position qb, where numbering starts at 0
    // only do so if qb = 0 or 1
    public void applyHGate(int qb) {
        float[][] gate;
        if (qb == 0) {
            gate = GenGates.genHGate();
        } else {
            gate = GenGates.genIdentityGate(1);
        }

        for (int i = 1; i < this.getNumQubits(); i++) {
            if (i == qb) {
                gate = MatrixMath.tensorProd(gate, GenGates.genHGate());
            } else {
                gate = MatrixMath.tensorProd(gate, GenGates.genIdentityGate(1));
            }
        }

        this.values = MatrixMath.matrixMult(gate, this.values);
    }

    // apply swap gate to the two qubits, where the inputs are the qubit positions of the two qubits.
    //Given that this is DoubleQubit class, the only valid inputs are 0 and 1 (in ascending order).
    public void applySwapGate(int qubit1, int qubit2) {
        float[][] gate = GenGates.genSwapGate();

        this.values = MatrixMath.matrixMult(gate, this.values);
    }
}
