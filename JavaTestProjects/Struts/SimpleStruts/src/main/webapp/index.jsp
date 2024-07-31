<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Struts Application - Welcome</title>
    <s:head />
    <style type="text/css">
    .errorMessage {
    	color: red;
    }
    </style>
  </head>
  <body>

    <p>Get your own personal hello by filling out and submitting this form.</p>
    <s:actionerror/>
    <s:form action="hello">
      <s:textfield name="userName" label="Your name" /> allowed names: nury, james, mary
      <s:textfield name="email" label="Your email" />
      <s:textfield name="blocked" label="Blocked input" />
      <s:submit value="Submit" />
    </s:form>

    <p><a href="search">Search user</a></p>
    <p><a href="search-lombok">Search user</a> (Lombok)</p>
    <br>
    <p><a href="Login">Login</a></p>
  </body>
</html>
