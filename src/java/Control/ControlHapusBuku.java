/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
@WebServlet(name = "ControlHapusBuku", urlPatterns = {"/ControlHapusBuku"})
public class ControlHapusBuku extends HttpServlet {

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
        Buku b = new Buku();
        b.setISBN(request.getParameter("demo-isbn"));
        //cek tombol
        if (request.getParameter("Tombol").equals("Back")) {
            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher("resultHapusBuku.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("demo-isbn")==null) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Data Tidak Berhasil Dihapus");
            dispatcher = request.getRequestDispatcher("HapusBuku.jsp");
            dispatcher.forward(request, response);
        }
        //hapus peminjaman
        Pinjam.hapusPinjamBuku(b.getISBN());
        //hapus buku
        b.hapusBuku(b.getISBN());
        this.tampil(request, response, "Data Buku Berhasil Dihapus");
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
