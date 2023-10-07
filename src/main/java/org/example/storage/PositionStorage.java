package org.example.storage;

import org.example.model.Position;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PositionStorage implements Storage<Position, Long> {
    private DAO dao = DAO.getInstance();
    @Override
    public Position save(Position entity) {
        String sql = "insert into position(position) values(?)";
        dao.executeUpdate(sql, new PreparedStatementFiller() {
            @Override
            public void fill(PreparedStatement statement) throws SQLException{
                statement.setString(1, entity.getTitle());
            }
        });
        return entity;
    }
}
