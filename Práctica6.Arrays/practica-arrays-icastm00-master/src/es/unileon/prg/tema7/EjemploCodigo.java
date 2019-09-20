package es.unileon.prg.tema7;
/**
 * Clase de prueba para conocer el manejo avanzado de arrays.
 *
 * @author PRG
 * @version 2.0
 */
public class EjemploCodigo {

    /**
     * Metodo para mostrar un mensaje de traza.
     *
     * @param metodo
     *            Metodo ejecutado.
     * @param mensaje
     *            Mensaje de traza a mostrar.
     */
    private void traza(String metodo, String mensaje) {
        System.out.println();
        System.out.println("<" + metodo + "> - " + mensaje);
        System.out.println();
    }

    /**
     * Copia de arrays.
     */
    public void copiarOpcion1() {
        int contador;

        traza("copiarOpcion1", "inicio");

        Persona[] personas = new Persona[2];
        Persona[] copia;

        personas[0] = new Persona("Pedro", "913779900");
        personas[1] = new Persona("Juan", "915453322");

        //Se realiza la copia.
        copia = personas;

        contador = 0;
        while ((contador < copia.length) && (copia[contador] != null)) {
            System.out.println(copia[contador]);
            contador++;
        }

        personas[0] = new Persona("Luis", "610010101");
        traza("copiarOpcion1", "tras realizar la modificacion ");

        contador = 0;
        while ((contador < copia.length) && (copia[contador] != null)) {
            System.out.println(copia[contador]);
            contador++;
        }

        traza("copiarOpcion1", "fin");
    }

    /**
     * Copia de arrays.
     */
    public void copiarOpcion2() {
        int contador;

        traza("copiarOpcion2", "inicio");

        Persona[] personas = new Persona[2];
        Persona[] copia;

        personas[0] = new Persona("Pedro", "913779900");
        personas[1] = new Persona("Juan", "915453322");

        //Se realiza la copia de la array.
        copia = new Persona[personas.length];
        contador = 0;
        while ((contador < personas.length) && (personas[contador] != null)) {
            copia[contador] = new Persona(personas[contador]);
            contador++;
        }

        contador = 0;
        while ((contador < copia.length) && (copia[contador] != null)) {
            System.out.println(copia[contador]);
            contador++;
        }

        personas[0] = new Persona("Luis", "610010101");
        traza("copiarOpcion2", "tras realizar la modificacion ");

        contador = 0;
        while ((contador < copia.length) && (copia[contador] != null)) {
            System.out.println(copia[contador]);
            contador++;
        }

        traza("copiarOpcion2", "fin");
    }

    /**
     * Paso de parametros.
     */
    public void pasarParametros() {
        int contador;

        traza("pasarParametros", "inicio");

        Persona[] personas = new Persona[2];

        personas[0] = new Persona("Pedro", "913779900");
        personas[1] = new Persona("Juan", "915453322");

        contador = 0;
        while ((contador < personas.length) && (personas[contador] != null)) {
            System.out.println(personas[contador]);
            contador++;
        }

        recibirParametros(personas);

        contador = 0;
        while ((contador < personas.length) && (personas[contador] != null)) {
            System.out.println(personas[contador]);
            contador++;
        }

        traza("pasarParametros", "fin");
    }

    /**
     * Metodo para modificar los valores del array
     *
     * @param listaDePersonas
     *            Array a modificar.
     */
    private void recibirParametros(Persona[] listaDePersonas) {
        int contador = 0;

        traza("recibirParametros", "inicio");

        contador = 0;
        while ((contador < listaDePersonas.length)
                && (listaDePersonas[contador] != null)) {
            System.out.println(listaDePersonas[contador]);
            contador++;
        }

        listaDePersonas[0] = new Persona("Luis", "610010101");
        traza("recibirParametros", "tras realizar la modificacion ");

        contador = 0;
        while ((contador < listaDePersonas.length)
                && (listaDePersonas[contador] != null)) {
            System.out.println(listaDePersonas[contador]);
            contador++;
        }

        traza("recibirParametros", "fin");
    }

    /**
     * Paso de parametros erroneo
     */
    public void pasarParametrosErroneo() {
        int contador;

        traza("pasarParametrosErroneo", "inicio");

        Persona[] personas = null;

        recibirParametros(personas);

        contador = 0;
        while ((contador < personas.length) && (personas[contador] != null)) {
            System.out.println(personas[contador]);
            contador++;
        }

        traza("pasarParametrosErroneo", "fin");
    }

    /**
     * Metodo para crear un nuevo array.
     *
     * @param listaDePersonas
     *            Array a crear.
     */
    private void recibirParametrosErroneo(Persona[] listaDePersonas) {

        traza("recibirParametrosErroneo", "inicio");

        listaDePersonas = new Persona[2];

        listaDePersonas[0] = new Persona("Pedro", "913779900");
        listaDePersonas[1] = new Persona("Juan", "915453322");

        traza("recibirParametrosErroneo", "erroneo");
    }
}
