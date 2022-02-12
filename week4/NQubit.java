public class NQubit extends ParentQubit {
    
    // Constructor: init all qubits to zero
    public NQubit(int numqubits) {
        super(numqubits);
    }

    // this merges two sets of qubits and returns a new one that has
    // a number of qubits that is the sum of the two.
    public ParentQubit mergeQubits(ParentQubit pq) {
        NQubit nq = new NQubit(this.getNumQubits() + pq.getNumQubits());

        nq.setAmpValues(MatrixMath.tensorProd(this.values, pq.getAmpValues()));
        return nq;
    }

    // this prints out the state in bra-ket notation, like last week
    public String toBraKet() {
        if (this.getValue(0) == 1) {
            return "|" + getBinary(0, this.getNumQubits()) + ">";
        }

        float int_val = this.getValue(0);
        float EPSILON = 0.0001f;
        boolean all_equals = true;
        for (int i = 1; i < (int) Math.pow(2, this.getNumQubits()); i++) {
            if ((this.getValue(i) - int_val) > EPSILON) {
                all_equals = false;
            }
        }

        String toReturn = "";

        for (int i = 0; i < this.values.length; i++) {
            if (i != 0 || this.getPhase(i) == -1) {
                if (this.getPhase(i) == -1) {
                    toReturn = toReturn + " - ";
                } else {
                    toReturn = toReturn + " + ";
                }
            }
            if (all_equals && Math.abs((this.getValue(0) - .25f )) < EPSILON) {
                toReturn = toReturn + String.format("%.1f", Math.abs(this.values[i])) + "|" + getBinary(i, this.getNumQubits()) + ">";
            } else {
                toReturn = toReturn + String.format("%.2f", Math.abs(this.values[i])) + "|" + getBinary(i, this.getNumQubits()) + ">";
            }
            
        }
        
        return toReturn;
    }

    // apply a not gate to every qubit
    public void applyNotGate() {
        float[][] notGate = GenGates.genNotGate(this.getNumQubits());
        this.values = MatrixMath.matrixMult(notGate, this.values);
    }

    // apply a not gate to the qubit in position qb, where numbering starts at 0
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

    // apply an H gate to each qubit
    public void applyHGate() {
        float[][] gate = GenGates.genHGate();

        for (int i = 1; i < this.getNumQubits(); i++) {
            gate = MatrixMath.tensorProd(gate, GenGates.genHGate());
        }

        this.values = MatrixMath.matrixMult(gate, this.values);
    }

    // apply an H gate to the qubit in position qb, where numbering starts at 0
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

    // apply a swap gate between qubit1 and qubit2, where numbering starts at 0
    public void applySwapGate(int qb1, int qb2) {
        float[][] gate = GenGates.genSwapGate(qb1, qb2, this.getNumQubits());
        this.values = MatrixMath.matrixMult(gate, this.values);
    }
}
