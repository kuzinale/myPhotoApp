package com.example.myphotoapp;

import javafx.scene.image.Image;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class MySQL {
    private static String url = "jdbc:mysql://localhost:3306?user=root&password=root&serverTimezone=UTC";

    public static void putPhoto(String name, String path){

        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       }catch (ClassNotFoundException ex){}

        try(Connection con = DriverManager.getConnection(url)){
            File file = new File(path);
            if(!file.exists()){return;}
            long size = file.length();
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(path));
            String sql = "Insert into adventureworks.pictures (caption,image) Values(?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setBinaryStream(2,fis,size);
            preparedStatement.executeUpdate();
        }catch (SQLException | FileNotFoundException ex ){
            System.out.println(ex.getMessage());}
    }
    public static ArrayList<PicturesSet> getPhotos(){
        ArrayList<PicturesSet> picturesSets = new ArrayList<>();
        PicturesSet picturesSet = new PicturesSet();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException ex){}

        String sql = "SELECT * FROM adventureworks.pictures";
        try(Connection con = DriverManager.getConnection(url)){

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                PicturesSet ps = new PicturesSet();
                ps.picture = new Image(rs.getBinaryStream("image"));
                ps.caption = rs.getString("caption");
                picturesSets.add(ps);
                HelloApplication.items.add(rs.getString(1));
            }

            rs.next();
            return picturesSets;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
