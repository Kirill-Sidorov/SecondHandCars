package ru.rsreu.sidorov.data;

import ru.rsreu.sidorov.models.Seller;

public interface SellerRepository {

    Seller findById(long id);

    Seller save(Seller seller);
}
