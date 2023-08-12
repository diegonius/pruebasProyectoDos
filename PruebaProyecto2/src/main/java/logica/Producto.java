
package producto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private String presentacion;
    private Proveedor proveedor; // Objeto de la clase Proveedor
    private Categoria categoria; // Objeto de la clase Categoria
    private Marca marca; // Objeto de la clase Marca
    private int existencias; // Control de existencias

    // Lista para guardar los productos
    private static List<Producto> productos = new ArrayList<>();

    public class Productos {
        

        public Productos(int id, String nombre, double precio, String presentacion, Proveedor proveedor, Categoria categoria, Marca marca, int stock) {
            if (nombre == null || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío");
                return;
            }

            if (precio < 0) {
                JOptionPane.showMessageDialog(null, "El precio no puede ser negativo");
                return;
            }

            if (stock < 0) {
                JOptionPane.showMessageDialog(null, "las existencias no pueden ser negativas");
                return;
            }

            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.presentacion = presentacion;
            this.proveedor = proveedor;
            this.categoria = categoria;
            this.marca = marca;
            this.stock = stock;
        }

    }

    public static boolean agregarProducto(Producto producto) {
        if (validarProducto(producto.getId())) {
            return false;
        }

        productos.add(producto);
        return true;
    }

    public static boolean editarProducto(int id, String nombre, double precio, String presentacion, Proveedor proveedor, Categoria categoria, Marca marca, int existencias) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setPresentacion(presentacion);
                producto.setProveedor(proveedor);
                producto.setCategoria(categoria);
                producto.setMarca(marca);
                producto.setexistencias(existencias);
                return true;
            }
        }

        return false;
    }

    public static boolean eliminarProducto(int id) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == id) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    public static List<Producto> extraerProductos() {
        return productos;
    }

    public static boolean validarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }

        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public static List<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(List<Producto> productos) {
        Producto.productos = productos;
    }

}
