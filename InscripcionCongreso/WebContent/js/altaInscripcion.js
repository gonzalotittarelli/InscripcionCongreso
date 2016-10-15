var i = 0;

$(document).ready(function() {
	$('#añadirSecundario').click(function() {
		if(!$("#nombre_secundario").val())
			return false;
		if(!$("#apellido_secundario").val())
			return false;
		var nombre = ($("#nombre_secundario").val()).toLowerCase();
		var apellido = ($("#apellido_secundario").val()).toLowerCase();
		var clase = "secundario_"+i;
		i++;
		$("#secundarios ul").append('<li role="presentation" class="'+clase+'" style="font-size: 16px;"><input type="hidden" class="'+clase+'" value="'+nombre+'/'+apellido+'" /><a href="javascript: void(0);">'+nombre+' '+apellido+' <i class="fa fa-minus"></i></a></li>');
		$("#nombre_secundario").val("");
		$("#apellido_secundario").val("");
		$("."+clase).on("click", function() {
			  $(this).remove();
			  i--;
		});
	});
});