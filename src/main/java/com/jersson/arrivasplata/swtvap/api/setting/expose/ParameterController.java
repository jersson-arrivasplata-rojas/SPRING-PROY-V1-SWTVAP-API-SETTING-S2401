package com.jersson.arrivasplata.swtvap.api.setting.expose;

import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterRequest;
import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ParameterController {
    Flux<ResponseEntity<ParameterResponse>> getAllParameters();

    Mono<ResponseEntity<ParameterResponse>> getParameterById(Long id);

    Mono<ResponseEntity<ParameterResponse>> createParameter(ParameterRequest parameter);

    Mono<ResponseEntity<ParameterResponse>> updateParameter(Long id, ParameterRequest updatedParameter);

    Mono<ResponseEntity<Void>> deleteParameter(Long id);
}
