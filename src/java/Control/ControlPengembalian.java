package Control;

import Model.Anggota;
import Model.Buku;
import Model.Pinjam;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author budhidarmap
 */
@WebServlet(name = "ControlPengembalian", urlPatterns = {"/ControlPengembalian"})
public class ControlPengembalian extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            //deklarasi kelas dan timeStamp
            String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
            Pinjam p = new Pinjam();
            //cookies
            Cookie cookie=CookieUtilities.getCookie(request, "id");
            String id = cookie.getValue();
            //get parameter
            String pinjam = request.getParameter("isbn");
            //pengembalian
            p.Pengembalian(timeStamp, pinjam, id);
            int sedia = Buku.cekKetersediaan(pinjam);
            Buku.UpdateKetersediaan(pinjam, (sedia + 1));
            this.tampil(request, response, "Pengembalian Terverifikasi");
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
