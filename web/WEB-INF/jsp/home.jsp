  <jsp:include page="head.jsp" flush="true" />
  <body>
  <jsp:include page="navigationmembers.jsp" flush="true" />
  

<div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-8">
          <p><a href="./ask" type="button" class="btn btn-success">Pide un taxi</a></p>
          <p><a href="./ongoingride" type="button" class="btn btn-success">Viaje en proceso</a></p>
          <p><a href="./clienthistoric" type="button" class="btn btn-success">Viajes terminados</a></p>
          <p><a href="http://es.gravatar.com/" type="button" class="btn btn-success">Cambiar foto de perfil en Gravatar</a></p>
          
          
        </div>
        <div class="col-md-4">
          <h2 style='text-transform: capitalize;'><%= session.getAttribute("tipo") %></h2>
          <p><img src='https://www.gravatar.com/avatar/<%=request.getAttribute("gravatar") %>?s=200' /></p>
          <p></p>
        </div>
      </div>
      <jsp:include page="copy.jsp" flush="true" />
</div>
  <jsp:include page="footer.jsp" flush="true" />
   