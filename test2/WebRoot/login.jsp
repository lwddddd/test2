<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">    
    function refresh() {    
        //IE存在缓存,需要new Date()实现更换路径的作用    
        document.getElementById("image").src="createImageAction.action?+ Math.random()"+new Date();    
    }    
</script>

	<script language="javascript">
	var flag="<s:property value="#request.tip" escape="false" />";
	if(flag!="")
		alert("<s:property value="#request.tip" escape="false" /> ");
	</script>


<title>登录网站</title>
</head>

<body style="padding:50px 0;">
	<DIV style="font-size: 15px;font-family: '宋体'">
	<s:fielderror cssStyle="color:red"></s:fielderror>
		<s:form action="Login.action" method="post">
			<s:textfield name="user.account" label="账号"></s:textfield>
			<s:password name="user.psw" label="密码"></s:password>
			<s:textfield name="checkCode" maxlength="4" label="验证码" />
			<td><img id="image" border="0" onclick="refresh()"
				src="createImageAction.action" title="看不清，换一张"></td> 
		<s:submit value="登录"></s:submit>
		</s:form>
		<a href="signup.jsp">注册</a>
	</DIV>
</body>
</html>
