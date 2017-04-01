<%-- 
    Document   : index
    Created on : Mar 28, 2017, 6:33:52 AM
    Author     : budhidarmap
--%>

<%@page import="Model.Anggota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Buku"%>
<%@page import='javax.servlet.http.Cookie'%>
<!DOCTYPE html>
<%
    String key = request.getParameter("key");

    Buku[] bk = Buku.getListPencarian(key);
    if (Buku.getListPencarian(key) == null) {
        RequestDispatcher dispatcher;
        request.setAttribute("error", "Buku Tidak Ditemukan");
        dispatcher = request.getRequestDispatcher("error.jsp");
        dispatcher.forward(request, response);
    }
%>
<html>
    <head>
        <title>Home Perpustakaan Dewe</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="assets/css/main.css" />
        <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
    </head>
    <body class="homepage">
        <div id="page-wrapper">

            <!-- Header -->
            <header id="header">
                <div class="logo container">
                    <div>
                        <h1><%= request.getAttribute("info")%> 
                            di Perpustakaan Dewe</h1>
                    </div>
                </div>
            </header>
            <!--%  Anggota a = new Anggota();
                Cookie cookie = null;
                Cookie[] cookies = null;
                // Get cookies
                cookies = request.getCookies();
                if (cookies != null) {
                    for (int i = 0; i < cookies.length; i++) {
                        cookie = cookies[i];
                        cookie.getName();
                        String id = cookie.getValue().substring(33, 38);%--!>
            <%--<%= id%>--%>
            <!--<--%}-->
            <!--} else {%>-->
            <!--<a href="Login.jsp">No Login  </a>-->
            <!--%}%--!>

            <!-- Nav -->
            <nav id="nav">
                <ul>
                    <li class="current">Home</a></li>
                    <li>
                        <a href="#">Menu</a>
                        <ul>
                            <li><a href="Peminjaman.jsp">Peminjaman</a></li>
                            <li><a href="Pengembalian.jsp">Pengembalian</a></li>
                            <li><a href="Logout.jsp">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>

            <!--Banner-->                                            
            <div id="banner-wrapper">
                <section id="banner">
                    <h2>Pencarian Buku</h2>
                    <form action="resultSearchLogin.jsp" method="get">
                        <table>
                            <tr><td><input type="text" name="key" id="email" placeholder="Cari Buku" />
                            <tr><td><input type="submit" value="Cari"/>
                        </table>
                    </form>
                </section>
            </div>

            <!--Main--> 
            <!--            <div id="main-wrapper">
                            <div id="main" class="container">
                                <div class="row 200%">
                                    <div class="12u">
            
                                        Highlight 
                                        <section class="box highlight">
                                        </section>
            
                                    </div>
                                </div>
                                <div class="row 200%">
                                    <div class="12u">
            
                                        Features 
                                        <section class="box features">
                                            <h2 class="major"><span>A Major Heading</span></h2>
                                            <div>
                                                <div class="row">
                                                    <div class="3u 12u(mobile)">
            
                                                        Feature 
                                                        <section class="box feature">
                                                        </section>
            
                                                    </div>
                                                    <div class="3u 12u(mobile)">
            
                                                        Feature 
                                                        <section class="box feature">
                                                        </section>
            
                                                    </div>
                                                    <div class="3u 12u(mobile)">
            
                                                        Feature 
                                                        <section class="box feature">
                                                        </section>
            
                                                    </div>
                                                    <div class="3u 12u(mobile)">
            
                                                        Feature 
                                                        <section class="box feature">
                                                        </section>
            
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="12u">
                                                        <ul class="actions">
                                                            <li><a href="#" class="button big">Do Something</a></li>
                                                            <li><a href="#" class="button alt big">Think About It</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </section>
            
                                    </div>
                                </div>
                                <div class="row 200%">
                                    <div class="12u">-->

            <!--Footer--> 
            <footer id="footer" class="container">
                <div class="row 200%">
                    <div class="12u">

                        <!--About--> 
                        <!--                        <section>
                                                    <h2 class="major"><span>What's this about?</span></h2>
                                                    <p>
                                                        <strong>Blank</strong>
                                                    </p>
                                                </section>-->

                    </div>
                </div>
                <div class="row 200%">
                    <div class="12u">

                        <!-- Contact -->
                        <section>
                            <h2 class="major"><span>Kontak</span></h2>
                            <ul class="contact">
                                <li><a class="icon fa-facebook" href="#"><span class="label">Facebook</span></a></li>
                                <li><a class="icon fa-twitter" href="#"><span class="label">Twitter</span></a></li>
                                <li><a class="icon fa-instagram" href="#"><span class="label">Instagram</span></a></li>
                            </ul>
                        </section>
                    </div>
                </div>

                <!-- Copyright -->
                <div id="copyright">
                    <ul class="menu">
                        <li>&copy; Sanata Dharma University. All rights reserved</li><li>Design: <a href="http://budhidarmap.github.io">Team</a></li>
                    </ul>
                </div>
            </footer>
        </div>

        <!-- Scripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/jquery.dropotron.min.js"></script>
        <script src="assets/js/skel.min.js"></script>
        <script src="assets/js/skel-viewport.min.js"></script>
        <script src="assets/js/util.js"></script>
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="assets/js/main.js"></script>

    </body>
</html>