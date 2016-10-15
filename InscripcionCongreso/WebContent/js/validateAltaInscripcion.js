(function($){
	$.fn.textareaCounter = function(options) {
		// setting the defaults
		// $("textarea").textareaCounter({ limit: 100 });
		var defaults = {
			limit: 100
		};	
		var options = $.extend(defaults, options);
 
		// and the plugin begins
		return this.each(function() {
			var obj, text, wordcount, limited;
			
			obj = $(this);
			obj.after('<span style="font-size: 16px; clear: both; margin-top: 1em; margin-bottom: 2em; display: block;" id="counter-text">Max. '+options.limit+' palabras</span>');

			obj.keyup(function() {
			    text = obj.val();
			    if(text === "") {
			    	wordcount = 0;
			    } else {
				    wordcount = $.trim(text).split(" ").length;
				}
			    if(wordcount > options.limit) {
			        $("#counter-text").html('<span style="color: #DD0000;">0 palabras restantes</span>');
					limited = $.trim(text).split(" ", options.limit);
					limited = limited.join(" ");
					$(this).val(limited);
			    } else {
			    	if(options.limit - wordcount == 1)
			    		$("#counter-text").html((options.limit - wordcount)+' palabras restante');
			    	else
			    		$("#counter-text").html((options.limit - wordcount)+' palabras restantes');
			    } 
			});
			obj.blur(function() {
			    text = obj.val();
			    if(text === "") {
			    	wordcount = 0;
			    } else {
				    wordcount = $.trim(text).split(" ").length;
				}
			    if(wordcount > options.limit) {
			        $("#counter-text").html('<span style="color: #DD0000;">0 palabras restantes</span>');
					limited = $.trim(text).split(" ", options.limit);
					limited = limited.join(" ");
					$(this).val(limited);
			    } else {
			    	if(options.limit - wordcount == 1)
			    		$("#counter-text").html((options.limit - wordcount)+' palabras restante');
			    	else
			    		$("#counter-text").html((options.limit - wordcount)+' palabras restantes');
			    } 
			});
		});
	};
})(jQuery);



function resumen(){
	$("#cNombre").html($("#nombre").val());
	$("#cApellido").html($("#apellido").val());
	$("#cCorreoPersonal").html($("#correo").val());
	$("#cCorreoGmail").html($("#correo_gmail").val());
	$("#cTitulo").html($("#titulo_trabajo").val());
	$("#cTema").html($("#tema_trabajo option:selected" ).text());
	$("#cPresentacion").html($("#tipo_presentacion option:selected" ).text());
	$("#cResumen").html(jQuery("textarea#resumen").val());
	$("#secundarios ul li input").each(function(i){
		var str = $(this).val();
		var res = str.split("/");
		$("#cAutoresSecundarios").append('<li role="presentation" style="font-size: 16px;"><a href="javascript: void(0); style="text-transform:lowercase">'+res[0]+' '+res[1]+'</a></li>');
	});
}

function clean(){
	var nombre = ($("#nombre").val()).toLowerCase();
	var apellido = ($("#apellido").val()).toLowerCase();
	var correo_gmail = $("#correo_gmail").val();
	var titulo_trabajo = ($("#titulo_trabajo").val()).toLowerCase();
	$("#secundarios ul li input").each(function(i){
		$(this).val(($(this).val()).toLowerCase());
	});
	$("#nombre").val(nombre);
	$("#apellido").val(apellido);
	$("#correo_gmail").val(correo_gmail);
	$("#titulo_trabajo").val(titulo_trabajo);
}


