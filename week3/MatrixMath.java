public class MatrixMath {

    // returns [# rows, # cols]
    public static int[] getShape(float[] matr) {
        int[] toReturn = new int[2];

        toReturn[0] = matr.length;
        toReturn[1] = 1;
        return toReturn;
    }

    public static int[] getShape(float[][] matr) {
        int[] toReturn = new int[2];

        toReturn[0] = matr.length;
        toReturn[1] = matr[0].length;
        return toReturn;
    }

    public static float matrixMult(float[] matr1, float[] matr2) {
        int[] shape1 = getShape(matr1);
        int[] shape2 = getShape(matr2);

        if (shape1[0] != shape2[0]) {
            String matr1LenStr = String.format("%d", shape1[0]);
            String matr2LenStr = String.format("%d", shape2[0]);
            throw new RuntimeException("Incompatible matrices: matrix 1 has " + matr1LenStr + "columns and matrix 2 has " + matr2LenStr + "rows");
        }

        float toReturn = 0;
        for (int i = 0; i < shape1[0]; i++) {
            toReturn += matr1[i] * matr2[i];
        }
        return toReturn;
    }

    public static float[] matrixMult(float[][] matr1, float[] matr2) {
        int[] shape1 = getShape(matr1);
        int[] shape2 = getShape(matr2);

        if (shape1[1] != shape2[0]) {
            String matr1LenStr = String.format("%d", shape1[1]);
            String matr2LenStr = String.format("%d", shape2[0]);
            throw new RuntimeException("Incompatible matrices: matrix 1 has " + matr1LenStr + "columns and matrix 2 has " + matr2LenStr + "rows");
        }

        float[] toReturn = new float[shape1[0]];
        for (int i = 0; i < shape1[0]; i++) {
            float val = 0;
            for (int j = 0; j < shape1[0]; j++) {
                val = matr1[i][j] * matr2[j];
            }
            toReturn[i] = val;
        }
        return toReturn;
    }
    
    public static float[][] matrixMult(float[][] matr1, float[][] matr2) {
        int[] shape1 = getShape(matr1);
        int[] shape2 = getShape(matr2);

        if (shape1[1] != shape2[0]) {
            String matr1LenStr = String.format("%d", shape1[1]);
            String matr2LenStr = String.format("%d", shape2[0]);
            throw new RuntimeException("Incompatible matrices: matrix 1 has " + matr1LenStr + "columns and matrix 2 has " + matr2LenStr + "rows");
        }

        float[][] toReturn = new float[shape1[0]][shape2[1]];
        for (int i = 0; i < shape1[0]; i++) {
            for (int j = 0; j < shape1[1]; j++) {
                int val = 0;
                for (int k = 0; k < shape2[1]; k++) {
                    val += matr1[i][k] * matr2[k][j];
                }
                toReturn[i][j] = val;
            }
        }
        return toReturn;
    }
}
