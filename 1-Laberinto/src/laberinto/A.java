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
    
    public void camino () {
    	Nodo nodoActual=openSet.get(0);
    	while((openSet.size()>0) && (nodoActual.getX()!=laberinto.Fin[0] || nodoActual.getY()!=laberinto.Fin[1])) {
    		nuevosNodos(nodoActual);
    		closedSet.add(nodoActual);
    		openSet.remove(nodoActual);
			if(openSet.size()<=0){
				throw new RuntimeException("No hay camino");
			}else{
				nodoActual=elegirNuevoActual();
			}
    		//laberinto.Lab[nodoActual.getX()][nodoActual.getY()]='O';
			//System.out.println("\n \n \n \n \n ");
    		//laberinto.mostrar();
    		
    	}
    	
    	//System.out.println("\n \n \n \n \n ");
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
    private void nuevosNodos (Nodo n) {
    	int X=n.getX();
    	int Y=n.getY();
    	for(int i=0; i<4;i++) {
    		switch (i) {
    			case 0:
    				if(X-1>=0 && laberinto.Lab[X-1][Y]!='\u2588' && buscarCerrado(X-1,Y)<0) {
						int pos=buscarAbierto(X-1, Y);
						int distmin=0;
						if(pos>=0){
							distmin=openSet.get(pos).getDist();
						}
						Nodo nodo=new Nodo(X-1, Y, laberinto.Fin[0],laberinto.Fin[1],n);
						rutina(pos, distmin, nodo);
    				}
    				break;
    			case 1:
					if(X+1<laberinto.FILAS && laberinto.Lab[X+1][Y]!='\u2588' && buscarCerrado(X+1,Y)<0) {
						int pos=buscarAbierto(X+1, Y);
						int distmin=0;
						if(pos>=0){
							distmin=openSet.get(pos).getDist();
						}
						Nodo nodo=new Nodo(X+1, Y, laberinto.Fin[0],laberinto.Fin[1],n);
						rutina(pos, distmin, nodo);
					}
    			break;
    			case 2:
					if(Y-1>=0 && laberinto.Lab[X][Y-1]!='\u2588' && buscarCerrado(X,Y-1)<0) {
						int pos=buscarAbierto(X, Y-1);
						int distmin=0;
						if(pos>=0){
							distmin=openSet.get(pos).getDist();
						}
						Nodo nodo=new Nodo(X, Y-1, laberinto.Fin[0],laberinto.Fin[1],n);
						rutina(pos, distmin, nodo);
					}
    			break;
    			case 3:
					if(Y+1<laberinto.COLUMNAS && laberinto.Lab[X][Y+1]!='\u2588' && buscarCerrado(X,Y+1)<0) {
						int pos=buscarAbierto(X, Y+1);
						int distmin=0;
						if(pos>=0){
							distmin=openSet.get(pos).getDist();
						}
						Nodo nodo=new Nodo(X, Y+1, laberinto.Fin[0],laberinto.Fin[1],n);
						rutina(pos, distmin, nodo);
					}
    			break;
    			default: throw new RuntimeException("Error de acceso");
    		}
			
    	}
    }
	private void rutina (int pos, int distmin, Nodo nodo ){
		if(pos<0 || nodo.getDist()<distmin){
			if(pos<0){
				openSet.add(nodo);
				//laberinto.Lab[nodo.getX()][nodo.getY()]='X';
			}else{
				openSet.get(pos).modDist(nodo.getDist());
				openSet.get(pos).modN(nodo.getN());
				//laberinto.Lab[nodo.getX()][nodo.getY()]='X';
			}
		}
	}
    /*private int calcDistMin(int x, int y, int pos) {
		int distmin=openSet.get(pos).getDist();
		for(int i=0; i<openSet.size();i++){
			if(openSet.get(i).getX()==x && openSet.get(i).getY()==y&&openSet.get(i).getDist()<distmin){
				distmin=openSet.get(i).getDist();
			}
		}
		return distmin;

	}*/

	private int buscarCerrado (int X, int Y) {
    	int pos=-1;
    	for(int i=0; i<closedSet.size() && pos<0;i++) {
    		if(closedSet.get(i).getX()==X && closedSet.get(i).getY()==Y) {
    			pos=i;
    		}
    	}
    	
    	return pos;
    }
	private int buscarAbierto(int X, int Y){
		int pos=-1;
    	for(int i=0; i<openSet.size() && pos<0;i++) {
    		if(openSet.get(i).getX()==X && openSet.get(i).getY()==Y) {
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
