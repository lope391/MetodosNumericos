/**
 * Created by Lope on 9/27/2016.
 */
public class Newton {

    private Funcion fX;

    public Newton(Funcion f) {
        fX = f;
    }

    public double[] evaluar(double tol, double x0, int iter, boolean errorAbs) throws Exception{

        double[] res;
        double eval = fX.evaluar(x0);
        double eval1 = fX.evaluarDer(x0);
        int cont = 0;
        System.out.println("It:" + 0 + "  --  Xi: " + x0 + "  -----  " + "F(x): " + eval + "  -----  " + "Error: ");
        double err = tol + 1;
        double x1;

        if(iter > 0){
            if(tol > 0){
                while(eval != 0 && err > tol && eval1 != 0 && cont < iter){

                    x1 = x0 - (eval/eval1);
                    eval = fX.evaluar(x1);
                    eval1 = fX.evaluarDer(x1);

                    if(errorAbs){
                        err = Math.abs(x1-x0);
                        System.out.println("It:" + (cont + 1) + "  --  Xi: " + x1 + "  -----  " + "F(x): " + eval + "  -----  " + "Error Absoluto: " + err);
                    }else{
                        err = Math.abs(x1-x0)/x1;
                        System.out.println("It:" + (cont + 1) + "  --  Xi: " + x1 + "  -----  " + "F(x): " + eval + "  -----  " + "Error Relativo: " + err);
                    }
                    x0 = x1;
                    cont++;

                }

                if(eval == 0){

                    res = new double[]{x0,0};
                    return res;

                }else if(err < tol){

                    res = new double[]{x0,err};
                    return res;

                }else if(eval1 == 0){
                    throw new Exception("Posible raiz multiple");
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
}
