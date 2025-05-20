function abrirModalEditar() {
  document.getElementById("modalEditarPerfil").classList.add("active");
}

function fecharModal() {
  document.getElementById("modalEditarPerfil").classList.remove("active");
}
const overlay = document.getElementById("modalEditarPerfil");
const modalContent = overlay.querySelector(".modal-content");

// quando clicar no overlay, fecha o modal
overlay.addEventListener("click", fecharModal);

// dentro do modal-content, impede que o clique suba até o overlay
modalContent.addEventListener("click", function (event) {
  event.stopPropagation();
});

document.addEventListener("DOMContentLoaded", function () {
  const input = document.getElementById("input-pesquisa");

  input.addEventListener("input", function () {
    const termo = input.value.toLowerCase();
    const cards = document.querySelectorAll(".livros-card");

    cards.forEach((card) => {
      const titulo = card.querySelector("h3").textContent.toLowerCase();
      const criador = card.querySelector("p").textContent.toLowerCase();

      if (titulo.includes(termo) || criador.includes(termo)) {
        card.style.display = "";
      } else {
        card.style.display = "none";
      }
    });
  });
});
