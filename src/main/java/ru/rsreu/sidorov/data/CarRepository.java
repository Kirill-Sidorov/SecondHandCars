package ru.rsreu.sidorov.data;

import ru.rsreu.sidorov.models.Car;

public interface CarRepository {
    Iterable<String> findAllBrands();
    Iterable<String> findAllModels(String carBrand);
    long findCarIdByModel(String model);
    Car findCarById(long id);
}
