<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.01 Frameset//EN" "http://www.w3c.org/tr/1999/REC-html401-19991224/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<style type=text/css>
body {
	font-size: 12px; color: #ffffff; font-family: 宋体
}
td {
	font-size: 12px; color: #ffffff; font-family: 宋体
}
</style>

<meta content="MSHTML 6.00.6000.16809" name=GENERATOR></head>
<body>
<form id=form1 name=form1 action="${pageContext.request.contextPath }/user_login.action" method=post>

<div id=UpdatePanel1>
<div id=div1 
style="left: 0px; position: absolute; top: 0px; background-color: #0066ff"></div>
<div id=div2 
style="left: 0px; position: absolute; top: 0px; background-color: #0066ff"></div>


<div>&nbsp;&nbsp; </div>
<div>
<table cellSpacing=0 cellPadding=0 width=900 align=center border=0>
  <tbody>
  <tr>
    <td style="height: 105px"><img src="images/login_1.gif" 
  border=0></td></tr>
  <tr>
    <td background=images/login_2.jpg height=300>
      <table height=300 cellPadding=0 width=900 border=0>
        <tbody>
        <tr>
          <td colSpan=2 height=35></td></tr>
        <tr>
          <td width=360></td>
          <td>
            <table cellSpacing=0 cellPadding=2 border=0>
              <tbody>
              <tr>
                <td style="height: 28px" width=80>登 录 名：</td>
                <td style="height: 28px" width=150><input id=txtName 
                  style="width: 130px" name="userCode"></td>
                <td style="height: 28px" width=370><span 
                  id=RequiredFieldValidator3 
                  style="font-weight: bold; VISIBILITY: hidden; color: white">请输入登录名</span></td></tr>
              <tr>
                <td style="height: 28px">登录密码：</td>
                <td style="height: 28px"><input id=txtPwd style="width: 130px" 
                  type=password name="userPassword"></td>
                <td style="height: 28px"><span id=RequiredFieldValidator4 
                  style="font-weight: bold; VISIBILITY: hidden; color: white">请输入密码</span></td></tr>
              <!-- <tr>
                <td style="height: 28px">验证码：</td>
                <td style="height: 28px"><input id=txtcode 
                  style="width: 130px" name=txtcode></td>
                <td style="height: 28px">&nbsp;</td></tr> -->
              <tr>
                <td style="height: 18px"></td>
                <td style="height: 18px"></td>
                <td style="height: 18px"></td></tr>
              <tr>
                <td></td>
                <td><input id=btn 
                  style="border-top-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-right-width: 0px" 
                  type=image src="images/login_button.gif" name=btn> 
              </td></tr></tbody></table></td></tr></tbody></table></td></tr>
  <tr>
    <td><img src="images/login_3.jpg" 
border=0></td></tr></tbody></table></div></div>


</form>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#txtName").focus();
	});
</script>
</body>
</html>
