<%@page import="com.jsp.hotel_management_system.dto.HotelOwner"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.hotel_management_system.admin.dao.HotelOwnerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hotel's owners</title>
<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.css"
  rel="stylesheet"
/>
</head>
<body>
<% HotelOwnerDao dao=new HotelOwnerDao(); 
List<HotelOwner> ls=dao.getAllHotelOwnerDao();
%>

<table class="table align-middle mb-0 bg-white">
  <thead class="bg-light">
    <tr>
      <th>Email</th>
      <th>Phone</th>
      <th>Status</th>
      <th>ID</th>
      <th>Actions</th>
    </tr>
  </thead>
  <% for(HotelOwner ho:ls){ %>
  <tbody>
    <tr>
      <td>
        <div class="d-flex align-items-center">
          <div class="ms-3">
            <p class="fw-bold mb-1"><%= ho.getName() %></p>
            <p class="text-muted mb-0"><%= ho.getEmail() %></p>
          </div>
        </div>
      </td>
      <td>
        <p class="text-muted mb-0"><%=ho.getPhone()%></p>
      </td>
      <td>
        <span class="badge badge-success rounded-pill d-inline"><%= ho.getVerify().equalsIgnoreCase("yes")?"verified":"not verified" %></span>
      </td>
      <td><%= ho.getId() %></td>
      <td>
      <%if( ho.getVerify().equalsIgnoreCase("yes")){%>
      <a href="update?id=<%=ho.getId()%>&action=no">
                <button type="button" class="btn btn-link btn-sm btn-rounded">
                Disprove
        </button>
        <%}else{ %>
            </a>
            <a href="update?id=<%=ho.getId()%>&action=yes" >
                <button type="button" class="btn btn-link btn-sm btn-rounded">
                Verify
        </button>
            </a>
            <%} %>
        
      </td>
    </tr>
  </tbody>
  <%} %>
</table>
</body>
</html>