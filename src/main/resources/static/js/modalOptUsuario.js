document.addEventListener("DOMContentLoaded", () => {
  let usuarioSelecionado = {};

  document.querySelectorAll(".table tbody tr").forEach((row) => {
    row.addEventListener("click", () => {
      document
        .querySelectorAll(".table tbody tr")
        .forEach((r) => r.classList.remove("selected"));

      row.classList.add("selected");

      const cells = row.querySelectorAll("td");
      usuarioSelecionado = {
        id: cells[0].textContent.trim(),
        nome: cells[1].textContent.trim(),
        email: cells[2].textContent.trim(),
        bi: cells[3].textContent.trim(),
      };
      document.getElementById("modalAcoes").style.display = "flex";
    });
  });

  document.getElementById("btnEditar").addEventListener("click", () => {
    document.getElementById("editarId").value = usuarioSelecionado.id;
    document.getElementById("editarNome").value = usuarioSelecionado.nome;
    document.getElementById("editarEmail").value = usuarioSelecionado.email;
    document.getElementById("editarBi").value = usuarioSelecionado.bi;
    fecharModalAcoes();
    document.getElementById("modalEditar").style.display = "flex";
  });

  const btnRemover = document.getElementById("btnConfirmarRemover");

  btnRemover.addEventListener("click", () => {
    if (!usuarioSelecionado?.id) return;
        
    if (
      confirm(`Deseja mesmo remover o usuário ID ${usuarioSelecionado.id}?`)
    ) {
      const form = document.createElement("form");
      form.method = "POST";
      form.action = `${window.contextPath}/adm/usuarios/deletar`;

      const input = document.createElement("input");
      input.type = "hidden";
      input.name = "id";
      input.value = usuarioSelecionado.id;
      form.appendChild(input);

      document.body.appendChild(form);
      form.submit();
    }
  });
});

function fecharModalAcoes() {
  document.getElementById("modalAcoes").style.display = "none";
  document
    .querySelectorAll(".table tbody tr")
    .forEach((r) => r.classList.remove("selected"));
}

function fecharModalEditar() {
  document.getElementById("modalEditar").style.display = "none";
}

function abrirModalEditar(id, nome, email, bi) {
  document.getElementById("editarId").value = id;
  document.getElementById("editarNome").value = nome;
  document.getElementById("editarEmail").value = email;
  document.getElementById("editarBi").value = bi;

  document.getElementById("modalEditar").style.display = "flex";
}

function fecharModal() {
  document.getElementById("modalEditar").style.display = "none";
}

function abrirModalAdd() {
  document.getElementById("modalAdcionar").style.display = "flex";
}

function fecharModalAdd() {
  document.getElementById("modalAdcionar").style.display = "none";
}