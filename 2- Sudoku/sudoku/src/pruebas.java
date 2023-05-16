import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import sudoku.*;
public class pruebas {
	public static final int POBLACION_INICIAL=200, PROBABILIDAD_CRUCE=100, PROBABILIDAD_MUTACION=20;
	public static final double CONSTANTE_ESCALADO_FITNESS=0.07;
	public static void main(String[] args) {
        Sudokux sudo=new Sudokux(1);
        System.out.println(sudo.toString());
        try(PrintWriter pw=new PrintWriter(new FileWriter("out.txt",false))){
        	pw.println(sudo.toString());
        	pw.println("\n");
        } catch (IOException e) {
			System.out.println("Salida .txt erronea");
		}
        int[] sol=SudokuMasterResolutor.resolverSudoku(sudo,POBLACION_INICIAL, PROBABILIDAD_CRUCE, PROBABILIDAD_MUTACION, CONSTANTE_ESCALADO_FITNESS);
        sudo.setPuzzle(sol);
        System.out.println(sudo.toString());
        try(PrintWriter pw=new PrintWriter(new FileWriter("out.txt",true))){
        	pw.println(sudo.toString());
        } catch (IOException e) {
			System.out.println("Salida .txt erronea");
		}
    }    
    
}
