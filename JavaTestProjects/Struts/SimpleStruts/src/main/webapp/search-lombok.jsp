<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Search User</title>
    <s:head />
</head>
<body>
<h3>Search user</h3>

<s:form action="search-lombok-submit">
    <s:textfield name="userLombok.name" label="Name"/>
    <s:submit method="execute" />
    <s:submit action="search-lombok-cancel" value="Cancel" />
</s:form>
</body>
</html>
