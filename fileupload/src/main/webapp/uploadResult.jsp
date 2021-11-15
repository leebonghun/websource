<%@page import="java.util.UUID"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>
      note :
      <%=request.getParameter("note")%></h1>
   <h1>
      upfile :
      <%=request.getParameter("upfile")%></h1>
   <hr />
   <%-- commons-fileupload 이용한 처리 방법 --%>
   <%
   boolean isMultipart = ServletFileUpload.isMultipartContent(request);
   if (isMultipart) {
      //전송된 파일을 디스크에 저장하기 위한 객체
      DiskFileItemFactory factory = new DiskFileItemFactory();
      
      ServletFileUpload upload = new ServletFileUpload(factory);
      //업로드 가능 사이즈 지정
      upload.setSizeMax(2000*1024);
      //사용자의 request 분석
      List<FileItem> fileItems = upload.parseRequest(request);
      
      String fieldName =null , fileName = null,value=null;
      
      Iterator<FileItem> iter = fileItems.iterator();
      while(iter.hasNext()){
         FileItem item = iter.next();
         
         //text,password,checkbox
         if(item.isFormField()){
            //요소명
            fieldName = item.getFieldName();
            value = item.getString("utf-8");
            out.print("<h3>일반 데이터</h3>");
            out.print(fieldName+" : "+value+"<br>");          
         }else{//type=file
           //요소명
            fieldName = item.getFieldName();
            //파일명
            fileName = item.getName();
            //파일 사이즈	
            long size = item.getSize();
            
            File file = null;
            //파일이 비어있지 않을 때 저장
            if(!fileName.isEmpty()){   
            //파일 저장
            String path= "C:\\upload\\";
            
            //중복되지 않은 고유한 키 값 생성
            UUID uuid = UUID.randomUUID();
            
            file = new File(path+uuid.toString()+"_"+fileName);
            item.write(file);
            }
            
            
            out.print("<h3>파일 데이터</h3>");
            out.print(fieldName+" : "+fileName+"<br>");
            out.print("파일 크기"+size);
            
            //파일다운로드 - 다운시킬 파일명 전송
            out.print("<p>");
            out.print("<a href='download.jsp?fileName="+file.getName()+"'>"+fileName+"</a>");
            out.print("</p>");
            
         }
      }
   }
   %>

</body>
</html>