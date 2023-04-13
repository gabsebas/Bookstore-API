package com.store.store.repository;

import com.store.store.model.AuthorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MySqlRepositoryAuthor extends JpaRepository<AuthorInfo, Integer> {
    Optional<AuthorInfo> findByLastName(String lastName);

}

