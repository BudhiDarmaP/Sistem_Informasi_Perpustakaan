/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Anggota;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ControlLogin", urlPatterns = {"/ControlLogin"})
public class ControlLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
            String pass = request.getParameter("user[password]");
            out.print("<html><head><body>"
                    + "<h1>"+pass+"</h1>"
                    + "</body></head></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //deklarasi
        Anggota a = null;
        String id = request.getParameter("user[id]");
        String pass = request.getParameter("user[password]");
        
        try {
            //Check kelengkapan ID dan password
            if (id.equals("")&&pass.equals("")) {
                throw new Exception("Silahkan Isi Form Login!");
            }
            else if (id.equals("")) {
                throw new Exception("ID Belum Terisi!");
            }
            else if (pass.equals("")) {
                throw new Exception("Password Belum Terisi!");
            }
            try {
                int format = Integer.parseInt(id);
            } catch (Exception ej) {
                throw new Exception("Format ID Salah!");
            }
        } catch (Exception e) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", e.getMessage());
            dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }
        if (a.cekAnggota(id) == 0) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Anggota tidak terdaftar!");
            dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }
        //Check kelengkapan password pada anggota
        if (a.LoginAnggota(id, pass)==false) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Password Salah");
            dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }
        a=Anggota.panggilAnggota(id);
        String pesan = a.getID_Angota();
        //simpan cookie
        Cookie ID = new LongLivedCookie("id", id);
        response.addCookie(ID);
        //lempar
        if (a.LoginAnggota(id, pass)==true&&id.equals("0")) {
            RequestDispatcher dispatcher;
            request.setAttribute("info", "Anda Masuk Sebagai ADMIN");
            dispatcher = request.getRequestDispatcher("Admin.jsp");
            dispatcher.forward(request, response);
        }
        this.tampil(request, response, pesan);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void returnError(HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("error", e.getMessage());
        dispatcher = request.getRequestDispatcher("errorNo_Login.jsp");
        dispatcher.forward(request, response);
    }

    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("indexLogin.jsp");
        dispatcher.forward(request, response);
    }
}
