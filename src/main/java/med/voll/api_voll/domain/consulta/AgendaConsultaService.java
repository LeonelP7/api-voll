package med.voll.api_voll.domain.consulta;

import med.voll.api_voll.domain.medico.Medico;
import med.voll.api_voll.domain.medico.MedicoRepository;
import med.voll.api_voll.domain.paciente.Paciente;
import med.voll.api_voll.domain.paciente.PacienteRepository;
import med.voll.api_voll.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public void agendar(DatosAgendarConsulta datos){

        if (pacienteRepository.findById(datos.idPaciente()).isEmpty()){
            throw new ValidacionDeIntegridad("Este id para el paciente no fue encontrado");
        }

        if (datos.idMedico() != null && !medicoRepository.existsById(datos.idMedico())){
            throw new ValidacionDeIntegridad("Este id para el paciente no fue encontrado");
        }


        var paciente = pacienteRepository.findById(datos.idPaciente()).get();

        var medico = seleccionarMedico(datos);


        var consulta =  new Consulta(null, medico, paciente,datos.fecha());
        consultaRepository.save(consulta);
    }

    private Medico seleccionarMedico(DatosAgendarConsulta datos) {

        if(datos.idMedico() != null){
            return medicoRepository.getReferenceById(datos.idMedico());
        }

        if(datos.especialidad() == null){
            throw new ValidacionDeIntegridad("Se debe seleccionar usa especialidad para el medico");
        }

        return medicoRepository.seleccionarMedicoConEspecialidadEnFecha(datos.especialidad(),datos.fecha());
    }
}
