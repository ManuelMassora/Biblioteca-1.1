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
      href="${pageContext.request.contextPath}/css/gestaoLivro.css"
    />
  
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
          <h1>Livros</h1>
          <div class="container-pesquisa">
            <input type="text" id="input-pesquisa" placeholder="Pesquise algo" />
            <button type="button" onclick="abrirModalAdcionar()">
              Adicionar Livro
            </button>
          </div>
        </div>
        <table class="table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Titulo</th>
              <th>Descrição</th>
              <th>Criador</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${livros}" var="l">
              <tr>
                <td>${l.id}</td>
                <td>${l.titulo}</td>
                <td>${l.descricao}</td>
                <td>${l.criador}</td>
                <td>${l.disponivel}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
  
        <div id="modal-acoes" class="modal-overlay" style="display: none">
          <div class="modal-box">
            <button type="button" id="btnEditar">Editar</button>
            <button type="button" id="btnConfirmarEmprestar">Emprestar</button>
            <button type="button" id="btnConfirmarRemover">Remover</button>
            <button type="button" onclick="fecharModalAcoes()">Cancelar</button>
          </div>
        </div>
        <div id="modalEditar" class="modal-overlay" style="display: none">
          <div class="modal-box">
            <form
              action="${pageContext.request.contextPath}/adm/livros/editar"
              method="post"
            >
              <input type="hidden" name="id" id="editarId" />
              <input type="text" name="titulo" id="editarTitulo" placeholder="Titulo"/><br />
              <input type="text" name="descricao" id="editarDescricao" placeholder="Descrição"/><br />
              <input type="text" name="criador" id="editarCriador" placeholder="Criador"/><br />
              <input type="text" name="imagemUrl" id="imagemaEdd" placeholder="URL_da_imagem"/><br>
              <button type="submit">Salvar</button>
              <button type="button" onclick="fecharModal()">Cancelar</button>
            </form>
          </div>
        </div>
        <div id="modalEmprestar" class="modal-overlay" style="display: none">
          <div class="modal-box">
            <form
              action="${pageContext.request.contextPath}/adm/livros/emprestar"
              method="post"
            >
              <input type="hidden" name="idLivro" id="livroId" />
  
              <label for="usuario">Escolha um usuário:</label>
              <select name="idUsuario" id="usuarioSelect">
                <c:forEach items="${usuarios}" var="usuario">
                  <option value="${usuario.id}">${usuario.nome}</option>
                </c:forEach></select
              ><br />
              <button type="submit">Emprestar</button>
              <button type="button" onclick="fecharModalEmprestar()">
                Cancelar
              </button>
            </form>
          </div>
        </div>
        <div id="modalAdcionar" class="modal-overlay" style="display: none">
          <div class="modal-box">
            <form
              action="${pageContext.request.contextPath}/adm/livros/adicionar"
              method="post"
            >
              <input
                type="text"
                name="titulo"
                id="tituloadd"
                placeholder="Titulo"
              />
              <input
                type="text"
                name="descricao"
                id="descadd"
                placeholder="Descrição"
              />
              <input
                type="text"
                name="criador"
                id="criadoradd"
                placeholder="Criador"
              />
              <input
                type="text"
                name="imagemUrl"
                id="imagemadd"
                placeholder="UR_da_imagem"
              />
              <button type="submit">Adicionar</button>
              <button type="reset">Apagar tudo</button>
              <button type="button" onclick="fecharModalAdicionar()">
                Cancelar
              </button>
            </form>
          </div>
        </div>
      </section>
    </div>
    <script>
      window.contextPath = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/modalOptLivro.js"></script>
    <script src="${pageContext.request.contextPath}/js/pesquisar.js"></script>
    <script src="${pageContext.request.contextPath}/js/validacao.js"></script>
  </body>
</c:if>