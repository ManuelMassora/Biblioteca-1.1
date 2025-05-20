<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
    integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
    crossorigin="anonymous"
    referrerpolicy="no-referrer"
  />
</head>
<body>
  <div class="menu-lateral">
    <div class="card">
      <a href="${pageContext.request.contextPath}/adm">
        <i class="fa-solid fa-house"></i><br>
        <span>Home</span>
      </a>
    </div>
    <div class="card">
      <a href="${pageContext.request.contextPath}/adm/pagamentos">
        <i class="fa-solid fa-cash-register"></i><br>
        <span>pagamentos</span>
      </a>
    </div>
    <div class="card">
      <a href="${pageContext.request.contextPath}/adm/Emprestimos">
        <i class="fa-solid fa-bell"></i><br>
        <span>Empréstimos</span>
      </a>
    </div>
    <div class="card">
      <a href="${pageContext.request.contextPath}/adm/usuarios">
        <i class="fa-solid fa-user"></i><br>
        <span>Usuários</span>
      </a>
    </div>
    <div class="card">
      <a href="${pageContext.request.contextPath}/adm/livros">
        <i class="fa-solid fa-book-open"></i><br>
        <span>Livros</span>
      </a>
    </div>
  </div>
</body>
