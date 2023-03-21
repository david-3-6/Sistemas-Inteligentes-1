package laberinto;

public class Nodo {
    private int CorX;
    private int CorY;
    private int Dist; //Realmente es el peso del nodo
    protected Nodo n;

    public Nodo(int X1, int Y1, int X2, int Y2){
        CorX = X1;
        CorY = Y1;
        Dist= Math.abs(X1-X2)+Math.abs(Y1-Y2);
        
    }
    public Nodo(int X1, int Y1, int X2, int Y2, Nodo nodo) {
    	this(X1,Y1,X2,Y2);
    	n=nodo;
        addDist();
    }
    public int getX() {
    	return CorX;
    }
    public int getY() {
    	return CorY;
    }
    public int getDist() {
    	return Dist;
    }
    public void modDist(int nuevaDist){
        Dist=nuevaDist;
    }
    public void modN(Nodo nodo){
        n=nodo;
    }
    public Nodo getN(){
        return n;
    }
    public void modY(int y){
        CorY=y;
    }
    private void addDist(){
        int distanciaInicio=0;
        Nodo nodox=n;
        while(nodox!=null){
            nodox=nodox.n;
            distanciaInicio++;
        }
        //System.out.println("Encontrado: "+Integer.toString(distanciaInicio+Dist));
        Dist+=distanciaInicio;
    }






}
