package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Models.Services;

import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Models.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Models.Domain.SucursalE;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Models.Repository.ISucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalService {
    @Autowired
    private ISucursalRepository sucursalRepository;
    // se pasa del Model(Entity guardada) al patron DTO :
    public SucursalDTO convertToDto(SucursalE savedSucursal){
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(savedSucursal.getPk_SucursalID());
        sucursalDTO.setNameSucursal(savedSucursal.getNameSucursal());
        sucursalDTO.setPaisSucursal(savedSucursal.getPaisSucursal());
        sucursalDTO.setTipoSucursal(savedSucursal.getTipoSucursal());
        return sucursalDTO;
    }

    // se pasa del patron DTO al Model(Entidad)
    public SucursalE convertToEntity(SucursalDTO sucursalDTO){
        SucursalE sucursalE = new SucursalE();
        sucursalE.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
        sucursalE.setNameSucursal(sucursalDTO.getNameSucursal());
        sucursalE.setPaisSucursal(sucursalDTO.getPaisSucursal());
        sucursalE.setTipoSucursal(sucursalDTO.getTipoSucursal());
        return sucursalE;
    }

    //se guarda una nueva sucursal(un obj en la db) a la entidad(SucursalE) y retorna la nueva suc o obj en el DTO
    public SucursalDTO saveSucursal(SucursalDTO sucursalDTO){
        sucursalDTO.determinarTipoSucursal();
        SucursalE sucursalE = convertToEntity(sucursalDTO);
        SucursalE savedSucursal = sucursalRepository.save(sucursalE);
        return convertToDto(savedSucursal);
    }

    //lista todas las sucursales
    public List<SucursalDTO> getAllSucursales(){
        List<SucursalE> sucursalES = sucursalRepository.findAll();
        return sucursalES.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // se obtienen todas las sucursales de la db y las retorna como una lista de objs SucursalDTO
    public SucursalDTO getSucursalById(Long id) {
        SucursalE sucursalE = sucursalRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Sucursal no encontrada"));
        return convertToDto(sucursalE);
    }

    //actualiza una sucursal en la base de datos
    public SucursalDTO updateSucursal(Long id, SucursalDTO sucursalDTO) {
        SucursalE sucursalModelToUpdate = sucursalRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Sucursal no encontrada"));

        sucursalModelToUpdate.setNameSucursal(sucursalDTO.getNameSucursal());
        sucursalModelToUpdate.setPaisSucursal(sucursalDTO.getPaisSucursal());
        sucursalDTO.determinarTipoSucursal();
        sucursalModelToUpdate.setTipoSucursal(sucursalDTO.getTipoSucursal());
        SucursalE updatedSucursal= sucursalRepository.save(sucursalModelToUpdate);
        return convertToDto(updatedSucursal);
    }
    //elimina
    public void deleteSucursal(Long id) {
        sucursalRepository.deleteById(id);
    }

}
