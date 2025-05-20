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
      <aside class="menu-lateral"><%@ include file="Menu.jsp" %></aside>
  
      <section class="conteudo">
        <div class="header">
          <h1>Usuarios</h1>
          <div class="container-pesquisa">
            <input type="text" id="input-pesquisa" placeholder="Pesquise algo" />
            <button type="button" onclick="abrirModalAdd()">
              Adiconar Admin
            </button>
          </div>
        </div>
        <table class="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Nome</th>
              <th>Email</th>
              <th>BI</th>
              <th>Role</th>
              <th>Data de criacao</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${usuarios}" var="u">
              <tr>
                <td>${u.id}</td>
                <td>${u.nome}</td>
                <td>${u.email}</td>
                <td>${u.bi}</td>
                <td>${u.role}</td>
                <td>${u.dataCriacao}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
  
        <div id="modalAcoes" class="modal-overlay" style="display: none">
          <div class="modal-box">
            <button type="button" id="btnEditar">Editar</button>
            <button type="button" id="btnConfirmarRemover">Remover</button>
  
            <button type="button" onclick="fecharModalAcoes()">Cancelar</button>
          </div>
        </div>
  
        <div id="modalEditar" class="modal-overlay" style="display: none">
          <div class="modal-box">
            <form
              action="${pageContext.request.contextPath}/adm/usuarios/editar"
              method="post"
            >
              <input type="hidden" name="id" id="editarId" />
              Nome: <input type="text" name="nome" id="editarNome" /><br />
              Email: <input type="email" name="email" id="editarEmail" /><br />
              BI: <input type="text" name="bi" id="editarBi" /><br />
              <button type="submit">Salvar</button>
              <button type="button" onclick="fecharModal()">Cancelar</button>
            </form>
          </div>
        </div>
        <div id="modalAdcionar" class="modal-overlay" style="display: none">
          <div class="modal-box">
            <form
              action="${pageContext.request.contextPath}/adm/usuarios/adicionar"
              method="post"
            >
              <input
                type="text"
                name="nome"
                id="AddNome"
                placeholder="Nome"
              /><br />
              <input
                type="email"
                name="email"
                id="AddEmail"
                placeholder="Email"
              /><br />
              <input type="text" name="bi" id="AddBi" placeholder="BI" /><br />
              <input
                type="password"
                name="senha"
                id="AddSenha"
                placeholder="Senha"
              /><br />
              <button type="submit">Adicionar</button>
              <button type="button" onclick="fecharModalAdd()">Cancelar</button>
            </form>
          </div>
        </div>
      </section>
    </div>
    <script>
      window.contextPath = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/pesquisar.js"></script>
    <script src="${pageContext.request.contextPath}/js/modalOptUsuario.js"></script>
    <script src="${pageContext.request.contextPath}/js/validacao.js"></script>
  </body>
</c:if>
