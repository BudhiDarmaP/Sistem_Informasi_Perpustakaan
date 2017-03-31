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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Anggota a = null;
//        try {
//            if (request.getParameter("user[id]").equals("")) {
//                throw new Exception("ID user salah");
//            }
//            if (request.getParameter("user[password]").equals("")) {
//                throw new Exception("Password user salah");
//            }
//            if (request.getParameter("user[id]").equals("")&&
//                    request.getParameter("user[password]").equals("")) {
//                throw new Exception("ID dan Password belum terisi");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception ex) {
//            this.returnError(request, response, ex);
//        }
        String id = request.getParameter("user[id]");
        String pass = request.getParameter("user[password]");
        a = Anggota.LoginAnggota(id, pass);
        String nama=a.getNama();
        Cookie NAMA = new Cookie("nama", nama);
        Cookie ID = new Cookie("id", id);
        Cookie PASS = new Cookie("pass", pass);
        response.addCookie(NAMA);
        response.addCookie(ID);
        response.addCookie(PASS);
        this.tampil(request, response, "Selamat Datang, ");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public void returnError(HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("error", e.getMessage());
        dispatcher = request.getRequestDispatcher("error.jsp");
        dispatcher.forward(request, response);
    }
    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("indexLogin.jsp");
        dispatcher.forward(request, response);
    }
}
