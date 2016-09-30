<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Congreso de tecnologia e informatica">
    <meta name="author" content="Tittarelli Gonzalo">

	<title><tiles:insertAttribute name='titulo' ignore='true' /></title>

    <!-- Bootstrap Core CSS -->
    <link href="template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="template/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link href="template/css/fonts.css" rel="stylesheet" type='text/css'>

    <!-- Plugin CSS -->
    <link href="template/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="template/css/creative.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top">

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">D S S D</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#acerca">Acerca</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#temas">Temas</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#inscripcion">Inscripcion</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contacto">Contacto</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading">Congreso de Tecnología e Informática</h1>
                <hr>
                <p style="font-family: 'Josefin Sans'; font-size: 34px">Business process management (BPM) &amp; Cloud Computing</p>
                <a href="#inscripcion" class="btn btn-primary btn-xl page-scroll">Inscribirse</a>
            </div>
        </div>
    </header>

    <section class="bg-primary" id="acerca">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Animate</h2>
                    <hr class="light">
                    <p class="text-faded" style="font-family: 'Bubbler One';font-size: 20px;text-align: justify">Tan solo deberás inscribir tu trabajo el cual será evaluado por un integrante del comité científico relacionado con la temática del mismo. Una vez evaluado el mismo se te avisará por mail el resultado.</p>
                    <a href="#inscripcion" class="page-scroll btn btn-default btn-xl sr-button">Inscribilo</a>
                </div>
            </div>
        </div>
    </section>

    <section id="temas">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Temáticas</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-cloud text-primary sr-icons"></i>
                        <h3>Cloud Computing</h3>
                        <p class="text-muted" style="font-family: 'Bubbler One';font-size: 17px">Paradigma que permite ofrecer servicios de computación a través de una red.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-cogs text-primary sr-icons"></i>
                        <h3>Business process management</h3>
                        <p class="text-muted" style="font-family: 'Bubbler One';font-size: 17px">Metodología corporativa y disciplina de gestión, cuyo objetivo es mejorar el desempeño y la optimización de los procesos de negocio de una organización.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-connectdevelop text-primary sr-icons"></i>
                        <h3>Web Services</h3>
                        <p class="text-muted" style="font-family: 'Bubbler One';font-size: 17px">Tecnología que utiliza un conjunto de protocolos y estándares que sirven para intercambiar datos entre aplicaciones.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-cogs text-primary sr-icons"></i>
                        <h3>Service Oriented Architecture</h3>
                        <p class="text-muted" style="font-family: 'Bubbler One';font-size: 17px">Paradigma de arquitectura para diseñar y desarrollar sistemas distribuidos.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <section id="inscripcion">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Inscribir Trabajo</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
            	<jsp:include page="inscripcion.jsp" />
            </div>
        </div>
    </section>  
      
    <section id="contacto" class="bg-dark">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Vamos a estar en contacto</h2>
                    <hr class="primary">
                    <p class="text-muted" style="font-family: 'Bubbler One';font-size: 17px;text-align: justify">Ante cualquier consulta relacionada con el contenido/participación del congreso puede contactarse con nosotros.</p>
                </div>
                <div class="col-lg-12 text-center">
                    <i class="fa fa-envelope-o fa-3x text-primary sr-contact"></i>
                    <p style="font-family: 'Bubbler One', sans-serif; font-size: 18px"><a href="mailto:your-email@your-domain.com">desarrollosoftwaredistribuido@gmail.com</a></p>
                </div>
                <div class="col-lg-12 text-center">
                    <p style="font-family: 'Bubbler One', sans-serif; font-size: 16px">Tittarelli Gonzalo | Julian Da Costa Faro</p>
                </div>
            </div>
        </div>
    </section>

    <!-- jQuery -->
    <script src="template/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="template/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="template/vendor/jquery/jquery.easing.min.js"></script>
    <script src="template/vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="template/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Theme JavaScript -->
    <script src="template/js/creative.min.js"></script>
    
    <script src="formvalidation/dist/js/formValidation.min.js"></script>
	<script src="formvalidation/dist/js/framework/bootstrap.min.js"></script>   
	<script src="js/jquery.bootstrap.wizard.min.js"></script>

</body>

</html>