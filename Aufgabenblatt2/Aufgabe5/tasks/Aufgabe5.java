public class Aufgabe5 {

    private static int[][] generiereMatrix(int N) {
        int[][] matrix = new int[N][N];
        int zahl = 0;
        for(int i = 0; i<matrix[0].length;i++)
        {
            for(int j = 0; j<matrix[0].length;j++)
            {
                matrix[i][j] = zahl;
                zahl++;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for(int i = 0; i<matrix.length;i++)
        {
            for(int j = 0; j<matrix.length;j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }

    private static void transponiereMatrix(int[][] matrix) {
        for (int i = 0 ; i < matrix.length ; i++ )
        {
            for (int j = 0 ; j < matrix.length ; j++ )
                matrix[j][i] = matrix[i][j];
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generiereMatrix(n);
        printMatrix(matrix);
        transponiereMatrix(matrix);
        printMatrix(matrix);
    }

}

/*
    1.  In Java werden 2D-Arrays wie gefolgt realisiert: matrix[reihe][spalte].
    2.  An sich besitzt Java keine "mehrdimensionalen Arrays". Im Prinzip ist ein 3D Array nur ein Array von Arrays von Arrays
        Umgesetzt kann ein 3D-Array wie gefolgt werden: int[][][] matrix = new int[x][y][z];
 */