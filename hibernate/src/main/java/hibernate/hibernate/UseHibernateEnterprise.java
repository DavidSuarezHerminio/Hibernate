package hibernate.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.LogManager;

public class UseHibernateEnterprise {
    public static void main(String[] args) {
        LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);

        // Configura Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            // Crea una instancia de EmpresaClientes
            EmpresaClientes empresaClientes = new EmpresaClientes(session);

            // Ejecuta los métodos según sea necesario
            empresaClientes.mostrarTodosClientes();
            empresaClientes.agregarCliente("David", "España");
            empresaClientes.mostrarTodosClientes();
            empresaClientes.borrarClientePorId(1);
           empresaClientes.actualizarCliente(2, "gyhjhjdghj", "NuevoPais");
           empresaClientes.borrarClientePorNombre("NombreCliente");
            empresaClientes.mostrarPorPais("PaisCliente");
           empresaClientes.buscarPaisDe("NombreCliente");
        } finally {
            // Cierra la sesión de Hibernate
            session.close();
            sessionFactory.close();
        }
    }
}