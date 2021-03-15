<%@ page language="java" import="java.util.*,java.io.*,java.lang.ClassNotFoundException,java.io.IOException,java.sql.SQLException" %>
<%@ page language="java" import="com.qrcode.*" %>
<%@ page language="java" import="com.qrcode.bean.*" %>
<%@ page language="java" import="com.qrcode.dao.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>Home</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="assets/css/my-login.css">
	<link rel="stylesheet" type="text/css" href="assets/css/home.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
</head>

<body class="my-login-page">

<%

ArrayList<FolderBean> folderDetail = (ArrayList<FolderBean>)request.getAttribute("folderDetail");
HttpSession session2 = request.getSession();
DbConnection db = new DbConnection();
if(folderDetail==null){
 folderDetail = db.getAllFolderDetails();
}else{
	
}
if(session2.getAttribute("user")==null){
	response.sendRedirect("login.jsp");   
    }
else{
	System.out.println(session2.getAttribute("user"));

}
%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<!-- Grid row -->
<div class="row">

  <!-- Grid column -->
  <div class="col-md-6 col-lg-4" >

    <button class="btn btn-default clf" data-toggle="collapse" data-target="#collapseOne" onclick="showf()" >
    <i class="fas fa-folder pr-2" aria-hidden="true"></i>Create Folder</button>
    
    <div class="collapse" id="collapseOne" style="display:none;">
      <!--Panel-->
      <div class="card card-body ml-1" style="background: none;">
        <h4 class="card-title">Create Folder</h4>
       <form action="CreateFolder" method="post">
       <div class="form-group row">
    <label for="inputPassword" class="col-sm-10 col-form-label">Folder Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="folder" placeholder="Enter Folder Name">
       <input type="hidden" class="form-control"  name="username" value="<%= session2.getAttribute("user") %>">
    </div>
  </div>
        <div class="flex-row">
         <input type="submit" class="btn btn-success cre"value="Create">
        </div>
        </form>
      </div>
      <!--/.Panel-->
    </div>


  </div>
  <!-- Grid column -->

</div>

<div class="row" style="padding-top: inherit;">

<%
try{
//for(FolderBean folder:folderDetail ){ 
for(int i=0;i<folderDetail.size();i++){
%>
<div class="col-md-6 col-lg-4" >
    <button class="btn btn-default fol" >
    <i class="fas fa-folder-open"></i>  
    <%=folderDetail.get(i).getFolder_name() %>
    <%--  <%=folder.getFolder_name() %>  --%>
   </button>    
    </div> 
		<% }}catch(Exception e){
			System.out.println(e);
		}
		%>
</div>
<!-- Grid row -->
</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script src="assets/js/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="assets/js/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="assets/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="assets/js/my-login.js"></script>
	<script>
	$('#collapseOne').on('shown.bs.collapse', function () {
	    $(".fa").removeClass("fa-folder-o").addClass("fa-folder-open-o");
	});

	$('#collapseOne').on('hidden.bs.collapse', function () {
	    $(".fa").removeClass("fa-folder-open-o").addClass("fa-folder-o");
	});
	
	function showf(){
		var x= document.getElementById("collapseOne");
		 if (x.style.display === "none") {
			    x.style.display = "block";
			  } else {
			    x.style.display = "none";
			  }
	}
	</script>
</body>
</html>
