<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2> 상세 정보 보기</h2>
<form action="updateBoard.do" method="get">
<input type="hidden" name="seq" value="${board.seq}">
<table border="1" width="80%">
   <tr>
     <td>제목</td>
     <td><input type="text" name="title" value=" ${board.title}"></td>
   </tr>
   <tr>
     <td>작성자</td>
     <td>${board.writer}</td>
   </tr>
   <tr>
     <td>등록일</td>
     <td>${board.regdate}</td>
   </tr>
   <tr>
     <td>내용</td>
     <td>
        <textarea rows="12" cols="50" name="content">
            ${board.content}
        </textarea>
     </td>
   </tr>
   <tr>
     <td colspan="2" ><input type="submit" value="수정">
      </td>
     
   </tr>
</table>
</form>
<a href="listBoard.do">글목록보기</a>
<a href="insertBoard.html">글쓰기</a>
<a href="deleteBoard.do?seq=${board.seq}">글삭제</a>

</div>
</body>
</html>