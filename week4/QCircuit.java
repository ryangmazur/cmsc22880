public class QCircuit {
    
    // no return value is necessary because you modify the input dq.
    public static void sameEntangle(DoubleQubit dq) {
        float[][] gate = MatrixMath.matrixMult(GenGates.genCNot(), MatrixMath.tensorProd(GenGates.genHGate(), GenGates.genIdentityGate(1)));
        dq.setAmpValues(MatrixMath.matrixMult(gate, dq.getAmpValues()));
    }

    // You can assume that nq has 4 bits and has been initialized as expected
    // for the bernvaz algorithm (3 white, 1 black). qo has already been initialized.
    // implement the algorithm.
    // no return value is necessary because you modify the input nq.
    public static void bernvaz(NQubit nq, QOracle qo) {
        qo.probeBernVaz(nq);
    }

    // You can assume that nq has 4 bits and has been initialized as expected
    // for the archimedes algorithm (3 white, 1 black). qo has already been initialized.
    // implement the algorithm.
    // no return value is necessary because you modify the input nq.
    public static void archimedes(NQubit nq, QOracle qo) {
        qo.probeArchimedes(nq);
    }
}
