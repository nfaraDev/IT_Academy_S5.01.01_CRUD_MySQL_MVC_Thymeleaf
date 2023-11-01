package cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Controllers;

import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Models.DTO.SucursalDTO;
import cat.itacademy.barcelonactiva.fara.natalia.s05.t01.n01.Models.Services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Este controlador es el controller del front-end está implementado utilizando el framework de Spring MVC en Java
Los métodos en la clase WebViewController manejan las solicitudes HTTP y se encargan de agregar los datos
 al modelo y devolver la vista para mostrar la información al usuario*/

@Controller
@RequestMapping("/sucursal")
public class WebViewController {
    @Autowired
    private SucursalService sucursalService;

    /*se maneja una solicitud GET a "/list" que obtiene una lista de sucursales y la pasa a una vista llamada
    "list.html"en la carpeta "sucursal" para mostrar los datos*/
    @GetMapping("/list")
    public String listSucursales(Model model) {
        List<SucursalDTO> sucursalesE = sucursalService.getAllSucursales();
        model.addAttribute("sucursales", sucursalesE);
        return "sucursal/list"; //se debe usa una vista llamada "list.html" en la carpeta "sucursal" para mostrar la respuesta
    }

    /*  add + save = addSucursal muestra el formulario de agregar sucursal y el método saveSucursal guarda la sucursal
    enviada desde el formulario en la base de datos
    -addSucursal maneja una solicitud GET a la ruta "/add",utiliza una vista llamada
     "add.html" en la carpeta "sucursal" para mostrar el formulario de agregar sucursal
    -saveSucursal maneja con la solicitud POST las rutas "/save" y "/add"
     */
    @GetMapping("/add")
    public String addSucursal(Model model) {
        model.addAttribute("sucursal", new SucursalDTO());
        return "sucursal/add";
    }
    //parámetro @ModelAttribute SucurDTO sucurlDTO vincula los datos enviados en el formulario con un obj SucursalDTO
    @PostMapping({"/save", "/add"})
    public String saveSucursal(@ModelAttribute SucursalDTO sucursalDTO) {
        // Llamar al método para determinar el tipo de sucursal
        sucursalDTO.determinarTipoSucursal();

        // Guardar la sucursal
        sucursalService.saveSucursal(sucursalDTO);
        return "redirect:/sucursal/list";//redirige al navegador la ruta "/list" para mostrar la lista actualizada
    }

    /* edit + update = método editSucursal muestra el formulario de edición de una sucursal existente y
    el método updateSucursal actualiza la sucursal en la db con los datos enviados desde el formulario
     - editSucursal devuelve una cadena "sucursal/edit",se debe usar una vista "edit.html" en la carpeta "sucursal"
     para mostrar el formulario de edición de sucursal
     */
    @GetMapping("/edit/{id}")
    public String editSucursal(@PathVariable Long id, Model model) {
        SucursalDTO sucursalDTO = sucursalService.getSucursalById(id);
        model.addAttribute("sucursal", sucursalDTO);
        return "sucursal/edit";
    }
    @PostMapping("/update")
    public String updateSucursal(SucursalDTO sucursalDTO) {
        sucursalService.updateSucursal(sucursalDTO.getPk_SucursalID(), sucursalDTO);
        return "redirect:/sucursal/list";
    }


    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable Long id) {
        sucursalService.deleteSucursal(id);
        return "redirect:/sucursal/list";
    }




}
