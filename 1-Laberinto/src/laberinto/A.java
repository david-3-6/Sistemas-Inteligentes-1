//El tamaño del closed set no aumenta, es decir, no prueba nuevos puntos

package laberinto;
import java.util.ArrayList;

public class A {

    private LabAzar laberinto;
    private ArrayList<Nodo> closedSet=new ArrayList<>();
    private ArrayList<Nodo> openSet= new ArrayList<>();


    public A (LabAzar laber){
    	laberinto=laber;
        openSet.add(new Nodo(laber.Inicial[0],laber.Inicial[1],laber.Fin[0],laber.Fin[1],null));
    }
    int i=0;
    public void camino () {
    	Nodo nodoActual=openSet.get(0);
    	while((openSet.size()>0) && (nodoActual.getX()!=laberinto.Fin[0] || nodoActual.getY()!=laberinto.Fin[1])) {
			
			nuevosNodos(nodoActual);
			anyadir(nodoActual); //Añade a cerrados
			//closedSet.add(nodoActual);
			quitar(nodoActual); //Quitar todos los nodos actuales con esa coordenada de openSet
			
			if(openSet.size()<=0){
				throw new RuntimeException("No hay camino");
			}else{
				nodoActual=elegirNuevoActual();
			}
			i++;
			System.out.println("paso"+i+" TamOpen"+openSet.size()+"TamClose:"+closedSet.size());
			
    		//laberinto.Lab[nodoActual.getX()][nodoActual.getY()]='+';
			System.out.println("\n \n \n \n \n ");
			
    		//laberinto.mostrar();
    		
    	}
    	
    	System.out.println("\n \n \n \n \n ");
    	colorear(nodoActual.n);

    }
	private void quitar(Nodo nodo) {
		int X=nodo.getX(), Y=nodo.getY();
		for(int i=0; i<openSet.size();i++){
			if(openSet.get(i).getX()==X && Y==openSet.get(i).getY()){
				openSet.remove(i);
			}
			i++;
		}
	}
	private void anyadir(Nodo nodo){
		int X=nodo.getX(), Y=nodo.getY();
		int pos=-1;
		for(int i=0; i<closedSet.size() && pos<0;i++){
			if(X==closedSet.get(i).getX() && Y==closedSet.get(i).getY()){
				pos=i;
			}
		}
		if(pos<0){
			closedSet.add(nodo);
		}
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
    private void nuevosNodos (Nodo n) {
    	int X=n.getX();
    	int Y=n.getY();
    	for(int i=0; i<4;i++) {
    		switch (i) {
    			case 0:
    				
    				if(X-1>=0 && laberinto.Lab[X-1][Y]!='\u2588' && buscar(X-1,Y)<0) {
    					Nodo nodo=new Nodo(X-1, Y, laberinto.Fin[0],laberinto.Fin[1],n);
    					openSet.add(nodo);
    				}
    				break;
    			case 1:
    				if(X+1<laberinto.FILAS && laberinto.Lab[X+1][Y]!='\u2588' && buscar(X+1,Y)<0) {
    					Nodo nodo=new Nodo(X+1, Y, laberinto.Fin[0],laberinto.Fin[1],n);
    					openSet.add(nodo);
    				}
    			break;
    			case 2:
    				if(Y-1>=0 && laberinto.Lab[X][Y-1]!='\u2588' && buscar(X,Y-1)<0) {
    					Nodo nodo=new Nodo(X, Y-1, laberinto.Fin[0],laberinto.Fin[1],n);
    					openSet.add(nodo);
    				}
    			break;
    			case 3:
    				if(Y+1<laberinto.COLUMNAS && laberinto.Lab[X][Y+1]!='\u2588' && buscar(X,Y+1)<0) {
    					Nodo nodo=new Nodo(X, Y+1, laberinto.Fin[0],laberinto.Fin[1],n);
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
