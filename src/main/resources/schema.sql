create table if not exists Car (
                                   id identity,
                                   brand varchar(20) not null,
                                   model varchar(20) not null
);

create table if not exists Car_Info (
                                        id identity,
                                        car_id bigint not null,
                                        seller_id bigint not null,
                                        yearManufacture varchar(4) not null,
                                        typeBody varchar(10) not null,
                                        typeFuel varchar(7) not null,
                                        typeTransmission varchar(15) not null,
                                        typeDrive varchar(10) not null,
                                        horsePower varchar(4) not null,
                                        engineVolume varchar(4) not null,
                                        odometer varchar(15) not null,
                                        passportVehicle varchar(10) not null,
                                        owner varchar(15) not null,
                                        licensePlate varchar(9) not null,
                                        vin varchar(17) not null,
                                        price varchar(20) not null
);

create table if not exists Seller (
                                      id identity,
                                      city varchar(15) not null,
                                      nameOwner varchar(15) not null,
                                      phoneNumber varchar(11) not null,
                                      email varchar(20) not null
);

alter table Car_Info
    add foreign key (car_id) references Car(id);

alter table Car_Info
    add foreign key (seller_id) references Seller(id);