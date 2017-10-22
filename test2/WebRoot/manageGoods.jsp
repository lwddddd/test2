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
				<li><a href="CartAction.action">购物车</a></li>
			</ul>
		</nav>
		<br>
		<div class="row">
			<div class="col-lg-2">
				<ul class="nav nav-stacked nav-tabs">
					<li><a href="HomePage.action">首页</a></li>
					<li class="active"><a href="ManageGoods.action">商品管理</a></li>
					<li><a href="#">用户管理</a></li>
					<li class="disabled"><a href="#">功能</a></li>
				</ul>
			</div>
			<div class="col-lg-10">
				<table class="table table-hover table-bordered"
					contenteditable="false">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>价格</th>
							<th>修改</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="#request.list">
							<tr>
								<th><s:property value="name" />
								</th>
								<th><s:property value="price" />
								</th>
								<th><a
									href="ToUpdateGoods.action?goods.id=<s:property value="id" escape="false" />&goods.name=<s:property value="name" escape="false" />&goods.price=<s:property value="price" escape="false" />">修改商品信息
								</a></th>
								<th><a
									href="DeleteGoods.action?goods.id=<s:property value="id" escape="false" />&goods.name=<s:property value="name" escape="false" />&goods.price=<s:property value="price" escape="false" />">删除商品
								</a>
								</th>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<s:property value="#request.s" escape="false" />
				<br />
				<a href="addGoods.jsp">增加商品</a>
				<form id="form1" action="" method="post">
					<input type="hidden" name=goods.id id=goods.id value="" /> <input
						type="hidden" name=goods.name id=goods.name value="" /> <input
						type="hidden" name=goods.price id=goods.price value="" />
				</form>
			</div>
		</div>
	</div>
	<script src="js/jquery-2.1.1.js"></script>
	<script src="js/bootstrap.js"></script>

</body>
</html>