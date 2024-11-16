package com.naru.my_app_be.sections.purchases.service;


import com.naru.my_app_be.exceptions.ResourceNotFoundException;
import com.naru.my_app_be.sections.purchases.entity.Purchase;
import com.naru.my_app_be.sections.purchases.repository.PurchaseRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseService {

    private final PurchaseRepo purchaseRepo;

    public List<Purchase> getAllPurchases(){
        return purchaseRepo.findAll();
    }

    public Purchase getPurchaseById(UUID id){
        Optional<Purchase> optionalPurchase = purchaseRepo.findById(id);
        if(optionalPurchase.isPresent()){
            return optionalPurchase.get();
        }
        log.info("Purchase with id: {} doesn't exist", id);
        return null;
    }

    public Purchase savePurchase (Purchase purchase){
        purchase.setCreatedAt(LocalDateTime.now());
        purchase.setUpdatedAt(LocalDateTime.now());
        Purchase savedPurchase = purchaseRepo.save(purchase);

        log.info("Purchase with id: {} saved successfully", purchase.getId());
        return savedPurchase;
    }

    public Purchase updatePurchase (Purchase purchase) {
        Optional<Purchase> existingPurchase = purchaseRepo.findById(purchase.getId());
        purchase.setCreatedAt(existingPurchase.get().getCreatedAt());
        purchase.setUpdatedAt(LocalDateTime.now());

        Purchase updatedPurchase = purchaseRepo.save(purchase);

        log.info("Purchase with id: {} updated successfully", purchase.getId());
        return updatedPurchase;
    }

    public Purchase updatePurchaseTitle (UUID id, String newTitle) {
        Purchase purchase = purchaseRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Purchase not found with id " + id));
        purchase.setTitle(newTitle);
        purchase.setUpdatedAt(LocalDateTime.now());

        Purchase updatedPurchase = purchaseRepo.save(purchase);

        log.info("Title of purchase with id: {} updated successfully", purchase.getId());
        return updatedPurchase;
    }

    public Purchase updatePurchaseDescription (UUID id, String newDescription) {
        Purchase purchase = purchaseRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Purchase not found with id " + id));
        purchase.setDescription(newDescription);
        purchase.setUpdatedAt(LocalDateTime.now());

        Purchase updatedPurchase = purchaseRepo.save(purchase);

        log.info("Description of purchase with id: {} updated successfully", purchase.getId());
        return updatedPurchase;
    }

    public void deletePurchaseById (UUID id) {
        purchaseRepo.deleteById(id);
    }

}
