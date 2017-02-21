  <jsp:include page="head.jsp" flush="true" />
  <body>
  <jsp:include page="navigationmembers.jsp" flush="true" />
  

<div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-8">
         <%= request.getAttribute("zcontent") %> 
        </div>
        <div class="col-md-4">
         
        </div>
      </div>
      <jsp:include page="copy.jsp" flush="true" />
</div>
  <jsp:include page="footer.jsp" flush="true" />
   