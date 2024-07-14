package med.voll.api_voll.domain.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        @NotBlank
        String calle,
        @NotBlank
        String distrito,
        @NotBlank
        String ciudad,
        @NotBlank
        String numero,
        @NotBlank
        String complemento
) {

        public static DatosDireccion convierteDatos(Direccion direccion){
                return new DatosDireccion(direccion.getCalle(),
                        direccion.getDistrito(), direccion.getCiudad(), direccion.getNumero(),
                        direccion.getComplemento());
        }
}
