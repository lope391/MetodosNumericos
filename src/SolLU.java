/**
 * Created by lope1 on 10/23/2016.
 */
public class SolLU {

    private double[][] matL;
    private double[][] matU;

    public SolLU(double[][] l, double[][] u){

        matL = l;
        matU = u;

    }

    public double[][] getMatL() {
        return matL;
    }

    public double[][] getMatU() {
        return matU;
    }

    public void setValL(int f, int c, double val){

        matL[f][c] = val;
    }

    public double[] sustProg(double[] vecSol){

        int n = vecSol.length;
        double cont;
        double[] res = new double[n];

        for(int i = 0;i < n; i++){

            cont = 0;
            for(int j = 0; j < i; j++){
                cont += matL[i][j] * res[j];
            }

            res[i] = (vecSol[i]-cont)/matL[i][i];
        }

        return res;
    }

    public double[] sustReg(double[] vecSol){

        int n = vecSol.length;
        double cont;
        double[] res = new double[n];

        for(int i = n-1;i >= 0; i--){

            cont = 0;
            for(int j = n-1; j > i; j--){
                cont += matU[i][j] * res[j];
            }

            res[i] = (vecSol[i]-cont)/matU[i][i];
        }

        return res;
    }

    public void toaString(){
        int n = matL.length;

        for (int i = 0; i < n; i++){
            System.out.print('[');
            for (int j = 0; j < n; j++){
                System.out.print("  " + matL[i][j] + "  ");
            }
            System.out.print(']');
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.print("\n");

        for (int i = 0; i < n; i++){
            System.out.print('[');
            for (int j = 0; j < n; j++){
                System.out.print("  " + matU[i][j] + "  ");
            }
            System.out.print(']');
            System.out.print("\n");
        }
    }
}
