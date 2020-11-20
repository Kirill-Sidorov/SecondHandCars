package ru.rsreu.sidorov.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.rsreu.sidorov.models.Car;

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

    @Override
    public Car findCarById(long id) {
        return jdbc.queryForObject("select * from Car where id=?",
                this::mapRowToCarById, id);
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

    private Car mapRowToCarById(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setBrand(rs.getString("brand"));
        car.setModel(rs.getString("model"));
        return car;
    }
}
