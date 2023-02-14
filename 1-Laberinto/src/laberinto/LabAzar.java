package laberinto;
import java.util.Random;
public class LabAzar {
    private static final int FILAS=60;
    private static final int COLUMNAS=80;
    private char[][] Lab;
    
    public LabAzar () {
        Lab = new  char[FILAS][COLUMNAS];
        Random rand = new Random();
        inicializacion();
        inicioFinal();
    }

    public void mostrar (){
        for (int f=0; f<FILAS; f++){
            for (int c=0; c<COLUMNAS; c++){
                System.out.print(Lab[f][c]);
            }
            System.out.println("");
        }
    }
    private void inicializacion (){
        for (int f=0; f<FILAS; f++){
            for (int c=0; c<COLUMNAS; c++){
                Lab[f][c]=' ';
            }
        }
    }

    private void inicioFinal(){
        Random fil = new Random();
        Random col = new Random();
        int filant=0;
        int colant=0;
        int cont=0;
        while (cont<2){
            int randfil=fil.nextInt(FILAS);
            int randcol=col.nextInt(COLUMNAS);
            if (cont==0){
                Lab[randfil][randcol]='I';
                cont++;
            }else{
                if(!(randfil==filant && randcol==colant)){
                    cont++;
                    Lab[randfil][randcol]='G';
                }
            }
            filant=randfil;
            colant=randcol;
        }
    }

}
