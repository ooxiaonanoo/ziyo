<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/ziYo/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ziYo/js/public.js"></script>
<script type="text/javascript" src="/ziYo/jsp/system/js/node.js"></script>
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
              <td > <b> &nbsp;&nbsp;&gt;&gt;功能信息录入</b> </td>
            </tr>
        </table>
    </td>
  </tr>
</table>
</div>
<form name="nodeForm" method="post">
<div class="main-data">
    <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
        <tbody>
        	<!-- 节点功能标志，暂时默认0 -->
 			<input type="hidden"  value="0"  name="node.type"/>
 			<!-- 排序 顺序排序，暂时默认1 -->
 			<input type="hidden"  value="1"  name="node.sort"/>
 			
            <tr class="formtitletr">
                <td colspan="4" bgcolor="#81BDDA"><b>功能基本信息：</b></td>
            </tr>
            <tr class="formtitle">
            	<td class="formtitle" align="right">
                    父级菜单(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                	<select name="node.nodefid" class="input1">
               			<option value="" selected="selected">请选择父级功能菜单...</option>
                		<c:forEach var="ass" items="${listAss}" >
                			<option value="${ass.nodeid}">${ass.nodename}</option>
               			</c:forEach >
					</select>
                    <!-- input type="text" class="input1" name="node.nodefid"/> -->
                </td>
                <td class="formtitle" align="right">
                     功能名称(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" name="node.nodename"/>
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle" align="right">
                     功能URL(<font color="red">必填</font>)：
                </td>
                <td class="formcontent" colspan="3">
                    <input type="text" class="input1" name="node.url"/>
                </td>
            </tr>
            <tr class="formtitle">
            	<td class="formtitle" align="right">
                     功能级别(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" name="node.levelup"/>
                </td>
                <td class="formtitle" align="right">
                   是否启用(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                	<select name="node.flag" class="input1">
					      <option value="Y">启用</option>
					      <option value="N">锁定</option>
					</select>
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle" align="right">
                    功能备注：
                </td>
                <td class="formcontent" colspan="3">
                    <textarea style="width:100%" rows="8" name="node.rem"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="4"  class="formcontent" align="center" >
                    <input type="button" class="botn" onclick="checkFromSubmitAdd()" value="提交"  />
                </td>
            </tr>
        </tbody>
    </table>
</div>
</form>

</body>
</html>