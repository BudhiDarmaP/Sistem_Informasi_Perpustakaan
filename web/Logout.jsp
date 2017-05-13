<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Buku"%>
<!DOCTYPE html>

<html>
    <%  String information = String.valueOf(request.getAttribute("info"));
        request.setAttribute("info", information);
    %>
    <head>
        <title>Logout</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="assets/css/main.css" />
        <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
    </head>
    <body class="homepage">
        <div id="page-wrapper">

            <!-- Header -->

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
                        </ul>
                    </li>
                </ul>
            </nav>

            <!--Banner-->                                            
            <div id="banner-wrapper">
                <section id="banner">
                    <h4>Yakin akan Logout?</h4>
                    <form action="ControlLogout" method="post">
                        <table>
                            <tr><td><input type="submit" value="Logout"/>
                        </table>
                    </form>
                </section>
            </div>

            <!-- Footer -->
            <footer id="footer" class="container">

                <!-- Contact -->
                <section>
                    <h2 class="major"><span>Kontak</span></h2>
                    <ul class="contact">
                        <li><a class="icon fa-facebook" href="#"><span class="label">Facebook</span></a></li>
                        <li><a class="icon fa-twitter" href="#"><span class="label">Twitter</span></a></li>
                        <li><a class="icon fa-instagram" href="#"><span class="label">Instagram</span></a></li>
                    </ul>
                </section>

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