<!DOCTYPE html>
<html lang="en">
<body class="my-login-page">
<%
HttpSession session2 = request.getSession();
if(null == session2.getAttribute("user") ){
	response.sendRedirect("login.html");   
    }
else{
	
}
%>
<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
  <a class="navbar-brand" href="#">
    <img src="assets/img/logo.jpg" width="30" height="30" class="d-inline-block align-top rounded-circle" alt="">
   Company Name
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" onclick="show()" style="background-color: darkslategrey;">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent" style="display: none;">
   <!--  <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul> -->
    <div  class="logout">
    <a href="logout.jsp" style="color:white;"><i class="fas fa-sign-out-alt"></i> Logout
    </a>
    </div>
  </div>
</nav>
</body>
<script> 
function show(){
	var x= document.getElementById("navbarSupportedContent");
	 if (x.style.display === "none") {
		    x.style.display = "block";
		  } else {
		    x.style.display = "none";
		  }
}
</script>
</html>
