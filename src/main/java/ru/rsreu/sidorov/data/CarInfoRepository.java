package ru.rsreu.sidorov.data;

import ru.rsreu.sidorov.models.CarInfo;

public interface CarInfoRepository {

    CarInfo findById(String id);

    CarInfo save(CarInfo carInfo);
}
