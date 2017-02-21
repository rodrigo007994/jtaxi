  <jsp:include page="head.jsp" flush="true" />
  <body>
  <jsp:include page="navigation.jsp" flush="true" />
<div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-8">
          <h2>Registration</h2>
          
          <div class="form-group">
              <input type="text" placeholder="Nombre" name="name" id="rname" class="form-control">
            </div>
          <div class="form-group">
              <input type="text" placeholder="Apellidos" name="lastname" id="rlastname" class="form-control">
            </div>
            <div class="form-group">
              <input type="text" placeholder="Correo" name="email" id="remail" class="form-control">
            </div>
            <div class="form-group">
              <input type="text" placeholder="Telefono" name="phone" id="rphone" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Contrase&ntilde;a" name="password" id="rpassword" class="form-control">
            </div>
            <button type="button" class="btn btn-success" onclick="xhrRegistration();">Registrarse</button>
        </div>
        <div class="col-md-4">
        </div>
        
      </div>
 <jsp:include page="copy.jsp" flush="true" />
	</div>
  <jsp:include page="footer.jsp" flush="true" />