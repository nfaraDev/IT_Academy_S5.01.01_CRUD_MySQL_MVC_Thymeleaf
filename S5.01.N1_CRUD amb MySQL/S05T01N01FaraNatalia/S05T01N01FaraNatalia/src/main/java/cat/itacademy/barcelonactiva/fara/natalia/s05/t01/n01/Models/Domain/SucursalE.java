package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Models.Domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sucursal")
public class SucursalE { //es una entidad de la base de datos

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long pk_SucursalID;
        @Column
        private String nameSucursal;
        @Column
        private String paisSucursal;
        @Column
        private String TipoSucursal;

}

