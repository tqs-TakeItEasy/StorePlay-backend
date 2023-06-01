package storeplay.backend.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import storeplay.backend.model.Package;
import storeplay.backend.service.PackageService;


@RestController
@CrossOrigin(origins={"http://localhost:3000", "http://127.0.0.1:3000"})
@RequestMapping("/api/v1/package/")
public class PackageController{

    @Autowired
    PackageService packageService;

    @PostMapping("add/")
    public ResponseEntity<Package> addPackage(@RequestBody Package package_info){
        Package newPackage = packageService.addPackage(package_info);
        // criar delivery DTO
        // Fazer post para criar uma delivery com o delivery dto
        // vai retornar um package DTO (tenho de ir buscvar o do tiago)
        // vai ter uma deliveryID, para saber que o package associa-se à delivery,
        // Se quiser algo sobre uma delivery uso o delivery id do package
        return ResponseEntity.ok().body(newPackage);
    }
}
