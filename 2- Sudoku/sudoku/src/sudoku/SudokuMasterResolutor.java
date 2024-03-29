package sudoku;
import java.util.Arrays;
public class SudokuMasterResolutor {
	
	public static int[] resolverSudoku(Sudokux sudo, int poblacionInicial, int probabilidadCruce, int probabilidadMutacion, double constanteEscalado) {
		//VAMOS A ASEGURAR QUE SE CUMPLE LA RESTRICCIONES DE FILA, ES DECIR
		//TODAS LAS FILAS TIENEN NUMEROS DIFERENTES
		Gen inicial=new Gen(sudo);
		Gen[] poblacion=generarPoblacionInicial(inicial, poblacionInicial);
		determinarFitness(poblacion, sudo);
		Arrays.sort(poblacion);
		while (poblacion[poblacion.length-1].getFitness()!=Sudokux.getBoardSize()*2) {
			poblacion=Gen.crossover(poblacion, probabilidadCruce);
			poblacion=Gen.mutacion(poblacion, probabilidadMutacion);
			determinarFitness(poblacion, sudo);
			Arrays.sort(poblacion);
			System.out.println(poblacion[poblacion.length-1].getFitness());
		}
		return poblacion[poblacion.length-1].toArray(sudo);
	}
	private static void determinarFitness(Gen[] poblacion, Sudokux sudo) {
		for(Gen x:poblacion) {
			x.refreshFitness(sudo);
		}
	}
	

	private static Gen[] generarPoblacionInicial(Gen inicial, int poblacionInicial) {
		Gen[] sol=new Gen[poblacionInicial];
		sol[0]=inicial;
		int i=1;
		while(i<poblacionInicial) {
			Gen aux=new Gen(inicial,true);
			int pos=buscarGen(aux, sol);
			if(pos<0) {
				sol[i]=aux;
				i++;
			}
		}
		return sol;
	}
	private static int buscarGen(Gen gen, Gen[] genes) {
		int pos=-1;
		for(int i=0; i< genes.length && pos<0;i++) {
			pos= gen.equals(genes[i]) ? i : pos;
		}
		return pos;
	}

	
	
	
}
