package suma;

public class Suma {
    private int n1;
    private int n2;
    private int resultado;
    
    public Suma(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    
    private void operacion(){
        resultado =  n1 + n2;
    }
    
    public void imprimirResultado() {
    	operacion();
    	System.out.println("El resultado es: " + resultado);
    }
}
