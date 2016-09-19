/**
 * Created by Lope on 9/19/2016.
 */
public class IntIncrem {

    private Funcion f;

    public IntIncrem(Funcion fun) {
        f = fun;
    }

    public double[] evaluar(int iter, double dX, double x0) throws Exception {

        double[] raiz;
        double eval = f.evaluar(x0);
        int cont = 0;

        if (eval == 0) {

            raiz = new double[]{x0, x0};
            return raiz;

        } else {
            if (dX != 0) {

                if (iter > 0) {

                    double x1 = x0 + dX;
                    double eval1 = f.evaluar(x1);
                    cont++;

                    while (eval * eval1 > 0 && cont < iter) {

                        x0 = x1;
                        eval = eval1;
                        x1 += dX;
                        eval1 = f.evaluar(x1);
                        cont++;

                    }

                    if (eval1 == 0) {
                        raiz = new double[]{x1, x1};
                        return raiz;
                    } else if (eval * eval1 < 0) {
                        raiz = new double[]{x0, x1};
                    } else {
                        throw new Exception("Error: Se supero numero de iteraciones");
                    }

                } else {
                    throw new Exception("Error: Iterador Menor o Igual a 0");
                }

            } else {
                throw new Exception("Error: Delta de X igual a 0");
            }

            return raiz;
        }
    }
}
