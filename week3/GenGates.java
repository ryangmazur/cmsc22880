public class GenGates {
    
    public static float[][] genIdentityGate(int numqubits) {
        int len = (int) Math.pow(2, numqubits);
        float[][] toReturn = new float[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    toReturn[i][j] = 1;
                } else {
                    toReturn[i][j] = 0;
                }
            }
        }

        return toReturn;
    }

    public static float[][] genNotGate(int numqubits) {
        int len = (int) Math.pow(2, numqubits);
        float[][] toReturn = new float[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i + j == len - 1) {
                    toReturn[i][j] = 1;
                } else {
                    toReturn[i][j] = 0;
                }
            }
        }

        return toReturn;
    }

    public static float[][] genHGate() {
        float[][] matr = {
            new float[] {1, 1},
            new float[] {1, -1}
        };

        return MatrixMath.scalarMult(1.0f/(float) Math.sqrt(2), matr);
    }

    public static float[][] genSwapGate() {
        float[][] toReturn = {
            new float[] {1, 0, 0, 0},
            new float[] {0, 0, 1, 0},
            new float[] {0, 1, 0, 0},
            new float[] {0, 0, 0, 1}
        };

        return toReturn;
    }
}
