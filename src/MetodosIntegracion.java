/**
 * Created by Lope on 11/5/2016.
 */
public class MetodosIntegracion {

    Funcion fun;

    public MetodosIntegracion(Funcion f){

        fun = f;

    }

    public double trapecioSencillo(double a, double b) throws Exception{

        double h = (b - a) / 2;
        double eval = fun.evaluar(a) + fun.evaluar(b);
        double res = h * eval;

        return res;

    }

    public double trapecioCompuesto(double a, double b, int n) throws Exception{

        if(n > 0) {
            double h = (b-a)/n;
            double aAux = a;
            double cont = fun.evaluar(a) + fun.evaluar(b);

            for(int i = 0; i < n-1; i++){
                aAux += h;
                cont += 2*fun.evaluar(aAux);
            }

            double res = (h/2)*(cont);
            return res;
        }else{
            throw new Exception("Iteraciones menores o Iguales a 0");
        }
    }

    public double simpsonUnTercio(double a, double b){

        double h = (b-a)/3;
        double aMedia = (a+b)/2;
        double eval = fun.evaluar(a) + fun.evaluar(b) + (4*fun.evaluar(aMedia));
        double res = (h/2)*eval;
        return res;

    }

    public double simpsonUnTercioGen(double a, double b, int n) throws Exception{

        if(n > 0) {
            double h = (b-a)/n;
            double aAux = a;
            double cont = fun.evaluar(a) + fun.evaluar(b);

            for(int i = 2; i < n; i = i+2){
                aAux = a + (i*h);
                cont += 2*fun.evaluar(aAux);
            }

            for(int i = 1; i < n; i = i+2){
                aAux = a + (i*h);
                cont += 4*fun.evaluar(aAux);
            }

            double res = (h/3)*(cont);
            return res;

        }else{
            throw new Exception("Iteraciones menores o Iguales a 0");
        }
    }

    public double simpsonTresOctavos(double a, double b){

        double h = (b-a)/3;
        double a1 = a + h;
        double a2 = a + h + h;
        double eval = fun.evaluar(a) + fun.evaluar(b) + 3*fun.evaluar(a1) + 3*fun.evaluar(a2);
        double res = ((3*h)/8)*eval;
        return res;
    }

    public double simpsonTresOctavosGen(double a, double b, int n) throws Exception{

        if(n > 0){
            double h = (b-a)/n;
            double aAux;
            double cont = fun.evaluar(a) + fun.evaluar(b);

            for(int i = 1; i < n; i++){
                aAux = a + (i*h);

                if(i % 3 == 0) {
                    cont += 2 * fun.evaluar(aAux);
                }else{
                    cont += 3 * fun.evaluar(aAux);
                }
            }

            double res = ((3*h)/8)*cont;
            return res;
        }else{
            throw new Exception("Iteraciones menores o iguales a 0");
        }

    }

}
