<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>增加商品</title>

  </head>
  
  <body style="padding:50px 0;">
	<DIV style="font-size: 15px;font-family: '宋体'">
	<s:form action="AddGoods.action" method="post">
	<s:textfield name="goods.name" label="商品名"></s:textfield>
	<s:textfield name="goods.price" label="价格"></s:textfield>
		<s:submit value="确认"></s:submit>
	</s:form> 
    </DIV>
  </body>
</html>
