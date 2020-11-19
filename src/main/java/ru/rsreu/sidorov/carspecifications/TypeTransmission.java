package ru.rsreu.sidorov.carspecifications;

public enum TypeTransmission {

    MANUALх{
        @Override
        public String toString() {
            return "Механическая";
        }
    },
    AUTOMATIC {
        @Override
        public String toString() {
            return "Автоматическая";
        }
    },
    ROBOTIC {
        @Override
        public String toString() {
            return "Роботизированная";
        }
    },
    CVT {
        @Override
        public String toString() {
            return "Вариатор";
        }
    };

    public abstract String toString();
}
