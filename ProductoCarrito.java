package EjercicioTiendaPoo;

public class ProductoCarrito {
    private Producto producto;
    private int cantidad;

    public ProductoCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }
    @Override
    public String toString() {
        return producto.getNombre() + "|" + " CON UN PRECIO DE $" + producto.getPrecio() + " | CANTIDAD SELECCIONADA: " + cantidad + " | LA SUMA DE ESTE ARTICULO ES = $" + getSubtotal();
    }
}