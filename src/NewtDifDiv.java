/**
 * Created by lope1 on 11/8/2016.
 */
public class NewtDifDiv {

    public static double evaluar(double [] vX, double[] vY, double val){

        int n = vX.length;
        double[][] mat = new double[n][n];
        double prod = 1;
        double res = 0;

        for(int i = 0; i < n; i++){

            mat[i][0] = vY[i];

            for(int j = 1; j <= i; j++){
                mat[i][j] = (mat[i][j-1] - mat[i-1][j-1])/(vX[i] - vX[i-j]);
            }
            if(i > 0){
                prod  *= val-vX[i-1];
            }
            res += mat[i][i]*prod;
        }

        return res;
    }
}
