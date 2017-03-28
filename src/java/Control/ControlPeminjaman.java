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
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String timeStamp = new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
            int i = 0;
            String ID=null;//cookies
            Buku bk[] = null;
                System.out.println("a");
            while (request.getParameter("data" + String.valueOf(i)) != null) {
                bk[i].getBuku(request.getParameter("data" + String.valueOf(i)));
                System.out.println("a");
                i++;
            }
            Pinjam p = new Pinjam();
//            out.print("<html>");
//            out.print("<head>");
//            out.print("<body>");
            for (int j = 0; j < i; j++) {
                p.setID_Peminjam(ID);
                p.setID_Buku(bk[j].getISBN());
                p.setTanggal_pinjam(timeStamp);
                p.setTanggal_kembali(null);
                p.setWaktu_pinjam(7);
            }
        
            
//            out.print("</html>");
//            out.print("</head>");
//            out.print("</body>");
               this.tampil(request, response, "Data Peminjaman Tersimpan");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("info.jsp");
        dispatcher.forward(request, response);
    }
}
