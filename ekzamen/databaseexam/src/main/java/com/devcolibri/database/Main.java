package com.devcolibri.database;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {
    private static final String URL="jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";

    private static final String neww="insert into planet(name,radius) values(?,?)";
    private static final String GET="select * from planet";
    private static final String DELETE="delete from planet where name=?";

    public static void main(String[] args){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        PreparedStatement preparedStatement1=null;
        PreparedStatement preparedStatement2=null;



        try {
            Driver driver=new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);

            Statement statement=connection.createStatement();

            preparedStatement=connection.prepareStatement(neww);
            //VSTAVKA
            preparedStatement.setString(1,"Earth");
            preparedStatement.setInt(2,100);
            preparedStatement.execute();


            preparedStatement1=connection.prepareStatement(GET);
            ResultSet re=preparedStatement1.executeQuery();
            while(re.next()){
                String name = re.getString("name");
                int radius = re.getInt("radius");
                System.out.println("name:"+name);
                System.out.println("radius:"+radius);
            }


            preparedStatement2=connection.prepareStatement(DELETE);
            //preparedStatement2.setString(1,"Earth");
            //preparedStatement2.setInt(2,100);
            //preparedStatement2.executeUpdate();



            //System.out.println(connection.isClosed());


            //statement.execute("insert into users(name,age) values('vitu',19);");
            //int res=statement.executeUpdate("update users set name='Vitya' where id=10;");
            //ResultSet res=statement.executeQuery("select * from users");
            //System.out.println(res);

            //statement.addBatch("insert into users(name,age) values('batch1',1)");
            //statement.addBatch("insert into users(name,age) values('batch2',2)");
            //statement.executeBatch();
            //statement.clearBatch();

            //boolean status=statement.isClosed();

            //System.out.println(status);

            //statement.getConnection();

            //statement.close();


            String query="select * from users ";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Users users=new Users();
                users.setId(resultSet.getInt("id"));
                users.setName(resultSet.getString(2));
                users.setAge(resultSet.getInt(3));
                System.out.println(users);
                //int id = resultSet.getInt(1);
                //String name = resultSet.getString(2);
                //int age = resultSet.getInt(3);
                //System.out.println(id);
                //System.out.println(name);
                //System.out.println(age);
            }


            if(!connection.isClosed()){
                System.out.println("Соединение установлено");
            }
            connection.close();
            if(connection.isClosed()){
                System.out.println("Соединение закрыто");
            }
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвер");
        }

    }

}
