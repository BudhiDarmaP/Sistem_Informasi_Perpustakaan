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
@WebServlet(name = "ControlPeminjaman", urlPatterns = {"/ControlPeminjaman"})
public class ControlPeminjaman extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
            String timeStamp = new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
            Pinjam p = new Pinjam();
            Anggota a = new Anggota();
            int i = 0;
            Cookie cookie = null;
            Cookie[] cookies = null;
            cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie1 : cookies) {
                    cookie = cookie1;
                    if ("id".equals(cookie.getName())) {
                        a.panggilAnggota(cookie.getValue());
                        p.setID_Peminjam(a.getID_Angota());
                    }
                }
            }
            Buku bk[] = null;
            while (request.getParameter("data" + String.valueOf(i)) != null) {
                bk[i].getBuku(request.getParameter("data" + String.valueOf(i)));
                i++;
            }
            for (int j = 0; j < i; j++) {
                p.setID_Buku(bk[j].getISBN());
                p.setTanggal_pinjam(timeStamp);
                p.setTanggal_kembali(null);
                p.setWaktu_pinjam(7);
                a.simpanPeminjaman(p);
                bk[i].cekKetersediaan(p.getID_Buku());
                bk[i].UpdateKetersediaan(p.getID_Buku(), (bk[i].getKetersediaan()-1));
            }
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
