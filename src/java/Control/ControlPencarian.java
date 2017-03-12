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
@WebServlet(name = "ControlPencarian", urlPatterns = {"/ControlPencarian"})
public class ControlPencarian extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControlPencarian</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlPencarian at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
                        + "<td>ID</td>"
                        + "<td>ISBN</td>"
                        + "<td>Judul</td>"
                        + "<td>Pengarang</td>"
                        + "<td>Penerbit</td>"
                        + "<td>Tahun Terbit</td>"
                        + "<td>Ketersediaan</td></tr>");
                for (int i = 0; i < bk.length; i++) {
                    out.print("<tr><td>"+i+1
                            + "<td>"+bk[i].getID_Buku()+"</td>"
                            + "<td>"+bk[i].getISBN()+"</td>"
                            + "<td>"+bk[i].getJudul()+"</td>"
                            + "<td>"+bk[i].getPenulis()+"</td>"
                            + "<td>"+bk[i].getPenerbit()+"</td>"
                            + "<td>"+bk[i].getTahun_Terbit()+"</td>"
                            + "<td>"+bk[i].getKetersediaan()+"</td>"
                            + "</table>");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
