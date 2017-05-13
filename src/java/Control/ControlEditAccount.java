package Control;

import Model.Anggota;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControlEditAccount", urlPatterns = {"/ControlEditAccount"})
public class ControlEditAccount extends HttpServlet {

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
        //panggil cookie id
        Cookie cookie = CookieUtilities.getCookie(request, "id");
    //cek mengubah password atau data?
        //mengubah data
        //cek nama
        if (request.getParameter("nama") != null) {
            Anggota a = Anggota.panggilAnggota(cookie.getValue());
            a.setID_Angota(cookie.getValue());
            if (request.getParameter("nama").matches("[0-9]*") == true) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Nama mengandung angka!");
                dispatcher = request.getRequestDispatcher("Edit Account.jsp");
                dispatcher.forward(request, response);
            }
            //cek no_tlp
            if (request.getParameter("no_tlp").matches("[0-9]*") == false) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Format no telepon salah!");
                dispatcher = request.getRequestDispatcher("Daftar.jsp");
                dispatcher.forward(request, response);
            }
            //set nilai kelas model
            a.setNama(request.getParameter("nama"));
            a.setNo_tlp(request.getParameter("no_tlp"));
            a.setAlamat(request.getParameter("alamat"));
            a.setPassword(request.getParameter("password"));
            //cek password dan anggota
            if (a.cekAnggota(a.getID_Angota()) == 0) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Anggota tidak terdaftar!");
                dispatcher = request.getRequestDispatcher("Edit Account.jsp");
                dispatcher.forward(request, response);
            }
            if (a.LoginAnggota(a.getID_Angota(), a.getPassword()) == false) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Password Salah");
                dispatcher = request.getRequestDispatcher("Edit Account.jsp");
                dispatcher.forward(request, response);
            }
            //edit anggota
            Anggota.editMember(a);
            //panggil anggota
            a = Anggota.panggilAnggota(a.getID_Angota());
            //cek anggota berhasil diubah atau tidak
            if (!a.getNama().equals(request.getParameter("nama"))
                    || !a.getNo_tlp().equals(request.getParameter("no_tlp"))
                    || !a.getAlamat().equals(request.getParameter("alamat"))) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Gagal mengubah data!");
                dispatcher = request.getRequestDispatcher("Edit Account.jsp");
                dispatcher.forward(request, response);
            }
            //tampilkan hasil
            this.tampil(request, response, a.getNama() + "<br> Data Anda Sudah Diubah");
            
            //mengubah password
        } else {
            Anggota a = Anggota.panggilAnggota(cookie.getValue());
            String newPassword = request.getParameter("newPassword");
            String password = request.getParameter("password");
            //cek password dan anggota
            if (a.LoginAnggota(a.getID_Angota(), password) == false) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Password Salah");
                dispatcher = request.getRequestDispatcher("Edit Password.jsp");
                dispatcher.forward(request, response);
            }
            //set password ke kelas model
            a.setPassword(newPassword);
            //edit password
            Anggota.editMember(a);
            //tampilkan hasil
            this.tampil(request, response, a.getNama() + "<br> Password Anda Telah Diubah");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("infoUser.jsp");
        dispatcher.forward(request, response);
    }
}
