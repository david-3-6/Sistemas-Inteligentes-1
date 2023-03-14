package laberinto;
import java.util.ArrayList;
import java.util.Arrays;

public class A {

    private LabAzar laberinto;
    private ArrayList<Nodo> closedSet;
    private ArrayList<Nodo> openSet;


    public A (LabAzar laber){
    	laberinto=laber;
        openSet.add(new Nodo(laber.Inicial[0],laber.Inicial[1],laber.Fin[0],laber.Fin[1]));
    }
    
    public void camino () {
    	Nodo nodoActual=new Nodo(openSet.get(0));
    	int iter=0;
    	while((openSet.size()>0) && (nodoActual.getX()!=laberinto.Fin[0] && nodoActual.getY()!=laberinto.Fin[1])) {
    		nuevosNodos(openSet.get(0),laberinto);
    	}

    }
    private void nuevosNodos (Nodo n, LabAzar laber) {
    	int X=n.getX();
    	int Y=n.getY();
    	for(int i=0; i<4;i++) {
    		
    	}
    }
    
}
