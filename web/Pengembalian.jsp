<%@page import="Model.Pinjam"%>
<%@page import="Model.Buku"%>
<%@page import="Model.Anggota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
        Dimension by HTML5 UP
        html5up.net | @ajlkn
        Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
    <%  String id = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                //cek nilai
                if (c.getName().equals("id")) {
                    id = c.getValue();
                }
            }
        } else {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Peminjaman Gagal");
            dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
        if (Pinjam.getListPinjaman(id) == null) {
            RequestDispatcher dispatcher;
            request.setAttribute("info", "Tidak Ada Peminjaman Saat Ini");
            dispatcher = request.getRequestDispatcher("info.jsp");
            dispatcher.forward(request, response);
        }
        Pinjam[] p = Pinjam.getListPinjaman(id);
        Pinjam list = new Pinjam();
    %>
    <head>
        <title>Pengembalian</title>
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
                        <h1><a href="indexLogin.jsp" id="logo">Perpustakaan Dewe</a></h1>
                        <p></p>
                    </div>
                </div>
            </header>

            <!-- Nav -->
            <nav id="nav">
                <ul>
                    <li class="current"><a href="indexLogin.jsp">Home</a></li>
                    <li>
                        <a href="#">Menu</a>
                        <ul>
                            <li><a href="Peminjaman.jsp">Peminjaman</a></li>
                            <li><a href="Logout.jsp">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>

            <!--Banner-->                                            
            <section id="banner">
                <form action="resultSearchLogin" method="get">
                    <table>
                        <tr><td><input type="text" name="key" id="email" placeholder="Cari Buku" />
                        <tr><td><input type="submit" value="Cari"/>
                    </table>
                </form>
            </section>

            <!--Main--> 
            <div id="main-wrapper">
                <div id="main" class="container">
                    <div class="row 200%">
                        <div class="12u">
                            <h3>Daftar Peminjaman:</h3>
                            <form action="ControlPengembalian" method="post">
                                <table id="customers" >
                                    <tr>
                                        <td>
                                            ID Buku
                                        </td>
                                        <td>
                                            Waktu Pinjam
                                        </td>
                                        <td>
                                            Tanggal Pinjam
                                        </td>
                                    </tr>
                                    <%for (int i = 0; i < list.cekPeminjaman(id); i++) {%>
                                    <tr>
                                        <td>
                                            <input type="submit"
                                                   name="isbn"
                                                   value="<%=p[i].getID_Buku()%>" 
                                                   height="0.75em" >
                                        </td>
                                        <td>
                                            <%= p[i].getWaktu_pinjam()%> Hari
                                        </td>
                                        <td>
                                            <%= p[i].getTanggal_pinjam()%>
                                        </td>
                                    </tr>
                                    <%}%>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>

                <!-- Footer -->
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