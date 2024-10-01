package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.application.dto.MedicationRequestDTO;
import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.List;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);
    Medication addMedication(MedicationRequestDTO requestMedication);
    List<Medication> getMedicationsByCategoryAndExpirationDateAfter(String category, LocalDate expirationAfter);


}
