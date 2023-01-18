<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/css/style.css">
<title>Mybatis blog</title>
</head>
<body>
	<div class="m--wrap">

		<nav class="navbar navbar-expand-md bg-dark navbar-dark">
			<!-- Brand -->
			<a class="navbar-brand" href="/">MyBlog</a>

			<!-- Toggler/collapsibe Button -->
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- Navbar links -->
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/board/list">List</a></li>
					<c:choose>
					<c:when test="${sessionScope.principal eq null}">
					<li class="nav-item"><a class="nav-link" href="/user/sign-in">Sign in</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/sign-up">Sign up</a></li>					
								<li class="nav-item"><a class="nav-link" href="/board/write">Write</a></li>
					</c:when>
					<c:otherwise>
					
					<li class="nav-item"><a class="nav-link" href="/board/write">Write</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/logout">Logout</a></li>
					</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</nav>