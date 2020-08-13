<!DOCTYPE html>
<html>
<head>
<title>WishList</title>
</head>

<body>
	<div class="container">

		<%@include file="header.jsp"%>


		<div class="row" style="margin-top: 2em">


			<!--  left section  -->

			<div class="section col s2 center-align">
				<br /> <br />
				<div class="collection">
					<a href='<c:url value="/"/>'
						class="collection-item <c:if test="${page == 'home'}">active</c:if>">Menu</a>
					<a href='<c:url value="/add"/>'
						class="collection-item <c:if test="${page == 'add'}">active</c:if>">Add
						Wish</a> <a href='<c:url value="/savewish"></c:url>'
						class="collection-item <c:if test="${page == 'viewwishes'}">active</c:if> ">View
						Wishes</a>
				</div>
			</div>


			<!-- right section -->

			<div class="section col s10 center-align " style="margin-top: 3em">

				<c:if test="${page=='home' }">
					<div class="gfg">
						<img
							src="${pageContext.request.contextPath}/resources/images/wish.svg"
							alt="wish image" class="img-wish">
					</div>
				</c:if>



				<c:if test="${page=='add' }">
					<br />
					<div class="row center-align">
						<form:form action="savewish" method="POST"
							modelAttribute="wishEntity">
							<div class="row">
								<div class="input-field col s6 push-s2">
									<i class="material-icons prefix">mode_edit</i>
									<form:textarea path="wishTitleString" id="icon_prefix1"
										cssClass="materialize-textarea"></form:textarea>
									<form:label path="wishTitleString" for="icon_prefix1">Title</form:label>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="input-field col s6 push-s2">
									<i class="material-icons prefix">mode_edit</i>
									<form:textarea path="wishContentString" id="icon_prefix2"
										cssClass="materialize-textarea"></form:textarea>
									<form:label path="wishContentString" for="icon_prefix2">Content</form:label>
								</div>
							</div>
							<br />
							<br />

							<button class="btn waves-effect waves-light btn-large z-depth-5 "
								style="margin-right: 6em" type="submit" name="action">
								Submit <i class="material-icons right">send</i>
							</button>

						</form:form>
					</div>
				</c:if>

				<c:if test="${page=='viewwishes' }">
					<ul class="collapsible">
						<c:forEach items="${allWishes}" var="wish">
							<li>
								<div class="collapsible-header hoverable text">
									<i class="material-icons teal"
										style="margin-top: 6px; color: white; background-color: #26A69A; padding: 2px">send</i>
									<c:out value="${wish.wishTitleString}"></c:out>
									<span class="new  badge " data-badge-caption=""
										style="margin-top: 8px"><c:out value="${wish.wishDate}"></c:out></span>
									<span><a
										href='<c:url value="/delete/${wish.id}"></c:url>'><i
											class="material-icons delete-icon hvr-buzz-out"
											style="font-size: 1.5em">delete</i></a></span>
											<span><a
										href='<c:url value="/update/${wish.id}"></c:url>'><i
											class="material-icons update-icon hvr-buzz-out"
											style="font-size: 1.5em">create</i></a></span>
								</div>
								<div class="collapsible-body">
									<h5>
										<c:out value="${wish.wishContentString}"></c:out>
									</h5>
								</div>

							</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>

	<!--JavaScript at end of body for optimized loading-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</body>
</html>