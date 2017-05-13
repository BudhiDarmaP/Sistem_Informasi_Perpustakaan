/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Anggota;
import Model.Buku;
import Model.Pinjam;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author budhidarmap
 */
@WebServlet(name = "ControlHapusAnggota", urlPatterns = {"/ControlHapusAnggota"})
public class ControlHapusAnggota extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
               Anggota a= new Anggota();
        a.setID_Angota(request.getParameter("id"));
        //cek tombol
        if (request.getParameter("Tombol").equals("Back")) {
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("resultHapusAnggota.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("id")==null) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Data Tidak Berhasil Dihapus");
            dispatcher = request.getRequestDispatcher("HapusAnggotta.jsp");
            dispatcher.forward(request, response);
        }
        //hapus pemijaman
        Pinjam.hapusPinjamAnggota(a.getID_Angota());
        //hapus anggota
        a.hapusMember(a.getID_Angota());
        this.tampil(request, response, "Data Anggota Perpustakaan Berhasil Dihapus");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("infoAdmin.jsp");
        dispatcher.forward(request, response);
    }
}