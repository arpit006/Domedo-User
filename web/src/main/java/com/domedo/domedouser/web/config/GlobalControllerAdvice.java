package com.domedo.domedouser.web.config;

import com.domedo.basesdk.exception.DomedoRestException;
import com.domedo.objects.exceptions.DomedoIntegrationException;
import com.domedo.objects.pojos.ErrorCodes;
import com.domedo.objects.pojos.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler(DomedoIntegrationException.class)
    public ResponseEntity<ResultInfo<String>> handleIntegrationException(DomedoIntegrationException ex) {
        log.error("DomedoIntegrationException : " + ex);
        ErrorCodes errorCodes = ex.getErrorCodes();
        ResultInfo<String> resultInfo = new ResultInfo<>();
        resultInfo.setStatusCode(errorCodes.getCode());
        resultInfo.setStatusMessage(errorCodes.getErrorMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultInfo);
    }

//    @ExceptionHandler(DomedoRestException.class)
    public ResponseEntity<ResultInfo<String>> handleDomedoRestException(DomedoRestException ex) {
//        ResponseEntity.status(Http)
        return null;
    }
}
