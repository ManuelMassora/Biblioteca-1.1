function validarFormularioEditar(event) {
    const titulo = document.getElementById('editarTitulo').value.trim();
    const descricao = document.getElementById('editarDescricao').value.trim();
    const criador = document.getElementById('editarCriador').value.trim();
    const imagemUrl = document.getElementById('imagemaEdd').value.trim();

    if (!titulo || !descricao || !criador || !imagemUrl) {
        alert('Por favor, preencha todos os campos.');
        event.preventDefault();
        return false;
    }
    return true;
}


function validarFormularioAdicionar(event) {
    const titulo = document.getElementById('tituloadd').value.trim();
    const descricao = document.getElementById('descadd').value.trim();
    const criador = document.getElementById('criadoradd').value.trim();
    const imagemUrl = document.getElementById('imagemadd').value.trim();

    if (!titulo || !descricao || !criador || !imagemUrl) {
        alert('Por favor, preencha todos os campos.');
        event.preventDefault();
        return false;
    }
    return true;
}

document.addEventListener('DOMContentLoaded', function () {
    const formEditar = document.querySelector('.modal-box form[action*="editar"]');
    if (formEditar) {
        formEditar.addEventListener('submit', validarFormularioEditar);
    }

    const formAdicionar = document.querySelector('#modalAdcionar .modal-box form[action*="adicionar"]');
    if (formAdicionar) {
        formAdicionar.addEventListener('submit', validarFormularioAdicionar);
    }
});

function validarFormularioEditarUsuario(event) {
    const nome = document.getElementById('editarNome').value.trim();
    const email = document.getElementById('editarEmail').value.trim();
    const bi = document.getElementById('editarBi').value.trim();

    if (!nome || !email || !bi) {
        alert('Por favor, preencha todos os campos.');
        event.preventDefault();
        return false;
    }
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
        alert('Por favor, insira um email válido.');
        event.preventDefault();
        return false;
    }
    return true;
}

function validarFormularioAdicionarUsuario(event) {
    const nome = document.getElementById('AddNome').value.trim();
    const email = document.getElementById('AddEmail').value.trim();
    const bi = document.getElementById('AddBi').value.trim();
    const senha = document.getElementById('AddSenha').value.trim();

    if (!nome || !email || !bi || !senha) {
        alert('Por favor, preencha todos os campos.');
        event.preventDefault();
        return false;
    }
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
        alert('Por favor, insira um email válido.');
        event.preventDefault();
        return false;
    }
    return true;
}

document.addEventListener('DOMContentLoaded', function () {
    const formEditarUsuario = document.querySelector('#modalEditar .modal-box form[action*="editar"]');
    if (formEditarUsuario) {
        formEditarUsuario.addEventListener('submit', validarFormularioEditarUsuario);
    }

    const formAdicionarUsuario = document.querySelector('#modalAdcionar .modal-box form[action*="adicionar"]');
    if (formAdicionarUsuario) {
        formAdicionarUsuario.addEventListener('submit', validarFormularioAdicionarUsuario);
    }
});

function validarFormularioLogin(event) {
    const email = document.querySelector('input[name="email"]').value.trim();
    const senha = document.querySelector('input[name="senha"]').value.trim();

    if (!email || !senha) {
        alert('Por favor, preencha todos os campos.');
        event.preventDefault();
        return false;
    }
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
        alert('Por favor, insira um email válido.');
        event.preventDefault();
        return false;
    }
    return true;
}

document.addEventListener('DOMContentLoaded', function () {
    const formLogin = document.querySelector('form[action$="/login"]');
    if (formLogin) {
        formLogin.addEventListener('submit', validarFormularioLogin);
    }
});

function validarFormularioSignup(event) {
    const nome = document.querySelector('form[action$="/signup"] input[name="nome"]').value.trim();
    const email = document.querySelector('form[action$="/signup"] input[name="email"]').value.trim();
    const bi = document.querySelector('form[action$="/signup"] input[name="bi"]').value.trim();
    const senha = document.querySelector('form[action$="/signup"] input[name="senha"]').value.trim();

    if (!nome || !email || !bi || !senha) {
        alert('Por favor, preencha todos os campos.');
        event.preventDefault();
        return false;
    }
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
        alert('Por favor, insira um email válido.');
        event.preventDefault();
        return false;
    }
    return true;
}

document.addEventListener('DOMContentLoaded', function () {
    const formSignup = document.querySelector('form[action$="/signup"]');
    if (formSignup) {
        formSignup.addEventListener('submit', validarFormularioSignup);
    }
});

function validarFormularioEditarPerfil(event) {
    const nome = document.getElementById('editarNome').value.trim();
    const bi = document.getElementById('editarBi').value.trim();
    const senha = document.getElementById('editarSenha').value.trim();
    const confirmarSenha = document.getElementById('confirmarSenha').value.trim();

    if (!nome || !bi || !senha || !confirmarSenha) {
        alert('Por favor, preencha todos os campos.');
        event.preventDefault();
        return false;
    }
    if (senha !== confirmarSenha) {
        alert('As senhas não coincidem.');
        event.preventDefault();
        return false;
    }
    return true;
}

document.addEventListener('DOMContentLoaded', function () {
    const formEditarPerfil = document.querySelector('#modalEditarPerfil form[action*="/perfil"]');
    if (formEditarPerfil) {
        formEditarPerfil.addEventListener('submit', validarFormularioEditarPerfil);
    }
});