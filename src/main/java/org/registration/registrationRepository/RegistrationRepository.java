package org.registration.registrationRepository;

import org.registration.registarationDTO.RegistrationDTO;

public interface RegistrationRepository {
    public void saveDataToDatabase(RegistrationDTO registrationDTO);
}
