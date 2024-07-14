package med.voll.api_voll.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api_voll.domain.direccion.DatosDireccion;

public record DatosActualizacionPaciente(
        @NotNull
        Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion) {
}
