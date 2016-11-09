/**
 * Created by lope1 on 11/8/2016.
 */
public class Lagrange {

    public static double evaluar(double [] vX, double[] vY, double val){

        int n = vX.length;
        double producto;
        double[] vL = new double[n];
        double res = 0;

        for(int i = 0; i < n; i++){

            producto = 1;

            for(int j = 0; j < n; j++){

                if(j != i){
                    producto *= (val- vX[j])/(vX[i]- vX[j]);
                }
            }
            vL[i] = producto;
            res += (vL[i]*vY[i]);
        }
        return res;
    }
}
