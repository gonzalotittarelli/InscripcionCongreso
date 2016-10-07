<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style>.form-control {font-size: 20px !important;}</style>
<div class="col-md-12" style="margin-top:3%;" role="main">
	<div class="panel panel-default">
		<div class="panel-body">
			<form id="guardarInscripcionForm" class="form-horizontal" action="guardarInscripcion" method="POST">
				<input type="hidden" name="autores_secundarios" value="" id="autores_secundarios">
	            <ul id="nav-pill-own" class="nav nav-pills"  style="font-family: 'Josefin Sans';font-size: 20px">
	                <li><a href="#datos" data-toggle="tab">Datos Interesado</a></li>
	                <li><a href="#trabajo" data-toggle="tab">Trabajo</a></li>
	                <li><a href="#resumen" data-toggle="tab">Resumen Trabajo</a></li>
	                <li><a href="#confirmacion" data-toggle="tab">Confirmacion</a></li>
	            </ul>				
	            <div class="tab-content">
	            	<!-- Primer tab -->
	                <div class="tab-pane active" id="datos"  style="font-family: 'Josefin Sans';font-size: 20px; margin-bottom: 2em;">
	                	<div class="col-md-12" style="margin-top:2%; margin-bottom:2%;">
			                <s:if test="fieldErrors.containsKey('autor_principal')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('autor_principal').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('autor_secundario')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('autor_secundario').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('titulo_trabajo')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('titulo_trabajo').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('resumen_trabajo')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('resumen_trabajo').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('tema_trabajo')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('tema_trabajo').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('presentacion_trabajo')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('presentacion_trabajo').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('correo')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('correo').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('correo_gmail')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('correo_gmail').get(0)"/></small>
					        </s:if>
							<div class="form-group row">
								<label for="nombre" class="col-xs-2 col-form-label">Nombre</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="nombre" name="nombre" style='text-transform:lowercase'>
								</div>
							</div>
							<div class="form-group row">
								<label for="apellido" class="col-xs-2 col-form-label">Apellido</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="apellido" name="apellido" style='text-transform:lowercase'>
								</div>
							</div>
							<div class="form-group row">
								<label for="correo" class="col-sm-2 col-form-label">Correo Personal</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" id="correo" name="correo">
								</div>
							</div>
							<div class="form-group row">
								<label for="correo_gmail" class="col-sm-2 col-form-label">Correo Gmail</label>
								<div class="col-sm-10">
									<div class="input-group">
										<input type="text" class="form-control" id="correo_gmail" name="correo_gmail">
										<div class="input-group-addon">@gmail.com</div>
									</div>
								</div>
							</div>										        
				        </div>
	                </div>
		            <!-- Segundo tab Trabajo-->
	                <div class="tab-pane" id="trabajo"  style="font-family: 'Josefin Sans';font-size: 20px; margin-bottom: 2em;">
	                	<div class="col-md-12" style="margin-top:2.5%;">
							<div class="form-group row">
								<label for="titulo_trabajo" class="col-xs-2 col-form-label">Titulo</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="titulo_trabajo" name="titulo_trabajo" style='text-transform:lowercase'>
								</div>
							</div>
							<div class="form-group row">
								<label for="tema_trabajo" class="col-xs-2 col-form-label">Tema</label>
								<div class="col-sm-10">
									<select class="form-control" id="tema_trabajo" name="tema_trabajo">
		    							<option value=""></option>
						                <option value="CLOUD">Cloud Computing</option>
						                <option value="WS">Web Service</option>
						                <option value="BPM">Business process management</option>
						                <option value="SOA">Service Oriented Architecture</option>
							        </select>
						        </div>
					        </div>
							<div class="form-group row">
								<label for="tipo_presentacion" class="col-xs-2 col-form-label" style="font-size:19px">Tipo de Presentacion</label>
								<div class="col-sm-10">
									<select class="form-control" id="tipo_presentacion" name="tipo_presentacion">
		    							<option value=""></option>
						                <option value="POSTER">Poster</option>
						                <option value="CONFERENCIA">Conferencia</option>
							        </select>
						        </div>
					        </div>
					        <div class="form-group row">
					        	<label for="tipo_presentacion" class="col-xs-2 col-form-label" style="font-size:19px">Autores Secundarios</label>
					        	<div class="col-sm-10">
						        	<div class="panel panel-default">
										<div class="panel-body">
											<div class="col-md-12">
												<div class="form-group">
													<div class="col-md-5">
														<label for="nombre_secundario">Nombre</label>
														<input id="nombre_secundario" class="form-control" type="text" style='text-transform:lowercase'>
													</div>
													<div class="col-md-5">
														<label for="apellido_secundario">Apellido</label>
														<input id="apellido_secundario" class="form-control" type="text" style='text-transform:lowercase'>
													</div>												
				        							<div class="col-md-2" style="margin-top:3.3%;">
				        								<a id="añadirSecundario" ><i class="fa fa-plus"></i> </a>
				        							</div>
										        </div>
										        <div class="form-group" id="secundarios">
										        	<ul class="nav nav-pills">												
													</ul>
													<input type="hidden" id="apellidos_nombres_secundarios" name="apellidos_nombres_secundarios" />
										        </div>										
									        </div>									
										</div>
									</div>
								</div>
							</div>				        	        
						</div>
				     </div>
					<!-- Tercer Tab Resumen-->
					<div class="tab-pane" id="resumen"  style="font-family: 'Josefin Sans';font-size: 20px">
						<div class="col-md-12" >
							<textarea id="resumen" class="form-control" rows="15" cols="50" name="resumen" style="resize: none; margin-bottom: 2em;"></textarea>
	        			</div>		        							        							        					        			
					</div>
					<!-- Cuarto Tab Confirmacion-->
					<div class="tab-pane" id="confirmacion"  style="font-family: 'Josefin Sans';font-size: 15px; margin-bottom: 2em;">
						<div class="col-md-6">
           					<label>Nombre</label>
           					<div class="well well-sm" id="cNombre" style='text-transform:lowercase'></div>
	        			</div>
						<div class="col-md-6">
           					<label>Apellido</label>
           					<div class="well well-sm" id="cApellido" style='text-transform:lowercase'></div>
	        			</div>
						<div class="col-md-6">
           					<label>Correo Personal</label>
           					<div class="well well-sm" id="cCorreoPersonal"></div>
	        			</div>
						<div class="col-md-6">
           					<label>Correo Gmail</label>
           					<div class="well well-sm" id="cCorreoGmail"></div>
	        			</div>
						<div class="col-md-12">
							<div class="form-group">
								<div class="col-md-4">
									<label>Titulo</label><div class="well well-sm" id="cTitulo" style='text-transform:lowercase'></div>
								</div>
								<div class="col-md-4">
									<label>Tema</label><div class="well well-sm" id="cTema"></div>
								</div>												
       							<div class="col-md-4">
       								<label>Tipo de Presentacion</label><div class="well well-sm" id="cPresentacion"></div>
       							</div>
					        </div>										
				        </div>	        			
						<div class="col-md-12" >
							<label>Autores Secundarios</label>
							<ul class="nav nav-pills" id="cAutoresSecundarios">												
							</ul>
	        			</div>    							        							        					        			
					</div>					
	                <!-- Botones Atras/Siguiente -->
	                <ul class="pager wizard" style="font-family: 'Josefin Sans';font-size: 16px">
	                    <li class="previous"><a href="javascript: void(0);"><i class="fa fa-arrow-left"></i> </a></li>
	                    <li class="next"><a href="javascript: void(0);"><i class="fa fa-arrow-right"></i> </a></li>
	                </ul>
	            </div>
	        </form>
		</div>
     </div>
</div>
		