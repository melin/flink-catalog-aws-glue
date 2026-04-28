package org.apache.flink.table.catalog.glue.util;

import org.apache.flink.annotation.Internal;

import java.util.regex.Pattern;

/**
 * Constants used throughout the Glue catalog implementation.
 * Includes string literals, patterns, and configuration keys.
 */
@Internal
public class GlueCatalogConstants {
    public static final String COMMENT = "comment";
    public static final String DEFAULT_SEPARATOR = ":";
    public static final String LOCATION_SEPARATOR = "/";
    public static final String LOCATION_URI = "path";
    public static final String AND = "and";
    public static final String NEXT_LINE = "\n";
    public static final String SPACE = " ";

    public static final String TABLE_OWNER = "owner";
    public static final String TABLE_INPUT_FORMAT = "table.input.format";
    public static final String TABLE_OUTPUT_FORMAT = "table.output.format";

    // Constants for preserving original case of object names
    // These follow the pattern established for column names
    public static final String ORIGINAL_DATABASE_NAME = "flink.original-database-name";
    public static final String ORIGINAL_TABLE_NAME = "flink.original-table-name";
    public static final String ORIGINAL_COLUMN_NAME = "originalName"; // Keep existing for backward compatibility
    public static final String ORIGINAL_FUNCTION_NAME = "flink.original-function-name";

    public static final String FLINK_SCALA_FUNCTION_PREFIX = "flink:scala:";
    public static final String FLINK_PYTHON_FUNCTION_PREFIX = "flink:python:";
    public static final String FLINK_JAVA_FUNCTION_PREFIX = "flink:java:";

    public static final String FLINK_CATALOG = "FLINK_CATALOG";

    public static final Pattern GLUE_DB_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{1,255}$");
    public static final String GLUE_EXCEPTION_MSG_IDENTIFIER = "GLUE EXCEPTION";
    public static final String TABLE_NOT_EXISTS_IDENTIFIER = "TABLE DOESN'T EXIST";
    public static final String DEFAULT_PARTITION_NAME = "__GLUE_DEFAULT_PARTITION__";

    public static final int UDF_CLASS_NAME_SIZE = 3;

    public static final String BASE_GLUE_USER_AGENT_PREFIX_FORMAT =
            "Apache Flink %s (%s) Glue Catalog";

    /** Glue Catalog identifier for user agent prefix. */
    public static final String GLUE_CLIENT_USER_AGENT_PREFIX = "aws.glue.client.user-agent-prefix";

    public static final String IS_PERSISTED = "isPersisted";
    public static final String EXPLAIN_EXTRAS = "explainExtras";
    public static final String IS_PHYSICAL = "isPhysical";
}
