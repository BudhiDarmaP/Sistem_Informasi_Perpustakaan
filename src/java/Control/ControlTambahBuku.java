package Control;

import Model.Anggota;
import Model.Buku;
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
@WebServlet(name = "ControlTambahBuku", urlPatterns = {"/ControlTambahBuku"})
public class ControlTambahBuku extends HttpServlet {

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
        //cek data isbn dan tahun
        try {
            if (request.getParameter("demo-isbn").equals("")
                    || request.getParameter("demo-judul").equals("")
                    || request.getParameter("demo-author").equals("")
                    || request.getParameter("demo-penerbit").equals("")
                    || request.getParameter("demo-tahun").equals("")
                    || request.getParameter("demo-copy").equals("")) {
                throw new Exception("Data Tidak Lengkap!");
            }
            try {
                int format = Integer.parseInt(request.getParameter("demo-tahun"));
            } catch (Exception ej) {
                throw new Exception("Format tahun Salah!");
            }
            try {
                int format = Integer.parseInt(request.getParameter("demo-copy"));
            } catch (Exception ej) {
                throw new Exception("Format Copy Salah!");
            }
        } catch (Exception e) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", e.getMessage());
            dispatcher = request.getRequestDispatcher("TambahBuku.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("demo-isbn").matches("[0-9]*")==false) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Format ISBN Salah!");
            dispatcher = request.getRequestDispatcher("TambahBuku.jsp");
            dispatcher.forward(request, response);
        }
        if ((request.getParameter("demo-isbn")).length() != 13
                || request.getParameter("demo-tahun").length() != 4) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Jumlah Angka ISBN atau Tahun Kurang!");
            dispatcher = request.getRequestDispatcher("TambahBuku.jsp");
            dispatcher.forward(request, response);
        }
        if (Buku.cekKetersediaan(request.getParameter("demo-isbn"))>0) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Buku Sudah Tersedia Silahkan Edit!");
            dispatcher = request.getRequestDispatcher("Tambah Buku.jsp");
            dispatcher.forward(request, response);
        }
        //membuat data
        b.setISBN(request.getParameter("demo-isbn"));
        b.setJudul(request.getParameter("demo-judul"));
        b.setPenulis(request.getParameter("demo-author"));
        b.setPenerbit(request.getParameter("demo-penerbit"));
        b.setTahun_Terbit(String.valueOf(request.getParameter("demo-tahun")));
        b.setKetersediaan(Integer.parseInt(request.getParameter("demo-copy")));
        b.tambahBuku(b);
        this.tampil(request, response, request.getParameter("demo-isbn"));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("TambahBuku.jsp");
        dispatcher.forward(request, response);
    }
}
