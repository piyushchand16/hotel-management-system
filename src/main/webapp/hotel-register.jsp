<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"></style>
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
<% String msg = (String) request.getAttribute("msg"); %>

<section class="vh-100 bg-image"
  style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
              <% if (msg != null) { %>
              <h2 class="text-uppercase text-center mb-5"><%= msg %></h2>
              <% } else { %>
              <h2 class="text-uppercase text-center mb-5">Register new Hotel</h2>
              <% } %>
              <form action="hotelRegister" method="post" autocomplete="off" enctype="multipart/form-data">

                <div data-mdb-input-init class="form-outline mb-4">
                  <input type="text" id="hotelName" name="name" class="form-control form-control-lg" autocomplete="off" />
                  <label class="form-label" for="hotelName">Hotel Name</label>
                </div>

                <div data-mdb-input-init class="form-outline mb-4">
                  <input type="text" id="hotelCity" name="city" class="form-control form-control-lg" autocomplete="off" />
                  <label class="form-label" for="hotelCity">Hotel City</label>
                </div>

                <div data-mdb-input-init class="form-outline mb-4">
                  <input type="number" id="hotelPrice" name="price" class="form-control form-control-lg" autocomplete="off" />
                  <label class="form-label" for="hotelPrice">Hotel Price</label>
                </div>

                <div data-mdb-input-init class="form-outline mb-4">
                  <input type="text" id="hotelAddress" name="address" class="form-control form-control-lg" autocomplete="off" />
                  <label class="form-label" for="hotelAddress">Hotel Address</label>
                </div>

                <div data-mdb-input-init class="form-outline mb-4">
                  <label class="form-label" for="hotelImage">Hotel Image</label>
                  <input type="file" id="hotelImage" name="image" class="form-control form-control-lg" autocomplete="off" />
                </div>

                <div class="form-check d-flex justify-content-center mb-5">
                  <input class="form-check-input me-2" type="checkbox" value="" id="termsCheckbox" />
                  <label class="form-check-label" for="termsCheckbox">
                    I agree to all statements in <a href="#!" class="text-body"><u>Terms of service</u></a>
                  </label>
                </div>

                <div class="d-flex justify-content-center">
                  <button type="submit" data-mdb-button-init data-mdb-ripple-init
                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                </div>

                <p class="text-center text-muted mt-5 mb-0">Already have an account? <a href="#!"
                    class="fw-bold text-body"><u>Login here</u></a></p>

              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- MDB -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.js"></script>
</body>
</html>
