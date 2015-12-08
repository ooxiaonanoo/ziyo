<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/ziYo/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ziYo/js/My97DatePicker/WdatePicker.js"></script>
<title>梓瑶兽药</title>
</head>
<body>
  <div class="list">
 	<strong>功能查询</strong>
 		<form action="/ziYo/nodeAction/findBySql"  method="post" >
 			<table width="100%" border="1" bordercolor="#9FD9E8" cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA" bgcolor="#D0E6F1">
 				<tr>
 					<td width="80" align="right" bgcolor="#D0E6F1">
                   		<strong>功能名称：</strong>
                    </td>
                    <td width="60" bgcolor="#F4F2F2">
                        <input type="text" id="" value="${node.nodename}" name="node.nodename"/>
                    </td>
                    <td bgcolor="#F4F2F2">
                        <input type="submit"  value=" 查  询 "/>
                    </td>
               	</tr>
           	</table>
       	</form>
	</div>
    <div class="list">
                        <strong>功能列表 </strong>
                        <table width="100%" border="1" bordercolor="#9FD9E8"
                            cellpadding="2" cellspacing="0" bordercolordark="#EDF2FA"
                            bgcolor="#D0E6F1">
                            <tr>
                                <td width="30" align="center" bgcolor="#D0E6F1">
                                    <strong>序号</strong>
                                </td>
                                <td align="center" bgcolor="#D0E6F1">
                                    <strong>功能名称</strong>
                                </td>
                                <td align="center" bgcolor="#D0E6F1">
                                    <strong>功能URL</strong>
                                </td>
                                <td align="center" bgcolor="#D0E6F1">
                                    <strong>是否启用</strong>
                                </td>
                                <td width="30" height="28" align="center" bgcolor="#D0E6F1" colspan="2">
                                    <strong>操作</strong>
                                </td>
                            </tr>
                            
                            <c:if test="${listAss==null}">
                            <tr>
                                <td colspan="12">没有符合条件的数据!</td>
                            </tr>
                            </c:if>
                            
                            <%int si=1;%>
                            <c:forEach var="ass" items="${listAss}" >
                                <tr bgcolor="#E7F2F8" onMouseOver="this.bgColor='#FFFFFF';" onMouseOut="this.bgColor='#E7F2F8';">
                                    <td align="center">
                                    <%=si++%>
                                    </td>
                                    <td align="center">
                                        ${ass.nodename}
                                    </td>
                                    <td align="center">
                                        ${ass.url}
                                    </td>
                                    <td align="center">
                                        <c:choose>
                                        	<c:when test="${ass.flag=='Y'}">
                                        		<span style="color: green;">启用</span>
                                        	</c:when>
                                        	<c:otherwise>
										        <span style="color: red;">锁定</span>
										    </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <a href="/ziYo/systemAction/getNodeById?id=${ass.nodeid}&returnType=update" class="data_edit">修改</a>
                                    </td>
                                    <td>
                                        <a href="/ziYo/systemAction/getNodeById?id=${ass.nodeid}&returnType=update" class="data_del">删除</a>
                                    </td>
                                </tr>
                            </c:forEach >
                        </table>
                        </div>
</body>
</html>