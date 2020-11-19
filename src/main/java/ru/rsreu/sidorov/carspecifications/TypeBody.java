package ru.rsreu.sidorov.carspecifications;

public enum TypeBody {

    SEDAN {
        @Override
        public String toString() {
            return "Седан";
        }
    },
    WAGON {
        @Override
        public String toString() {
            return "Универсал";
        }
    },
    HATCHBACK {
        @Override
        public String toString() {
            return "Хэтчбэк";
        }
    },
    SUV {
        @Override
        public String toString() {
            return "SUV";
        }
    },
    PICKUP {
        @Override
        public String toString() {
            return "Пикап";
        }
    };

    @Override
    public abstract String toString();
}
