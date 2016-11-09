/**
 * Created by Murillo on 9/19/2016.
 */
public class PivoteoParcial {
  private double A;

  public PivoteoParcial(double[][] A) {
    this.A = A;
  }

  public double [][] evaluar(int k)throws Exception{
    double mayor=Math.abs(A[k][k]);
    int filaMayor=k;
    int n = A.length;
    for(int i=k+1;i<n;i++){
        if(Math.abs(A[i][k])>mayor){
            mayor=Math.abs(A[i][k]);
            filaMayor=i;
        }
    }
    if(mayor==0){
        throw new Exception("El sistema no tiene solucion unica");
    }else{
        if(filaMayor!=k){
            //double[]aux=new double[A[filaMayor].length];
            double [] aux=A[filaMayor];
            A[filaMayor]=A[k];
            A[k]=aux;
        }
    }

    return A;
  }
}
