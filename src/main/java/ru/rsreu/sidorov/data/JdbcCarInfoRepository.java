package ru.rsreu.sidorov.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.rsreu.sidorov.models.Car;
import ru.rsreu.sidorov.models.CarInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class JdbcCarInfoRepository implements CarInfoRepository {

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert carInfoInserter;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcCarInfoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.carInfoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Car_Info")
                .usingGeneratedKeyColumns("id");
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public CarInfo findById(String id) {
        return jdbc.queryForObject("select * from Car_Info where id=?",
                this::mapRowToCarInfo, id);
    }

    @Override
    public CarInfo save(CarInfo carInfo) {
        long carInfoId = saveCarInfo(carInfo);
        carInfo.setId(carInfoId);
        return carInfo;
    }

    private long saveCarInfo(CarInfo carInfo) {
        Map<String, Object> values = objectMapper.convertValue(carInfo, Map.class);

        values.put("car_id", carInfo.getCarId());
        values.put("seller_id", carInfo.getSellerId());
        values.put("yearManufacture", carInfo.getYearManufacture());
        values.put("typeBody", carInfo.getTypeBody());
        values.put("typeFuel", carInfo.getTypeFuel());
        values.put("typeTransmission", carInfo.getTypeTransmission());
        values.put("typeDrive", carInfo.getTypeDrive());
        values.put("horsePower", carInfo.getHorsePower());
        values.put("engineVolume", carInfo.getEngineVolume());
        values.put("odometer", carInfo.getOdometer());
        values.put("passportVehicle", carInfo.getPassportVehicle());
        values.put("owner", carInfo.getOwner());
        values.put("licensePlate", carInfo.getLicensePlate());
        values.put("vin", carInfo.getVin());
        values.put("price", carInfo.getPrice());

        long carInfoId = carInfoInserter.executeAndReturnKey(values).longValue();
        return carInfoId;
    }

    private CarInfo mapRowToCarInfo(ResultSet rs, int rowNum) throws SQLException {
        CarInfo carInfo = new CarInfo();
        carInfo.setId(rs.getLong("id"));
        carInfo.setCarId(rs.getLong("car_id"));
        carInfo.setSellerId(rs.getLong("seller_id"));
        carInfo.setYearManufacture(rs.getString("yearManufacture"));
        carInfo.setTypeBody(rs.getString("typeBody"));
        carInfo.setTypeFuel(rs.getString("typeFuel"));
        carInfo.setTypeTransmission(rs.getString("typeTransmission"));
        carInfo.setTypeDrive(rs.getString("typeDrive"));
        carInfo.setHorsePower(rs.getString("horsePower"));
        carInfo.setEngineVolume(rs.getString("engineVolume"));
        carInfo.setOdometer(rs.getString("odometer"));
        carInfo.setPassportVehicle(rs.getString("passportVehicle"));
        carInfo.setOwner(rs.getString("owner"));
        carInfo.setLicensePlate(rs.getString("licensePlate"));
        carInfo.setVin(rs.getString("vin"));
        carInfo.setPrice(rs.getString("price"));
        return carInfo;
    }
}
