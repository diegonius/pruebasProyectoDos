
package logica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Cliente {
      List<Cliente> listaClientes = new ArrayList<>();
    private int id;
    private String cedula;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private int telefono;
    private String correo;
    

    public Cliente(int id, String cedula, String nombre, String primerApellido, String segundoApellido, int telefono, String correo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
         
   public void agregarCliente(int id, String cedula, String nombre, String primerApellido, String segundoApellido, int telefono, String correo) {
        if (!validarCedula(cedula)) {
            JOptionPane.showMessageDialog(null, "El cliente ya existe");
        } else {
            Cliente nuevoCliente = new Cliente(id, cedula, nombre, primerApellido, segundoApellido, telefono, correo);
            listaClientes.add(nuevoCliente);
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");
        }
    }
    
      public boolean validarCedula(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return false;
            }
        }
        return true;
    }
            
    public void eliminarClientePorId(int id) {
        Cliente clienteAEliminar = null; 
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                listaClientes.remove(cliente);
                break;
            }
        }
        if (clienteAEliminar !=null){
            listaClientes.remove(clienteAEliminar);
            JOptionPane.showMessageDialog(null, "Cliente Eliminado"); 
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro el cliente"); 
        }
    }
    
     public void modificarCliente(int id, String cedula, String nombre, String primerApellido, String segundoApellido, int telefono, String correo) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                if(!cliente.getCedula().equals(cedula)&& !validarCedula(cedula)){
                   JOptionPane.showMessageDialog(null, "La cedula ya existe"); 
                   return;
                }
                cliente.setCedula(cedula);
                cliente.setNombre(nombre);
                cliente.setPrimerApellido(primerApellido);
                cliente.setSegundoApellido(segundoApellido);
                cliente.setTelefono(telefono);
                cliente.setCorreo(correo);
                JOptionPane.showMessageDialog(null,"Cliente Modficado");
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"No se encontro el cliente");
    }
    
     public String obtenerCliente() {
         String resultado="";
        for (Cliente cliente : listaClientes) {
           resultado+=cliente+"\n";
        }
       return resultado;
    }
}
