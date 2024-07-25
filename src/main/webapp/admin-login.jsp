<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.css"
	rel="stylesheet" />
<style>
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}
</style>
</head>
<body>
<% String msg=(String)request.getAttribute("msg"); %>
	<form action="loginAdmin" method="post">
		<section class="vh-100" style="background-color: #508bfc;">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">

								<h3 class="mb-5">Sign in</h3>
								<% if(msg!=null){ %>
								<h4 style="color:red"><%= msg %></h4>
								<%} %>

								<div data-mdb-input-init class="form-outline mb-4">
								 <label
										class="" for="typeEmailX-2">Email</label>
									<input type="email" id="typeEmailX-2"
										class="form-control form-control-lg" name="email" />
								</div>

								<div data-mdb-input-init class="form-outline mb-4">
								<label
										class="" for="typePasswordX-2">Password</label>
									<input type="password" id="typePasswordX-2"
										class="form-control form-control-lg" name="password" /> 
								</div>

								<!-- Checkbox -->
								<div class="form-check d-flex justify-content-start mb-4">
									<input class="form-check-input" type="checkbox" value=""
										id="form1Example3" /> <label class="form-check-label"
										for="form1Example3"> Remember password </label>
								</div>

								<button data-mdb-button-init data-mdb-ripple-init
									class="btn btn-primary btn-lg btn-block" type="submit">Login</button>

								<hr class="my-4">

								<button data-mdb-button-init data-mdb-ripple-init
									class="btn btn-lg btn-block btn-primary"
									style="background-color: #dd4b39;" type="submit">
									<i class="fab fa-google me-2"></i> Sign in with google
								</button>
								<button data-mdb-button-init data-mdb-ripple-init
									class="btn btn-lg btn-block btn-primary mb-2"
									style="background-color: #3b5998;" type="submit">
									<i class="fab fa-facebook-f me-2"></i>Sign in with facebook
								</button>

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
</body>
</html>