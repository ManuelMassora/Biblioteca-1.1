<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/cadastro.css"
    />
    <title>Sign-in</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/signup" method="post">
      <!-- Linha 1: Nome + Email -->
      <div class="form-row">
        <div>
          <input
            type="text"
            id="nome"
            name="nome"
            required
            placeholder="Nome"
          />
        </div>
        <div>
          <input
            type="email"
            id="email"
            name="email"
            required
            placeholder="Email"
          />
        </div>
      </div>

      <!-- Linha 2: BI + Senha -->
      <div class="form-row">
        <div>
          <input type="text" id="bi" name="bi" required placeholder="BI" />
        </div>
        <div>
          <input
            type="password"
            id="senha"
            name="senha"
            required
            placeholder="Sua Senha"
          />
        </div>
      </div>

      <!-- Linha 3: Botões -->
      <div class="button-row">
        <input type="submit" value="Registar" />
        <input type="reset" value="Limpar" />
      </div>
    </form>

    <a href="/livros">Voltar</a><br />
    <a href="/login">Já tem conta? Iniciar sessão</a><br />
    <script src="${pageContext.request.contextPath}/js/validacao.js"></script>
  </body>
</html>
