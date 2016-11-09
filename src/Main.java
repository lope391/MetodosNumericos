/**
 * Created by Lope on 9/12/2016.
 */
public class Main {

    public static void main(String[] args){

        Funcion fun = new Funcion();
//        ReglaFalsa rf = new ReglaFalsa(fun);
//        Biseccion bis = new Biseccion(fun);
//        IntIncrem intInc = new IntIncrem(fun);
//        PuntoFijo pf = new PuntoFijo(fun);
//        Secante sec = new Secante(fun);
//        Newton newt = new Newton(fun);
//        RaizMult raiz = new RaizMult(fun);
//        FactDirectaMat fdm = new FactDirectaMat();
//        MetIter jac = new MetIter();
//        LUGaus factlu = new LUGaus();
        MetodosIntegracion integ = new MetodosIntegracion(fun);

        double[][] mat = {
                {38,-6,4,-7},
                {2,-16,7,-3},
                {1,-6,43,-7},
                {5,-7,10,-56}
        };

        double[] vec = {321,32,28,-328};

        double[][] matA = {
                {13,-4,-5},
                {3,-7,2},
                {-4,5,-16},
        };
        double[] vecB = {-23,5,34};
        double[] x0 = {1,2,3};

        try {

//            System.out.println(integ.simpsonTresOctavosGen(2,4.4,12));

//            double[][] res = jac.evaluar(x0,0.00001,15,matA,vecB,1,false);
//
//            System.out.println("Solución: ");
//            for (int i = 0; i < res[0].length;i++){
//                System.out.println("X[" + (i+1) + "] "+ res[0][i]);
//            }
//            System.out.println("Con Error Relativo: " + res[1][0]);
//
//            double[] resF = factlu.evaluar(mat,vec);
//            System.out.println("Soluciones de X:");
//
//            for (int p=0;p < resF.length;p++){
//                System.out.println("X[" + (p+1) + "]: "+ resF[p]);
//            }

            //double[] res = intInc.evaluar(2   0,0.5,0);
            //double[] res = bis.evaluar( -5, 10,20,0.1);
            //double[] res = rf.evaluar(20,21,10,0.00000001);
            //double[] res = pf.evaluar(0.0000000001,-2.5,10,false);
            //double[] res = sec.evaluar(0.00000001, 20, 21, 10, true);
            //double[] res = newt.evaluar(0.000000001, -2.5, 100, true);
            //double[] res = raiz.evaluar(0.00000005,-2.5,10,false);
            //System.out.println("Raiz en - " + res[0] + " con tolerancia - " + res[1]);
//            double[] x = {2,2.2,2.4,2.6,2.8};
//            double[] y = {-4.610947901,-4.1745865,-3.376823619,-2.13626196499,-0.3553532289};
//            System.out.print(NewtDifDiv.evaluar(x,y,2.5));

            System.out.println(integ.simpsonTresOctavos(2,4.4));
            System.out.println(integ.simpsonTresOctavosGen(2,4.4,12));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

}