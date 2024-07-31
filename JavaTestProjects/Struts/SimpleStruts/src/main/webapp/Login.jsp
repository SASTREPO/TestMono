<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Sign On</title>
    <s:head />
</head>

<body>
<s:form action="Login">
    <s:textfield name="username" label="Username"/>
    <s:password name="password" label="Password"/>
    <s:submit/>
</s:form>
</body>
</html>