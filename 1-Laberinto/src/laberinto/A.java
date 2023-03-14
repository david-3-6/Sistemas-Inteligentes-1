package laberinto;
import java.util.ArrayList;
import java.util.Arrays;

public class A {

    private LabAzar laberinto;
    private ArrayList<Nodo> closedSet=new ArrayList<>();
    private ArrayList<Nodo> openSet= new ArrayList<>();


    public A (LabAzar laber){
    	laberinto=laber;
        openSet.add(new Nodo(laber.Inicial[0],laber.Inicial[1],laber.Fin[0],laber.Fin[1],null));
    }
    
    public void camino () {
    	Nodo nodoActual=openSet.get(0);
    	int iter=1;
    	while((openSet.size()>0) && (nodoActual.getX()!=laberinto.Fin[0] || nodoActual.getY()!=laberinto.Fin[1])) {
    		nuevosNodos(nodoActual, iter);
    		
    		closedSet.add(nodoActual);
    		openSet.remove(nodoActual);
    		nodoActual=elegirNuevoActual();
    		laberinto.Lab[nodoActual.getX()][nodoActual.getY()]='+';
    		laberinto.mostrar();
    		
    	}
    	
    	System.out.println("\n \n \n \n \n ");
    	colorear(nodoActual.n);

    }
    private Nodo elegirNuevoActual() {
    	Nodo AC=openSet.get(0);
    	int distmin=openSet.get(0).getDist();
    	for(int i=1; i<openSet.size();i++) {
    		if(openSet.get(i).getDist()<distmin) {
    			distmin=openSet.get(i).getDist();
    			AC=openSet.get(i);
    		}
    	}
    	return AC;
    }
    private void nuevosNodos (Nodo n, int iter) {
    	int X=n.getX();
    	int Y=n.getY();
    	for(int i=0; i<4;i++) {
    		switch (i) {
    			case 0:
    				
    				if(X-1>=0 && laberinto.Lab[X-1][Y]!='*' && buscar(X-1,Y)<0) {
    					Nodo nodo=new Nodo(X-1, Y, laberinto.Fin[0],laberinto.Fin[1],n);
    					nodo.modDist(iter);
    					openSet.add(nodo);
    				}
    				break;
    			case 1:
    				if(X+1<laberinto.FILAS && laberinto.Lab[X+1][Y]!='*' && buscar(X+1,Y)<0) {
    					Nodo nodo=new Nodo(X+1, Y, laberinto.Fin[0],laberinto.Fin[1],n);
    					nodo.modDist(iter);
    					openSet.add(nodo);
    				}
    			break;
    			case 2:
    				if(Y-1>=0 && laberinto.Lab[X][Y-1]!='*' && buscar(X,Y-1)<0) {
    					Nodo nodo=new Nodo(X, Y-1, laberinto.Fin[0],laberinto.Fin[1],n);
    					nodo.modDist(iter);
    					openSet.add(nodo);
    				}
    			break;
    			case 3:
    				if(Y+1<laberinto.COLUMNAS && laberinto.Lab[X][Y+1]!='*' && buscar(X,Y+1)<0) {
    					Nodo nodo=new Nodo(X, Y+1, laberinto.Fin[0],laberinto.Fin[1],n);
    					nodo.modDist(iter);
    					openSet.add(nodo);
    				}
    			break;
    			default: throw new RuntimeException("Error de acceso");
    		}
    	}
    }
    private int buscar (int X, int Y) {
    	int pos=-1;
    	for(int i=0; i<closedSet.size() && pos<0;i++) {
    		if(closedSet.get(i).getX()==X && closedSet.get(i).getY()==Y) {
    			pos=i;
    		}
    	}
    	
    	return pos;
    }
    public void colorear(Nodo nodito) {
    	while(nodito.n!=null) {
    		laberinto.Lab[nodito.getX()][nodito.getY()]='+';
    		nodito=nodito.n;
    	}
    }
    
}
