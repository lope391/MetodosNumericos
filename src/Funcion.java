/**
 * Created by lope1 on 9/10/2016.
 */
public class Funcion {

    public Funcion() {
    }

    public double evaluar(double x1){

        double ans = Math.log((x1*x1)+1)*Math.exp(-x1+2);
        return ans;
    }

    public double evaluarG(double x1){

        double ans = x1-(((x1*x1*x1)+(4*x1*x1)-10)/((3*x1*x1)+(8*x1)));
        return ans;
    }

    public double evaluarDer(double x1){

        double ans = (4*x1*x1*x1)-(36*x1);
        return ans;
    }

    public double evaluarDer2(double x1){

        double ans = (12*x1*x1)-36;
        return ans;
    }
}
