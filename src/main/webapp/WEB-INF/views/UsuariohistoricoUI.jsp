<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <% if
(session.getAttribute("usuarioLogado") == null) {
response.sendRedirect("/login"); return; } %>

<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
      integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/tableUser.css"
    />
    <title>Historico de Usuario</title>
  </head>
  <body>
    <header>
      <nav class="navbar">
        <div class="logo">
          <h4>Imagine</h4>
          <button
            onclick="window.location.href='${pageContext.request.contextPath}/livros'"
          >
            <i class="fa-solid fa-book-open"></i>
          </button>
          <button
            onclick="window.location.href='${pageContext.request.contextPath}/livros/emprestimos'"
          >
            <i class="fa-regular fa-bell"></i>
          </button>
        </div>
        <div class="container-pesquisa">
          <input
            type="text"
            id="input-pesquisa"
            placeholder="Pesquise por um livro..."
          />
          <%--
          <select id="categoria-select">
            <option value="">Categoria</option>
            <option value="ficcao">Ficção</option>
            <option value="aventura">Aventura</option>
            <option value="romance">Romance</option>
            <option value="biografia">Biografia</option>
            <option value="fantasia">Fantasia</option>
          </select>
          --%>
        </div>
        <div class="links">
          <button type="button" onclick="alternarTema()">
            <i id="icone-tema" class="fa-regular fa-moon"></i>
          </button>
          <button
            type="button"
            onclick="window.location.href='${pageContext.request.contextPath}/logout'"
          >
            <i class="fa-solid fa-right-from-bracket"></i>
          </button>
          <button type="button" onclick="abrirModalEditar()">
            <i class="fa-regular fa-circle-user"></i>
          </button>
        </div>
      </nav>
    </header>

    <section>
      <h2>Histórico</h2>
      <table class="table">
        <thead>
          <tr>
            <th>Livro</th>
            <th>Valor</th>
            <th>Hora Paga</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${historico}" var="h">
            <tr>
              <td>${h.livro}</td>
              <td>${h.valor}</td>
              <td>${h.horaPaga}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <div id="modalEditarPerfil" class="modal-overlay">
        <div class="modal-content">
          <form
            action="${pageContext.request.contextPath}/perfil"
            method="post"
          >
            <input
              type="text"
              name="nome"
              id="editarNome"
              placeholder="Nome"
            /><br />
            <input type="text" name="bi" id="editarBi" placeholder="BI" /><br />
            <input
              type="password"
              name="senha"
              id="editarSenha"
              placeholder="Senha"
            /><br />
            <input
              type="password"
              name="confirmarSenha"
              id="confirmarSenha"
              placeholder="Confirmar Senha"
            /><br />
            <div class="actions">
              <button type="submit">Salvar</button>
              <button type="reset" onclick="fecharModal()">Cancelar</button>
            </div>
          </form>
        </div>
      </div>
    </section>
    <script src="${pageContext.request.contextPath}/js/pesquisar.js"></script>
    <script src="${pageContext.request.contextPath}/js/tema.js"></script>
    <script src="${pageContext.request.contextPath}/js/modalPerfil.js"></script>
  </body>
</html>
