package cn.com.dreamcraft.heritane.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static cn.com.dreamcraft.heritane.SQL.Pool.SQLDataSource;
import static com.mojang.text2speech.Narrator.LOGGER;

public class Main {
    public static Statement dbStatement; // SQL 语句存储在此对象中
    public static void createDatabaseStructure(String tablePrefix) { // 建立表结构
        try{
            dbStatement = SQLDataSource.getConnection().createStatement();
            LOGGER.info("Creating database structure with prefix: " + tablePrefix + ".");
            dbStatement.executeUpdate("");
        } catch (SQLException e) {
            LOGGER.error("Error occurred while creating database structure.");
            throw new RuntimeException(e);
        }
    }
    public static ResultSet querySQLData(String sel, String whe) { // 查询数据库中的特定数据
        try {
            return dbStatement.executeQuery("SELECT " + sel + " FROM user_config WHERE " + whe);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closedbStatement() {
        try {
            dbStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeConnection() { // 关闭数据库连接
        try {
            if (SQLDataSource != null) {
                LOGGER.info("Closing SQL Connections.");
                SQLDataSource.close();
                SQLDataSource = null;
            }
        }
        catch (Exception e) {
            LOGGER.error("Error occurred while closing SQL connections.");
            e.printStackTrace();
        }
    }
}
