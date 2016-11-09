/**
 * Created by lope1 on 9/26/2016.
 */
public class PuntoFijo {

    private Funcion fX;

    public PuntoFijo(Funcion f) {

        fX = f;

    }

    public double[] evaluar(double tol, double xi, int iter, boolean errorAbs) throws Exception{

        double[] res;
        double err = tol + 1;
        double eval = fX.evaluar(xi);
        int cont = 0;
        System.out.println("It:" + 0 + "  --  Xi: " + xi + "  -----  " + "F(x): " + eval + "  -----  " + "Error: ");
        double xa;

        if(iter > 0){
            if(tol > 0){
                while(eval != 0 && err > tol && cont < iter){

                    xa = xi;
                    xi = fX.evaluarG(xi);
                    eval =  fX.evaluar(xi);

                    if(errorAbs){
                        err = Math.abs(xi-xa);
                        System.out.println("It:" + (cont + 1) + "  --  Xi: " + xi + "  -----  " + "F(x): " + eval + "  -----  " + "Error Absoluto: " + err);
                    }else{
                        err = Math.abs(xi-xa)/xi;
                        System.out.println("It:" + (cont + 1) + "  --  Xi: " + xi + "  -----  " + "F(x): " + eval + "  -----  " + "Error Relativo: " + err);
                    }
                    cont++;

                }

                if(eval == 0){

                    res = new double[]{xi,0};
                    return res;

                }else if(err < tol){

                    res = new double[]{xi,err};
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


}
