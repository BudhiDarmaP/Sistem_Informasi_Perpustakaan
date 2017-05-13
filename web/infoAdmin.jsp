<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
        Spectral by HTML5 UP
        html5up.net | @ajlkn
        Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
    <%  String information = String.valueOf(request.getAttribute("info"));
        request.setAttribute("info", information);
    %>
    <head>
        <title>Informasi</title>
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
                        <h1><a href="Admin.jsp" id="logo">Perpustakaan Dewe</a></h1>
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
                    <h2><%=request.getAttribute("info")%></h2>
                </section>
            </div>

            <!--Footer--> 
            <footer id="footer" class="container">
                <div class="row 200%">
                    <div class="12u">

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