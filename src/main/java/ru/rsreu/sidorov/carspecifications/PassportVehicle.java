package ru.rsreu.sidorov.carspecifications;

public enum PassportVehicle {

    ORIGINAL {
        @Override
        public String toString() {
            return "Оригинал";
        }
    },
    DUPLICATE {
        @Override
        public String toString() {
            return "Дубликат";
        }
    };

    @Override
    public abstract String toString();
}
