/**
 * Created by lope1 on 10/24/2016.
 */
public class MetIter {


    public double[][] evaluar(double[] x0,double tol, int iter, double[][] matA, double[] vecB, double rel, boolean jac) throws Exception{

        int cont = 0;
        double disp = tol +1;
        double[] x1;
        double[] aux;

        if(iter > 0){
            if(tol > 0){

            while(disp > tol && cont < iter){

                if(jac){
                    x1 = calcX1Jac(x0, matA, vecB);
                }else{
                    x1 = calcX1Seid(x0, matA, vecB);
                }

                aux = restaVec(x1,x0);
                disp = calcNorma(aux)/calcNorma(x1);

                System.out.println("Iteración " + cont);
                for (int i = 0; i < x0.length;i++){
                    System.out.println("X[" + i + "] "+ x1[i]);
                }

                for(int i = 0; i < x0.length; i++){

                    x1[i] = (rel*x1[i])+((1-rel)*x0[1]);

                }

                x0 = x1;
                cont++;
            }
            if(disp < tol){

                double[][] res = {x0,{disp}};
                return res;

            }else{
                throw new Exception("Error: Exedio iteraciones");
            }


            }else{
                throw new Exception("Tolerancia menor que 0");
            }
        }else{
            throw new Exception("Iteraciones menores o iguales que 0");
        }
    }

    public double[] calcX1Jac(double[] x0, double[][] matA, double[] vecB) throws Exception{

        int n = x0.length;
        double[] res = new double[n];
        double cont;

        for(int i = 0; i < n; i++){
            cont = 0;
            for(int j = 0; j < n; j++){
                if(i != j){
                    cont += matA[i][j]*x0[j];
                }
            }
            if(matA[i][i] != 0){
                res[i] = (vecB[i] - cont)/matA[i][i];
            }else{
                throw new Exception("El sistema posiblemente no tiene solucion");
            }
        }

        return res;

    }

    public double[] calcX1Seid(double[] x0, double[][] matA, double[] vecB) throws Exception{

        int n = x0.length;
        double[] res = new double[n];
        double cont;

        for(int i = 0; i < n; i++){
            res[i] = x0[i];
        }

        for(int i = 0; i < n; i++){
            cont = 0;
            for(int j = 0; j < n; j++){
                if(i != j){
                    cont += matA[i][j]*res[j];
                }
            }
            if(matA[i][i] != 0){
                res[i] = (vecB[i] - cont)/matA[i][i];
            }else{
                throw new Exception("El sistema posiblemente no tiene solucion");
            }
        }

        return res;

    }


    public double calcNorma(double[] x0){

        double cont = 0;

        for(int i = 0; i < x0.length;i++){

            cont += Math.abs(x0[i]) * Math.abs(x0[i]);

        }
        return Math.sqrt(cont);

    }

    public double[] restaVec(double[] x0, double[] x1) {

        int n = x0.length;
        double[] res = new double[n];

        for(int i = 0; i < n; i++){
            res[i] = x0[i] - x1[i];
        }

        return res;
    }


}
