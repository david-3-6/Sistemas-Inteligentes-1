package sudoku;
import java.util.ArrayList;
import java.util.List;

public class SudokuMasterResolutor {
	
	public static int[] resolverSudoku(Sudokux sudo, int poblacionInicial) {
		//VAMOS A ASEGURAR QUE SE CUMPLE LA RESTRICCIONES DE FILA, ES DECIR
		//TODAS LAS FILAS TIENEN NUMEROS DIFERENTES
		int[] completo=sudo.getPuzzle();
		Gen[] poblacion=new Gen[20];
		Gen primero=new Gen(sudo); //TODO aqui me quedo (hay que generar primer gen distinto de 0)
		return completo;
	}

	
	
	
}
