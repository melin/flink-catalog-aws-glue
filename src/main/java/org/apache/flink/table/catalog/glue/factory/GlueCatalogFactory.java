package org.apache.flink.table.catalog.glue.factory;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ConfigOptions;
import org.apache.flink.table.catalog.Catalog;
import org.apache.flink.table.catalog.exceptions.CatalogException;
import org.apache.flink.table.catalog.glue.GlueCatalog;
import org.apache.flink.table.factories.CatalogFactory;

public class GlueCatalogFactory implements CatalogFactory {
    public static final ConfigOption<String> REGION = ConfigOptions.key("region")
            .stringType()
            .noDefaultValue()
            .withDescription("AWS region for the Glue catalog");

    public static final ConfigOption<String> DEFAULT_DATABASE = ConfigOptions.key("default-database")
            .stringType()
            .defaultValue("default")
            .withDescription("Default database to use in Glue catalog");

    public String factoryIdentifier() {
        return "glue";
    }

    public Set<ConfigOption<?>> requiredOptions() {
        Set<ConfigOption<?>> options = new HashSet<>();
        options.add(REGION);
        return options;
    }

    public Set<ConfigOption<?>> optionalOptions() {
        Set<ConfigOption<?>> options = new HashSet<>();
        options.add(DEFAULT_DATABASE);
        return options;
    }

    public Catalog createCatalog(CatalogFactory.Context context) {
        Map<String, String> config = context.getOptions();
        String name = context.getName();
        String region = config.get(REGION.key());
        String defaultDatabase = config.getOrDefault(DEFAULT_DATABASE.key(), (String)DEFAULT_DATABASE.defaultValue());
        if (region == null || region.isEmpty())
            throw new CatalogException("The 'region' property must be specified for the Glue catalog.");
        return (Catalog)new GlueCatalog(name, defaultDatabase, region);
    }
}
