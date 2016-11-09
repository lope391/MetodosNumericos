/**
 * Created by Murillo on 9/19/2016.
 */
public class EliminacionGaussianaSimple {
  private double A;

  public EliminacionGaussianaSimple(double[][] A) {
    this.A = A;
  }

  public double [][] evaluar(){
    int n=A.length;
    //agregar pivoteo seleccionado
        for(int k=0;k<n-1;k++){
            for(int i=k+1;i<n;i++){
                double multiplicador = A[i][k]/A[k][k];
                for(int j=k;j<n;j++){
                    A[i][j] -= multiplicador*A[k][j];
                }
            }
        }
        return A;
  }
}
