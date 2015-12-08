<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/ziYo/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ziYo/js/public.js"></script>
<script type="text/javascript" src="/ziYo/jsp/users/js/users.js"></script>
<script type="text/javascript" src="/ziYo/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
.input1{width: 100%;height: 25px;}
.botn{margin:0; padding:0;border:0;  width:60px;height:25px; background:url(/ziYo/images/anniu.jpg) no-repeat 0 0; margin-right:10px;}
.botn a{ width:60px; height:25px; line-height:25px; display:block; text-align:center; color:#fff; text-decoration:none;}
.botn a:hover{ color:#000; text-decoration:none;}
</style>
</head>
<body>
<div class="main_title">
 <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
  <tr>
    <td background="/ziYo/images/htgl_04.gif">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
              <td > <b> &nbsp;&nbsp;&gt;&gt;密码修改</b> </td>
            </tr>
        </table>
    </td>
  </tr>
</table>
</div>
<form name="usersForm" method="post">
<div class="main-data">
    <table width="100%" cellspacing="0" cellpadding="2" border="1" bgcolor="#d0e6f1">
        <tbody>
            <tr class="formtitletr">
                <td colspan="4" bgcolor="#81BDDA"><b>用户密码修改：</b></td>
            </tr>
            <tr class="formtitle">
            	<td rowspan="4" width="200px"><img src="/ziYo/images/23652.jpg" alt="" width="200px" height="190px"/></td>
            	<td class="formtitle" align="center" style="width: 200px">
                    原密码(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="password" class="input1" name="users.userPwd"/>
                </td>
                <td rowspan="4" width="200px"><img src="/ziYo/images/23652.jpg" alt="" width="200px" height="190px"/></td>
            </tr>
             <tr class="formtitletr">
            	 <td class="formtitle" align="center">
                   新密码(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="password" class="input1" name="newPassWord"/>
                </td>
            </tr>
            <tr class="formtitletr">
            	 <td class="formtitle" align="center">
                   确认新密码(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="password" class="input1" name="newPassWord2"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"  class="formcontent" align="center" >
                    <input type="button" class="botn" onclick="checkFromSubmitUpdate()" value="提交"  />
                </td>
            </tr>
        </tbody>
    </table>
</div>
 <input type="hidden"  value="${users.id}"  name="users.id"/>
</form>
</body>
</html>