import laberinto.*;
public class prueba {
    public static void main(String[] args) {
            LabAzar laberintox= new LabAzar();
            laberintox.mostrarSalida(true);
            
            A generar=new A(laberintox);
            generar.camino();
            laberintox.mostrarSalida(false);

        
        
    }
    
}