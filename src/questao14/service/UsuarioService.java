package questao14.service;

import questao14.annotations.Inject;

public class UsuarioService {

    @Inject
    private EmailService emailService;

    @Inject
    private BancoService bancoService;

    public void cadastrarUsuario(String nome) {

        bancoService.salvarUsuario(nome);

        emailService.enviarEmail(
                "Usuario " + nome + " cadastrado com sucesso."
        );
    }
}