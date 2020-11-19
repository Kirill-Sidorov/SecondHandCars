package ru.rsreu.sidorov.carspecifications;

import java.util.ArrayList;
import java.util.List;

public enum CarModelEnum {

    A4 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    A6 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    A8 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN);
            return bodyList;
        }
    },
    CRUZE {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.HATCHBACK); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    AVEO {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.HATCHBACK);
            return bodyList;
        }
    },
    C4 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.HATCHBACK);
            return bodyList;
        }
    },
    C5 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    BERLINGO {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    FOCUS {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.HATCHBACK); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    KUGA {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SUV);
            return bodyList;
        }
    },
    CIVIC {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.HATCHBACK); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    ACCORD {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    CRV {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SUV);
            return bodyList;
        }
    },
    I30 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.HATCHBACK); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    IX35 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SUV);
            return bodyList;
        }
    },
    RIO {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.HATCHBACK);
            return bodyList;
        }
    },
    CEED {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.HATCHBACK); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    SPORTAGE {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SUV);
            return bodyList;
        }
    },
    MAZDA_6 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    CX5 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SUV);
            return bodyList;
        }
    },
    ASTRA {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.HATCHBACK); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    ZAFIRA {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    CAMRY {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN);
            return bodyList;
        }
    },
    RAV4 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SUV);
            return bodyList;
        }
    },
    S60 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN); bodyList.add(TypeBody.WAGON);
            return bodyList;
        }
    },
    S80 {
        @Override
        public List<TypeBody> getListTypeBody() {
            List<TypeBody> bodyList = new ArrayList<TypeBody>();
            bodyList.add(TypeBody.SEDAN);
            return bodyList;
        }
    };

    public abstract List<TypeBody> getListTypeBody();
}
