package com.jersson.arrivasplata.swtvap.api.setting.business.implementation;

import com.jersson.arrivasplata.swtvap.api.setting.business.service.ParameterService;
import com.jersson.arrivasplata.swtvap.api.setting.model.Parameter;
import com.jersson.arrivasplata.swtvap.api.setting.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterServiceImpl implements ParameterService {
    private final ParameterRepository parameterRepository;

    @Autowired
    public ParameterServiceImpl(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    public List<Parameter> getAllParameters() {
        return parameterRepository.findAll();
    }

    public Parameter getParameterById(Long id) {
        return parameterRepository.findById(id).orElse(null);
    }

    public Parameter createParameter(Parameter parameter) {
        return parameterRepository.save(parameter);
    }

    public Parameter updateParameter(Long id, Parameter updatedParameter) {
        updatedParameter.setId(id);
        return parameterRepository.save(updatedParameter);
    }

    public void deleteParameterById(Long id) {
        parameterRepository.deleteById(id);
    }
}