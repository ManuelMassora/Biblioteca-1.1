document.addEventListener("DOMContentLoaded", function () {
    const input = document.getElementById("input-pesquisa");
  
    input.addEventListener("input", function () {
      const termo = input.value.toLowerCase();
      const linhas = document.querySelectorAll(".table tbody tr");
  
      linhas.forEach((linha) => {
        const textoLinha = linha.textContent.toLowerCase();
  
        if (textoLinha.includes(termo)) {
          linha.style.display = "";
        } else {
          linha.style.display = "none";
        }
      });
    });
  });