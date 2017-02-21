  <jsp:include page="head.jsp" flush="true" />
  <body>
  <jsp:include page="navigationmembers.jsp" flush="true" />
  

<div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-8">
          <button onclick="getLocation()" class="btn btn-success">Encuentra mi ubicaci&oacute;n</button>

<div id="mapholder"></div>
<hr>
<h3>GPS Coordinates:</h3>
<div id="dataholder"></div>
<h3>¿No es tu ubicaci&oacute;n?</h3>
<p>Si no es tu ubicaci&oacute;n, escribe la direccion a donde necesitas tu taxi.</p>
     
<div class="form-group">
	<input type="text" placeholder="Calle" name="calle" id="calle" class="form-control">
</div>
<div class="form-group">
	<input type="text" placeholder="N&uacute;mero exterior" name="numext" id="numext" class="form-control">
</div>
<div class="form-group">
	<input type="text" placeholder="Cruzamientos" name="cruzamientos" id="cruzamientos" class="form-control">
</div>
<div class="form-group">
	<input type="text" placeholder="Colonia" name="colonia" id="colonia" class="form-control">
</div>
<div class="form-group">
	<input type="text" placeholder="Referencia" name="referencia" id="referencia" class="form-control">
</div>
<div class="form-group">
<button onclick='xhrSetRide()' class='btn btn-primary'>Solicitar</button>
</div>

        </div>
        <div class="col-md-4">
          

        </div>
      </div>
      <jsp:include page="copy.jsp" flush="true" />
</div>
<script src="js/location.js"></script>
  <jsp:include page="footer.jsp" flush="true" />
   