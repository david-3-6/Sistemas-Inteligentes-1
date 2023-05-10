import sudoku.*;
public class pruebas {
   public static void main(String[] args) {
        Sudokux sudo=new Sudokux(5);
        System.out.println(sudo.toString());
        SudokuMasterResolutor.resolverSudoku(sudo) ;
    }    
    
}
