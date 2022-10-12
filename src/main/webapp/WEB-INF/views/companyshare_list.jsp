<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%> <%@ taglib uri="http://www.springframework.org/tags"
prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="eng">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Company Share List</title>
    <link
      href="../../webjars/bootstrap/5.2.2/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="../../webjars/bootstrap/5.2.2/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.6.1/js/jquery.min.js"></script>
  </head>
  <body>
    <div class="container">
      <caption>Company Share</caption>
        <thead class="thead-dark">
          <th scope="row">ID</th>
          <th scope="row">Company Name</th>
          <th scope="row">Share Price</th>
          <th scope="row">Update</th>
          <th scope="row">Delete</th>
        </thead>
        <tbody>
          <c:forEach items="${companyShareList}" var="companyshare">
            <tr>
              <td>${companyshare.id}</td>
              <td>${companyshare.firstname}</td>
              <td>${companyshare.lastname}</td>
              <td>
                <spring:url
                  value="/Company/editcompanyshare/${companyshare.id}"
                  var="editURL"
                />
                <a class="btn btn-info" href="${editURL}" role="button"
                  >Update</a
                >
              </td>
              <td>
                <spring:url
                  value="/Company/deletecompanyshare/${companyshare.id}"
                  var="deleteURL"
                />
                <a class="btn btn-danger" href="${deleteURL}" role="button"
                  >Delete</a
                >
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <spring:url value="/company/addcompanyshare/" var="addURL" />
      <a class="btn btn-success" href="${addURL}" role="button"
        >Add New Company</a
      >
    </div>
  </body>
</html>
