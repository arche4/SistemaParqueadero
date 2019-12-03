<%-- 
    Document   : home
    Created on : 30/11/2019, 10:34:30 PM
    Author     : manue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <title>Sistema Parqueadero</title>

        <!-- Favicons -->
        <link href="${pageContext.servletContext.contextPath}/img/favicon.png" rel="icon">
        <link href="${pageContext.servletContext.contextPath}/img/apple-touch-icon.png" rel="apple-touch-icon">
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.servletContext.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--external css-->
        <link href="${pageContext.servletContext.contextPath}/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="${pageContext.servletContext.contextPath}/lib/advanced-datatable/css/demo_page.css" rel="stylesheet" />
        <link href="${pageContext.servletContext.contextPath}/lib/advanced-datatable/css/demo_table.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/lib/advanced-datatable/css/DT_bootstrap.css" />
        <link rel="stylesheet" type="${pageContext.servletContext.contextPath}/text/css" href="lib/bootstrap-fileupload/bootstrap-fileupload.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/lib/bootstrap-datepicker/css/datepicker.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/lib/bootstrap-daterangepicker/daterangepicker.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/lib/bootstrap-timepicker/compiled/timepicker.css" />
        <link href="${pageContext.servletContext.contextPath}/lib/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet" type="text/css"/>

        <!-- Custom styles for this template -->
        <link href="${pageContext.servletContext.contextPath}/lib/bootstrap-datepicker/css/datepicker.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/css/style-responsive.css" rel="stylesheet">

        <!-- =======================================================
          Template Name: Dashio
          Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
          Author: TemplateMag.com
          License: https://templatemag.com/license/
        ======================================================= -->
    </head>

    <body>
        <section id="container">
            <!-- **********************************************************************************************************************************************************
                TOP BAR CONTENT & NOTIFICATIONS
                *********************************************************************************************************************************************************** -->
            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a href="index.html" class="logo"><b style="font: oblique bold 70% cursive;">Mattelsa<span></span></b></a>
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li><a class="logout" href="index.jsp">Logout</a></li>
                    </ul>
                </div>
            </header>
            <!--header end-->
            <!-- **********************************************************************************************************************************************************
                MAIN SIDEBAR MENU
                *********************************************************************************************************************************************************** -->
            <!--sidebar start-->
            <aside>
                <div id="sidebar" class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">
                        <p class="centered"><a href="profile.html"><img src="${pageContext.servletContext.contextPath}/img/ui-sam.jpg" class="img-circle" width="80"></a></p>
                        <h5 class="centered" id="usuario">${sessionScope.USUARIO}</h5>
                        <li class="mt">
                            <a href="${pageContext.servletContext.contextPath}/views/ingreso.jsp">
                                <i class="fa fa-truck"></i>
                                <span>Ingreso Parqueadero</span>
                            </a>

                            <a href="${pageContext.servletContext.contextPath}/views/vehiculo.jsp">
                                <i class="fa fa-truck"></i>
                                <span>Vehiculo</span>
                            </a>
                            <a href="${pageContext.servletContext.contextPath}/views/informe.jsp">
                                <i class="fa fa-truck"></i>
                                <span>Informe</span>
                            </a>
                        </li>
                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->
            <!-- **********************************************************************************************************************************************************
                MAIN CONTENT
                *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <h3><i class="fa fa-angle-right"></i>Ingreso Parqueadero</h3>
                    <button type="button" class="btn btn-theme" data-toggle="modal" data-target="#registroIngreso">
                        Registrar Ingreso
                    </button>
                    <button type="button" class="btn btn-theme" data-toggle="modal" data-target="#vehiculo">
                        Registrar Vehiculo
                    </button>

                    <div class="alert alert-success" id="Exitoso" style="display:none;">
                        <strong>Super!</strong>Datos Guardados Correctamente
                    </div>
                    <div class="alert alert-danger" id="Error" style="display:none;">
                        <strong>Error!</strong>Recuerda debes llenar todos los campos
                    </div>
                    <hr class="line-seprate">
                    <div class="row mb">
                        <!-- page start-->
                        <div class="content-panel">
                            <div class="adv-table">
                                <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered" id="hidden-table-info">
                                    <thead>
                                        <tr>
                                            <th>Cedula</th>
                                            <th>Placa</th>
                                            <th class="hidden-phone">fecha ingreso</th>
                                            <th class="hidden-phone">fecha saida</th>
                                            <th class="hidden-phone">Vehiculo</th>
                                            <th class="hidden-phone">Celda</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="gradeX">
                                            <td>Trident</td>
                                            <td>Internet Explorer 4.0</td>
                                            <td class="hidden-phone">Win 95+</td>
                                            <td class="center hidden-phone">4</td>
                                            <td class="center hidden-phone">X</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="modal fade" id="registroIngreso">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Registrar ingreso</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <br/>    
                                    <div class="modal-body">

                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                
                                                <label for="cedula">Cedula</label>
                                                <input type="text" class="form-control" id="cedula" name="cedula" placeholder="Cedula">
                                            </div>

                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="fechaIngreso">Fecha  Ingreso</label>
                                            <input type="datetime-local" class="form-control" id="fechaIngreso" name="fechaIngreso">                                          
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="celda">Celda</label>
                                                <input type="text" class="form-control" id="cedula" name="celda" placeholder="Cedula">
                                            </div>

                                        </div>

                                        <br/>
                                        <br/>
                                        <br/>
                                        <br/>
                                        <label class="checkbox-inline"><input type="checkbox" name="biciIngreso" id="biciIngreso" value="1" onchange="javascript:showBicicletaIngreso()" />
                                            Bicicleta</label>
                                        <label class="checkbox-inline"><input type="checkbox" name="motoIngreso" id="motoIngreso" value="1" onchange="javascript:showMotoIngreso()" />
                                            Moto</label>
                                        <label class="checkbox-inline"><input type="checkbox" name="carroIngreso" id="carroIngreso" value="1" onchange="javascript:showCarroIngreso()" />
                                            Carro </label>
                                        
                                            <div id="content1" style="display: none;">
                                                <div class="adv-table">
                                                <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered" id="hidden-table-info">
                                                    <thead>
                                                        <tr>
                                                            <th>Vehiculo</th>
                                                            <th class="hidden-phone">Selecionar</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="Bicicleta" items="${sessionScope.Bicicleta}" varStatus="myIndex">
                                                            <tr class="gradeA">
                                                                <td><c:out value="Bicicleta"/></td>
                                                                <td><label class="checkbox-inline"><input type="checkbox" name="biciIngreso" id="biciIngreso" value="1" onchange="javascript:showBicicletaIngreso()" />
                                                                    </label></td>
                                                            </tr>
                                                        </c:forEach>


                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div id="content2" style="display: none;">
                                            <div class="adv-table">
                                                <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered" id="hidden-table-info">
                                                    <thead>
                                                        <tr>
                                                            <th>Vehiculo</th>
                                                            <th class="hidden-phone">Placa</th>
                                                            <th class="hidden-phone">Selecionar</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="Moto" items="${sessionScope.Moto}" varStatus="myIndex">
                                                            <tr class="gradeA">
                                                                <td><c:out value="Bicicleta"/></td>
                                                                <td><c:out value="${Moto.getPlaca()}"/></td>
                                                                <td><label class="checkbox-inline"><input type="checkbox" name="biciIngreso" id="biciIngreso" value="1" onchange="javascript:showBicicletaIngreso()" />
                                                                    </label></td>
                                                            </tr>
                                                        </c:forEach>


                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        
                                        <div id="content4" style="display: none;">
                                            <div class="adv-table">
                                                <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered" id="hidden-table-info">
                                                    <thead>
                                                        <tr>
                                                            <th>Vehiculo</th>
                                                            <th class="hidden-phone">Placa</th>
                                                            <th class="hidden-phone">Selecionar</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="Carro" items="${sessionScope.Carro}" varStatus="myIndex">
                                                            <tr class="gradeA">
                                                                <td><c:out value="Carro"/></td>
                                                                <td><c:out value="${Carro.getPlaca()}"/></td>
                                                                <td><label class="checkbox-inline"><input type="checkbox" name="biciIngreso" id="biciIngreso" value="1" onchange="javascript:showBicicletaIngreso()" />
                                                                    </label></td>
                                                            </tr>
                                                        </c:forEach>


                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        </div>

                                        <br/>
                                        <br/>
                                        <br/>
                                        <br/>
                                        <br/>
                                        <br/>
                                        <br/>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">cerrar</button>
                                        <button type="button" class="btn btn-primary">Registrar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal fade" id="vehiculo">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Registrar Vehiculo</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <label class="checkbox-inline"><input type="checkbox" name="bicicleta" id="bicicleta" value="1" onchange="javascript:showBicicleta()" />
                                            Bicicleta</label>
                                        <label class="checkbox-inline"><input type="checkbox" name="moto" id="moto" value="1" onchange="javascript:showMoto()" />
                                            Moto</label>
                                        <label class="checkbox-inline"><input type="checkbox" name="carro" id="carro" value="1" onchange="javascript:showCarro()" />
                                            Carro </label>
                                        <div id="content3" style="display: none;">
                                            <br/>                                         
                                            <button type="button" class="btn btn-theme" data-toggle="modal" data-target="#foto">
                                                Tomar Foto
                                            </button>
                                            <br/>
                                            <br/>
                                            <!-- 
                                            <div class="form-group last">
                                                <div class="col-md-9">
                                                    <form  method="post" name="upload" id="upload" action="">
                                                        <div class="fileupload fileupload-new" data-provides="fileupload">
                                                            <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                                                <img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=no+image" alt="" />
                                                            </div>
                                                            <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                                                            <div>
                                                                <span class="btn btn-theme02 btn-file">
                                                                    <span class="fileupload-new"><i class="fa fa-paperclip"></i> Select image</span>
                                                                    <span class="fileupload-exists"><i class="fa fa-undo"></i> Change</span>
                                                                    <input type="file" class="default" />
                                                                </span>
                                                                <a href="advanced_form_components.html#" class="btn btn-theme04 fileupload-exists" data-dismiss="fileupload"><i class="fa fa-trash-o"></i> Remove</a>
                                                                <button class="btn btn-theme" name="upload" value="upload" type="submit" onclick="return validarUpload()">Cargar</button>
    
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                            -->

                                        </div>
                                        <div id="contentMoto" style="display: none;">
                                            <br/>
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <input type="text" class="form-control" id="cilindraje" name="cilindraje" placeholder="Cilindraje">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <input type="text" class="form-control" id="tiempo" name="tiempo" placeholder="Tiempos">
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <br/>
                                                    <div class="form-group col-md-6">
                                                        <input type="text" class="form-control" id="placa" name="placa" placeholder="Placa">
                                                    </div>
                                                </div>
                                                <br/>
                                                <button type="button" class="btn btn-theme" data-toggle="modal" data-target="#foto">
                                                    Tomar Foto
                                                </button>
                                            </div>
                                        </div>
                                        <br/>
                                        <div id="contentCarro" style="display: none;">
                                            <br/>
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <input type="text" class="form-control" id="modelo" name="modelo" placeholder="Modelo">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <input type="text" class="form-control" id="numeroPuertas" name="numeroPuertas" placeholder="Cantidad de Puertas">
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <br/>
                                                    <div class="form-group col-md-6">
                                                        <input type="text" class="form-control" id="placaCarro" name="placaCarro" placeholder="Placa ">
                                                    </div>
                                                    <button type="button" class="btn btn-theme" data-toggle="modal" data-target="#foto">
                                                        Tomar Foto
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <br/>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-theme">Guardar</button>
                                        <button class="btn btn-theme" name="crearVehiculo" value="crearVehiculo" type="submit" onclick="return validarVehiculo()">Guardar</button>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal fade" id="foto">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Foto</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <br/>
                                        <video id="video" style="width:200px;"></video>
                                        <br>
                                        <button id="boton" class="btn btn-theme">Tomar foto  y Guardar</button>
                                        <p id="estado"></p>
                                        <canvas id="canvas" style="display: none;"></canvas>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- page end-->
                    </div>

                    <!-- /row -->
                </section>
                <!-- /wrapper -->
            </section>
            <!-- /MAIN CONTENT -->
            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    <p>
                        &copy; Copyrights <strong></strong>. Todos los derechos reservados
                    </p>
                    <div class="credits">
                        <!--
                          You are NOT allowed to delete the credit link to TemplateMag with free version.
                          You can delete the credit link only if you bought the pro version.
                          Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/dashio-bootstrap-admin-template/
                          Licensing information: https://templatemag.com/license/
                        -->
                        Created Mattelsa <a href="https://templatemag.com/"></a>
                    </div>
                    <a href="advanced_table.html#" class="go-top">
                        <i class="fa fa-angle-up"></i>
                    </a>
                </div>
            </footer>
            <!--footer end-->
        </section>
        <!-- js placed at the end of the document so the pages load faster -->
        <script type="text/javascript" language="javascript" src="${pageContext.servletContext.contextPath}/lib/advanced-datatable/js/jquery.js"></script>
        <script class="include" type="text/javascript" src="${pageContext.servletContext.contextPath}/lib/jquery.dcjqaccordion.2.7.js"></script>
        <script src="${pageContext.servletContext.contextPath}/lib/jquery.scrollTo.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/lib/jquery.nicescroll.js" type="text/javascript"></script>
        <script type="text/javascript" language="javascript" src="${pageContext.servletContext.contextPath}/lib/advanced-datatable/js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="${pageContext.servletContext.contextPath}/lib/advanced-datatable/js/DT_bootstrap.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" integrity="sha384-xBuQ/xzmlsLoJpyjoggmTEz8OWUFM0/RC5BsqQBDX2v5cMvDHcMakNTNrHIW2I5f" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="${pageContext.servletContext.contextPath}/lib/common-scripts.js"></script>
        <script src="${pageContext.servletContext.contextPath}/Js/ingresoParqueadero.js" type="text/javascript"></script>
        <script src="${pageContext.servletContext.contextPath}/Js/foto.js" type="text/javascript"></script>
        <script src="https://blueimp.github.io/JavaScript-Canvas-to-Blob/js/canvas-to-blob.min.js"></script>
        <script type="text/javascript" src="${pageContext.servletContext.contextPath}/lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="${pageContext.servletContext.contextPath}/lib/bootstrap-daterangepicker/date.js"></script>
        <script type="text/javascript" src="${pageContext.servletContext.contextPath}/lib/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script type="text/javascript" src="${pageContext.servletContext.contextPath}/lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
        <script type="text/javascript" src="${pageContext.servletContext.contextPath}/lib/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>

        <!--script for this page-->
        <script type="text/javascript">
                                            /* Formating function for row details */
                                            function fnFormatDetails(oTable, nTr) {
                                                var aData = oTable.fnGetData(nTr);
                                                var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
                                                sOut += '<tr><td>Rendering engine:</td><td>' + aData[1] + ' ' + aData[4] + '</td></tr>';
                                                sOut += '<tr><td>Link to source:</td><td>Could provide a link here</td></tr>';
                                                sOut += '<tr><td>Extra info:</td><td>And any further details here (images etc)</td></tr>';
                                                sOut += '</table>';

                                                return sOut;
                                            }

                                            $(document).ready(function () {
                                                /*
                                                 * Insert a 'details' column to the table
                                                 */
                                                var nCloneTh = document.createElement('th');
                                                var nCloneTd = document.createElement('td');
                                                nCloneTd.innerHTML = '<img src="lib/advanced-datatable/images/details_open.png">';
                                                nCloneTd.className = "center";

                                                $('#hidden-table-info thead tr').each(function () {
                                                    this.insertBefore(nCloneTh, this.childNodes[0]);
                                                });

                                                $('#hidden-table-info tbody tr').each(function () {
                                                    this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
                                                });

                                                /*
                                                 * Initialse DataTables, with no sorting on the 'details' column
                                                 */
                                                var oTable = $('#hidden-table-info').dataTable({
                                                    "aoColumnDefs": [{
                                                            "bSortable": false,
                                                            "aTargets": [0]
                                                        }],
                                                    "aaSorting": [
                                                        [1, 'asc']
                                                    ]
                                                });

                                                /* Add event listener for opening and closing details
                                                 * Note that the indicator for showing which row is open is not controlled by DataTables,
                                                 * rather it is done here
                                                 */
                                                $('#hidden-table-info tbody td img').live('click', function () {
                                                    var nTr = $(this).parents('tr')[0];
                                                    if (oTable.fnIsOpen(nTr)) {
                                                        /* This row is already open - close it */
                                                        this.src = "lib/advanced-datatable/media/images/details_open.png";
                                                        oTable.fnClose(nTr);
                                                    } else {
                                                        /* Open this row */
                                                        this.src = "lib/advanced-datatable/images/details_close.png";
                                                        oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
                                                    }
                                                });
                                            });

        </script>
    </body>

</html>