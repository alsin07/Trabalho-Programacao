package questao13.persistence;

import questao13.metadata.EntityMetadata;
import questao13.sql.SqlGenerator;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class EntityManager<T> {

    private final EntityMetadata<T> metadata;
    private final SqlGenerator<T> sqlGenerator;
    private final Map<Object, T> database = new HashMap<>();

    public EntityManager(Class<T> entityClass) {
        this.metadata = new EntityMetadata<>(entityClass);
        this.sqlGenerator = new SqlGenerator<>(metadata);
    }

    public void save(T entity) {

        try {
            Field idField = metadata.getIdField();
            idField.setAccessible(true);

            Object id = idField.get(entity);

            database.put(id, entity);

            System.out.println(
                    "SQL: " + sqlGenerator.generateInsert()
            );

            System.out.println(
                    "Entidade salva: " + entity
            );

        } catch (IllegalAccessException e) {
            throw new RuntimeException(
                    "Erro ao acessar o ID", e
            );
        }
    }

    public T findById(Object id) {

        System.out.println(
                "SQL: " + sqlGenerator.generateFindById()
        );

        return database.get(id);
    }

    public void delete(Object id) {

        System.out.println(
                "SQL: " + sqlGenerator.generateDelete()
        );

        T removed = database.remove(id);

        if (removed != null) {
            System.out.println(
                    "Entidade removida: " + removed
            );
        } else {
            System.out.println(
                    "Entidade nao encontrada."
            );
        }
    }
}