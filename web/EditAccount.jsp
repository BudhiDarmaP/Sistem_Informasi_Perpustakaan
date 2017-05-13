<%@page import="Control.CookieUtilities"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Buku"%>
<!DOCTYPE html>
<%  if (CookieUtilities.getCookie(request, "id") == null) {
        RequestDispatcher dispatcher;
        request.setAttribute("error", "Login Expired, Silahkan Login Ulang");
        dispatcher = request.getRequestDispatcher("Login.jsp");
        dispatcher.forward(request, response);
    }
    Cookie cookie = CookieUtilities.getCookie(request, "id");
    String id = cookie.getValue();
    Anggota a = Anggota.panggilAnggota(id);
%>
<html>
    <head>
        <title>Pendaftaran</title>
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
                            <li><a href="EditPassword.jsp">Edit Password</a></li>
                            <li><a href="Logout.jsp">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>

            <!--Banner-->                                            
            <div id="banner-wrapper">
                <section id="banner">
                    <h2>Edit Akun</h2>
                    <form action="ControlEditAccount" method="post">
                        <table>
                            <tr><td><input type="text" name="nama" id="email" value="<%=a.getNama()%>"/>
                            <tr><td><input type="email" name="email" id="email" value="<%=a.getEmail()%>"/>
                            <tr><td><input type="text" name="no_tlp" id="phone" value="<%=a.getNo_tlp()%>"/>
                            <tr><td><input type="text" name="alamat" id="alamat" value="<%=a.getAlamat()%>"/>
                            <tr><td><input type="password" name="password" id="password" placeholder="Password" />
                            <tr><ul class="actions">
                                <li><input type="submit" value="Edit" class="special" /></li>
                                <li><input type="reset" value="Reset" /></li>
                        </table>
                    </form>
                </section>
            </div>

            <!-- Footer -->
            <footer id="footer" class="container">
                <div class="row 200%">
                    <div class="12u">

                        <!-- About -->
                        <section>
                            <h2 class="major"><span>What's this about?</span></h2>
                            <p>
                                <strong>Blank</strong>
                            </p>
                        </section>

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