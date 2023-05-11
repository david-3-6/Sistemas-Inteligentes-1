package sudoku;

public class SudokuMasterResolutor {
	
	public static int[] resolverSudoku(Sudokux sudo, int poblacionInicial) {
		//VAMOS A ASEGURAR QUE SE CUMPLE LA RESTRICCIONES DE FILA, ES DECIR
		//TODAS LAS FILAS TIENEN NUMEROS DIFERENTES
		Gen inicial=new Gen(sudo);
		Gen[] poblacion=generarPoblacionInicial(inicial, poblacionInicial);
		/*for(int i=0; i<poblacion.length;i++) { // ver poblacion inicial
			System.out.println(poblacion[i].toString());
		}*/
		poblacion=Gen.crossover(poblacion);
		/*System.out.println("____________________________________");
		for(int i=0; i<poblacion.length;i++) { // ver poblacion cruzada
			System.out.println(poblacion[i].toString());
		}*/
		poblacion=Gen.mutacion(poblacion);
		/*System.out.println("____________________________________");
		for(int i=0; i<poblacion.length;i++) { // ver poblacion cruzada
			System.out.println(poblacion[i].toString());
		}*/
		
		return genToArray(sudo,poblacion[0]);
	}
	private static int[] genToArray(Sudokux sudo, Gen gen) {
		int[] sol=sudo.getPuzzle();
		for(int f=1;f<gen.getGen().size();f++) {
			for(int c=0; c<gen.getGen().get(f).size();c++) {
				gen.getGen().get(0).add(gen.getGen().get(f).get(c));
			}
		}
		int f=0;
		for(int i=0;i<sol.length;i++) {
			if(sol[i]==0) {
				sol[i]=gen.getGen().get(0).get(f);
				f++;
			}
		}
		return sol;
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
