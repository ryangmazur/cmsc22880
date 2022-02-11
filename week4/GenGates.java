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

    // https://www.techiedelight.com/swap-two-bits-given-position-integer/
    // citation for swapping bits in an integer
    public static float[][] genSwapGate(int qb1, int qb2, int numqubits) {
        int len = (int) Math.pow(2, numqubits);
        float[][] toReturn = new float[len][len];

        float[] order = new float[len];
        for(int i = 0; i < len; i++) {
            int val = i;
            if ((((val & (1 << qb1)) >> qb1) ^ ((val & (1 << qb2)) >> qb2)) == 1) {
                val ^= (1 << qb1);
                val ^= (1 << qb2);
            }
            order[i] = val;
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if (j == order[i]) {
                    toReturn[i][j] = 1;
                } else {
                    toReturn[i][j] = 0;
                }
            }
        }

        return toReturn;
    }

    public static float[][] genCNot() {
        float[][] toReturn = {
            new float[] {1, 0, 0, 0},
            new float[] {0, 1, 0, 0},
            new float[] {0, 0, 0, 1},
            new float[] {0, 0, 1, 0}
        };

        return toReturn;
    }

    public static float[][] genCNot(int qb, int numqubits) {
        int len = (int) Math.pow(2, numqubits);
        float[][] toReturn = new float[len][len];

        for (int i = 0; i < len; i++) {
            int index = i;
            if ((i & (1 << qb)) != 0) {
                index ^= 1;
            }
            //System.out.println(index);
            // if ((i & 1) == 0 && (i & (1 << qb)) == 1) {
            //     index += 1;
            // } else if ((i & 1) == 1 && (i & (1 << qb)) == 1) {
            //     index -= 1;
            // }
            for (int j = 0; j < len; j++) {
                if (j == index) {
                    toReturn[i][j] = 1;
                } else {
                    toReturn[i][j] = 0;
                }
            }
        }
        
        return toReturn;
    }
}
