
public class BancoMain {

    public static void main (String[]args) {
        CuentaBancaria cuentaIvan = new CuentaBancaria(new Persona("Ivan"), 3500000);
        CuentaBancaria cuentaManu = new CuentaBancaria(new Persona("Manu"), -540);
        
        System.out.println(cuentaIvan);
        System.out.println(cuentaManu);
        
        cuentaIvan.transferir(cuentaManu, 1000);
       
        System.out.println(cuentaIvan);
        System.out.println(cuentaManu);
    }     
}