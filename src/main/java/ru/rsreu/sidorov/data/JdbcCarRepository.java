package ru.rsreu.sidorov.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcCarRepository implements CarRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcCarRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<String> findAllBrands() {
        return jdbc.query("select distinct brand from Car",
                this::mapRowToCarBrand);
    }

    @Override
    public Iterable<String> findAllModels(String carBrand) {
        return jdbc.query("select model from Car where brand=?",
                this::mapRowToCarModel, carBrand);
    }

    @Override
    public long findCarIdByModel(String model) {
        return jdbc.queryForObject("select id from Car where model=?",
                this::mapRowToCarIdByModel, model);
    }

    private String mapRowToCarBrand(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString("brand");
    }

    private String mapRowToCarModel(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString("model");
    }

    private long mapRowToCarIdByModel(ResultSet rs, int rowNum) throws SQLException {
        return rs.getLong("id");
    }
}
