<%@page import="Model.Buku"%>
<%@page import="Model.Anggota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String key = request.getParameter("key");
    Buku[] bk = Buku.getListPencarian(key);
    if (bk.length < 1) {
        RequestDispatcher dispatcher;
        request.setAttribute("error", "Buku tidak ditemukan");
        dispatcher = request.getRequestDispatcher("error.jsp");
        dispatcher.forward(request, response);
    }
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
                            <li><a href="Pengembalian.jsp">Pengembalian</a></li>
                            <li><a href="EditAccount.jsp">Edit Account</a></li>
                            <li><a href="EditPassword.jsp">Edit Password</a></li>
                            <li><a href="Logout.jsp">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>

            <!--Banner-->                                            
            <section id="banner">
                <form action="resultSearchLogin.jsp" method="get">
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
                            <p>Klik Kode ISBN untuk melakukan peminjaman</p>
                            <form action="ControlPeminjaman" method="post">
                                <table id="customers" >
                                    <tr>
                                        <th>
                                            <b>ISBN</b>
                                        </th>
                                        <th>
                                            <b>Judul</b>
                                        </th>
                                        <th>
                                            <b>Penulis</b>
                                        </th>
                                        <th>
                                            <b>Tahun Terbit</b>
                                        </th>
                                        <th>
                                            <b>Penerbit</b>
                                        </th>
                                        <th>
                                            <b>Ketersediaan</b>
                                        </th>
                                    </tr>
                                    <%for (int i = 0; i < bk.length; i++) {%>
                                    <tr>
                                        <td><input type="submit" name="isbn"
                                                   value="<%= bk[i].getISBN()%>" 
                                                   height="0.75em"/>
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