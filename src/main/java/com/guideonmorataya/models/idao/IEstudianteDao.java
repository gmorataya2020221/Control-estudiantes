/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guideonmorataya.models.idao;

import com.guideonmorataya.models.domain.Estudiante;
import java.util.List;

/**
 *
 * @author klbmo
 */
public interface IEstudianteDao {
    //declaración de los métodos para accerder a la base de datos
    public List<Estudiante> listar();//list getAllEstudiante
    public Estudiante encontrar(Estudiante estudiante);//getEstudianteById
    public void insertar(Estudiante estudiante);//getInsertar
    public int acutalizar(Estudiante estudiante);//getActualizar
    public int eliminar(Estudiante estudiante);//getEliminar
}
