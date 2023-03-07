package laberinto;
import java.lang.Math;
public class Nodo {
    private int CorX;
    private int CorY;
    private int Dist;

    public Nodo(int X1, int Y1, int X2, int Y2){
        CorX = X1;
        CorY = Y1;
        Dist= Math.abs(X1-X2)+Math.abs(Y1-Y2);
    }






}
