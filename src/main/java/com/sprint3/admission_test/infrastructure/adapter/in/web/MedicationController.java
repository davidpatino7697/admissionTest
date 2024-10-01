package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.dto.MedicationRequestDTO;
import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.model.Medication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private IMedicationUseCase medicationUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }

    @PostMapping
    public ResponseEntity<Medication> addMedication(@Valid @RequestBody MedicationRequestDTO requestMedication) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicationUseCase.addMedication(requestMedication));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Medication>> getMedicationsByCategoryAndExpirationDateAfter(
            @PathVariable String category,
            @RequestParam("expiration-after") LocalDate expirationAfter) {

        List<Medication> medications = medicationUseCase.getMedicationsByCategoryAndExpirationDateAfter(category, expirationAfter);
        return ResponseEntity.status(HttpStatus.OK).body(medications);
    }
}
