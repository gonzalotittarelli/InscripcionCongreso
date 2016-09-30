<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="col-md-12" style="margin-top:3%;" role="main">
	<div class="panel panel-default">
		<div class="panel-body">
			<form id="" class="form-horizontal" action="GuardarRecorrido" method="POST">
	            <ul class="nav nav-pills">
	                <li><a href="#rutaMapa" data-toggle="tab"><s:property value="getText('altarecorrido.rutamapa')" /></a></li>
	                <li><a href="#datos" data-toggle="tab"><s:property value="getText('altarecorrido.datos')" /></a></li>
	                <li><a href="#confirmacion" data-toggle="tab"><s:property value="getText('altarecorrido.confirmacion')" /></a></li>
	            </ul>				
	            <div class="tab-content">
	            	<!-- Primer tab -->
	                <div class="tab-pane active" id="rutaMapa">
	                	<div class="col-md-12" style="margin-top:2%; margin-bottom:2%;">
			                <s:if test="fieldErrors.containsKey('direccion_origen')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('direccion_origen').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('direccion_destino')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('direccion_destino').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('fecha_recorrido')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('fecha_recorrido').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('hora_partida')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('hora_partida').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('hora_regreso')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('hora_regreso').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('asientos_disponibles')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('asientos_disponibles').get(0)"/></small>
					        </s:if>
					        <s:if test="fieldErrors.containsKey('tipo_recorrido')">
					        	<small class="text-danger"><s:property value="fieldErrors.get('tipo_recorrido').get(0)"/></small>
					        </s:if>
							<div class="form-group">
								<div class="col-md-5">
									<label for="origen">A</label>
									<input id="origen" class="form-control" type="text" placeholder="<s:property value="getText('altarecorrido.form.origen')" />" name="origen" value="">
								</div>
       							<div class="col-md-5">
       								<label for="destino">B</label>
       								<div>
        								<select class="selectpicker" data-width="100%" data-size="5" data-live-search="true" id="eventos" data-none-results-text="<s:property value="getText('select.no_existe')" />">
        									<option value=""><s:property value="getText('altarecorrido.form.evento.select')" /></option>
							                <s:iterator value="eventos" var="evento">
							                	<option value='{"id": <s:property value="#evento.id"/>, "dir": "<s:property value="#evento.direccion"/>", "fecha": "<s:date name="#evento.fecha" format="%{getText('date.format')}" />" }'><s:property value="#evento.nombre"/></option>
							                </s:iterator>
									        </select>
								        </div>
       								<input id="destino" class="form-control" type="text" placeholder="<s:property value="getText('altarecorrido.form.destino')" />" name="destino">
       								<a href="#" id="c_evento"></a>
       								
       								<input type="hidden" id="con_evento" value="<s:property value="getText('altarecorrido.form.con_evento')"/>" />
       								<input type="hidden" id="sin_evento" value="<s:property value="getText('altarecorrido.form.sin_evento')"/>" />
       								
       								<input type="hidden" id="toggle" value="si">
       								<input type="hidden" name="eventoId" id="eventoId">
       							</div>
       							<div class="col-md-2" style="margin-top:2.3%;">
       								<input type="button" class="btn btn-info-pool " value="<s:property value="getText('altarecorrido.form.buscar_ruta')"/>" id="buscarRuta">
       							</div>
					        </div>
				        </div>
				        <div class="form-group">
      							<div class="col-md-12" style="margin-top:2%; margin-bottom:2%;">
		                        <input type="hidden" name="ruta" id="ruta">
		                        <s:if test="fieldErrors.containsKey('ruta')">
			            			<small class="text-danger"><s:property value="fieldErrors.get('ruta').get(0)"/></small>
			            		</s:if>
		                        <div id="contenedor_mapa">
						            <div id="mapa"></div>
							    </div>
						    </div>
					    </div>
	                </div>
		            <!-- Segundo tab -->
	                <div class="tab-pane" id="datos">
	                	<div class="col-md-12" style="margin-top:2.5%;">
							<div class="form-group">
			                   <div class="col-md-5">
									<div class="form-group">
							            <label for="nombre"><s:property value="getText('altarecorrido.form.dirorigen')"/></label>
							            <input type="text" class="form-control" name="direccionOrigen" readonly id="dirOrigen"/>
							       </div>
						        </div>									        
						        <div class="col-md-5 col-md-offset-1">
						          	<div class="form-group">
							            <label for="nombre"><s:property value="getText('altarecorrido.form.dirdestino')"/></label>
							            <input type="text" class="form-control" name="direccionDestino" readonly id="dirDestino"/>
							        </div>
						        </div>
							</div>        
						</div>  
						<div class="col-md-12">
						        <div class="col-md-2 col-md-offset-1" id="fecha_de_recorrido"> 
									<div class="form-group">
										<label><s:property value="getText('altarecorrido.form.fecha')"/></label>							        							
										<input type='text' class="form-control" name="fechaRecorrido" id="fechaRecorrido" readonly  maxlength="10"/>
									</div>
								</div>
								<div class="col-md-2 col-md-offset-1">
									<div class="form-group">
										<label><s:property value="getText('altarecorrido.form.horaida')"/></label>
										<input type='text' class="form-control" name="horaPartida" id="horaPartida" readonly maxlength="8"/>
									</div>
								</div>
								<div class="col-md-2 col-md-offset-1">
									<div class="form-group">
										<label><s:property value="getText('altarecorrido.form.horavuelta')"/> <input type="checkbox" id="vuelvo"></label>
										<input class="form-control" name="horaRegreso" id="horaRegreso" type="hidden" value="-" readonly maxlength="8"/>
									</div>
								</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
					            <label for="nombre"><s:property value="getText('altarecorrido.form.asientos')"/></label>
					            <input type="number" class="form-control" name="asientosDisponibles" min="1" max="10" value="1"/>
					        </div>
				        </div>
						<div class="col-md-12">
							<div class="form-group" id="tipo_de_recorrido">
								<label class="radio-inline"><input type="radio" name="tipoRecorrido" value="puntual" checked/><s:property value="getText('altarecorrido.form.puntual')"/></label>
					            <label class="radio-inline"><input type="radio" name="tipoRecorrido" value="diario" /><s:property value="getText('altarecorrido.form.diario')"/></label>
					            <label class="radio-inline"><input type="radio" name="tipoRecorrido" value="periodico"/><s:property value="getText('altarecorrido.form.periodico')"/></label>
					       </div>
				        </div>
				        <div class="row" id="lista-dias"></div>
				        <input type="hidden" value="<s:property value="getText('dia.LUNES')"/>" id="lunes">
				        <input type="hidden" value="<s:property value="getText('dia.MARTES')"/>" id="martes">
				        <input type="hidden" value="<s:property value="getText('dia.MIERCOLES')"/>" id="miercoles">
				        <input type="hidden" value="<s:property value="getText('dia.JUEVES')"/>" id="jueves">
				        <input type="hidden" value="<s:property value="getText('dia.VIERNES')"/>" id="viernes">
				     </div>
					<!-- Tercer Tab -->
					<div class="tab-pane" id="confirmacion">
						<div class="col-md-6">
           					<label><s:property value="getText('altarecorrido.form.dirorigen')"/></label>
           					<div class="well well-sm" id="cDireccionOrigen"></div>
	        			</div>
						<div class="col-md-6">
           					<label><s:property value="getText('altarecorrido.form.dirdestino')"/></label>
           					<div class="well well-sm" id="cDireccionDestino"></div>
	        			</div>
						<div class="col-md-6">
           					<label><s:property value="getText('altarecorrido.form.fecha')"/></label>
           					<div class="well well-sm" id="cFecha"></div>
	        			</div>
						<div class="col-md-6">
           					<label><s:property value="getText('altarecorrido.form.horaida')"/></label>
           					<div class="well well-sm" id="cHoraIda"></div>
	        			</div>
						<div class="col-md-6">
           					<label><s:property value="getText('altarecorrido.form.horavuelta')"/></label>
           					<div class="well well-sm" id="cHoraVuelta"></div>
	        			</div>
						<div class="col-md-6">
           					<label><s:property value="getText('altarecorrido.form.asientos')"/></label>
           					<div class="well well-sm" id="cAsientos"></div>
	        			</div>
						<div class="col-md-12" >
							<label><s:property value="getText('altarecorrido.form.dias')"/></label>
							<div class="well well-sm" id="cDias"></div>
	        			</div>		        							        							        					        			
					</div>
	                <!-- Botones Atras/Siguiente -->
	                <ul class="pager wizard">
	                    <li class="previous"><a href="javascript: void(0);"><i class="fa fa-arrow-left fa-lg"></i> </a></li>
	                    <li class="next"><a href="javascript: void(0);"><i class="fa fa-arrow-right fa-lg"></i> </a></li>
	                </ul>
	            </div>
	        </form>
		</div>
     </div>
</div>
		