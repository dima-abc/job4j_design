package ru.job4j.jdbc;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

/**
 * 2.3.5.JDBC.
 * 0.1. Statement [#379306].
 * test.
 *
 * @author Dmitry
 * @since 27.12.2021
 */
public class TableEditorTest {
    @Test
    public void whenTableEditorNewObject() throws Exception {
        TableEditor tableEditor = new TableEditor(new Properties(),
                "jdbc/idea_db.properties");
        tableEditor.createTable("table1");
        tableEditor.addColumn("table1", "column1", "varchar(255)");
        tableEditor.renameColumn("table1", "column1", "column100");
        System.out.println(tableEditor.getTableScheme("table1"));
        tableEditor.dropColumn("table1", "column100");
        tableEditor.dropTable("table1");
        tableEditor.close();
    }

}