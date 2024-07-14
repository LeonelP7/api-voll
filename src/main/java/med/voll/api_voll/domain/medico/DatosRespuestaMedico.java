package med.voll.api_voll.domain.medico;

import med.voll.api_voll.domain.direccion.DatosDireccion;

public record DatosRespuestaMedico(
        Long id,
        String nombre,
        String email,
        String telefono,
        String documento,
        DatosDireccion direccion
) {

    public static DatosRespuestaMedico convierteDatos(Medico medico){
        return new DatosRespuestaMedico(medico.getId(), medico.getNombre(), medico.getEmail(),
                medico.getTelefono(), medico.getDocumento(), DatosDireccion.convierteDatos(medico.getDireccion()));
    }
}
