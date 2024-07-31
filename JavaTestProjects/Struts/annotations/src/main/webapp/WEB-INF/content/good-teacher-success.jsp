<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Good teacher</title>
</head>
<body>
<h3>Good teacher</h3>

<p>Good teacher: <s:property value="name"/></p>

<p><a href="<s:url action='index'  />">Return to home page</a>.</p>

</body>
</html>