<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,bean.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>电商网站</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
	<script language="javascript">
	var flag="<s:property value="#request.tip" escape="false" />";
	if(flag!="")
		alert("<s:property value="#request.tip" escape="false" /> ");
	</script>
<body style="padding:50px 0;">
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<a href="HomePage.action" class="navbar-brand"></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="HomePage.action">电商网站</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right"> 
			<li> <img src ='<s:property value="#session.user.photo" escape="false"   />'  height="50" width="50"  /> </li>
			<li><a href="fileUpload.jsp">修改头像</a></li>
            <li><a href="CartAction.action">购物车</a></li> 
        </ul> 
		</nav>
		<br>
		<div class="row">
			<div class="col-lg-2">
				<ul class="nav nav-stacked nav-tabs">
					<li class="active"><a href="HomePage.action">首页</a></li>
					<li><a href="ManageGoods.action">商品管理</a></li>
					<li><a href="#">用户管理</a></li>
					<li class="disabled"><a href="#">功能</a></li>
				</ul>
			</div>
			<div class="col-lg-10">
				<s:form action="SearchGoods.action" method="post" theme="simple">
					<s:textfield name="word"></s:textfield>
					<s:submit value="搜索"></s:submit>
				</s:form>
				<table class="table table-hover table-bordered"
					contenteditable="false">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>价格</th>
							<th>购买</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="#request.list">
							<tr>
								<th><s:property value="name" />
								</th>
								<th><s:property value="price" />
								</th>
								<th><button type="button" value=<s:property value="id" />   onclick="onclick1(this)">添加至购物车</button></th>
							</tr>
						</s:iterator>

					</tbody>
				</table>
				<s:property value="#request.s" escape="false" />
				<form id="form1" action="CartAction.action" method="post">
					<input type="hidden" name=goods.id  id=goods.id value="" />
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript">
		function onclick1(button) {
			var id = button.value;
			document.getElementById("goods.id").value = id;
			document.getElementById("form1").submit();
		}
	</script>
</body>
</html>