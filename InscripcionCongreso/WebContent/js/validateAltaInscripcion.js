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
	$("#cCorreoGmail").html($("#correo_gmail").val()+"@gmail.com");
	$("#cTitulo").html($("#titulo_trabajo").val());
	$("#cTema").html($("#tema_trabajo option:selected" ).text());
	$("#cPresentacion").html($("#tipo_presentacion option:selected" ).text());
	$("#cResumen").html(jQuery("textarea#resumen").val());
	$("#secundarios ul li input").each(function(i){
		$("#cAutoresSecundarios").append('<li role="presentation" style="font-size: 16px;"><a href="javascript: void(0); style="text-transform:lowercase">'+$(this).val()+'</a></li>');
	});
}

$(document).ready(function() {
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
                            max: 50,
                        },
                        regexp: {
                            regexp: /^[a-zA-ZñÑÁÉÍÓÚáéíóú\d\s]+$/,
                        }
                    }
                },
            	apellido: {
                    validators: {
                        notEmpty: {
                        },
                        stringLength: {
                            max: 50,
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
                        emailAddress: {
                        }
                    }
                },
                correo_gmail: {
                    validators: {
                        notEmpty: {
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