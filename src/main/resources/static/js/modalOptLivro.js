document.addEventListener("DOMContentLoaded", () => {
    let livroSelecionado = {};
    document.querySelectorAll(".table tbody tr").forEach((row) => {
        row.addEventListener("click", () => {
            document
                .querySelectorAll(".table tbody tr")
                .forEach((r) => r.classList.remove("selected"));

            row.classList.add("selected");

            const cells = row.querySelectorAll("td");
            livroSelecionado = {
                id: cells[0].textContent.trim(),
                titulo: cells[1].textContent.trim(),
                descricao: cells[2].textContent.trim(),
                criador: cells[3].textContent.trim(),
            };
            document.getElementById("modal-acoes").style.display = "flex";
        });
    });
    
    document.getElementById("btnEditar").addEventListener("click", () => {
        abrirModalEditar(
            livroSelecionado.id,
            livroSelecionado.titulo,
            livroSelecionado.descricao,
            livroSelecionado.criador
        );
        fecharModalAcoes();
    });

    const btnEmprestar = document.getElementById("btnConfirmarEmprestar");
    const btnRemover = document.getElementById("btnConfirmarRemover");
    btnEmprestar.addEventListener("click", () => {
        if (!livroSelecionado?.id) return;

        abrirModalEmprestar(livroSelecionado.id);
        fecharModalAcoes();
    })

    btnRemover.addEventListener("click", () => {
        if (!livroSelecionado?.id) return;

        if (confirm(`Deseja mesmo remover o livro ID ${livroSelecionado.id}?`)) {
            const form = document.createElement("form");
            form.method = "POST";
            form.action = `${window.contextPath}/adm/livros/deletar`;

            const input = document.createElement("input");
            input.type = "hidden";
            input.name = "id";
            input.value = livroSelecionado.id;
            form.appendChild(input);

            document.body.appendChild(form);
            form.submit();
        }
        document.getElementById("modalAcoes").style.display = "flex";
    })
})

function fecharModalAcoes() {
  document.getElementById("modal-acoes").style.display = "none";
  document
    .querySelectorAll(".table tbody tr")
    .forEach((r) => r.classList.remove("selected"));
}

function abrirModalEditar(id, titulo, descricao, criador) {
  document.getElementById("editarId").value = id;
  document.getElementById("editarTitulo").value = titulo;
  document.getElementById("editarDescricao").value = descricao;
  document.getElementById("editarCriador").value = criador;
  document.getElementById("modalEditar").style.display = "flex";
}

function fecharModal() {
  document.getElementById("modalEditar").style.display = "none";
}

function abrirModalEmprestar(idLivro) {
  document.getElementById("livroId").value = idLivro;
  document.getElementById("modalEmprestar").style.display = "flex";
}

function fecharModalEmprestar() {
  document.getElementById("modalEmprestar").style.display = "none";
}

function abrirModalAdcionar() {
  document.getElementById("modalAdcionar").style.display = "flex";
}

function fecharModalAdicionar() {
  document.getElementById("modalAdcionar").style.display = "none";
}
