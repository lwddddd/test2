<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>

  </head>
  
  <body style="padding:50px 0;">
	<DIV style="font-size: 15px;font-family: '宋体'">
	<s:form action="SignUp.action" method="post">
	<s:textfield name="user.account" label="账号"></s:textfield>
		<s:textfield name="user.psw" label="密码"></s:textfield>
    <s:textfield name="user.email" label="电子邮箱"></s:textfield>
    <s:textfield name="user.phoneNum" label="电话号码"></s:textfield>
		<s:submit value="注册"></s:submit>
	</s:form> 
    </DIV>
  </body>
</html>
