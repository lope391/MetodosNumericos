/**
 * Created by lope1 on 9/10/2016.
 */
public class MetodoNumerico {

    public MetodoNumerico(){

    }

    public double[] intervaloInclemental(Funcion f, int iter, double dX, double x0) throws Exception {

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

    public double[] biseccion(Funcion f, double xi, double xf, int iter, double tol) throws Exception{

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
                        double xm = (xi+xf)/2;
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
                            xm = (xi+xf)/2;
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

    public double[] busquedaFalsa(Funcion f, double xi, double xf, int iter, double tol) throws Exception{

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
