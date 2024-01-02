package controlador;

import modelo.Citas;
import modelo.ConsultasCitas;
import vista.FrmCitas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CtrlCitas implements ActionListener {

    public Citas cita;
    public FrmCitas frmCitas;
    public ConsultasCitas modConCitas;


    public CtrlCitas(Citas cita, FrmCitas frmCitas, ConsultasCitas modConCitas) {
        this.cita = cita;
        this.frmCitas = frmCitas;
        this.modConCitas = modConCitas;

        frmCitas.btnGenerarCita.addActionListener(this);
        frmCitas.btnEliminarCita.addActionListener(this);
    }

    public void iniciarVistaCitas() {
        frmCitas.setTitle("FORMULARIO DE CITAS");
        frmCitas.setLocationRelativeTo(null);
        frmCitas.setVisible(true);
        frmCitas.cargarDatosPacientes(modConCitas.obtenerDatosPacientes());
        frmCitas.cargarDatosMedicos(modConCitas.obtenerDatosMedicos());
        frmCitas.cargarDatosCitas(modConCitas.obtenerDatosCitas());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmCitas.btnGenerarCita) {
            int medicoSelecionado = frmCitas.tbMedicos.getSelectedRow();
            cita.setMedico_id((String) frmCitas.tbMedicos.getValueAt(medicoSelecionado, 0));
            int pacienteSelecionado = frmCitas.tbPacientes.getSelectedRow();
            cita.setPaciente_id((String) frmCitas.tbPacientes.getValueAt(pacienteSelecionado, 0));
            Date fechaOriginal = new Date();
            SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd hh::mm:ss");
            String strFechaOriginal = formato1.format(fechaOriginal);
            cita.setCreated_at(strFechaOriginal);
            Date fechaCita=new Date();
            fechaCita=frmCitas.dtFechaCita.getDate();
            SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
            String strFechaCita = formato2.format(fechaCita);

            Date horaCita= (Date) frmCitas.spinnerHora.getValue();
            SimpleDateFormat formato3 = new SimpleDateFormat("HH:mm");
            String strHoraCita = formato3.format(horaCita);
            cita.setFecha(strFechaCita+" "+strHoraCita);




            if (modConCitas.registrarCita(cita)) {
                JOptionPane.showMessageDialog(null, "Cita guardada con éxito");
                //Se refresca el listado de citas tras insertar/borrar
                frmCitas.cargarDatosCitas(modConCitas.obtenerDatosCitas());
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar cita");
            }


        }


        if (e.getSource() == frmCitas.btnEliminarCita) {
            int citaSelecionada = frmCitas.tbCitas.getSelectedRow();
            cita.setMedico_id((String) frmCitas.tbCitas.getValueAt(citaSelecionada, 0));
            cita.setPaciente_id((String) frmCitas.tbCitas.getValueAt(citaSelecionada, 1));
            cita.setFecha((String) frmCitas.tbCitas.getValueAt(citaSelecionada, 2));
            cita.setCreated_at((String) frmCitas.tbCitas.getValueAt(citaSelecionada, 3));

            if (modConCitas.eliminarCita(cita)) {
                JOptionPane.showMessageDialog(null, "Cita borrada con éxito");
                //Se refresca el listado de citas tras insertar/borrar
                frmCitas.cargarDatosCitas(modConCitas.obtenerDatosCitas());
            } else {
                JOptionPane.showMessageDialog(null, "Error al borrar cita");
            }
        }


    }

        /*
        if(e.getSource()==frmMedicos.btnModificar) {
            medico.setNumero_colegiado(frmMedicos.tfNumColegiado1.getText().trim());
            medico.setDni(frmMedicos.tfDNI.getText().trim());
            medico.setNombre(frmMedicos.tfNombre.getText().trim());
            medico.setApellido1(frmMedicos.tfApellido1.getText().trim());
            medico.setApellido2(frmMedicos.tfApellido2.getText().trim());
            medico.setTelefono(frmMedicos.tfTelefono.getText().trim());
            medico.setEspecialidad_id(Integer.parseInt(frmMedicos.tfEspecialidad.getText().trim()));

            if (modConMedicos.modificarMedico(medico)) {
                JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        }
        */


}




