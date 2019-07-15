package com.medici.app.spring.facade;

import java.time.LocalDate;

public interface TimeService {

	LocalDate getNextAssessmentDate();
}
