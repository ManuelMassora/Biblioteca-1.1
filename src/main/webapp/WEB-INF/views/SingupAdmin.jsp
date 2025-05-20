<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Imagine</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/usuarioUI.css">
    </head>
    <body>
        <header>
            <h4>Imagine</h4>
            <nav>
                <input type="search" name="pesquisa" id="" placeholder="Pesquisar...">
            </nav>
        </header>
        <section>
            <h2>Livros</h2>
            <form action="${pageContext.request.contextPath}/adm" method="post">
                    <input type="text" name="titulo" required placeholder="Titulo"><br>
                    <input type="text" name="descricao" required placeholder="Descricao"><br>
                    <input type="text" name="criador" required placeholder="Criador"><br>
                    <input type="submit" value="Registar"><br>
                    <input type="reset" value="Limpar"><br>
            </form>
            <div class="livros-grid">
                <c:forEach items = "${livros}" var="livro">
                    <div class="livros-card">
                        <h3>${livro.id}</h3>
                        <h3>${livro.titulo}</h3>
                        <p>${livro.descricao}</p>
                        <p>${livro.criador}</p>
                    </div>
                </c:forEach>
            </div>
        </section>
    </body>
</html>