package ru.rsreu.sidorov.carspecifications;

public enum TypeDrive {

    FWD {
        @Override
        public String toString() {
            return "Передний";
        }
    },

    RWD {
        @Override
        public String toString() {
            return "Задний";
        }
    },

    AWD {
        @Override
        public String toString() {
            return "Полный";
        }
    };

    @Override
    public abstract String toString();

}
