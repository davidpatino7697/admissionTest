package com.sprint3.admission_test.application.ports.out;

import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;

import java.util.Optional;

public interface ICategoryRepository {

    Optional<Category> findByName(String name);

}
