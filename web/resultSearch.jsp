<%@page import="Model.Buku"%>
<%@page import="Model.Anggota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String key=request.getParameter("key");
    
        Buku b = new Buku();
    if (b.cekBuku(key)==false||key=="") {
        RequestDispatcher dispatcher;
        request.setAttribute("error", "Buku tidak ditemukan");
        dispatcher = request.getRequestDispatcher("errorNo_Login.jsp");
        dispatcher.forward(request, response);
    }
    Buku []bk=Buku.getListPencarian(key);
%>
<!DOCTYPE HTML>
<!--
        Dimension by HTML5 UP
        html5up.net | @ajlkn
        Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
    <head>
        <title>Search Result</title>
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
                        <h1><a href="index.jsp" id="logo">Perpustakaan Dewe</a></h1>
                        <p></p>
                    </div>
                </div>
            </header>

            <!-- Nav -->
            <nav id="nav">
                <ul>
                    <li class="current"><a href="index.jsp">Home</a></li>
                    <li>
                        <a href="#">Menu</a>
                        <ul>
                            <li><a href="Login.jsp">Login</a></li>
                            <li><a href="Daftar.jsp">Daftar</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>

            <!--Banner-->                                            
            <section id="banner">
                <form action="resultSearch.jsp" method="get">
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
                            <h3>Hasil Pencarian:</h3>
                            <table id="customers" >
                                <tr>
                                    <td>
                                        ISBN
                                    </td>
                                    <td>
                                        Judul
                                    </td>
                                    <td>
                                        Penulis
                                    </td>
                                    <td>
                                        Tahun Terbit
                                    </td>
                                    <td>
                                        Penerbit
                                    </td>
                                    <td>
                                        Ketersediaan
                                    </td>
                                </tr>
                                <%for (int i = 0; i < bk.length; i++) {%>
                                <tr>
                                    <td>
                                        <%= bk[i].getISBN()%></a>
                                    </td>
                                    <td>
                                        <%= bk[i].getJudul()%>
                                    </td>
                                    <td>
                                        <%= bk[i].getPenulis()%>
                                    </td>
                                    <td>
                                        <%= bk[i].getTahun_Terbit()%>
                                    </td>
                                    <td>
                                        <%= bk[i].getPenerbit()%>
                                    </td>
                                    <td>
                                        <%= bk[i].getKetersediaan()%>
                                    </td>
                                </tr>
                                <%}%>
                            </table>
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