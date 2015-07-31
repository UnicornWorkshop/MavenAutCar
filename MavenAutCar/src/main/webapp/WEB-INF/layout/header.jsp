<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
  <title>AutCar</title>
  <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Tangerine&amp;v1" />
  <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz" />
  <jsp:include page="//WEB-INF/layout/style.jsp"></jsp:include>
  <script type="text/javascript" src="//WEB-INF/layout/currentPage.js"/></script>
  <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
</head>

<body>
  <div id="main">
    <div id="header">
      <div id="logo">
        <h1>Aut<a href="#">Car</a></h1>
        <div class="slogan">[Spring+MySQL+Hibernate]</div>
      </div>
      <jsp:include page="//WEB-INF/layout/top_menu.jsp"></jsp:include>
    </div>
    <div id="site_content">
    <jsp:include page="//WEB-INF/layout/sidebar.jsp"></jsp:include>
    <div id="content">