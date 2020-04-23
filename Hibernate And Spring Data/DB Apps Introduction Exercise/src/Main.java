import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Main {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "minions_db";
    private static final String USE_SSL = "?useSSL=false";

    private static Connection connection;
    private static PreparedStatement statement;
    private static String query;
    private static BufferedReader reader;

    public static void main(String[] args) throws SQLException, IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));

        Properties properties = new Properties();

//        System.out.println("Please enter username: ");
//        String userName = reader.readLine();
//        System.out.println("Please enter password: ");
//        String password = reader.readLine();


        //Don't forget to add your password
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        connection = DriverManager.getConnection(
                CONNECTION_STRING
                        + DATABASE_NAME
                        + USE_SSL, properties);


        //02. Get Villain's Names
        // getVillainsByNameAndCountOfMinions();

        //03. Get Minion Names
        // getMinionNames();

        //04. Add Minion
        // addMinion();

        //05. Change Town Names Casing
        // changeTownNameCasing();

        //06. *Remove villain
        // removeVillain();

        //07. Print all minion names
       // printAllMinionNames();

        //08. Increase Minions Age
        // increaseMinionsAge();

        //09.Increase Age Stored Procedure
        //increaseAgeWithStoredProcedure();


        connection.close();


        //TODO:                  Privet kolegi :) V proekta v sqlDatabase -> minions_db sum dobavil sql file. Za ulesnenie ako e nujno moje da se dropne/truncatne bazata i lesno da se vkara na novo.
        //TODO:                  Pozdravi!


    }

    private static void removeVillain() throws IOException, SQLException {
        System.out.println("Enter villain iD: ");
        int idVillain = Integer.parseInt(reader.readLine());
        int numberMinions = 0;
        query = "SELECT minion_id FROM minions_villains WHERE villain_id = ?";
        statement = connection.prepareStatement(query);
        statement.setInt(1, idVillain);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            rs.getInt("minion_id");
            numberMinions++;
        }

        if (checkEntityExist(idVillain, "villains")) {
            query = "CALL usp_remove_villain (?)";
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, idVillain);
            callableStatement.execute();

            String name = getEntityNameById(idVillain, "villains");
            System.out.println(name + " was deleted");
            System.out.println(numberMinions + " minions released");
        } else {
            System.out.println("No such villain was found");
        }

    }

    private static void changeTownNameCasing() throws IOException, SQLException {
        System.out.println("Enter country: ");
        String country = reader.readLine();
        List<String> countriesList = new ArrayList<>();

        query = "SELECT name FROM towns WHERE country = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, country);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            countriesList.add(rs.getString("name").toUpperCase());
        }
        if (!countriesList.isEmpty()) {
            System.out.println(countriesList);
        } else {
            System.out.println("No town names were affected.");
        }

    }

    private static void printAllMinionNames() throws SQLException {
        List<String> minionsList = new ArrayList<>();

        query = "SELECT name FROM minions";
        statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            minionsList.add(resultSet.getString("name"));
        }

        for (int i = 0; i < minionsList.size(); i++) {
            System.out.println(minionsList.get(i));
            System.out.println(minionsList.get(minionsList.size() - 1 - i));
        }
    }

    private static void increaseMinionsAge() throws IOException, SQLException {
        System.out.println("Enter minions ID's separated with space.");
        int[] minionsIdArray = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        Map<String, Integer> minions = new LinkedHashMap<>();

        //Increasing the years
        for (int i = 0; i < minionsIdArray.length; i++) {
            int currentId = minionsIdArray[i];
            query = "UPDATE minions SET age = age + 1 WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, currentId);
            statement.executeUpdate();


            query = "SELECT name, age FROM minions WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, currentId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                minions.putIfAbsent(resultSet.getString("name")
                        , resultSet.getInt("age"));
            }
        }

            query = "SELECT name, age FROM minions";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                minions.putIfAbsent(resultSet.getString("name")
                        , resultSet.getInt("age"));
            }
            minions.forEach((k,v) -> {
                System.out.println(String.format("%-10.10s %d", k, v));
            });

    }

    private static void increaseAgeWithStoredProcedure() throws IOException, SQLException {
        System.out.println("Enter minion id: ");
        int minionId = Integer.parseInt(reader.readLine());
        query = "CALL usp_get_older(?)";
        CallableStatement callableStatement = connection.prepareCall(query);
        callableStatement.setInt(1, minionId);
        callableStatement.execute();
    }

    private static void addMinion() throws IOException, SQLException {
        System.out.println("Enter minion name, age and town name separated with single space.");
        System.out.print("Minion: ");
        // Taking information about the minion...
        String[] minion = reader.readLine().split("\\s+");
        String minionName = minion[0];
        int minionAges = Integer.parseInt(minion[1]);
        String minionTown = minion[2];
        // Taking villain name...
        System.out.println("Enter villain name.");
        System.out.print("Villain: ");
        String villainName = reader.readLine();


        // Check minion's town, exist or not..
        if (!checkEntityExistByName(minionTown, "towns")) {
            insertEntityInTown(minionTown);
            System.out.println(String.format("Town %s was added to the database.", minionTown));
        }
        int townID = getIdByName(minionTown, "towns");

        //Check villain, exists or not
        if (!checkVillainExists(villainName)) {
            insertVillainByName(villainName);
            System.out.println(String.format("Villain %s was added to the database.", villainName));
        }

        // Check minion, exists or not
        if (!checkMinionByName(minionName)) {
            insertMinionByName(minionName, minionAges, townID);
            // Po princip e redno i tuk da pi6e, 4e e dobaven minion no v uslovite ne go pi6e...
            System.out.println(String.format("Successfully added %s to be minion of %s.", minionName, villainName));
        }

        int minionId = getIdByName(minionName, "minions");
        int villainId = getIdByName(villainName, "villains");

        // Setting the minion to be servant of the villain.
        insertIntoMappingTable(minionId, villainId);
    }

    private static void insertIntoMappingTable(int minionId, int villainId) throws SQLException {
        query = "INSERT INTO minions_villains VALUE(?, ?)";
        statement = connection.prepareStatement(query);
        statement.setInt(1, minionId);
        statement.setInt(2, villainId);
        statement.execute();
    }

    private static int getIdByName(String entityName, String tableName) throws SQLException {
        query = "SELECT id FROM " + tableName + " WHERE name = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, entityName);
        ResultSet resultSet = statement.executeQuery();
        int id = 0;
        while (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;
    }

    private static void insertMinionByName(String minionName, int ages, int townId) throws SQLException {
        query = "INSERT INTO minions (name, age, town_id) VALUE (?, ?, ?)";
        statement = connection.prepareStatement(query);
        statement.setString(1, minionName);
        statement.setInt(2, ages);
        statement.setInt(3, townId);
        statement.execute();

    }

    private static boolean checkMinionByName(String minionName) throws SQLException {
        query = "SELECT name FROM minions WHERE name = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, minionName);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    private static void insertVillainByName(String villainName) throws SQLException {
        query = "INSERT INTO villains (name, evilness_factor) VALUE (?, ?)";

        statement = connection.prepareStatement(query);
        statement.setString(1, villainName);
        statement.setString(2, "evil");
        statement.execute();
    }

    private static boolean checkVillainExists(String villainName) throws SQLException {
        query = "SELECT name FROM villains WHERE name = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, villainName);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    private static void insertEntityInTown(String minionTown) throws SQLException {
        query = "INSERT INTO towns (name, country) VALUE (?, ?)";

        statement = connection.prepareStatement(query);
        statement.setString(1, minionTown);
        statement.setString(2, "NULL");
        statement.execute();
    }

    private static boolean checkEntityExistByName(String entityName, String tableName) throws SQLException {
        query = "SELECT * FROM " + tableName + " WHERE name = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, entityName);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    private static void getMinionNames() throws SQLException, IOException {

        System.out.println("Enter villain id: ");
        int villainId = Integer.parseInt(reader.readLine());

        if (!checkEntityExist(villainId, "villains")) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }

        System.out.println(String.format("Villain: %s", getEntityNameById(villainId, "villains")));


        query = "SELECT m.name, m.age FROM minions AS m\n" +
                "LEFT JOIN minions_villains mv ON m.id = mv.minion_id\n" +
                "LEFT JOIN villains v ON mv.villain_id = v.id\n" +
                "WHERE v.id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);
        ResultSet resultSet = statement.executeQuery();

        int minionCount = 1;
        while (resultSet.next()) {
            System.out.println(minionCount + String.format(". %-10s | %d"
                    , resultSet.getString("name")
                    , resultSet.getInt("age")
            ));
            minionCount++;
        }
    }

    private static String getEntityNameById(int entityId, String tableName) throws SQLException {
        query = "SELECT name FROM " + tableName + " WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, entityId);
        ResultSet resultSet = statement.executeQuery();


        return resultSet.next() ? resultSet.getString("name") : null;
    }

    private static boolean checkEntityExist(int villainId, String tableName) throws SQLException {
        query = "SELECT * FROM " + tableName + " WHERE id = ?";

        statement = connection.prepareStatement(query);
        statement.setInt(1, villainId);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }

    private static void getVillainsByNameAndCountOfMinions() throws SQLException {
        query = "SELECT v.name, COUNT(m.name) AS count_minions FROM villains AS v\n" +
                "LEFT JOIN minions_villains AS ms ON v.id = ms.villain_id\n" +
                "LEFT JOIN minions AS m ON ms.minion_id = m.id\n" +
                "GROUP BY v.name\n" +
                "HAVING count_minions > 15\n" +
                "ORDER BY count_minions DESC";

        statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        System.out.println("Villain name | number of minions");
        while (resultSet.next()) {
            System.out.println(String.format("%-12s | %13s"
                    , resultSet.getString("name")
                    , resultSet.getString("count_minions")));
        }
    }
}
