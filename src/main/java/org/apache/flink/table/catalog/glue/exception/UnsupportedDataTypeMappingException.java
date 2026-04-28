package org.apache.flink.table.catalog.glue.exception;

public class UnsupportedDataTypeMappingException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnsupportedDataTypeMappingException(String message) {
        super(message);
    }

    public UnsupportedDataTypeMappingException(String message, Throwable cause) {
        super(message, cause);
    }
}
