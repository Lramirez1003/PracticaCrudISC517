package edu.pucmm.eitc.practicacrudisc517.repository;

import org.springframework.stereotype.Repository;
import edu.pucmm.eitc.practicacrudisc517.encapsulaciones.Estudiante;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EstudianteRepository {
    private List<Estudiante> estu = new ArrayList<Estudiante>();


    public List<Estudiante> getAllEstu() {
        return estu;
    }

    public Estudiante findByMAT(int mat) {
        for (int i = 0; i < estu.size(); i++) {
            if (estu.get(i).getMatricula() == (mat)) {
                return estu.get(i);
            }
        }
        return null;
    }

    public List<Estudiante> buscar(String nombre) {
        return estu.stream().filter(x -> x.getNombre().startsWith(nombre)).collect(Collectors.toList());
    }

    public Estudiante guardar(Estudiante E) {
        Estudiante student = new Estudiante();
        student.setIdEstudiante(E.getIdEstudiante());
        student.setMatricula(E.getMatricula());
        student.setNombre(E.getNombre());
        student.setApellido(E.getApellido());
        student.setTelefono(E.getTelefono());
        System.out.println("Id del estudiante " + student.getIdEstudiante());
        estu.add(student);
        return student;
    }


    public void borrar(int mat) {
        estu.removeIf(x -> x.getMatricula() == (mat));
    }

    public Estudiante actualizar(Estudiante E) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < estu.size(); i++) {
            if (estu.get(i).getIdEstudiante() == (E.getIdEstudiante())) {
                id = E.getIdEstudiante();
                idx = i;
                break;
            }
        }

        Estudiante student = new Estudiante();
        student.setIdEstudiante(id);
        student.setNombre(student.getNombre());
        student.setApellido(student.getApellido());
        student.setTelefono(student.getTelefono());
        estu.set(idx, student);
        return student;


    }
}
