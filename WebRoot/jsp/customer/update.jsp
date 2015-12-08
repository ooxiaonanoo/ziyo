<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/ziYo/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ziYo/js/public.js"></script>
<script type="text/javascript" src="/ziYo/jsp/customer/js/customer.js"></script>
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
              <td > <b> &nbsp;&nbsp;&gt;&gt;客户信息修改</b> </td>
            </tr>
        </table>
    </td>
  </tr>
</table>
</div>
<form name="customerForm" method="post">
<div class="main-data">
    <table width="100%" cellspacing="0" cellpadding="2" bordercolor="#9fd9e8" border="1" bgcolor="#d0e6f1" bordercolordark="#EDF2FA">
        <tbody>
            <tr class="formtitletr">
                <td colspan="4" bgcolor="#81BDDA"><b>客户基本信息：</b></td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle" align="right">
                   客户名称(<font color="red">必填</font>)：
                </td>
                <td class="formcontent" colspan="3">
                    <input type="text" class="input1" value="${customer.khmc}" name="customer.khmc"/>
                </td>
            </tr>
            <tr class="formtitletr">
                <td class="formtitle" align="right">
                    客户编号(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${customer.khbh}" name="customer.khbh"/>
                </td>
                <td class="formtitle" align="right">
                    简称(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${customer.jc}"  name="customer.jc"/>
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle" align="right">
                   联系人(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${customer.lxr}" name="customer.lxr"/>
                </td>
                <td class="formtitle" align="right">
                    联系电话(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${customer.lxdh}"  name="customer.lxdh"/>
                </td>
            </tr>
            <tr class="formtitle" align="right">
                <td class="formtitle">
                   地址(<font color="red">必填</font>)：
                </td>
                <td class="formcontent" colspan="3">
                    <input type="text" class="input1" value="${customer.dz}" name="customer.dz"/>
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle" align="right">
                   区域(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${customer.qy}" name="customer.qy"/>
                </td>
                <td class="formtitle" align="right">
                    业务员(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${customer.ywy}"  name="customer.ywy"/>
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle" align="right">
                   发货方式(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${customer.fhfs}" name="customer.fhfs"/>
                </td>
                <td class="formtitle" align="right">
                    回款方式(<font color="red">必填</font>)：
                </td>
                <td class="formcontent">
                    <input type="text" class="input1" value="${customer.hkfs}"  name="customer.hkfs"/>
                </td>
            </tr>
            <tr class="formtitle">
                <td class="formtitle" align="right">
                    备注（可不填）：
                </td>
                <td class="formcontent" colspan="3">
                    <textarea style="width:100%" rows="8" name="customer.bz">${customer.bz}</textarea>
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
 <input type="hidden"  value="${customer.id}"  name="customer.id"/>
</form>
</body>
</html>