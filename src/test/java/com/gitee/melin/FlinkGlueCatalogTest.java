package com.gitee.melin;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;

public class FlinkGlueCatalogTest {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setString("classloader.resolve-order", "parent-first");
        configuration.setString("table.local-time-zone", "UTC");

        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inBatchMode().withConfiguration(configuration).build();

        TableEnvironment tableEnv = TableEnvironment.create(settings);

        String catalogSql = "CREATE CATALOG gluecatalog WITH (\n" +
                "    'type' = 'glue',\n" +
                "    'region' = 'cn-northwest-1'" +
                ")";

        tableEnv.executeSql(catalogSql);
        tableEnv.executeSql("show catalogs").print();
        tableEnv.executeSql("USE CATALOG gluecatalog");


        tableEnv.executeSql("show tables").print();
    }
}
