/**
 * Created by lope1 on 9/27/2016.
 */
public class RaizMult {

    private Funcion fX;

    public RaizMult(Funcion f) {
        fX = f;
    }

    public double[] evaluar(double tol, double x0, int iter, boolean errorAbs) throws Exception{

        double[] res;
        double eval = fX.evaluar(x0);

        if(eval != 0) {
            if (iter > 0) {
                if (tol > 0) {

                    double xa;
                    double der1 = fX.evaluarDer(x0);
                    double der2 = fX.evaluarDer2(x0);
                    double err = tol + 1;
                    double den = (der1*der1)-(eval*der2);
                    int cont = 0;
                    System.out.println("It:" + 0 + "  --  Xi: " + x0 + "  -----  " + "F(x): " + eval + "  -----  " + "F'(x): " + der1 + "  -----  " + "F''(x): " + der2 + "  -----  " + "Error: ");

                    while (err > tol && eval != 0 && den != 0 && cont < iter) {

                        xa = x0;
                        x0 = x0 - ((eval*der1)/den);
                        eval = fX.evaluar(x0);
                        der1 = fX.evaluarDer(x0);
                        der2 = fX.evaluarDer2(x0);
                        den = (der1*der1)-(eval*der2);

                        if (errorAbs) {
                            err = Math.abs(x0 - xa);
                            System.out.println("It:" + (cont+1) + "  --  Xi: " + x0 + "  -----  " + "F(x): " + eval + "  -----  " + "F'(x): " + der1 + "  -----  " + "F''(x): " + der2 + "  -----  " + "Error Absoluto: " + err);
                        } else {
                            err = Math.abs((x0 - xa) / x0);
                            System.out.println("It:" + (cont+1) + "  --  Xi: " + x0 + "  -----  " + "F(x): " + eval + "  -----  " + "F'(x): " + der1 + "  -----  " + "F''(x): " + der2 + "  -----  " + "Error Relativo: " + err);
                        }
                        cont++;

                    }

                    if (der1 == 0) {

                        res = new double[]{x0, 0};
                        return res;

                    } else if (err < tol) {

                        res = new double[]{x0, err};
                        return res;

                    } else if(den == 0) {
                        throw new Exception("Multiplicidad mayor a 2");
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
