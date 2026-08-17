package questao13;

import questao13.model.Usuario;
import questao13.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {

        EntityManager<Usuario> manager =
                new EntityManager<>(Usuario.class);

        Usuario usuario1 =
                new Usuario(1, "Joao", "joao@email.com");

        Usuario usuario2 =
                new Usuario(2, "Maria", "maria@email.com");

        manager.save(usuario1);
        manager.save(usuario2);

        System.out.println();

        Usuario encontrado =
                manager.findById(1);

        System.out.println("Encontrado: " + encontrado);

        System.out.println();

        manager.delete(1);

        System.out.println();

        Usuario removido =
                manager.findById(1);

        System.out.println(
                "Depois da exclusao: " + removido
        );
    }
}