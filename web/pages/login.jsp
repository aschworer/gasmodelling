<%--
  Nakuru. 2007.
  Created: 10.07.2007 || 15:07:39 by A.Zainullina
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="../common/init.jsp" %><%@ page errorPage="jsp_error_handler.jsp" %><%@ page errorPage="jsp_error_handler.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <TITLE>
        Nakuru Login
    </TITLE>
    <link rel="stylesheet" type="text/css" href="<html:rewrite page='/css/common.css'/>">
    <script type="text/javascript" src="<html:rewrite page='/common/common.js'/>"></script>
</HEAD>
<BODY>

<table width="100%" cellpadding="0" cellspacing="0">
    <tr>
        <td align="right" width="100%" height="50px;" class="pink_back"><b>Nakuru&nbsp;Configurator&nbsp;&nbsp;</b></td>
    </tr>
</table>

<center>
    <table width="40%" style="margin-top:100px;">
        <tr>
            <td valign="top">
                <center>
                    <table class="header">
                        <tr>
                            <td>
                                Nakuru&nbsp;Configurator&nbsp;Login
                            </td>
                        </tr>
                    </table>

                    <%--<%if (request.getParameter("fail") != null) {%>
                    <table class="errors">
                        <tr>
                            <td>
                                <%if (request.getParameter("fail").equals("nakuru")) {%>
                                Nakuru authentication failed
                                <%}%>
                                <%if (request.getParameter("fail").equals("domain")) {%>
                                Domain authentication failed
                                <%}%>
                            </td>
                        </tr>
                    </table>
                    <%}%>--%>
                    <logic:present name="org.apache.struts.action.ERROR">
                        <table class="errors">
                            <tr>
                                <td>
                                    <html:errors/>
                                </td>
                            </tr>
                        </table>
                    </logic:present>

                    <table class="entity">
                        <tr>
                            <td>

                                <html:form action="/Login" method="POST">
                                    <html:hidden property="method" value="submit"/>
                                    <br><br>
                                    <table width=100%>
                                        <tr>
                                            <td colspan="2" style="padding-bottom:20px;">
                                                Please&nbsp;input&nbsp;your&nbsp;username&nbsp;and&nbsp;password:
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="20%">
                                                <strong>Username:</strong>
                                            </td>
                                            <td width="80%">
                                                <input id="login" type="text" name="username" class="fieldInput">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="20%">
                                                <strong>Password:</strong>
                                            </td>
                                            <td width="80%">
                                                <input id="pass" type="password" name="password" class="fieldInput">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right" colspan="2">
                                                <input type="submit" class="btn" value="Login"/>
                                                <%--
                                                <html:submit styleClass="btn">
                                                    <bean:message key="button.login.label"/>
                                                </html:submit>
                                                --%>
                                            </td>
                                        </tr>
                                    </table>
                                </html:form>

                            </td>
                        </tr>
                    </table>
                </center>
            </td>
        </tr>
    </table>
</center>
</BODY>
</HTML>


<script language="JavaScript" type="text/javascript">
//    document.getElementById("login").value = "admin";
//    document.getElementById("pass").value = "passw0rd";
//    document.forms[0].submit();
</script>