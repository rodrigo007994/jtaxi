    <nav class="navbar navbar-inverse navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="./home">JTaxi</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <div class="navbar-form navbar-right">
            <button type="button" class="btn btn-success"><%= session.getAttribute("email") %></button>
            <button type="button" onclick="xhrLogout();" class="btn btn-success">Salir</button>
          </div>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
    <div id="zenmsg">
  </div>
