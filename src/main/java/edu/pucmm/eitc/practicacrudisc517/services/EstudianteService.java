package edu.pucmm.eitc.practicacrudisc517.services;

import edu.pucmm.eitc.practicacrudisc517.encapsulaciones.Estudiante;
import edu.pucmm.eitc.practicacrudisc517.repository.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }


    public Estudiante guardarEstudiante(Estudiante estudiante){
        return repository.guardar(estudiante);
    }

    public List<Estudiante> getEstudiantes(){
        return repository.getAllEstu();
    }

    public Estudiante getEstudiantebyMAT(int mat){
        return repository.findByMAT(mat);
    }

    public void BorrarEstudiante(int mat){
        repository.borrar(mat);
    }

    public Estudiante ActualizarEstudiante(Estudiante estudiante){
        return repository.actualizar(estudiante);
    }
}
