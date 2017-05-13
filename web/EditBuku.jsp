<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Buku"%>
<!DOCTYPE html>
<%
    String key;
    if (request.getAttribute("demo-isbn") != null) {
        key = String.valueOf(request.getAttribute("info"));
    } else {
        key = request.getParameter("isbn");
    }
    Buku b = Buku.getBuku(key);
%>
<html>
    <head>
        <title>Edit Buku</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="assets/css/main.css" />
        <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
    </head>
    <body class="homepage">
        <div id="page-wrapper">
            <!-- Nav -->
            <nav id="nav">
                <ul>
                    <li class="current"><a href="Admin.jsp">Home</a></li>
                    <li>
                        <a href="#">Menu</a>
                        <ul>
                            <li><a href="TambahBuku.jsp">Tambah Buku</a></li>
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
                    <article>
                        <div class="features">
                            <h1>Tambahkan Buku</h1>
                            <form method="post" action="ControlEditBuku">
                                <!-- Break -->
                                <table>
                                    <tr><input type="text" id="demo-copy" name="demo-judul" placeholder="Judul" value="<%=b.getJudul()%>"/>
                                    <tr> <input type="text" id="demo-copy" name="demo-author" placeholder="Author" value="<%=b.getPenulis()%>"/>
                                    <tr><input type="text" id="demo-copy" name="demo-penerbit" placeholder="Penerbit" value="<%=b.getPenerbit()%>"/>
                                    <tr><ul class="actions">
                                        <li><input type="text" id="demo-copy" name="demo-tahun" placeholder="Tahun" value="<%=b.getTahun_Terbit()%>"/></li>
                                        <li><input type="number" id="demo-copy" name="demo-copy" placeholder="Copy" value="<%=b.getKetersediaan()%>"/></li>
                                    </ul>
                                    <tr><ul class="actions">
                                        <li><input type="submit" value="Tambah Buku" class="special" /></li>
                                        <li><input type="reset" value="Reset" /></li>
                                    </ul>
                                </table>
                                <%if (request.getAttribute("error") != null) {
                                %>
                                <p> <%= request.getAttribute("error")%></p>
                                <%}%>
                                <%if (request.getAttribute("info") != null) {
                                %>
                                <p> Buku Berhasil Diubah!</p>
                                <%}%>
                        </form>
                        </div>
                    </article>
                </section>
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