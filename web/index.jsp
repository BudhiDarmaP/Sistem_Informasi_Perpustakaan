<%-- 
    Document   : index
    Created on : Mar 28, 2017, 6:33:52 AM
    Author     : budhidarmap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                        <h1><a href="index.jsp" id="logo">Welcome to Perpustakaan Dewe</a></h1>
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
                            <li><a href="#">Login</a></li>
                            <li><a href="#">Daftar</a></li>
                            <li><a href="#">Peminjaman</a></li>
                            <li><a href="#">Pengembalian</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>

            <!--Banner-->                                            
            <div id="banner-wrapper">
                <form action="action" aglin="center">
                    <table>
                        <tr><td><input type="Text" name="search" id="email" placeholder="Cari Buku" />
                        <tr><td><input type="submit" value="Cari" />
                    </table>
                </form>
            </div>

            <!--			 Main 
                                            <div id="main-wrapper">
                                                    <div id="main" class="container">
                                                            <div class="row 200%">
                                                                    <div class="12u">
            
                                                                             Highlight 
                                                                                    <section class="box highlight">
                                                                                            <ul class="special">
                                                                                                    <li><a href="#" class="icon fa-search"><span class="label">Magnifier</span></a></li>
                                                                                                    <li><a href="#" class="icon fa-tablet"><span class="label">Tablet</span></a></li>
                                                                                                    <li><a href="#" class="icon fa-flask"><span class="label">Flask</span></a></li>
                                                                                                    <li><a href="#" class="icon fa-cog"><span class="label">Cog?</span></a></li>
                                                                                            </ul>
                                                                                            <header>
                                                                                                    <h2>A random assortment of icons in circles</h2>
                                                                                                    <p>And some text that attempts to explain their significance</p>
                                                                                            </header>
                                                                                            <p>
                                                                                                    Phasellus quam turpis, feugiat sit amet ornare in, hendrerit in lectus. Praesent semper mod quis eget mi. Etiam eu<br />
                                                                                                    ante risus. Aliquam erat volutpat. Aliquam luctus et mattis lectus amet pulvinar. Nam nec turpis consequat.
                                                                                            </p>
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
                                                                                                                                    <a href="#" class="image featured"><img src="images/pic01.jpg" alt="" /></a>
                                                                                                                                    <h3><a href="#">A Subheading</a></h3>
                                                                                                                                    <p>
                                                                                                                                            Phasellus quam turpis, feugiat sit amet ornare in, a hendrerit in
                                                                                                                                            lectus dolore. Praesent semper mod quis eget sed etiam eu ante risus.
                                                                                                                                    </p>
                                                                                                                            </section>
            
                                                                                                            </div>
                                                                                                            <div class="3u 12u(mobile)">
            
                                                                                                                     Feature 
                                                                                                                            <section class="box feature">
                                                                                                                                    <a href="#" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
                                                                                                                                    <h3><a href="#">Another Subheading</a></h3>
                                                                                                                                    <p>
                                                                                                                                            Phasellus quam turpis, feugiat sit amet ornare in, a hendrerit in
                                                                                                                                            lectus dolore. Praesent semper mod quis eget sed etiam eu ante risus.
                                                                                                                                    </p>
                                                                                                                            </section>
            
                                                                                                            </div>
                                                                                                            <div class="3u 12u(mobile)">
            
                                                                                                                     Feature 
                                                                                                                            <section class="box feature">
                                                                                                                                    <a href="#" class="image featured"><img src="images/pic03.jpg" alt="" /></a>
                                                                                                                                    <h3><a href="#">And Another</a></h3>
                                                                                                                                    <p>
                                                                                                                                            Phasellus quam turpis, feugiat sit amet ornare in, a hendrerit in
                                                                                                                                            lectus dolore. Praesent semper mod quis eget sed etiam eu ante risus.
                                                                                                                                    </p>
                                                                                                                            </section>
            
                                                                                                            </div>
                                                                                                            <div class="3u 12u(mobile)">
            
                                                                                                                     Feature 
                                                                                                                            <section class="box feature">
                                                                                                                                    <a href="#" class="image featured"><img src="images/pic04.jpg" alt="" /></a>
                                                                                                                                    <h3><a href="#">And One More</a></h3>
                                                                                                                                    <p>
                                                                                                                                            Phasellus quam turpis, feugiat sit amet ornare in, a hendrerit in
                                                                                                                                            lectus dolore. Praesent semper mod quis eget sed etiam eu ante risus.
                                                                                                                                    </p>
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
                                                                    <div class="12u">
            
                                                                             Blog 
                                                                                    <section class="box blog">
                                                                                            <h2 class="major"><span>Another Major Heading</span></h2>
                                                                                            <div>
                                                                                                    <div class="row">
                                                                                                            <div class="9u 12u(mobile)">
                                                                                                                    <div class="content content-left">
            
                                                                                                                             Featured Post 
                                                                                                                                    <article class="box post">
                                                                                                                                            <header>
                                                                                                                                                    <h3><a href="#">Here's a really big heading</a></h3>
                                                                                                                                                    <p>With a smaller subtitle that attempts to elaborate</p>
                                                                                                                                                    <ul class="meta">
                                                                                                                                                            <li class="icon fa-clock-o">15 minutes ago</li>
                                                                                                                                                            <li class="icon fa-comments"><a href="#">8</a></li>
                                                                                                                                                    </ul>
                                                                                                                                            </header>
                                                                                                                                            <a href="#" class="image featured"><img src="images/pic05.jpg" alt="" /></a>
                                                                                                                                            <p>
                                                                                                                                                    Phasellus quam turpis, feugiat sit amet ornare in, a hendrerit in lectus. Praesent
                                                                                                                                                    semper mod quis eget mi. Etiam sed ante risus aliquam erat et volutpat. Praesent a
                                                                                                                                                    dapibus velit. Curabitur sed nisi nunc, accumsan vestibulum lectus. Lorem ipsum
                                                                                                                                                    dolor sit non aliquet sed, tempor et dolor.  Praesent a dapibus velit. Curabitur
                                                                                                                                                    accumsan.
                                                                                                                                            </p>
                                                                                                                                            <a href="#" class="button">Continue Reading</a>
                                                                                                                                    </article>
            
                                                                                                                    </div>
                                                                                                            </div>
                                                                                                            <div class="3u 12u(mobile)">
                                                                                                                    <div class="sidebar">
            
                                                                                                                             Archives 
                                                                                                                                    <ul class="divided">
                                                                                                                                            <li>
                                                                                                                                                    <article class="box post-summary">
                                                                                                                                                            <h3><a href="#">A Subheading</a></h3>
                                                                                                                                                            <ul class="meta">
                                                                                                                                                                    <li class="icon fa-clock-o">6 hours ago</li>
                                                                                                                                                                    <li class="icon fa-comments"><a href="#">34</a></li>
                                                                                                                                                            </ul>
                                                                                                                                                    </article>
                                                                                                                                            </li>
                                                                                                                                            <li>
                                                                                                                                                    <article class="box post-summary">
                                                                                                                                                            <h3><a href="#">Another Subheading</a></h3>
                                                                                                                                                            <ul class="meta">
                                                                                                                                                                    <li class="icon fa-clock-o">9 hours ago</li>
                                                                                                                                                                    <li class="icon fa-comments"><a href="#">27</a></li>
                                                                                                                                                            </ul>
                                                                                                                                                    </article>
                                                                                                                                            </li>
                                                                                                                                            <li>
                                                                                                                                                    <article class="box post-summary">
                                                                                                                                                            <h3><a href="#">And Another</a></h3>
                                                                                                                                                            <ul class="meta">
                                                                                                                                                                    <li class="icon fa-clock-o">Yesterday</li>
                                                                                                                                                                    <li class="icon fa-comments"><a href="#">184</a></li>
                                                                                                                                                            </ul>
                                                                                                                                                    </article>
                                                                                                                                            </li>
                                                                                                                                            <li>
                                                                                                                                                    <article class="box post-summary">
                                                                                                                                                            <h3><a href="#">And Another</a></h3>
                                                                                                                                                            <ul class="meta">
                                                                                                                                                                    <li class="icon fa-clock-o">2 days ago</li>
                                                                                                                                                                    <li class="icon fa-comments"><a href="#">286</a></li>
                                                                                                                                                            </ul>
                                                                                                                                                    </article>
                                                                                                                                            </li>
                                                                                                                                            <li>
                                                                                                                                                    <article class="box post-summary">
                                                                                                                                                            <h3><a href="#">And One More</a></h3>
                                                                                                                                                            <ul class="meta">
                                                                                                                                                                    <li class="icon fa-clock-o">3 days ago</li>
                                                                                                                                                                    <li class="icon fa-comments"><a href="#">8,086</a></li>
                                                                                                                                                            </ul>
                                                                                                                                                    </article>
                                                                                                                                            </li>
                                                                                                                                    </ul>
                                                                                                                                    <a href="#" class="button alt">Browse Archives</a>
            
                                                                                                                    </div>
                                                                                                            </div>
                                                                                                    </div>
                                                                                            </div>
                                                                                    </section>
            
                                                                    </div>
                                                            </div>
                                                    </div>
                                            </div>-->

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
                            <h2 class="major"><span>Get in touch</span></h2>
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