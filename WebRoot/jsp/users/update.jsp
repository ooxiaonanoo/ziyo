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
              <td > <b> &nbsp;&nbsp;&gt;&gt;用户信息修改</b> </td>
            </tr>
        </table>
    </td>
  </tr>
</table>
</div>
<form name="usersForm" method="post">
<div class="main-data">
 	<input type="hidden"  value="${users.id}"  name="users.id"/>
 	<input type="hidden"  value="${users.userType}"  name="users.userType"/>
    <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
        <tbody>
            <tr class="formtitletr">
                <td colspan="4" bgcolor="#81BDDA"><b>用户基本信息：</b></td>
            </tr>
            <tr class="formtitle">
            	<td class="formtitle" align="right">
                    用户帐号(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${users.userAccount}" name="users.userAccount"/>
                </td>
                <td class="formtitle" align="right">
                    用户密码(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${users.userPwd}" name="users.userPwd"/>
                </td>
            </tr>
            <tr class="formtitletr">
            	 <td class="formtitle" align="right">
                   用户名称(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${users.userName}" name="users.userName"/>
                </td>
                <td class="formtitle" align="right">
                    联系电话(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${users.userPhone}" name="users.userPhone"/>
                </td>
            </tr>
            <tr class="formtitle">
            	<td class="formtitle" align="right">
                    邮件(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${users.userEmail}"  name="users.userEmail"/>
                </td>
                <td class="formtitle" align="right">
                   是否启用(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                	<select name="users.userFlag" class="input1">
                		<c:choose>
                			<c:when test="${users.userFlag=='Y'}">
					      		<option value="Y" selected="selected">启用</option>
					      		<option value="N">锁定</option>
                			</c:when>
                			<c:otherwise>
						      	<option value="N" selected="selected">锁定</option>
						      	<option value="Y">启用</option>
                			</c:otherwise>
                		</c:choose>
					</select>
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle" align="right">
                    备注（可不填）：
                </td>
                <td class="formcontent" colspan="3">
                    <textarea style="width:100%" rows="8" name="users.userRem">${users.userRem}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="formcontent" align="center" >
                    <input type="button" class="botn" onclick="checkFromSubmitUpdate()" value="提交"  />
                </td>
            </tr>
        </tbody>
    </table>
</div>
</form>
</body>
</html>