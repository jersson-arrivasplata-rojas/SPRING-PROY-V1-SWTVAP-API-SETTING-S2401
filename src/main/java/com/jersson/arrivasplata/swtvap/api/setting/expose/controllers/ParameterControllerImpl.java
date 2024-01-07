package com.jersson.arrivasplata.swtvap.api.setting.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.setting.business.service.ParameterService;
import com.jersson.arrivasplata.swtvap.api.setting.expose.ParameterController;
import com.jersson.arrivasplata.swtvap.api.setting.mapper.ParameterMapper;
import com.jersson.arrivasplata.swtvap.api.setting.model.Parameter;
import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterRequest;
import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/parameters")
public class ParameterControllerImpl implements ParameterController {
    private final ParameterService parameterService;
    private final ParameterMapper parameterMapper;

    public ParameterControllerImpl(ParameterService parameterService, ParameterMapper parameterMapper) {
        this.parameterService = parameterService;
        this.parameterMapper = parameterMapper;
    }

    @GetMapping
    public Flux<ResponseEntity<ParameterResponse>> getAllParameters() {
        return Flux.fromIterable(parameterService.getAllParameters())
                .map(parameter -> {
                    ParameterResponse parameterResponse = parameterMapper.parameterToParameterResponse(parameter);
                    return ResponseEntity.ok(parameterResponse);
                });
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ParameterResponse>> getParameterById(@PathVariable Long id) {
        return Mono.just(parameterService.getParameterById(id))
                .map(parameter -> {
                    ParameterResponse parameterResponse = parameterMapper.parameterToParameterResponse(parameter);
                    return ResponseEntity.ok(parameterResponse);
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<ParameterResponse>> createParameter(@RequestBody ParameterRequest parameterRequest) {
        Parameter parameter = parameterMapper.parameterRequestToParameter(parameterRequest);

        return Mono.just(parameterService.createParameter(parameter))
                .map(newParameter -> {
                    ParameterResponse parameterResponse = parameterMapper.parameterToParameterResponse(newParameter);
                    return ResponseEntity.status(HttpStatus.CREATED).body(parameterResponse);
                });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<ParameterResponse>> updateParameter(@PathVariable Long id, @RequestBody ParameterRequest parameterRequest) {
        Parameter parameter = parameterMapper.parameterRequestToParameter(parameterRequest);

        return Mono.just(parameterService.updateParameter(id, parameter))
                .map(updatedParameter -> {
                    ParameterResponse parameterResponse = parameterMapper.parameterToParameterResponse(updatedParameter);
                    return ResponseEntity.ok(parameterResponse);
                })
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteParameter(@PathVariable Long id) {
        parameterService.deleteParameterById(id);
        return Mono.just(ResponseEntity.noContent().build());
    }
}
