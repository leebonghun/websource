<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String fileName = request.getParameter("fileName");

   //전송될 파일이 저장된 폴더로 가서 해당 파일 읽어오기
   String uploadPath="c:\\upload\\"+fileName;
   FileInputStream fis = new FileInputStream(uploadPath);
   
   //브라우저를 통해서 다운로드
   out.clear();
   out=pageContext.pushBody();
   
   //다운로드 시 uuid 값을 떼내고 다운로드 시키기
  int position= fileName.indexOf("_");
   fileName = fileName.substring(position+1);
   
   //MIME 타입
   response.setContentType("application/octet-stream");
   //한글파일명 원래대로 변경
   //url에 붙은 한글은 인코딩이 일어남()
   fileName = new String(fileName.getBytes("utf-8"),"iso-8859-1");
   response.setHeader("Content-Disposition", "attachment;filename="+fileName);
   
   //읽어온 파일을 클라이언트 브라우저로 전송
   BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
   int numRead = 0;
   byte[] b = new byte[4896];
   while((numRead = fis.read(b,0,b.length))!=-1){
      bos.write(b,0,numRead);
   }
   bos.flush();
   bos.close();
   fis.close();
%>