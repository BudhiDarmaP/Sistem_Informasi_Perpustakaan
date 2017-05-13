<%@page import="Model.Anggota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Buku"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
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
                    <li><a href="Peminjaman.jsp">Peminjaman</a></li>
                    <li><a href="Pengembalian.jsp">Pengembalian</a></li>
                    <li><a href="EditAccount.jsp">Edit Account</a></li>
                    <li><a href="Logout.jsp">Logout</a></li>
                    </li>
                </ul>
            </nav>

            <!--Banner-->                                            
            <div id="banner-wrapper">
                <section id="banner">
                    <h2>Login</h2>
                    <form action="ControlEditAccount" method="post">
                        <table>
                            <tr><td><input type="password" name="user[newPassword]" id="pass" placeholder="New Password" />
                            <tr><td><input type="password" name="user[password]" id="pass" placeholder="Password" />
                            <tr><td><input type="submit" value="Edit"/>
                                    <%if (request.getAttribute("error") != null) {%>
                                    <p><%= request.getAttribute("error")%></p>
                                    <%}%>
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