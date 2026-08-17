package questao14;

import questao14.container.Container;
import questao14.service.UsuarioService;

public class Main {

    public static void main(String[] args) {

        Container container = new Container();

        UsuarioService usuarioService =
                container.getInstance(UsuarioService.class);

        usuarioService.cadastrarUsuario("Joao");
    }
}