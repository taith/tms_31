<%@ page import="com.opensymphony.xwork2.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<div id="header">
	<nav class="navbar navbar-default navbar-fixed-top navbar-shrink">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<s:url value="/" />">Framgia
					Training System</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				

				<s:if test="#session.currentUser == null">
					<a id="signin-link" href="<s:url value="/login"/>"><strong>Login</strong></a>
				</s:if>
				<s:else>
				<ul class="nav navbar-nav navbar-right">
				<s:if test="#session.currentUser.suppervisor == 1">
					<li class="page-scroll"><a href="<s:url value="/courses/"/> ">Course</a>
					</li>
					<li class="page-scroll"><a href="<s:url value="/subjects/"/> ">Subject</a>
					</li>
					<li class="page-scroll"><a href="<s:url value="/users/"/> ">All
							Users</a></li>
				</s:if>
				</ul>
					<div class="active-links">
						<div id="session">
							<a id="signin-link" href="#"> Welcome <strong><s:property
										value="%{#session.currentUser.name}" />!</strong>
							</a>
						</div>
						<div id="signin-dropdown">
							<a href="<s:url value="/logout"/>">Logout</a><br> <a
								href="<s:url value="/users/detail%{#session.currentUser.id}"/>">View
								profile</a><br>
						</div>
					</div>
				</s:else>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>