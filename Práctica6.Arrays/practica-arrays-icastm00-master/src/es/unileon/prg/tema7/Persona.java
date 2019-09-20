package es.unileon.prg.tema7;
/**
 * Clase que representa un individuo.
 *
 * @author PRG
 * @version 3.0
 */
public class Persona {
    /**
     * Nombre del individuo.
     */
    private String nombre;

    /**
     * Telefono del individuo.
     */
    private String telefono;

    /**
     * Constructor que recibe todos los datos necesarios de una persona.
     *
     * @param nombre
     *            Nombre del individuo
     * @param telefono
     *            Telefono del individuo
     */
    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    /**
     * Constructor de copia. Crear una personas a partir de otra recibida como
     * argumento.
     *
     * @param otra
     *            Individuo a copiar.
     */
    public Persona(Persona otra) {
        nombre = otra.obtenerNombre();
        telefono = otra.obtenerTelefono();
    }

    /**
     * Devuelve el nombre del individuo
     *
     * @return Nombre del individuo
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Devuelve el telefono del individuo
     *
     * @return Telefono del individuo
     */
    public String obtenerTelefono() {
        return telefono;
    }

    /**
     * Dos personas se consideran igual si tienen el mismo nombre y numero de
     * telefono.
     *
     * @param otra
     *            Individuo a comparar.
     * @return <code> verdadero </code> Son la misma persona.
     *         <code> falso </code> En caso contrario
     */
    public boolean esIgual(Persona otra) {
        return (nombre.equals(otra.obtenerNombre()) &&
                    telefono.equals(otra.obtenerTelefono()));
    }
}
