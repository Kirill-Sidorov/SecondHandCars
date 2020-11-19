package ru.rsreu.sidorov.carspecifications;

public enum TypeFuel {

    PETROL {
        @Override
        public String toString() {
            return "Бензин";
        }
    },
    DIESEL {
        @Override
        public String toString() {
            return "Дизель";
        }
    };

    public abstract String toString();
}
