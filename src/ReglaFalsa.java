/**
 * Created by Lope on 9/19/2016.
 */
public class ReglaFalsa {

    private Funcion f;

    public ReglaFalsa(Funcion fun) {
        f = fun;
    }

    public double[] evaluar(double xi, double xf, int iter, double tol) throws Exception{

        double[] res;
        double evalXi = f.evaluar(xi);
        double evalXf = f.evaluar(xf);

        if(evalXf == 0){

            res = new double[]{xf,0};
            return res;

        }else if(evalXi == 0){

            res = new double[]{xi,0};
            return res;

        }else{

            if(evalXf*evalXi < 0){

                if(iter > 0){

                    if(tol > 0){

                        double xAnt;
                        double xm = xi - (evalXi*(xi-xf))/(evalXi - evalXf);
                        double evalXm = f.evaluar(xm);
                        double err = tol + 1;
                        int cont = 1;

                        while(evalXm != 0 && err > tol && cont < iter){

                            if(evalXm*evalXi > 0){

                                xi = xm;
                                evalXi = evalXm;

                            }else{

                                xf = xm;
                                evalXf = evalXm;

                            }

                            xAnt = xm;
                            xm = xi - (evalXi*(xi-xf))/(evalXi - evalXf);
                            evalXm = f.evaluar(xm);
                            err = Math.abs(xm-xAnt);
                            cont++;
                        }

                        if(evalXm == 0){

                            res = new double[]{xm,0};
                            return res;

                        }else if(err < tol){

                            res = new double[]{xm,err};
                            return res;

                        }else{
                            throw new Exception("Error: Exedio iteraciones");
                        }

                    }else{
                        throw new Exception("Error: Tolerancia menor o igual a 0");
                    }
                }else{
                    throw new Exception("Error: Iteraciones menores o igual a 0");
                }
            }else{
                throw new Exception("Error: Intervalo mal definido");
            }

        }
    }
}
