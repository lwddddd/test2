<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>增加商品</title>

  </head>
  
  <body style="padding:50px 0;">
    <form id="form1" action="" method="post">					
					商品名称：<input  name=goods.name id=goods.name value="<s:property value="#request.goods.name"   escape="false" />" />
                    <br/>商品价格：<input  name=goods.price id=goods.price value="<s:property value="#request.goods.price"   escape="false" />" />
				</form>
  </body>
</html>
