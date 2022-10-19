<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>

<%@ page  contentType="text/html; charset=UTF-8"
  %>
  
  <%
  String seq=request.getParameter("seq");
  
  //db연동
  BoardVO vo= new BoardVO();
  vo.setSeq(Integer.parseInt(seq));
  
  
  BoardDAO boardDAO=new BoardDAO();
	boardDAO.deleteBoard(vo);
  
	response.sendRedirect("getBoarList.jsp");
  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>