<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <%@ page isELIgnored="false" %>
  <meta charset="UTF-8">
  <title>Add Student</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
<div class="container">
  <div align="center">
    <h2>Add / Update Student</h2>
    <table>
      <form:form modelAttribute="student" action="saveStudent" method="POST">
        <form:hidden path="id" />
        <tr>
          <td class="studentprop">FirstName:</td>
          <td><form:input path="firstname" size="30" /></td>
          <td><form:errors path="firstname" class="error" /></td>
        </tr>
        <tr>
          <td class="studentprop">LastName:</td>
          <td><form:input path="lastname" size="30" /></td>
          <td><form:errors path="lastname" class="error" /></td>
        </tr>
        <tr>
          <td class="studentprop">Grade:</td>
          <td><form:input path="grade" size="30" /></td>
          <td><form:errors path="grade" class="error" /></td>
        </tr>

        <tr>
          <td></td>
          <td align="center"><form:button>Submit</form:button></td>
          <td align="center">
                  <a href="${pageContext.request.contextPath}">
                      <button type="button">Back To Home</button>
                  </a>
              </td>
          <td></td>
        </tr>
      </form:form>
    </table>
  </div>
</div>
</body>
</html>