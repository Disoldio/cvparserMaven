package org.example.storage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementFiller {
    void fill(PreparedStatement statement) throws SQLException;
}
