import sudoku.*;
public class pruebas {
	public static final int POBLACION_INICIAL=10000, PROBABILIDAD_CRUCE=95, PROBABILIDAD_MUTACION=10;
	public static final double CONSTANTE_ESCALADO_FITNESS=0.07;
	public static void main(String[] args) {
        Sudokux sudo=new Sudokux(2);
        System.out.println(sudo.toString());
        int[] sol=SudokuMasterResolutor.resolverSudoku(sudo,POBLACION_INICIAL, PROBABILIDAD_CRUCE, PROBABILIDAD_MUTACION, CONSTANTE_ESCALADO_FITNESS);
        sudo.setPuzzle(sol);
        System.out.println(sudo.toString());
    }    
    
}
