<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<!-- Page icon -->
  <link rel="shortcut icon" href="images/anh_page.png">
<!-- Style sheet -->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
    />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <!-- Script -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
</head>
<body>
 <nav
      class="navbar navbar-expand-md navbar-light bg-light sticky-header"
      id="bg-black"
    >
      <div class="container-fluid">
        <a class="navbar-brand" href="/ECWeb/" style="font-size:30px;"
          ><img
            src="images/anh_logo1.png"
            style="height: 100px; width: 150px; margin-left:100px;"
            alt="logo"
        />Lin's Lens</a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarResponsive"
          aria-controls="navbarResponsive"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button> 
        </div>
    </nav>


  <!-------account-------->
 
  <div class="container-fluid padding">
    <div class="row padding">
      <div class=" col-12 col-md-6 ">
        <div class="card">
          <img class="card-imd-top" src="images/jiso_lens.jpg">
        </div>
      </div>
  
      <div class="col-12 col-md-6 " id="mg-login">
        <div class="card" id="account-page"> 
          <div class="form-container" id="dn">
            
            <span style="font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; width:100%">Lấy lại mật khẩu </span>
            <!-- <span onclick="login()" style="font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;">Đăng nhập</span> -->
            <hr style="width:100px;height:3px;background:black;">
            <form action="/ECWeb/forget_password" method="post" >
              <input id="ip" type="text" placeholder="Tên đăng nhập" name="username">
              <input id="ip" type="email" placeholder="Email" name="email">
              <input id="ip" type="password" placeholder="Mật khẩu " name="newPassword">
              <button type="submit" class="bt">Đồng ý</button>
              <a href="/ECWeb/login" style="text-decoration: none; color: black">Đăng nhập</a>
              <% String forgetPasswordMessage=(String) request.getAttribute("forgetPasswordMessage");
              	if(forgetPasswordMessage!=null){
              %>
              <h4 style="font-size: 15px;color:red; margin-top:10px"><%= request.getAttribute("forgetPasswordMessage") %></h4>
              <% } else { %>
              <h4 style="font-size: 15px;color:red; margin-top:10px"><% out.print(""); %></h4>
              <% } %>
          </form>
          
        </div>
      </div> 
      </div>
  
    </div>
  </div>

<jsp:include page="footer.jsp"></jsp:include>
<!-- <script>
    var loginform = document.getElementById("loginform");
    var formdk = document.getElementById("formdk");
    var indicator = document.getElementById("indicator");
    function login(){
        formdk.style.transform = "translateX(0px)";
        loginform.style.transform = "translateX(0px)";
        indicator.style.transform = "translateX(100px)";
    }
    function register(){
        formdk.style.transform = "translateX(300px)";
        loginform.style.transform = "translateX(300px)";
        indicator.style.transform = "translateX(0px)";
    }
</script> -->
</body>
</html>