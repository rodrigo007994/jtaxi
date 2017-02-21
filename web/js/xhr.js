function zoom(imagen,latitude,longitude){
	var mapsize=parseInt(imagen.getAttribute("zsize"));
	if (mapsize==18){
		mapsize=14;
	}else{
		mapsize++;
	}
	imagen.setAttribute("zsize", mapsize);
	imagen.src='http://image.maps.cit.api.here.com/mia/1.6/mapview?app_id=FepdAwq3sSVy5iSz8ofh&app_code=xZn2tPu48VdAKO1wS1X_NA&c='+
		latitude+
		','+
		longitude+
		'&h=320&w=320&z='+mapsize+'&f=0&style=alps';
	
};


function xhrRegistration() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
	    var msg=document.getElementById("zenmsg");
	    if(this.responseText=="Registrado exitosamente"){
		msg.innerHTML ="<strong>Registro exitoso!</strong>Le enviamos una liga a su correo para continuar el registro.";
	    msg.className = "alert alert-success";
	    window.setTimeout(function(){ window.location = "./"; },3000);
	    }else{
	    msg.innerHTML = "<strong>Error!</strong> "+this.responseText;
	    msg.className = "alert alert-danger";
	    }
    }
  };
  var param="xhrreg?name="+
  document.getElementById("rname").value+
  "&lastname="+
  document.getElementById("rlastname").value+
  "&email="+
  document.getElementById("remail").value+
  "&password="+
  document.getElementById("rpassword").value+
  "&phone="+
document.getElementById("rphone").value;

  xhttp.open("GET", param, true);
  xhttp.send();
};


function xhrLogin() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
	    var msg=document.getElementById("zenmsg");
	    if(this.responseText=="Inicio de session exitosa."){
	    window.setTimeout(function(){ window.location = "./home"; },500);
	    }else{
	    msg.innerHTML = "<strong>Error!</strong> "+this.responseText;
	    msg.className = "alert alert-danger";
	    }
    }
  };
  var param="xhrlogin?email="+
  document.getElementById("email").value+
  "&password="+
  document.getElementById("password").value;

  xhttp.open("GET", param, true);
  xhttp.send();
};

function xhrLogout() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
	    var msg=document.getElementById("zenmsg");
	    if(this.responseText=="out"){
	    window.setTimeout(function(){ window.location = "./"; },500);
	    }else{
	    msg.innerHTML = "<strong>Error!</strong> "+this.responseText;
	    msg.className = "alert alert-danger";
	    }
    }
  };
  var param="xhrlogout";

  xhttp.open("GET", param, true);
  xhttp.send();
};




function xhrSetRide() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
		    var msg=document.getElementById("zenmsg");
		    if(this.responseText=="Solicitud enviada"){
			msg.innerHTML ="<strong>Solicitud enviada</strong>En breve sera redireccionada.";
		    msg.className = "alert alert-success";
		    window.setTimeout(function(){ window.location = "./ongoingride"; },3000);
		    }else{
		    msg.innerHTML = "<strong>Error!</strong> "+this.responseText;
		    msg.className = "alert alert-danger";
		    }
	    }
	  };
	  var param="xhrsetride?latitude="+
	  document.getElementById("latitude").value+
	  "&longitude="+
	  document.getElementById("longitude").value+
	  "&calle="+
	  document.getElementById("calle").value+
	  "&numext="+
	  document.getElementById("numext").value+
	  "&cruzamientos="+
	  document.getElementById("cruzamientos").value+
	  "&colonia="+
	  document.getElementById("colonia").value+
	  "&referencia="+
	  document.getElementById("referencia").value;

	  xhttp.open("GET", param, true);
	  xhttp.send();
	};
	
	

	function xhrCancelTaxi() {
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
			    var msg=document.getElementById("zenmsg");
			    if(this.responseText=="Servicio cancelado exitosamente"){
				msg.innerHTML ="<strong>Servicio Cancelado</strong>";
			    msg.className = "alert alert-success";
			    window.setTimeout(function(){ window.location = "./ongoingride"; },3000);
			    }else{
			    msg.innerHTML = "<strong>Error!</strong> "+this.responseText;
			    msg.className = "alert alert-danger";
			    }
		    }
		  };
		  var param="xhrcanceltaxi";

		  xhttp.open("GET", param, true);
		  xhttp.send();
		};
		
		
		function xhrDriverCancelTaxi() {
			  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
				    var msg=document.getElementById("zenmsg");
				    if(this.responseText=="Servicio cancelado exitosamente"){
					msg.innerHTML ="<strong>Servicio Cancelado</strong>";
				    msg.className = "alert alert-success";
				    window.setTimeout(function(){ window.location = "./rides"; },3000);
				    }else{
				    msg.innerHTML = "<strong>Error!</strong> "+this.responseText;
				    msg.className = "alert alert-danger";
				    }
			    }
			  };
			  var param="xhrdrivercanceltaxi";

			  xhttp.open("GET", param, true);
			  xhttp.send();
			};
		
		
		function xhrTie(theid) {
			  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
				    var msg=document.getElementById("zenmsg");
				    if(this.responseText=="Servicio asignado"){
					msg.innerHTML ="<strong>Servicio asignado</strong>";
				    msg.className = "alert alert-success";
				    window.setTimeout(function(){ window.location = "./driverongoingride"; },3000);
				    }else{
				    msg.innerHTML = "<strong>Error!</strong> "+this.responseText;
				    msg.className = "alert alert-danger";
				    }
			    }
			  };
			  var param="xhrtie?id="+
			  theid.value;

			  xhttp.open("GET", param, true);
			  xhttp.send();
			};
	