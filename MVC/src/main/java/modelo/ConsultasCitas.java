package modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

public class ConsultasCitas {

    Citas cita=new Citas();
    SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
    boolean res=false;

    /*
    public Medicos buscarMedico(String num_colegiado){
        this.medico=medico;

        Session session =sessionFactory.openSession();
        try{
            session.beginTransaction();
            Medicos medico1= (Medicos) session.createQuery("from Medicos m where m.numero_colegiado='"+num_colegiado+"'").getSingleResult();
            session.getTransaction().commit();
            res=true;
            return medico1;

        }finally {
            session.close();
            //sessionFactory.close();
        }

    }

    public boolean modificarMedico(Medicos medico){
        this.medico=medico;

        Session session=sessionFactory.openSession();
        try{


            session.beginTransaction();
            Medicos medicoPersistente=medico;
            session.update(medicoPersistente);
            session.getTransaction().commit();
            System.out.println("Registro modificado en BBDD");
            res=true;
            return res;

        }finally {
            session.close();
            //sessionFactory.close();
        }

    }

    public boolean eliminarMedico(Medicos medico){
        this.medico=medico;

        Session session=sessionFactory.openSession();
        try{


            session.beginTransaction();
            session.delete(medico);
            session.getTransaction().commit();
            System.out.println("Registro borrado en BBDD");
            res=true;
            return res;

        }finally {
            session.close();
            //sessionFactory.close();
        }

    }
     */

    public List<Medicos> obtenerDatosMedicos(){
        //this.medico=medico;

        Session session =sessionFactory.openSession();
        try{
            session.beginTransaction();
            List <Medicos> listaMedicos=session.createQuery("from Medicos ").getResultList();
            session.getTransaction().commit();
            //res=true;

            /*
            for (Medicos unMedico:listaMedicos){
                System.out.println(unMedico.getDNI()+','+unMedico.getNombre());
            }
             */
            return listaMedicos;

        }finally {
            session.close();
            //sessionFactory.close();
        }

    }
    public List<Pacientes> obtenerDatosPacientes(){
        //this.medico=medico;

        Session session =sessionFactory.openSession();
        try{
            session.beginTransaction();
            List <Pacientes> listaPacientes=session.createQuery("from Pacientes ").getResultList();
            session.getTransaction().commit();
            //res=true;
            /*
            for (Pacientes unPaciente:listaPacientes){
                System.out.println(unPaciente.getSip()+','+unPaciente.getDNI()+','+unPaciente.getNombre());
            }
             */
            return listaPacientes;

        }finally {
            session.close();
            //sessionFactory.close();
        }

    }
    public List<Citas> obtenerDatosCitas(){
        //this.medico=medico;

        Session session =sessionFactory.openSession();
        try{
            session.beginTransaction();
            List <Citas> listaCitas=session.createQuery("from Citas").getResultList();
            session.getTransaction().commit();
            //res=true;

            /*
            for (Citas unaCita:listaCitas){
                System.out.println(unaCita.getMedico_id()+','+unaCita.getPaciente_id()+','+unaCita.getFecha());
            }
             */
            return listaCitas;

        }finally {
            session.close();
            //sessionFactory.close();
        }

    }

    public boolean registrarCita(Citas cita){

        this.cita=cita;

        Session session=sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(cita);
            session.getTransaction().commit();
            System.out.println("Registro insertado en BBDD");
            res=true;
            return res;


        }finally {
            session.close();
            //sessionFactory.close();
        }

    }
    public boolean eliminarCita(Citas cita){

        this.cita=cita;

        Session session=sessionFactory.openSession();
        try{
            session.beginTransaction();
            Citas cita_eliminar= (Citas) session.createQuery("from Citas c where c.created_at='"+ cita.getCreated_at()+"'").getSingleResult();
            session.delete(cita_eliminar);
            session.getTransaction().commit();
            //System.out.println("Aqui");
            res=true;
            return res;

        }finally {
            session.close();
            //sessionFactory.close();
        }

    }

}
