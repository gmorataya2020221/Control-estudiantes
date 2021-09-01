/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guideonmorataya.Controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.util.List;
import com.guideonmorataya.models.dao.EstudianteDaoImpl;
import com.guideonmorataya.models.domain.Estudiante;
import java.io.IOException;



/**
 *
 * @author klbmo
 */
@WebServlet("/ServletEstudiante")
public class ServletEstudiante extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{             
        
        String accion= request.getParameter("accion");
        
        if(accion !=null){
            
            switch(accion){
                case "listar":
                    listarEstudiantes(request,response);
                    break;
                case "editar":
                       // editarEstudiantes(request,response);
                        break;
                case "eliminal":
                        eliminarEstudiantes(request,response);
                        break;
            
            }
        }
        
    }
    
    private void eliminarEstudiantes(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //recuperar el id del estudiante
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        
        //crear objeto de tipo estudiante
        Estudiante estudiante= new Estudiante(idEstudiante);
        
        //Llamar al método eliminar que está en DaoImpl
        //Eliminar el objeto de la base de datos
        int registrosEliminados=new EstudianteDaoImpl().eliminar(estudiante);
        
        //volvemos a cargar la lista de estudiantes
        listarEstudiantes(request,response);
        
    }
    
    private void listarEstudiantes(HttpServletRequest request, HttpServletResponse response)throws IOException{
        
        List<Estudiante> listaEstudiantes = new EstudianteDaoImpl().listar();
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoEstudiantes",listaEstudiantes);
        sesion.setAttribute("saldoTotal", getSaldoTotal());
        sesion.setAttribute("cantidadEstudiantes", 8/*getCantidadEstudiantes()*/);
        response.sendRedirect("estudiantes/listarEstudiantes.jsp");
        
    }
    
    public double getSaldoTotal(){
        double saldoTotal;
        
        //Implementar un ciclo para recorrer la lista de estudiantes
        //Ir sumando cada saldo
        
        saldoTotal=870;
        
        return saldoTotal;
    }
    
}
