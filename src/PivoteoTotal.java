/**
 * Created by Murillo on 9/19/2016.
 */
public class PivoteoTotal {
  private double A;
  private int marcas;

  public PivoteoTotal(double[][] A, int marcas) {
    this.A = A;
    this.marcas= marcas;
  }
  public int [] getMarcas(){
    return marcas;
  }
  public double [][] evaluar(int k)throws Exception{
    double mayor=Math.abs(A[k][k]);
        int filaMayor=k;
        int columnaMayor=k;
        int n = A.length;
        for(int i=k;i<n;i++){
            for(int r=k;r<n;r++){
                if(Math.abs(A[i][r])>mayor){
                    mayor=Math.abs(A[i][k]);
                    filaMayor=i;
                    columnaMayor=r;
                }
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
            if(columnaMayor!=k){
                double[]aux=new double[A.length];
                for(int i=0; i<aux.length;i++){
                    aux[i]=A[i][columnaMayor];
                    A[i][columnaMayor]=A[i][k];
                    A[i][k]=aux[i];
                }
                int aux2=marcas[columnaMayor];
                marcas[columnaMayor]=marcas[k];
                marcas[k]=marcas[aux2];
            }
        }

        return A;
  }
}
