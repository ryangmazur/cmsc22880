public class SingleQubit extends ParentQubit {

    // Constructor: initialize bit to |0>
    public SingleQubit() {
        super(1);
    }

    // this merges two sets of qubits and returns a new one that has
    // a number of qubits that is the sum of the two. You are implementing
    // merging a SingleQubit with another SingleQubit. You will need to verify
    // that the input only has one Qubit. If it has more than one qubit, then
    // return null. Otherwise, create a DoubleQubit object and fill it in
    // with the proper values.
    DoubleQubit mergeQubits(ParentQubit pq) {
        if (pq.getNumQubits() > 1) {
            return null;
        }
        
        DoubleQubit dq = new DoubleQubit();
        float[] vals = new float[2];
        vals[0] = (float) Math.pow(pq.getValue(0), 2);
        vals[1] = (float) Math.pow(pq.getValue(1), 2);

        float[] allVals = MatrixMath.tensorProd(this.values, vals);
        float[] newVals = new float[allVals.length];
        for (int i = 0; i < allVals.length; i++) {
            int phase;
            if (allVals[i] >= 0) {
                phase = 1;
            } else {
                phase = -1;
            }   
            newVals[i] = phase * (float) Math.sqrt(Math.abs(allVals[i]));
        }

        dq.setValues(newVals);
        return dq;
        /*
        int pos = 0;
        float[] values = new float[4];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                values[pos] = this.values[i] * pq.getValue(j);
            }
        }
        return dq;
        */
    }

    // this prints out the state in bra-ket notation, like last week
    public String toBraKet() {
        int phase = this.getPhase(1);
        if (this.values[0] == 1) {
            return "|0>";
        } else if (this.values[0] == 0 && phase == 1) {
            return "|1>";
        } else if (this.values[0] == 0 && phase == -1) {
            return "- |1>";
        }
        double alpha = Math.round(Math.abs(this.values[0]) * 100.0) / 100.0;
        double beta = Math.round(Math.abs(this.values[1]) * 100.0) / 100.0;
        if (phase == 1) {
            return alpha + "|0> + " + beta + "|1>";
        } else {
            return alpha + "|0> - " + beta + "|1>";
        }
    }

    // apply a not gate to the qubit
    public void applyNotGate() {
        float[][] gate = GenGates.genNotGate(1);
        this.values = MatrixMath.matrixMult(gate, this.values);
    }

    // apply a not gate to the qubit in position qb, where numbering starts at 0
    // only do so if qb = 0 (since, in this case, we have only 1 qb)
    public void applyNotGate(int qb) {
        if (qb == 0) {
            this.applyNotGate();
        }
    }

    // apply an H gate to the qubit
    public void applyHGate() {
        float[][] gate = GenGates.genHGate();
        this.values = MatrixMath.matrixMult(gate, this.values);
    }

    // apply an H gate to the qubit in position qb, where numbering starts at 0
    // only do so if qb = 0
    public void applyHGate(int qb) {
        if (qb == 0) {
            this.applyHGate();
        }
    }

    // do nothing
    public void applySwapGate(int qubit1, int qubit2) {

    }
}
