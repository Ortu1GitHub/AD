package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class ConsultasPacientes {

    Pacientes paciente = new Pacientes();
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    boolean res = false;

    public boolean registrarPaciente(Pacientes paciente) {

        this.paciente = paciente;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(paciente);
            session.getTransaction().commit();
            System.out.println("Paciente insertado en BBDD");
            res = true;
            return res;

        } finally {
            session.close();
            //sessionFactory.close();
        }

    }


    public Pacientes buscarPaciente(String sip) {
        this.paciente = paciente;

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Pacientes paciente1 = (Pacientes) session.createQuery("from Pacientes p where p.sip='" + sip + "'").getSingleResult();
            session.getTransaction().commit();
            res = true;
            return paciente1;

        } finally {
            session.close();
            //sessionFactory.close();
        }

    }


    public boolean modificarPaciente(Pacientes paciente) {
        this.paciente = paciente;

        Session session = sessionFactory.openSession();
        try {


            session.beginTransaction();
            Pacientes pacientePersistente = paciente;
            session.update(pacientePersistente);
            session.getTransaction().commit();
            System.out.println("Registro modificado en BBDD");
            res = true;
            return res;

        } finally {
            session.close();
            //sessionFactory.close();
        }

    }

    public boolean eliminarPaciente(Pacientes paciente) {
        this.paciente = paciente;

        Session session = sessionFactory.openSession();
        try {


            session.beginTransaction();
            session.delete(paciente);
            session.getTransaction().commit();
            System.out.println("Registro borrado en BBDD");
            res = true;
            return res;

        } finally {
            session.close();
            //sessionFactory.close();
        }

    }

}
