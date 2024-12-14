package StructuralPatterns.Onlines.C2;

interface DatabaseQuery {
    void executeQuery(String query);
}

class SQLDatabase implements DatabaseQuery {
    @Override
    public void executeQuery(String sqlQuery) {
        System.out.println("Executing SQL query: " + sqlQuery);
    }
}

class NoSQLDatabase {
    public void runQuery(String noSQLQuery) {
        System.out.println("Executing NoSQL query: " + noSQLQuery);
    }
}

class NoSQLDatabaseAdapter implements DatabaseQuery {
    private NoSQLDatabase noSQLDatabase;

    public NoSQLDatabaseAdapter(NoSQLDatabase noSQLDatabase) {
        this.noSQLDatabase = noSQLDatabase;
    }

    @Override
    public void executeQuery(String query) {
        noSQLDatabase.runQuery(query);
    }
}

public class C2Online {
    public static void main(String[] args) {
        SQLDatabase sqlDatabase = new SQLDatabase();
        sqlDatabase.executeQuery("SELECT * FROM users");

        NoSQLDatabase noSQLDatabase = new NoSQLDatabase();
        NoSQLDatabaseAdapter adapter = new NoSQLDatabaseAdapter(noSQLDatabase);
        adapter.executeQuery("db.users.find()");
    }
}
