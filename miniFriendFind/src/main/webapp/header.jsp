<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-light navbar-light">
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="nav-link" href="home.do"><h3>Home</h3></a>		
		</li>
		<div class="navbar-collapse full-width pull-right">
			<li class="nav-item">
				<a class="nav-link" href="detailPage.do?id=<%=session.getAttribute("id") %>">
				<h3 style="color: blue;">
				<%=session.getAttribute("nickName") %></h3></a>	
			</li>
			<li class="nav-item">
				<a class="nav-link" href="logout.do"><h3>Logout</h3></a>		
			</li>
		</div>
		
	</ul>
</nav>

