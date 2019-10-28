import java.util.Arrays;

public class Matrics {
    public int[][] solution(int[][] matrixA, int[][] matrixB){
        int [][] res = new int[matrixA.length][matrixB[0].length];
        for(int i=0; i< res.length; i++){
            for(int j=0; j< matrixA[0].length;j++){
                if(matrixA[i][j] != 0){
                    for(int k=0; k<res[0].length; k++){
                        res[i][j] += matrixA[i][j] * matrixB[j][k];
                    }
                }
            }
        }return res;

    }

    public static void main(String[] args) {
        int[][] matrixA = {{1, 0, 0}, {-1, 0, 3}};
        int[][] matrixB = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        Matrics test = new Matrics();
        int[][] result = test.solution(matrixA, matrixB);
        System.out.println(Arrays.deepToString(result));
    }
}
