<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"       %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Login</title>
      <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/login.css"
    />
</head>
<body>
  <h2>Faça seu Login</h2>

  <c:if test="${not empty erro}">
    <div class="error">${erro}</div>
  </c:if>

  <c:if test="${not empty mensagem}">
    <div class="message">${mensagem}</div>
  </c:if>

  <form:form method="post" action="${pageContext.request.contextPath}/login" modelAttribute="autenticacaoDTO">

    <div>
      <form:label path="email">Email:</form:label><br/>
      <form:input path="email" placeholder="email"/>
      <form:errors path="email" cssClass="error"/>
    </div>

    <div>
      <form:label path="senha">Senha:</form:label><br/>
      <form:password path="senha" placeholder="password"/>
      <form:errors path="senha" cssClass="error"/>
    </div>

    <div>
      <button type="submit">Entrar</button>
      <a href="${pageContext.request.contextPath}/signup">Cadastrar</a>
    </div>

  </form:form>
  <script src="${pageContext.request.contextPath}/js/validacao.js"></script>
</body>
</html>