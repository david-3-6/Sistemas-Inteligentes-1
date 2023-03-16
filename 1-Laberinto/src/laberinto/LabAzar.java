package laberinto;
import java.util.Random;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class LabAzar {
    protected  final int FILAS=60;
    protected  final int COLUMNAS=80;
    private static final double OBSPORCENT=0.30;
    protected char[][] Lab;
    public int[] Inicial= new int[2];
    public int[] Fin= new int[2];
    
    public LabAzar () {
        Lab = new  char[FILAS][COLUMNAS];
        
        inicializacion();
        inicioFinal();
        obstaculos();
    }
    public LabAzar(int x1, int y1, int x2, int y2){
        Inicial[0]=x1;
        Inicial[1]=y1;
        Fin[0]=x2;
        Fin[1]=y2;
        Lab = new  char[FILAS][COLUMNAS];
        inicializacion();
        Lab[x1][y1]='I';
        Lab[x2][y2]= 'G';
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
    public void mostrarSalida(boolean nuevo){
        if(nuevo){
            File archivo=new File("salida.txt");
            System.out.println("Creando archivo salida.txt");
            
            try{
                FileWriter escritor=new FileWriter(archivo, StandardCharsets.UTF_8);
                escritor.write("Laberinto sin solucion:\n");
                for (int f=0; f<FILAS; f++){
                    for (int c=0; c<COLUMNAS; c++){
                        escritor.write(Lab[f][c]);
                    }
                    escritor.write("\n");
                }
                escritor.write("\n\n\n\n\n\n Laberinto con solucion:\n");
                escritor.close();
            }catch (IOException e){
                System.out.println("Error en escritura del resultado");
            }
            System.out.println("Resultado escrito en salida.txt con exito");
        }else{
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("salida.txt", true);
                OutputStreamWriter escritor = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
    
                for (int f=0; f<FILAS; f++){
                    for (int c=0; c<COLUMNAS; c++){
                        escritor.write(Lab[f][c]);
                    }
                    escritor.write("\n");
                }
                escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
