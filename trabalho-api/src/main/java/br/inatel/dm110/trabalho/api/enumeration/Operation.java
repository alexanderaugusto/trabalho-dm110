package br.inatel.dm110.trabalho.api.enumeration;

public enum Operation {
    CREATE("create"),
    UPDATE("update"),
    DELETE("delete"),
    LIST("list");

    private String operation;

    private Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
