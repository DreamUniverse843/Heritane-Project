package cn.com.dreamcraft.heritane.SQL;

public class Config {
    private String SQLType = "MySQL";
    private String SQLAddress = "172.17.0.1";
    private String SQLUsername = "root";
    private String SQLPassword = "root";
    private String SQLDatabaseName = "DCMonitor";
    private String SQLPort = "3306";
    private String SQLDBPrefix = "";
    public String getSQLType() {
        return SQLType;
    }
    public String getSQLAddress() {
        return SQLAddress;
    }
    public String getSQLUsername() {
        return SQLUsername;
    }
    public String getSQLPassword() {
        return SQLPassword;
    }
    public String getSQLDatabaseName() {
        return SQLDatabaseName;
    }
    public String getSQLPort() {
        return SQLPort;
    }
    public String getSQLDBPrefix() {
        return SQLDBPrefix;
    }
}
