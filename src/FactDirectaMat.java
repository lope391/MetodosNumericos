/**
 * Created by lope1 on 10/23/2016.
 */
public class FactDirectaMat {

    public double[] evaluar(double[][] matCoef,double[] solCoef, int caso) throws Exception{

        int n = matCoef.length;
        double contK;
        double contJ;
        double contI;
        double cont;

        double[][] l = new double[n][n];
        double[][] u = new double[n][n];
        double[] res = new double[n];
        double[] aux = new  double[n];

        for(int k = 0; k < n; k++){

            contK = 0;

            for(int p = 0; p < k;p++){
                contK += (l[k][p] * u[p][k]);
            }

            switch (caso){
                case 1:
                    System.out.println("Metodo Seleccionado Choleski");
                    l[k][k] = Math.sqrt(matCoef[k][k] - contK);
                    u[k][k] = l[k][k];
                    break;

                case 2:
                    System.out.println("Metodo Seleccionado Crout");
                    l[k][k] = matCoef[k][k] - contK;
                    u[k][k] = 1;
                    break;

                case 3:
                    System.out.println("Metodo Seleccionado Dolittle");
                    l[k][k] = 1;
                    u[k][k] = matCoef[k][k] - contK;
                    break;

                default:

                    break;
            }

            for(int i = k+1; i < n;i++){

                contI = 0;

                for(int p = 0; p <= k;p++){
                    contI += (l[i][p] * u[p][k]);
                }

                if(l[k][k] != 0){
                    l[i][k] = (matCoef[i][k] - contI)/u[k][k];
                }else{
                    throw new Exception("Posiblemente no tiene solución el sistema");
                }

            }

            for(int j = k+1; j < n;j++){

                contJ = 0;

                for(int p = 0; p <= k;p++){
                    contJ += (l[k][p] * u[p][j]);
                }

                if(l[k][k] != 0) {
                    u[k][j] = (matCoef[k][j] - contJ) / l[k][k];
                }else{
                    throw new Exception("Posiblemente no tiene solución el sistema");
                }
            }

        }

        System.out.println("Mat L");
        for(int i = 0; i < n;i++){
            System.out.print("[");
            for(int j = 0; j < n;j++){
                System.out.print("  "+ l[i][j] + "  ");
            }
            System.out.println("]");
        }

        System.out.println("Mat U");
        for(int i = 0; i < n;i++){
            System.out.print("[");
            for(int j = 0; j < n;j++){
                System.out.print("  "+ u[i][j] + "  ");
            }
            System.out.println("]");
        }

        for(int i = 0;i < n; i++){    //Sust Progresiva

            cont = 0;
            for(int j = 0; j < i; j++){
                cont += l[i][j] * aux[j];
            }

            aux[i] = (solCoef[i]-cont)/l[i][i];
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
