package proyectos;

/**
 * Representa un producto identificado por un código SKU.
 */
public class Producto {

    private final String sku;      
    private String nombre;
    private double precio;

    /**
     * Crea un producto y valida el formato del SKU.
     */
    public Producto(String sku, String nombre, double precio) {
        if (validarFormato(sku)) {
            this.sku = sku;
        } else {
            System.out.println("SKU inválido, se pone ALM-0000");
            this.sku = "ALM-0000";
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Valida que el código tenga el formato ALM-####.
     */
    public static boolean validarFormato(String codigo) {
        if (codigo == null) return false;
        if (codigo.length() != 8) return false;
        if (!codigo.startsWith("ALM-")) return false;

        String num = codigo.substring(4);  
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Devuelve una representación textual del producto.
     */
    @Override
    public String toString() {
        return sku + " - " + nombre + " - " + precio + "€";
    }
}