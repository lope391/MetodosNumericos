/**
 * Created by Lope on 10/26/2016.
 */
public class LUGaus {



    public double [] evaluar(double[][] matA, double[] vecB){

        int n=matA.length;
        double[][] l = new double[n][n];
        for(int i = 0; i < n;i++) l[i][i] = 1;
        double[][] u = new double[n][n];
        double[] res = new double[n];
        double[] aux = new  double[n];

        for(int i = 0; i < n;i++){
            for(int j = i; j < n;j++){
                u[i][j] = matA[i][j];
            }
        }


        for(int k=0;k<n-1;k++){
            for(int i=k+1;i<n;i++){
                double multiplicador = matA[i][k]/matA[k][k];
                l[i][k] = multiplicador;
                for(int j=k;j<n;j++){
                    matA[i][j] -= multiplicador*matA[k][j];
                }
            }
        }

        double cont;
        for(int i = 0;i < n; i++){    //Sust Progresiva

            cont = 0;
            for(int j = 0; j < i; j++){
                cont += l[i][j] * aux[j];
            }

            aux[i] = (vecB[i]-cont)/l[i][i];
        }

        for(int i = n-1;i >= 0; i--){   // Sust Regresiva

            cont = 0;
            for(int j = n-1; j > i; j--){
                cont += u[i][j] * res[j];
            }

            res[i] = (aux[i]-cont)/u[i][i];
        }

        return res;
    }

}
