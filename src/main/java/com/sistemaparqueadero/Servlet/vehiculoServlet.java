/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaparqueadero.Servlet;

import com.sistemaparqueadero.Controller.BicicletaJpaController;
import com.sistemaparqueadero.Controller.CarroJpaController;
import com.sistemaparqueadero.Controller.MotoJpaController;
import com.sistemaparqueadero.entity.Bicicleta;
import com.sistemaparqueadero.entity.Carro;
import com.sistemaparqueadero.entity.Moto;
import com.sistemaparqueadero.util.JPAFactory;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.persistence.Convert;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import sun.misc.BASE64Decoder;

/**
 *
 * @author manue
 */
@WebServlet(name = "vehiculoServlet", urlPatterns = {"/vehiculoServlet"})
public class vehiculoServlet extends HttpServlet {

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

        HttpSession session = request.getSession();

        RequestDispatcher rd = null;
        BicicletaJpaController bicicletaJPA = new BicicletaJpaController(JPAFactory.getFACTORY());
        MotoJpaController motoJPA = new MotoJpaController(JPAFactory.getFACTORY());
        CarroJpaController carroJPA = new CarroJpaController(JPAFactory.getFACTORY());
        PrintWriter out = response.getWriter();

        String foto = request.getParameter("imagen");

        String cilindraje = request.getParameter("cilindraje");
        String tiempo = request.getParameter("cilindraje");
        String placa = request.getParameter("placa");
        String vehiculo = request.getParameter("vehiculo");
        String nombreFoto = null;

        String placaCarro = request.getParameter("placaCarro");
        String catidadPuertas = request.getParameter("numeroPuertas");
        String modelo = request.getParameter("modelo");

        Random r = new Random();
        if (vehiculo.equals("1")) {
            nombreFoto = "Bicicleta" + r.nextInt(100) + 1 + ".png";
        } else if (vehiculo.equals("2")) {
            nombreFoto = "Moto" + r.nextInt(100) + 1 + ".png";
        } else {
            nombreFoto = "Carro" + r.nextInt(100) + 1 + ".png";

        }

        String[] strings = foto.split(",");
        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
        String path = "C:\\Users\\manue\\Documents\\NetBeansProjects\\SistemaParqueadero\\src\\main\\webapp\\fotos\\" + nombreFoto;
        String ruta = "fotos/" + nombreFoto;
        File file = new File(path);

        try {
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
            outputStream.write(data);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        if (vehiculo.equals("1")) {
            Bicicleta bici = new Bicicleta(ruta);
            try {
                bicicletaJPA.create(bici);
                List<Bicicleta> biciList = bicicletaJPA.findBicicletaEntities();
                session.setAttribute("Bicicleta", biciList);
                out.print("Exitoso");
            } catch (Exception e) {
            }
        } else if (vehiculo.equals("2")) {
            Moto moto = new Moto(cilindraje, tiempo, placa, ruta);
            try {
                motoJPA.create(moto);
                List<Moto> motoList = motoJPA.findMotoEntities();
                session.setAttribute("Moto", motoList);
                out.print("Exitoso");
            } catch (Exception e) {
            }
        } else {
            Carro carro = new Carro(modelo, catidadPuertas, placaCarro, ruta);
            try {
                carroJPA.create(carro);
                List<Carro> carrolist = carroJPA.findCarroEntities();
                session.setAttribute("Carro", carrolist);
                out.print("Exitoso");
            } catch (Exception e) {
            }
            rd.forward(request, response);

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
