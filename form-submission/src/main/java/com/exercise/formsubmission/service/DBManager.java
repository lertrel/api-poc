package com.exercise.formsubmission.service;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;

import org.hsqldb.persist.HsqlProperties;

public class DBManager implements Closeable {

    private static final String DB_LOCATION = "c:\\temp\\"; // change it to your db location

    org.hsqldb.server.Server sonicServer;
    Connection dbConn = null;

    public void start() {
        HsqlProperties props = new HsqlProperties();
        props.setProperty("server.database.0", "file:" + DB_LOCATION + "testdb;");
        props.setProperty("server.dbname.0", "testdb");
        sonicServer = new org.hsqldb.Server();
        try {
            sonicServer.setProperties(props);
        } catch (Exception e) {
            return;
        }
        sonicServer.start();
    }

    @Override
    public void close() throws IOException {
        sonicServer.shutdown();
    }
}