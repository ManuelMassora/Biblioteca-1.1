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
          <h1>Emprestimos</h1>
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
              <th>Total</th>
              <th>Data Emprestada</th>
              <th>Data de Devolucao</th>
              <th>Acao</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${emprestimos}" var="e">
              <tr>
                <td>${e.id}</td>
                <td>${e.usuario}</td>
                <td>${e.livro}</td>
                <td>${e.total}</td>
                <td>${e.dataEmprestado}</td>
                <td>${e.dataEntrega}</td>
                <td>
                  <c:if test="${!e.finalizado}">
                    <form
                      action="${pageContext.request.contextPath}/adm/Emprestimos/devolver"
                      method="post"
                      style="display: inline"
                    >
                      <input type="hidden" name="id" value="${e.id}" />
                      <button
                        type="submit"
                        onclick="return confirm('Tem certeza que deseja devolver?')" class="btn-acao"
                      >
                        Devolver
                      </button>
                    </form>
                  </c:if>
                  <c:if test="${!e.pago && e.finalizado}">
                    <form
                      action="${pageContext.request.contextPath}/adm/Emprestimos/pagar"
                      method="post"
                      style="display: inline"
                    >
                      <input type="hidden" name="id" value="${e.id}" />
                      <button
                        type="submit"
                        onclick="return confirm('Tem certeza que deseja Pagar?')" class="btn-acao"
                      >
                        Pagar
                      </button>
                    </form>
                  </c:if>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </section>
    </div>
    <script src="${pageContext.request.contextPath}/js/pesquisar.js"></script>
  </body>
</c:if>
