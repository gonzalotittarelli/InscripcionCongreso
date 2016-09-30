$(document).ready(function() {
	var leng="";
	if($("#setLocale").val() == "en_US")
		leng="-en";
	var images = [{src:"fomentar-relaciones"+leng+".png", alt:"Fomentar Relaciones"},
	               {src:"reducir-costos"+leng+".png", alt:"Reducir Costos"},
	               {src:"responsabilidad-social"+leng+".png", alt:"Responsabilidad Social"}]
	var i=0;
	$('.item').each(function() {
		$(this).prepend("<img src='images/"+images[i]["src"]+"' alt='"+images[i++]["alt"]+"' data-holder-rendered='true' height='1046'>");
    });	
});