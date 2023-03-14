package laberinto;
import java.util.Random;
public class LabAzar {
    protected  final int FILAS=60;
    protected  final int COLUMNAS=80;
    private static final double OBSPORCENT=0.3;
    protected char[][] Lab;
    public int[] Inicial= new int[2];
    public int[] Fin= new int[2];
    
    public LabAzar () {
        Lab = new  char[FILAS][COLUMNAS];
        
        inicializacion();
        inicioFinal();
        obstaculos();
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
                Inicial[0]=randfil;
                Inicial[1]=randcol;
                cont++;
            }else{
                if(!(randfil==filant && randcol==colant)){
                    cont++;
                    Lab[randfil][randcol]='G';
                    Fin[0]=randfil;
                    Fin[1]=randcol;
                }
            }
            filant=randfil;
            colant=randcol;
        }
    }
    private void obstaculos(){
        double aprox=FILAS*COLUMNAS*OBSPORCENT;
        int cantObs= (int) aprox;
        int cont=0;
        Random fil = new Random();
        Random col = new Random();
        while (cont<=cantObs){
            int randfil=fil.nextInt(FILAS);
            int randcol=col.nextInt(COLUMNAS);
            if(Lab[randfil][randcol]==' '){
                Lab[randfil][randcol]='\u2588';
                cont++;
            }
        }

    }

}
