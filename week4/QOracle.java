public class QOracle {

    private float[][] matr;

    public QOracle() {
        this.matr = new float[16][16];
    }
    
    private float[][] createBernVaz(int code) {
        float[][] toReturn = GenGates.genIdentityGate(4);
        //float[][] toReturn = new float[16][16];

        boolean first = true;

        for (int i = 0; i < 3; i++) {
            //System.out.println("Before if");
            if ((code & (1 << i)) != 0) {
                if (first) {
                    //System.out.println("First");
                    toReturn = GenGates.genCNot(i + 1, 4);
                    first = false;
                } else {
                    //System.out.println("Not First");
                    toReturn = MatrixMath.matrixMult(toReturn, GenGates.genCNot(i + 1, 4));
                }
            }
        }

        return toReturn;
    }

    // receives a 3-bit code (number from 0-7). Based on that
    // 3-bit code, construct the oracle. For each 1 in the 3-bit code.
    // a C-NOT is connected to the response, where the qubit corresponding to
    // the 1 is the control, and the response is the target.
    public void setBernVaz(int code) {
        this.matr = createBernVaz(code);
    }

    // NQubit is a 4-qubit input, with the first three qubits being the "guess" and
    // the last qubit being the response. Apply the oracle. No return value is
    // necessary because you modify the state of the input.
    public void probeBernVaz(NQubit nq) {
        float[][] hgates = MatrixMath.tensorProd(MatrixMath.tensorProd(GenGates.genHGate(), GenGates.genHGate()), MatrixMath.tensorProd(GenGates.genHGate(), GenGates.genHGate()));

        nq.setAmpValues(MatrixMath.matrixMult(MatrixMath.matrixMult(hgates, this.matr), MatrixMath.matrixMult(hgates, nq.getAmpValues())));
    }

    // receives a set of 3-bit codes (number from 0-7). Based on that
    // 3-bit code, construct the oracle. For each 3-bit code, the last
    // bit of the input gets flipped. Think carefully about what the matrix looks
    // like in the absence of any codes, and then think about how each individual
    // code modifies that starting matrix. Once you have figured it out on paper,
    // then you can work on how to implement that in code.
    public void setArchimedes(int[] codes) {
        if (codes.length == 0) {
            GenGates.genIdentityGate(4);
            return;
        }
        this.matr = createBernVaz(codes[0]);

        for (int i = 1; i < codes.length; i++) {
            this.matr = MatrixMath.matrixMult(this.matr, createBernVaz(codes[i]));
        }
    }

    // NQubit is a 4-qubit input, with the first three qubits being the "guess" and
    // the last qubit being the response. Apply the oracle. No return value is
    // necessary because you modify the state of the input.
    public void probeArchimedes(NQubit nq) {
        float[][] hgates = MatrixMath.tensorProd(MatrixMath.tensorProd(GenGates.genHGate(), GenGates.genHGate()), MatrixMath.tensorProd(GenGates.genHGate(), GenGates.genHGate()));

        nq.setAmpValues(MatrixMath.matrixMult(MatrixMath.matrixMult(hgates, this.matr), MatrixMath.matrixMult(hgates, nq.getAmpValues())));
    }

    public float[][] getMatr() {
        return this.matr;
    }
}
