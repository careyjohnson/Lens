<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add product</title>
</head>
<body>
<jsp:include page="admin_header.jsp"></jsp:include>
<h3 class="alert">Product Added Successfully!</h3>

<h3 class="alert">Some thing went wrong! Try Again!</h3>

<form action="addnewproduct" method="post">

<!-- <input type="hidden" name="action" value="AddOrEdit"> -->
<h3 style="color: yellow;">Product ID: </h3>
<input type="hidden" name="id" value="">

<div class="left-div">
 <h3>Enter Name</h3>
 <input type="text" name="name" placeholder="Tên sản phẩm" required>
<hr>
</div>

<div class="right-div">
<h3>Enter Category</h3>
  <select name="cateID" required>
		                    
	<option disabled="disabled" selected="selected">Select category</option>
    <c:forEach var="cate" items="${LIST_CATE }">
    	<option value="${cate.id }">${cate.name }</option>
    </c:forEach>      		
        	
        
      </select>
<hr>
</div>

<div class="left-div">
 <h3>Enter Description</h3>
 <input type="text" name="description" placeholder="Mô tả sản phẩm" required>
<hr>
</div>

<div class="left-div">
<h3>Enter Price</h3>
 <input type="number" name="price" required>
<hr>
</div>

<div class="left-div">
 <h3>Enter Inventory</h3>
 <input type="number" name="inventory" placeholder="Số lượng..." required>
<hr>
</div>

<div class="right-div">
<h3>Active</h3>
    <select name="active" required>
                        	<option value="yes">Yes</option>
					<option value="no">No</option>                        
                      </select>
<hr>
</div>
<button type="submit">Save</button>
<button type="reset">Reset</button>
 <i class='far fa-arrow-alt-circle-right'></i>
</form>
</body>
</html>