package ru.rsreu.sidorov.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Fact S Musingarimi
 * 5/13/19
 * 10:58 AM
 */
@Data
public class CarInfo {

    private long id;
    private long carId;
    private long sellerId;

    @NotBlank(message="Необходимо заполнить поле")
    private String yearManufacture;
    @NotNull
    private String typeBody;
    @NotNull
    private String typeFuel;
    @NotNull
    private String typeTransmission;
    @NotNull
    private String typeDrive;
    @NotBlank(message="Необходимо заполнить поле")
    private String horsePower;
    @NotBlank(message="Необходимо заполнить поле")
    private String engineVolume;
    @NotBlank(message="Необходимо заполнить поле")
    private String odometer;
    @NotNull
    private String passportVehicle;
    @NotNull
    private String owner;
    @NotBlank(message="Необходимо заполнить поле")
    @Pattern(regexp="[а-я]\\d{3}[а-я]{2}\\d{2,3}",
            message="Номер должен соответствовать формату аХХХааХХ или аХХХааХХХ")
    private String licensePlate;
    @NotBlank(message="Необходимо заполнить поле")
    @Pattern(regexp="[A-HJ-NPR-Z0-9]{17}",
            message="Значение не соответсвует VIN")
    private String vin;
    @NotBlank(message="Необходимо заполнить поле")
    private String price;
}
