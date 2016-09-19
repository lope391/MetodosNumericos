/**
 * Created by Lope on 9/12/2016.
 */
public class Main {

    public static void main(String[] args){
        Funcion fun = new Funcion();
        ReglaFalsa rf = new ReglaFalsa(fun);
        Biseccion bis = new Biseccion(fun);
        IntIncrem intInc = new IntIncrem(fun);

        try {
            double[] res = intInc.evaluar(20,0.5,0);
            //double[] res = bis.evaluar( -5, 10,20,0.1);
            //double[] res = rf.evaluar(-5, 10,20,0.1);
            System.out.println("Raiz en - " + res[0] + " con tolerancia - " + res[1]);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

}
