package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Models.Repository;

import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Models.Domain.SucursalE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISucursalRepository extends JpaRepository<SucursalE,Long> {

}
