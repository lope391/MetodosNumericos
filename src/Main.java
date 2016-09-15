/**
 * Created by Lope on 9/12/2016.
 */
public class Main {

    public static void main(String[] args){
        Funcion fun = new Funcion();
        MetodoNumerico metodo = new MetodoNumerico();

        try {
            //double[] res = metodo.intervaloInclemental(fun,20,0.5,0);
            //double[] res = metodo.biseccion(fun, -5, 10,20,0.1);
            double[] res = metodo.busquedaFalsa(fun, -5, 10,20,0.1);
            System.out.println("Raiz en - " + res[0] + " con tolerancia - " + res[1]);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

}
