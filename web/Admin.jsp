<%-- 
    Document   : index
    Created on : Mar 28, 2017, 6:33:52 AM
    Author     : budhidarmap
--%>

<%@page import="Control.CookieUtilities"%>
<%@page import="Model.Anggota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Buku"%>
<%@page import='javax.servlet.http.Cookie'%>
<!DOCTYPE html>

<html>
    <%  if (CookieUtilities.getCookie(request, "id") == null) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Login Expired, Silahkan Login Ulang");
            dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }
        Cookie cookie = CookieUtilities.getCookie(request, "id");
        String id = cookie.getValue();
    %>
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
                        <h1>Selamat Datang</h1>
                        <h6><%= Anggota.panggilAnggota(id).getNama()%>.</h6>
                    </div>
                </div>
            </header>

            <!-- Nav -->
            <nav id="nav">
                <ul>
                    <li class="current">Home</a></li>
                    <li>
                        <a href="#">Menu</a>
                        <ul>
                            <li><a href="TambahBuku.jsp">Tambah Buku</a></li>
                            <li><a href="searchEditBuku.jsp">Edit Buku</a></li>
                            <li><a href="searchHapusBuku.jsp">Hapus Buku</a></li>
                            <li><a href="searchHapusAnggota.jsp">Hapus Anggota</a></li>
                            <li><a href="LogoutAdmin.jsp">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>

            <!--Banner-->                                            
            <div id="banner-wrapper">
                <section id="banner">
                    <h2>Pencarian Buku</h2>
                    <form action="resultSearchAdmin.jsp" method="get">
                        <table>
                            <tr><td><input type="text" name="key" id="email" placeholder="Cari Buku" />
                            <tr><td><input type="submit" value="Cari"/>
                        </table>
                    </form>
                </section>
            </div>


            <!--Footer--> 
            <footer id="footer" class="container">
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