package com.tekingb.testapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface tEntityRepository
    extends JpaRepository<tentity, UUID>, QuerydslPredicateExecutor<tentity> {}
