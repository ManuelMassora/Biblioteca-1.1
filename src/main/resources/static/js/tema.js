let modoDark = false;

function alternarTema() {
  const root = document.documentElement;
  const icone = document.getElementById("icone-tema");

  if (modoDark) {
    // Modo light
    root.style.setProperty("--color-white", "#ffffff");
    root.style.setProperty("--color-black", "#000000");
    root.style.setProperty("--color-gray-light", "#c5c5c5");
    root.style.setProperty("--color-gray-dark", "#333");
    root.style.setProperty("--color-gray-medium", "#666");
    root.style.setProperty("--color-blue", "#0056b3");
    root.style.setProperty("--color-shadow", "rgba(0, 0, 0, 0.1)");
    root.style.setProperty("--color-overlay", "rgba(0, 0, 0, 0.568)");
    icone.className = "fa-regular fa-moon";
  } else {
    // Modo dark
    root.style.setProperty("--color-white", "#1e1e1e");
    root.style.setProperty("--color-black", "#ffffff");
    root.style.setProperty("--color-gray-light", "#2f2f2f");
    root.style.setProperty("--color-gray-dark", "#eaeaea");
    root.style.setProperty("--color-gray-medium", "#bbbbbb");
    root.style.setProperty("--color-blue", "#66aaff");
    // root.style.setProperty("--color-shadow", "rgba(255, 255, 255, 0.1)");
    // root.style.setProperty("--color-overlay", "rgba(255, 255, 255, 0.2)");
    icone.className = "fa-regular fa-sun";
  }

  modoDark = !modoDark;
}

function aplicarTema(dark) {
  const root = document.documentElement;
  const icone = document.getElementById("icone-tema");

  if (dark) {
    root.style.setProperty("--color-white", "#1e1e1e");
    root.style.setProperty("--color-black", "#ffffff");
    root.style.setProperty("--color-gray-light", "#2f2f2f");
    root.style.setProperty("--color-gray-dark", "#eaeaea");
    root.style.setProperty("--color-gray-medium", "#bbbbbb");
    root.style.setProperty("--color-blue", "#66aaff");
    icone.className = "fa-regular fa-sun";
  } else {
    root.style.setProperty("--color-white", "#ffffff");
    root.style.setProperty("--color-black", "#000000");
    root.style.setProperty("--color-gray-light", "#c5c5c5");
    root.style.setProperty("--color-gray-dark", "#333");
    root.style.setProperty("--color-gray-medium", "#666");
    root.style.setProperty("--color-blue", "#0056b3");
    root.style.setProperty("--color-shadow", "rgba(0, 0, 0, 0.1)");
    root.style.setProperty("--color-overlay", "rgba(0, 0, 0, 0.568)");
    icone.className = "fa-regular fa-moon";
  }

  modoDark = dark;
}

function aplicarTemaInicial() {
  const prefereDark = window.matchMedia("(prefers-color-scheme: dark)").matches;
  aplicarTema(prefereDark);
}
