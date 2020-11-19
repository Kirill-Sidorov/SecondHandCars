package ru.rsreu.sidorov.data;

public interface CarRepository {
    Iterable<String> findAllBrands();
    Iterable<String> findAllModels(String carBrand);
    long findCarIdByModel(String model);
}
