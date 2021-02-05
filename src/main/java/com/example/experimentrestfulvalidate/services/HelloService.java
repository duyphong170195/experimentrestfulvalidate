package com.example.experimentrestfulvalidate.services;

import com.example.experimentrestfulvalidate.error.ExceptionTranslator;
import com.example.experimentrestfulvalidate.exceptions.NotFoundException;
import com.example.experimentrestfulvalidate.request.HelloRequest;
import com.example.experimentrestfulvalidate.validator.ModelValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HelloService {

    private final ExceptionTranslator exp;

    private final ModelValidator modelValidator;

    public void hello() {
        try{
            modelValidator.validate(new HelloRequest(null));
            int a = 3/0;
        } catch (ArithmeticException e) {
//            NotFoundException exception = exp.translate(NotFoundException::new,
//                    "service.staff.find_by_facility_code.facility_not_found", facilityCode, lang);

//            NotFoundException exception = exp.translate(NotFoundException::new,
//                    "service.provisioning_location.find.not_found", "facilityCode", "lang");
//            exp.translate(NotFoundException::new,
//                    "service.provisioning_location.find.not_found", "facilityCode", "lang");
//            log.info("Failed to get list AdditionalService by facility_code. {}", exception.getMessage());
//            throw exception;
            NotFoundException exception = exp.translate(NotFoundException::new,
                    "service.provisioning_location.find.not_found", "facilityCode", "lang");
            log.error("Failed to get list AdditionalService by facility_code. {}", exception.getMessage());

            if(exception == null) {
                System.out.println("Say hello");
            }
            System.out.println(exception.getErrorCode());
            throw exception;
        }


    }
}
