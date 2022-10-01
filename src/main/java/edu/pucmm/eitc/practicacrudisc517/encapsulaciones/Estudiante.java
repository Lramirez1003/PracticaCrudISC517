package edu.pucmm.eitc.practicacrudisc517.encapsulaciones;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    private int idEstudiante;
    private int matricula;
    private String nombre;
    private String apellido;
    private String telefono;


}
