package Onlines.Practice;

// Legacy NoSQLDatabase class that we cannot modify
class NoSQLDatabase {
    public void openConnection() {
        System.out.println("NoSQL database connection opened.");
    }

    public String find(String criteria) {
        return "NoSQL result for criteria: " + criteria;
    }
}

// Standard Database interface expected by the application
interface Database {
    void connect();

    String query(String sql);
}

class NoSQLDatabaseAdapter implements Database {
    private NoSQLDatabase noSQLDatabase;

    public NoSQLDatabaseAdapter(NoSQLDatabase noSQLDatabase) {
        this.noSQLDatabase = noSQLDatabase;
    }

    @Override
    public void connect() {
        noSQLDatabase.openConnection();
    }

    @Override
    public String query(String sql) {
        return noSQLDatabase.find(sql);
    }

}

// Application class to test the adapter
public class DBAdapter {
    public static void main(String[] args) {
        // Creating an instance of NoSQLDatabase
        NoSQLDatabase noSQLDatabase = new NoSQLDatabase();

        // Wrapping NoSQLDatabase with NoSQLDatabaseAdapter
        Database databaseAdapter = new NoSQLDatabaseAdapter(noSQLDatabase);

        // Using the adapter with the standardized Database interface
        databaseAdapter.connect();  // Output: NoSQL database connection opened.
        System.out.println(databaseAdapter.query("SELECT * FROM users"));  // Output: NoSQL result for criteria: SELECT * FROM users
    }
}
