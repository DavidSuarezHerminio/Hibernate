package hibernate.hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmpresaClientes {

	private Session session;
	
	public EmpresaClientes(Session session) {
        this.session = session;
    }
    // Método para obtener la sesión de Hibernate
    public Session getSession() {
        return this.session;
    }

    // Método para mostrar todos los clientes
    public void mostrarTodosClientes() {
        try {
            List<Clientes> clientes = session.createQuery("FROM Clientes", Clientes.class).list();
            for (Clientes cliente : clientes) {
                System.out.println(cliente);
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar los clientes: " + e.getMessage());
        }
    }

    // Método para añadir un cliente
    public void agregarCliente(String nombre, String pais) {
        try {
            Clientes cliente = new Clientes(nombre, pais);
            Transaction tx = session.beginTransaction();
            session.save(cliente);
            tx.commit();
            System.out.println("Cliente agregado correctamente.");
        } catch (Exception e) {
            System.err.println("Error al agregar el cliente: " + e.getMessage());
        }
    }

    // Método para borrar un cliente por ID
    public void borrarClientePorId(int id) {
        try {
            Clientes cliente = session.get(Clientes.class, id);
            if (cliente != null) {
                Transaction tx = session.beginTransaction();
                session.delete(cliente);
                tx.commit();
                System.out.println("Cliente con ID " + id + " borrado correctamente.");
            } else {
                System.out.println("No se encontró ningún cliente con ID " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al borrar el cliente: " + e.getMessage());
        }
    }

    // Método para actualizar un cliente por ID
    public void actualizarCliente(int id, String nuevoNombre, String nuevoPais) {
        try {
            Clientes cliente = session.get(Clientes.class, id);
            if (cliente != null) {
                cliente.setNombre(nuevoNombre);
                cliente.setPais(nuevoPais);
                Transaction tx = session.beginTransaction();
                session.update(cliente);
                tx.commit();
                System.out.println("Cliente actualizado correctamente.");
            } else {
                System.out.println("No se encontró ningún cliente con ID " + id);
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    // Método para borrar clientes por nombre
    public void borrarClientePorNombre(String nombre) {
        try {
            Transaction tx = session.beginTransaction();
            int deletedCount = session.createQuery("DELETE FROM Clientes WHERE nombre = :nombre")
                    .setParameter("nombre", nombre)
                    .executeUpdate();
            tx.commit();
            System.out.println("Se han borrado " + deletedCount + " cliente(s) con el nombre '" + nombre + "'.");
        } catch (Exception e) {
            System.err.println("Error al borrar el cliente por nombre: " + e.getMessage());
        }
    }

    // Método para mostrar clientes por país
    public void mostrarPorPais(String pais) {
        try {
            List<Clientes> clientes = session.createQuery("FROM Clientes WHERE pais = :pais", Clientes.class)
                    .setParameter("pais", pais)
                    .list();
            System.out.println("Número de clientes en " + pais + ": " + clientes.size());
            for (Clientes cliente : clientes) {
                System.out.println(cliente);
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar los clientes por país: " + e.getMessage());
        }
    }

    // Método para buscar el país de un cliente por nombre
    public void buscarPaisDe(String nombre) {
        try {
            Clientes cliente = session.createQuery("FROM Clientes WHERE nombre = :nombre", Clientes.class)
                    .setParameter("nombre", nombre)
                    .uniqueResult();
            if (cliente != null) {
                System.out.println("El país de " + nombre + " es: " + cliente.getPais());
            } else {
                System.out.println("No se encontró ningún cliente con el nombre " + nombre);
            }
        } catch (Exception e) {
            System.err.println("Error al buscar el país del cliente: " + e.getMessage());
        }
    }
}