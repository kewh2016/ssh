<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息列表</title>
</head>
<body>
	<ul>
		<s:iterator value="messages" var="me">
			<li>id:<s:property value="msgId" />|content:<s:property value="msgContent" /></li>
		</s:iterator>
	</ul>
</body>
</html>