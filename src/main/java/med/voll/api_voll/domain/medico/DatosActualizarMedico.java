package med.voll.api_voll.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api_voll.domain.direccion.DatosDireccion;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DatosDireccion direccion
) {
}
