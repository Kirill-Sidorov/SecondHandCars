package ru.rsreu.sidorov.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.rsreu.sidorov.models.Seller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.Map;

@Repository
public class JdbcSellerRepository implements SellerRepository {

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert sellerInserter;
    private ObjectMapper objectMapper;

    @Autowired
    public JdbcSellerRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.sellerInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Seller")
                .usingGeneratedKeyColumns("id");
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Seller findById(long id) {
        return jdbc.queryForObject("select * from Seller where id=?",
                this::mapRowToSeller, id);
    }

    @Override
    public Seller findByUsername(String username) {
        return jdbc.queryForObject("select * from Seller where username=?",
                this::mapRowToSeller, username);
    }

    @Override
    public Seller save(Seller seller) {
        long sellerId = saveSellerInfo(seller);
        seller.setId(sellerId);
        return seller;
    }

    private long saveSellerInfo(Seller seller) {
        Map<String, Object> values = objectMapper.convertValue(seller, Map.class);
        values.put("city", seller.getCity());
        values.put("username", seller.getUsername());
        values.put("name", seller.getName());
        values.put("phoneNumber", seller.getPhoneNumber());
        values.put("email", seller.getEmail());
        values.put("password", seller.getPassword());

        long sellerId = sellerInserter.executeAndReturnKey(values).longValue();
        return sellerId;

        /*
        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
                "insert into Seller (city, nameOwner, phoneNumber, email) values (?, ?, ?, ?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR
        ).newPreparedStatementCreator(
                Arrays.asList(
                        seller.getCity(), seller.getNameOwner(), seller.getPhoneNumber(), seller.getEmail()
                )
        );
        KeyHolder keyHolder = new GeneratedKeyHolder();
//        long sellerId = keyHolder.getKey().longValue();
        jdbc.update(psc, keyHolder);

        return (long) 87457983;
        */
    }



    private Seller mapRowToSeller(ResultSet rs, int rowNum) throws SQLException {
        Seller seller = new Seller();
        seller.setId(rs.getLong("id"));
        seller.setCity(rs.getString("city"));
        seller.setUsername(rs.getString("username"));
        seller.setName(rs.getString("name"));
        seller.setPhoneNumber(rs.getString("phoneNumber"));
        seller.setEmail(rs.getString("email"));
        seller.setPassword(rs.getString("password"));
        return seller;
    }

}
