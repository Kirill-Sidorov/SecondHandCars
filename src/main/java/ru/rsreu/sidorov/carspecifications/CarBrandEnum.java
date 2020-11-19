package ru.rsreu.sidorov.carspecifications;

import java.util.ArrayList;
import java.util.List;

public enum CarBrandEnum {

    AUDI {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.A4); carModelEnums.add(CarModelEnum.A6); carModelEnums.add(CarModelEnum.A8);
            return carModelEnums;
        }
    },

    BMW {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.A4); carModelEnums.add(CarModelEnum.A4); carModelEnums.add(CarModelEnum.A4);
            return carModelEnums;
        }
    },

    CHEVROLET {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.CRUZE); carModelEnums.add(CarModelEnum.AVEO);
            return carModelEnums;
        }
    },

    CITROEN {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.C4); carModelEnums.add(CarModelEnum.C5); carModelEnums.add(CarModelEnum.BERLINGO);
            return carModelEnums;
        }
    },

    FORD {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.FOCUS); carModelEnums.add(CarModelEnum.KUGA);
            return carModelEnums;
        }
    },

    HONDA {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.CIVIC); carModelEnums.add(CarModelEnum.ACCORD); carModelEnums.add(CarModelEnum.CRV);
            return carModelEnums;
        }
    },

    HYUNDAI {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.I30); carModelEnums.add(CarModelEnum.IX35);
            return carModelEnums;
        }
    },

    KIA {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.RIO); carModelEnums.add(CarModelEnum.CEED); carModelEnums.add(CarModelEnum.SPORTAGE);
            return carModelEnums;
        }
    },

    MAZDA {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.MAZDA_6); carModelEnums.add(CarModelEnum.CX5);
            return carModelEnums;
        }
    },

    OPEL {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.ASTRA); carModelEnums.add(CarModelEnum.ZAFIRA);
            return carModelEnums;
        }
    },

    TOYOTA {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.CAMRY); carModelEnums.add(CarModelEnum.RAV4);
            return carModelEnums;
        }
    },

    VOLVO {
        @Override
        public List<CarModelEnum> getListModels() {
            List<CarModelEnum> carModelEnums = new ArrayList<CarModelEnum>();
            carModelEnums.add(CarModelEnum.S60); carModelEnums.add(CarModelEnum.S80);
            return carModelEnums;
        }
    };

    public abstract List<CarModelEnum> getListModels();
}
