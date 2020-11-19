package ru.rsreu.sidorov.carspecifications;

public enum Owner {

    FIRST {
        @Override
        public String toString() {
            return "Первый";
        }
    },
    SECOND {
        @Override
        public String toString() {
            return "Второй";
        }
    },
    THIRD_AND_MORE {
        @Override
        public String toString() {
            return "Третий и более";
        }
    };

    @Override
    public abstract String toString();
}
