<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student search</title>
</head>

<body>
<h3>Student search</h3>

<s:form action="student">

    <s:textfield name="name" label="Name"/>
    <s:textfield name="studentAge.age" label="Age"/>

    <s:submit/>

</s:form>

</body>
</html>