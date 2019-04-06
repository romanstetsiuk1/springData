package com.romanstetsiuk.spring_data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByName(String nazwa);

    @Query("select p from Product p where p.name = :myname")
    List<Product> fetchAllByName (@Param("myname") String cokolwiek);

}
