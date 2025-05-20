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
      href="${pageContext.request.contextPath}/css/menu.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/dashboard.css"
    />
  </head>
  
  <body>
    <div class="container">
      <div class="menu">
        <div th:replace="fragments/menu :: *"></div>
        <%@ include file="Menu.jsp" %>
      </div>
      <section class="conteudo">
        <h1>Painel Administrativo</h1>
        <div class="dashboard">
          <div class="card">
            <h2>Usuários</h2>
            <div>
          <span class="count">234</span>
          <span class="label">Total</span>
          <span class="admin-count">12 Administradores</span>
            </div>
          </div>
          <div class="card-2">
            <h2>Livros</h2>
            <p>876 livros cadastrados</p>
          </div>
          <div class="card-2">
            <h2>Pagamentos Recentes</h2>
            <ul>
          <li>27/04/2025 - Recebido: R$250,00</li>
          <li>27/04/2025 - Recebido: R$100,00</li>
            </ul>
          </div>
          <div class="card-2">
            <h2>Novo Administrador</h2>
            <button>Adicionar</button>
          </div>
          <div class="card-2">
            <h2>Gestão de Autores</h2>
            <p>Adicionar novo autor</p>
          </div>
        </div>
      </section>
    </div>
  </body>
</c:if>