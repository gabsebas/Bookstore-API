package com.store.store.repository;

import com.store.store.model.Bookstore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepository extends JpaRepository<Bookstore, Integer> {
}
