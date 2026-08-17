package questao13.sql;

import questao13.metadata.EntityMetadata;

import java.util.List;
import java.util.stream.Collectors;

public class SqlGenerator<T> {

    private final EntityMetadata<T> metadata;

    public SqlGenerator(EntityMetadata<T> metadata) {
        this.metadata = metadata;
    }

    public String generateInsert() {

        List<String> columns = metadata.getFields()
                .stream()
                .map(metadata::getColumnName)
                .collect(Collectors.toList());

        String columnNames = String.join(", ", columns);

        String values = columns.stream()
                .map(c -> "?")
                .collect(Collectors.joining(", "));

        return "INSERT INTO " +
                metadata.getTableName() +
                " (" + columnNames + ")" +
                " VALUES (" + values + ")";
    }

    public String generateFindById() {

        String idColumn =
                metadata.getColumnName(metadata.getIdField());

        return "SELECT * FROM " +
                metadata.getTableName() +
                " WHERE " +
                idColumn +
                " = ?";
    }

    public String generateDelete() {

        String idColumn =
                metadata.getColumnName(metadata.getIdField());

        return "DELETE FROM " +
                metadata.getTableName() +
                " WHERE " +
                idColumn +
                " = ?";
    }
}