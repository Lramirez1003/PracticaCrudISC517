package edu.pucmm.eitc.practicacrudisc517.controladores;

import edu.pucmm.eitc.practicacrudisc517.encapsulaciones.Estudiante;
import edu.pucmm.eitc.practicacrudisc517.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping("/")
    public String listarEstudiantes(Model model){
        List<Estudiante> listadoEstudiantes = service.getEstudiantes();

        model.addAttribute("titulo","Listado de estudiantes");
        model.addAttribute("estudiantes",listadoEstudiantes);

        return "home";
    }

    @GetMapping("/crear")
    public String CrearEstudiante(Model model){

        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);

        return "/vistas/crearestu";
    }
    @PostMapping("/guardar")
    public String GuardarEstudiante(@ModelAttribute Estudiante estudiante){

        service.guardarEstudiante(estudiante);

        return "redirect:/";
    }

    @GetMapping("/editar/{mat}")
    public String EditarEstudiante(@PathVariable("mat") int matEstu, Model model){

        Estudiante estudiante = service.getEstudiantebyMAT(matEstu);

        model.addAttribute("estudiante", estudiante);
        service.ActualizarEstudiante(estudiante);

        return "/vistas/crearestu";
    }

    @GetMapping("/eliminar/{mat}")
    public String BorrarEstudiante(@PathVariable("mat") int matEstu){

        service.BorrarEstudiante(matEstu);

        return "redirect:/";
    }

    @PutMapping
    public Estudiante actualizarEstudiante(@RequestBody Estudiante estudiante){
        return service.ActualizarEstudiante(estudiante);
    }

}
