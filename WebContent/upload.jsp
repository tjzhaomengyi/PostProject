<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Struts 2�ļ��ϴ�</title>
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <body>
        <center>
            <h3>ͷ���ϴ�</h3>
            <hr/>
            <s:form action="myUpload" enctype="multipart/form-data">
                <s:file name="doc" label="ѡ���ϴ��ļ�"/>
                <s:submit value="�ϴ�"/>
            </s:form>
        </center>
    </body>
</html>
