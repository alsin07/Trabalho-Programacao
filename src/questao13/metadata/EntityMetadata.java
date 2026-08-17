package questao13.metadata;

import questao13.annotations.Column;
import questao13.annotations.Entity;
import questao13.annotations.Id;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityMetadata<T> {

    private final Class<T> entityClass;
    private Field idField;
    private final List<Field> fields = new ArrayList<>();

    public EntityMetadata(Class<T> entityClass) {
        this.entityClass = entityClass;
        analisar();
    }

    private void analisar() {
        if (!entityClass.isAnnotationPresent(Entity.class)) {
            throw new IllegalArgumentException(
                    "A classe precisa possuir a anotacao @Entity"
            );
        }

        for (Field field : entityClass.getDeclaredFields()) {

            if (field.isAnnotationPresent(Id.class)) {
                idField = field;
            }

            if (field.isAnnotationPresent(Column.class)) {
                fields.add(field);
            }
        }

        if (idField == null) {
            throw new IllegalArgumentException(
                    "A entidade precisa possuir um campo @Id"
            );
        }
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public Field getIdField() {
        return idField;
    }

    public List<Field> getFields() {
        return fields;
    }

    public String getTableName() {
        return entityClass.getSimpleName().toLowerCase();
    }

    public String getColumnName(Field field) {
        Column column = field.getAnnotation(Column.class);
        return column.name();
    }
}