<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Frameset//EN" "http://www.w3c.org/tr/1999/REC-html401-19991224/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<style type=text/css>
body {
	font-size: 12px;
	color: #ffffff;
	font-family: 宋体
}

td {
	font-size: 12px;
	color: #ffffff;
	font-family: 宋体
}

.error {
	color: red;
}
</style>
<meta content="MSHTML 6.00.6000.16809" name=GENERATOR>

<!-- 引入JQ -->
<script type="text/javascript"
	src="${ pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
	// 验证登录名
	function checkCode() {
		// 获取用户输入的登录名
		var code = $("#userCode").val();
		// 进行判断，说明没有输入登录名
		if (code.trim() == "") {
			// 给提示
			$("#codeId").addClass("error");
			$("#codeId").html("登录名不能为空");
		} else {
			// 登录名不为空，ajax请求，验证
			$.ajax({
				url:'${pageContext.request.contextPath}/user_checkCode.action',
				type:'post',
				data:{
					userCode : code
				},
				dataType:'text',
				success:function(data){
					// 操作data，进行判断
					if (data && data == "no") {
						// 提示
						$("#codeId").addClass("error");
						$("#codeId").html("登录名已经存在");
					} else {
						$("#codeId").removeClass("error");
						$("#codeId").html("可以注册");
					}
				}
			});
		}
	}

	// 可以阻止表单的提交
	function checkForm() {
		// 先让校验名称的方法先执行以下
		checkCode();
		// 获取error的数量，如果数量 > 0，说明存在错误，不能提交表单
		if ($(".error").size() > 0) {
			return false;
		}
	}
</script>

</head>

<body>

	<form id=form1 name=form1
		action="${ pageContext.request.contextPath }/user_register.action"
		onsubmit="return checkForm()" method=post>

		<div id=UpdatePanel1>
			<div id=div1
				style="left: 0px; position: absolute; top: 0px; background-color: #0066ff"></div>
			<div id=div2
				style="left: 0px; position: absolute; top: 0px; background-color: #0066ff"></div>


			<div>&nbsp;&nbsp;</div>
			<div>
				<table cellSpacing=0 cellPadding=0 width=900 align=center border=0>
					<tbody>
						<tr>
							<td style="height: 105px"><img src="images/login_1.gif"
								border=0></td>
						</tr>
						<tr>
							<td background=images/login_2.jpg height=300>
								<table height=300 cellPadding=0 width=900 border=0>
									<tbody>
										<tr>
											<td colSpan=2 height=35></td>
										</tr>
										<tr>
											<td width=360></td>
											<td>
												<table cellSpacing=0 cellPadding=2 border=0>
													<tbody>
														<tr>
															<td style="height: 28px" width=80>登 录 名：</td>

															<td style="height: 28px" width=150>
																<input id="userCode" style="width: 130px" name="userCode"	onblur="checkCode()"/>
															</td>
															<td style="height: 28px" width=370>
																<span id="codeId" style="font-weight: bold;"></span>
															</td>
														</tr>
														<tr>
															<td style="height: 28px">登录密码：</td>
															<td style="height: 28px">
																<input id="userPassword" style="width: 130px" type=password name="userPassword" />
															</td>
															<td style="height: 28px">
																<span id=RequiredFieldValidator4 style="font-weight: bold; VISIBILITY: hidden; COLOR: white">请输入密码</span>
															</td>
														</tr>
														<tr>
															<td style="height: 28px">用户姓名：</td>
															<td style="height: 28px">
																<input id="userName" style="width: 130px" type="text" name="userName" />
															</td>

															<td style="height: 28px">
																<span id=RequiredFieldValidator4 style="font-weight: bold;"></span>
															</td>
														</tr>
														<tr>
															<td style="height: 18px"></td>
															<td style="height: 18px"></td>
															<td style="height: 18px"></td>
														</tr>
														<tr>
															<td></td>
															<td>
																<input type="submit" value="注册" />
															</td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td><img src="images/login_3.jpg" border=0></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>


	</form>
</body>
</html>