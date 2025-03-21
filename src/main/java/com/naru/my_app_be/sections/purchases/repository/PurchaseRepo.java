package com.naru.my_app_be.sections.purchases.repository;

import com.naru.my_app_be.sections.purchases.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseRepo extends JpaRepository<Purchase, UUID> {
}

