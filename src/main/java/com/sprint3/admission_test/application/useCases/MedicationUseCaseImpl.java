package com.sprint3.admission_test.application.useCases;

import com.sprint3.admission_test.application.dto.MedicationRequestDTO;
import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.application.ports.out.ICategoryRepository;
import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicationUseCaseImpl implements IMedicationUseCase {

    @Autowired
    private IMedicationRepository medicationRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Could not find medication with ID: " + id
        ));
    }

    @Override
    public Medication addMedication(MedicationRequestDTO medicationRequest) {

        Category category = categoryRepository.findByName(medicationRequest.getCategory_name()).orElseThrow(() -> new NotFoundException(
                "No existe categoria: " + medicationRequest.getCategory_name()
        ));

        Medication medication = Medication.builder()
                .name(medicationRequest.getName())
                .description(medicationRequest.getDescription())
                .price(medicationRequest.getPrice())
                .expirationDate(medicationRequest.getExpiration_date())
                .category(category)
                .build();


        return medicationRepository.save(medication);
    }

    @Override
    public List<Medication> getMedicationsByCategoryAndExpirationDateAfter(String category, LocalDate expirationDate) {
        return medicationRepository.findByCategoryNameAndExpirationDateAfter(category,expirationDate);

    }
}
