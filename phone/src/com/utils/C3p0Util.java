package com.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2019/7/11.
 */
public class C3p0Util {
    private static DataSource ds=new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl=new ThreadLocal<>();
    public static DataSource getDatasource(){
        return ds;
    }
    public static Connection getConnection(){
        try {
            Connection connection=tl.get();
            if(connection==null){
                connection=ds.getConnection();
                tl.set(connection);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void startTransaction() throws SQLException {
        getConnection().setAutoCommit(false);
    }
    public static void commitAndClose(){
        Connection connection=null;
        try {
            connection=getConnection();
            connection.commit();
            connection.close();
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void releaseConnection(Connection connection){
        try{
            if(connection!=null){
                connection.close();
                tl.remove();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void rollBackAndClose(){
        Connection connection=null;
        try {
            connection=getConnection();
            connection.rollback();
            connection.close();
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
