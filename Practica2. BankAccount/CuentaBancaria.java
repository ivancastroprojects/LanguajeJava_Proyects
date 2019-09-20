
public class CuentaBancaria {
    private Persona dueño;
    private int saldo;

    public CuentaBancaria(Persona dueño, int saldo) {
        this.dueño = dueño;
        saldo = 0;
    }
    
    public void retirar(int cantidadMenos) {
       this.saldo -= cantidadMenos;
    }
    
    public void depositar(int cantidadMas) {
       this.saldo += cantidadMas;
    }
    
    public void transferir(CuentaBancaria cuenta, int cantidadTransf) {
       this.saldo -= cantidadTransf;
       cuenta.depositar(cantidadTransf);
    }
    
    public void prestamo(CuentaBancaria cuenta, int cantidadSolicit) {
       int interes = 10%;
       int plazo = 365;
       
       saldo += cantidadSolicit;
       System.out.println("Prestamo realizado con exito. Saldo anterior: " + this.saldo-cantidadSolicit + "
       
       for(int i = 0; i < plazo; i++) {
           saldo
       
       
    }
    
    public String toString() {
        return "El saldo de la cuenta de " + this.dueño + " es: " + this.saldo;
    }
}
