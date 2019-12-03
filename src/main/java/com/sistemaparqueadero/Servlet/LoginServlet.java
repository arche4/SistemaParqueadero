/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaparqueadero.Servlet;

import com.sistemaparqueadero.Controller.BicicletaJpaController;
import com.sistemaparqueadero.Controller.CarroJpaController;
import com.sistemaparqueadero.Controller.IngresoParqueaderoJpaController;
import com.sistemaparqueadero.Controller.MotoJpaController;
import com.sistemaparqueadero.Controller.UsuarioJpaController;
import com.sistemaparqueadero.entity.Bicicleta;
import com.sistemaparqueadero.entity.Carro;
import com.sistemaparqueadero.entity.Moto;
import com.sistemaparqueadero.entity.Usuario;
import com.sistemaparqueadero.util.JPAFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author manue
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioJpaController userJpa = new UsuarioJpaController(JPAFactory.getFACTORY());
        IngresoParqueaderoJpaController ingresoParqueaderoJPA = new IngresoParqueaderoJpaController(JPAFactory.getFACTORY());
        BicicletaJpaController bicicletaJPA = new BicicletaJpaController(JPAFactory.getFACTORY());
        MotoJpaController motoJPA = new MotoJpaController(JPAFactory.getFACTORY());
        CarroJpaController carroJPA = new CarroJpaController(JPAFactory.getFACTORY());

        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        try {
            Usuario user = userJpa.buscarUsuario(usuario, clave);
            String Mensaje = "";
            if (user == null) {
                Mensaje = "Email o Clave no validos";
                session.setAttribute("MENSAJE", Mensaje);
                rd = request.getRequestDispatcher("index.jsp");

            } else {
                rd = request.getRequestDispatcher("views/ingreso.jsp");
                //Mensaje = "Email o Clave no validos";
            }

            session.setAttribute("USUARIO", usuario);
            List<Moto> motoList = motoJPA.findMotoEntities();
            session.setAttribute("Moto", motoList);
            List<Bicicleta> biciList = bicicletaJPA.findBicicletaEntities();
            session.setAttribute("Bicicleta", biciList);
            List<Carro> carrolist = carroJPA.findCarroEntities();
            session.setAttribute("Carro", carrolist);
            rd.forward(request, response);

        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
