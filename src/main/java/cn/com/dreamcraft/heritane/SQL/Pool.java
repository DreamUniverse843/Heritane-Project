package cn.com.dreamcraft.heritane.SQL;

import cn.com.dreamcraft.heritane.DCHMain;
import cn.com.dreamcraft.heritane.DCHServer;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Objects;

public class Pool {
    public static HikariDataSource SQLDataSource;
    public void loadDatabase() { // 启动数据库连接
        Main.closeConnection();
        // 先关掉既有的数据库连接
        HikariConfig dbConfig = new HikariConfig();
        Config DCMConfig = DCHServer.DCHConfig;
        if(Objects.equals(new Config().getSQLType(), "MySQL")) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
            }
            catch (Exception e) {
                dbConfig.setDriverClassName("com.mysql.jdbc.Driver");
            }
            String JDBCURL = "jdbc:mysql://" + DCMConfig.getSQLAddress() + ":" + DCMConfig.getSQLPort() + "/" + DCMConfig.getSQLDatabaseName();
            dbConfig.setJdbcUrl(JDBCURL);
            DCHMain.LOGGER.info(JDBCURL);
        }
        dbConfig.setUsername(DCMConfig.getSQLUsername());
        dbConfig.setPassword(DCMConfig.getSQLPassword());
        dbConfig.setMaxLifetime(300000);
        dbConfig.addDataSourceProperty("characterEncoding", "UTF-8");
        dbConfig.addDataSourceProperty("connectionTimeout", "10000");
        /* https://github.com/brettwooldridge/HikariCP/wiki/MySQL-Configuration */
        /* https://cdn.oreillystatic.com/en/assets/1/event/21/Connector_J%20Performance%20Gems%20Presentation.pdf */
        dbConfig.addDataSourceProperty("cachePrepStmts", "true");
        dbConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        dbConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dbConfig.addDataSourceProperty("useServerPrepStmts", "true");
        dbConfig.addDataSourceProperty("useLocalSessionState", "true");
        dbConfig.addDataSourceProperty("rewriteBatchedStatements", "true");
        dbConfig.addDataSourceProperty("cacheServerConfiguration", "true");
        dbConfig.addDataSourceProperty("maintainTimeStats", "false");
        /* Disable SSL to suppress the unverified server identity warning */
        dbConfig.addDataSourceProperty("allowPublicKeyRetrieval", "true");
        dbConfig.addDataSourceProperty("useSSL", "false");
        Pool.SQLDataSource = new HikariDataSource(dbConfig);
    }
}
