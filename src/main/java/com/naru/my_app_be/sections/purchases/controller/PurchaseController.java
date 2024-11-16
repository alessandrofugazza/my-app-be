package com.naru.my_app_be.sections.purchases.controller;

import com.naru.my_app_be.sections.purchases.entity.Purchase;
import com.naru.my_app_be.sections.purchases.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/purchases/v1")
@RequiredArgsConstructor
@Validated
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping("/")
    public ResponseEntity<List<Purchase>> getAllPurchases(){
        return ResponseEntity.ok().body(purchaseService.getAllPurchases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(purchaseService.getPurchaseById(id));
    }
    
    @PostMapping("/")
    public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase purchase)
    {
        return ResponseEntity.ok().body(purchaseService.savePurchase(purchase));
    }

    @PutMapping("/")
    public ResponseEntity<Purchase> updatePurchase(@RequestBody Purchase purchase)
    {
        return ResponseEntity.ok().body(purchaseService.updatePurchase(purchase));
    }

    @PatchMapping("/{id}/title")
    public ResponseEntity<Purchase> updatePurchaseTitle(@PathVariable UUID id, @RequestBody String newTitle)
    {
        return ResponseEntity.ok().body(purchaseService.updatePurchaseTitle(id, newTitle));
    }

    @PatchMapping("/{id}/description")
    public ResponseEntity<Purchase> updatePurchaseDescription(@PathVariable UUID id, @RequestBody String newDescription)
    {
        return ResponseEntity.ok().body(purchaseService.updatePurchaseTitle(id, newDescription));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePurchaseById(@PathVariable UUID id)
    {
        purchaseService.deletePurchaseById(id);
        return ResponseEntity.ok().body("Deleted purchase successfully");
    }


}
