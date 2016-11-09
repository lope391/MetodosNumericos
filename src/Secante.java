/**
 * Created by Lope on 9/27/2016.
 */
public class Secante {

    private Funcion fX;

    public Secante(Funcion f) {

        fX = f;

    }

    public double[] evaluar(double tol, double x0, double x1, int iter, boolean errorAbs) throws Exception{

        double[] res;
        double eval = fX.evaluar(x0);

        if(eval != 0) {
            if (iter > 0) {
                if (tol > 0) {

                    double x2;
                    double err = tol + 1;
                    double eval1 = fX.evaluar(x1);
                    double den  = eval1 - eval;
                    int cont = 0;
                    System.out.println("It:" + 0 + "  --  Xi: " + x0 + "  -----  " + "F(x): " + eval + "  -----  " + "Error: ");
                    System.out.println("It:" + 1 + "  --  Xi: " + x1 + "  -----  " + "F(x): " + eval1 + "  -----  " + "Error: ");

                    while (err > tol && eval1 != 0 && den != 0 && cont < iter) {


                        x2 = x1-((eval1*(x1-x0))/den);
                        eval = eval1;
                        x0 = x1;
                        x1 = x2;
                        eval1 = fX.evaluar(x1);
                        den = eval1 - eval;

                        if (errorAbs) {
                            err = Math.abs(x1 - x0);
                            System.out.println("It:" + (cont + 2) + "  --  Xi: " + x2 + "  -----  " + "F(x): " + eval1 + "  -----  " + "Error Absoluto: " + err);
                        } else {
                            err = Math.abs((x1 - x0) / x1);
                            System.out.println("It:" + (cont + 2) + "  --  Xi: " + x2 + "  -----  " + "F(x): " + eval1 + "  -----  " + "Error Relativo: " + err);
                        }
                        cont++;

                    }

                    if (eval1 == 0) {

                        res = new double[]{x1, 0};
                        return res;

                    } else if (err < tol) {

                        res = new double[]{x1, err};
                        return res;

                    } else if(den == 0) {

                        throw new Exception("Posible Raiz Multiple");

                    } else {
                        throw new Exception("Error: Exedio iteraciones");
                    }

                } else {
                    throw new Exception("Tolerancia menor que 0");
                }
            } else {
                throw new Exception("Iteraciones menores o iguales que 0");
            }
        }else{
            res = new double[] {x0,0};
            return res;
        }

    }

}