$(document).ready(function() {
	
	var stack_topleft = {"dir1": "down", "dir2": "right", "push": "top"};

	if($('#success').length){
		new PNotify({
			title: "Trabajo enviado",
	        text: $("#success").val(),
	        type: "success",
	        styling: 'bootstrap3',
	        addclass: "stack-topleft",
	        stack: stack_topleft
	    });
	}
	
	if($('#error').length){
		new PNotify({
			title: "Error",
	        text: "Ha ocurrido algún error, verifique la información ingresada",
	        type: "error",
	        styling: 'bootstrap3',
	        addclass: "stack-topleft",
	        stack: stack_topleft
	    });
	}
	
	$("textarea").textareaCounter({ limit: 200 });
	
	$('#tema_trabajo').on('change', function(e) {
        $('#guardarInscripcionForm').formValidation('revalidateField', 'tema_trabajo');
    });
	$('#tipo_presentacion').on('change', function(e) {
        $('#guardarInscripcionForm').formValidation('revalidateField', 'tipo_presentacion');
    });
	
    $('#guardarInscripcionForm').formValidation({
            framework: 'bootstrap',
            icon: {
                validating: 'glyphicon glyphicon-refresh'
            },
            excluded: ':disabled',
            fields: {
            	nombre: {
                    validators: {
                        notEmpty: {
                        },
                        stringLength: {
                            max: 100,
                        },
                        regexp: {
                            regexp: /^[a-zA-ZñÑÁÉÍÓÚáéíóú\s]+$/,
                        }
                    }
                },
            	apellido: {
                    validators: {
                        notEmpty: {
                        },
                        stringLength: {
                            max: 100,
                        },
                        regexp: {
                            regexp: /^[a-zA-ZñÑÁÉÍÓÚáéíóú\d\s]+$/,
                        }
                    }
                },
                correo: {
                    validators: {
                        notEmpty: {
                        },
                        regexp:{
                        	regexp: /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i
                        }
                    }
                },
                correo_gmail: {
                    validators: {
                        notEmpty: {
                        },
                        regexp:{
                        	regexp: /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*(@gmail.com)$/
                        }
                    }
                },
                titulo_trabajo: {
                    validators: {
                        notEmpty: {
                        },
                        stringLength: {
                            max: 50,
                        }
                    }
                },
                tema_trabajo: {
                    validators: {
                        notEmpty: {
                        }
                    }
                },
                tipo_presentacion: {
                    validators: {
                        notEmpty: {
                        }
                    }
                },
                resumen: {
                	validators: {
                        notEmpty: {
                        },
                    }
                }
            }
        })
        .on('err.field.fv', function(e, data) {
    	data.element.data('fv.messages').find('.help-block[data-fv-for="' + data.field + '"]').hide(); 
        })
        .bootstrapWizard({
            tabClass: 'nav nav-pills',
            onTabClick: function(tab, navigation, index) {
                return validateTab(index);
            },
            onNext: function(tab, navigation, index) {
                var numTabs    = $('#guardarInscripcionForm').find('.tab-pane').length,
                    isValidTab = validateTab(index - 1);
                if (!isValidTab) {
                    return false;
                }

                if (index === numTabs) {
                	var string = "";
                	$("#secundarios ul li input").each(function(i){
                		string+=$(this).val()+",";
                	});
                	$("#apellidos_nombres_secundarios").val(string);
                	clean();
                    $('#guardarInscripcionForm').formValidation('defaultSubmit');
                }

                return true;
            },
            onPrevious: function(tab, navigation, index) {
                return validateTab(index + 1);
            },
            onTabShow: function(tab, navigation, index) {
                // Se actualiza el label del boton siguiente cuando se esta en el ultimo paso
                var numTabs = $('#guardarInscripcionForm').find('.tab-pane').length;
            	if((numTabs - 1) == index ){
            		resumen();
            	}
                $('#guardarInscripcionForm')
                    .find('.next')
                        .removeClass('disabled')    // Habilita el boton siguiente
                        .find('a')
                        .html(index === numTabs - 1 ? 'Enviar Trabajo <i class="fa fa fa-paper-plane fa-lg"></i>' : '<i class="fa fa-arrow-right fa-lg"></i>');
            }
        });

    function validateTab(index) {
        var fv   = $('#guardarInscripcionForm').data('formValidation'), // Formulario
            // Tab actual
            $tab = $('#guardarInscripcionForm').find('.tab-pane').eq(index);

        // Valida el contenido
        fv.validateContainer($tab);

        var isValidStep = fv.isValidContainer($tab);
        if (isValidStep === false || isValidStep === null) {
            // No se salta al siguiente tab
            return false;
        }

        return true;
    }
});