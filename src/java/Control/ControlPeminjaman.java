/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Buku;
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
@WebServlet(name = "ControlPeminjaman", urlPatterns = {"/ControlPeminjaman"})
public class ControlPeminjaman extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlPeminjaman</title>");            
            out.println("</head>");
            out.println("<body>");
             processRequest(request, response);
            String key = request.getParameter("key");
            Buku[] bk = Buku.getListPencarian(key);
            if (Buku.getListPencarian(key) == null) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Pencarian Buku Tidak Ditemukan");
                dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            } else {
                out.print("<table>"
                        + "<tr><td>No"
                        + "<td>ISBN</td>"
                        + "<td>Judul</td>"
                        + "<td>Pengarang</td>"
                        + "<td>Tahun Terbit</td>"
                        + "<td>Penerbit</td>"
                        + "<td>Ketersediaan</td></tr>");
                for (int i = 0; i < bk.length; i++) {
                    out.print("<tr><td>"+(i+1)
                            + "<td>"+bk[i].getISBN()+"</td>"
                            + "<td>"+bk[i].getJudul()+"</td>"
                            + "<td>"+bk[i].getPenulis()+"</td>"
                            + "<td>"+bk[i].getTahun_Terbit()+"</td>"
                            + "<td>"+bk[i].getPenerbit()+"</td>"
                            + "<td>"+bk[i].getKetersediaan()+"</td>");
                }
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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
