<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Update Wish</title>
</head>
<body>
	<div class="container">
		<%@include file="header.jsp"%>
		<br /> <br />
		<div class="row center-align" style="margin-left: 10em">
			<form:form action="${pageContext.request.contextPath}/updatewish"
				method="POST" modelAttribute="wishEntity">
				<div class="row">
					<div class="input-field col s6 push-s2">
						<i class="material-icons prefix">mode_edit</i>
						<form:textarea path="wishTitleString" id="icon_prefix1"
							cssClass="materialize-textarea"></form:textarea>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="input-field col s6 push-s2">
						<i class="material-icons prefix">mode_edit</i>
						<form:textarea path="wishContentString" id="icon_prefix2"
							cssClass="materialize-textarea"></form:textarea>

					</div>
				</div>
				<br />
				<br />
				<a href='<c:url value="/savewish"></c:url>'>
					<button class="btn waves-effect waves-light btn-large z-depth-5 "
						style="margin-right: 6em" type="button">
						Back <i class="material-icons right">arrow_back </i>
					</button>
				</a>
				<button class="btn waves-effect waves-light btn-large z-depth-5 "
					style="margin-right: 6em" type="submit" name="action">
					Update <i class="material-icons right">send</i>
				</button>
			</form:form>
		</div>
	</div>
</body>
</html>