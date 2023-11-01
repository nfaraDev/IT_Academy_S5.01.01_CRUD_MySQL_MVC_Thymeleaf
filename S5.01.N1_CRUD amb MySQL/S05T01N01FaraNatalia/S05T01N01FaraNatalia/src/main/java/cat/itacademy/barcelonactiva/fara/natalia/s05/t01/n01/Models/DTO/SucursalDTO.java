package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Models.DTO;
import lombok.*;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SucursalDTO {

    private long pk_SucursalID;
    private String nameSucursal;
    private String paisSucursal;
    private String TipoSucursal;


    private static final List<String> paises = Arrays.asList(
            "Alemania", "Austria", "Belgica", "Bulgaria", "Chipre", "Croacia", "Dinamarca",
            "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Grecia",
            "Hungria", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta",
            "Países Bajos", "Polonia", "Portugal", "Republica Checa", "Rumanía", "Suecia"
    );
    //get
    public String determinarTipoSucursal() {
        String ue = "UE";
        String fueraUE = "Fuera UE";
        if (paises.contains(paisSucursal)) {
            return ue;
        } else {
            return fueraUE;
        }
    }
}




