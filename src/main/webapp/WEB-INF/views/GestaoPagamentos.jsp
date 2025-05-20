<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="user" value="${sessionScope.usuarioLogado}" />

<c:if test="${user == null || not user.admin}">
    <script>window.location.href='${pageContext.request.contextPath}/login';</script>
</c:if>

<c:if test="${user.admin}">
  <head>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/table.css"
    />
    <head>
      <link
        rel="stylesheet"
        href="${pageContext.request.contextPath}/css/menu.css"
      />
    </head>
  </head>
  <body>
    <div class="container">
      <div class="menu">
        <div th:replace="fragments/menu :: *"></div>
        <%@ include file="Menu.jsp" %>
      </div>
      <section class="conteudo">
        <div class="header">
          <h1>Pagamentos</h1>
          <div class="container-pesquisa">
            <input type="text" id="input-pesquisa" placeholder="Pesquise algo" />
          </div>
        </div>
        <table class="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Usuario</th>
              <th>Livro</th>
              <th>ID_Emprestimo</th>
              <th>Valor</th>
              <th>Data</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${pagamentos}" var="p">
              <tr>
                <td>${p.id}</td>
                <td>${p.usuario}</td>
                <td>${p.livro}</td>
                <td>${p.idEmprestimo}</td>
                <td>${p.valoPagamento}</td>
                <td>${p.hora}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </section>
    </div>
    <script src="${pageContext.request.contextPath}/js/pesquisar.js"></script>
  </body>
</c:if>
