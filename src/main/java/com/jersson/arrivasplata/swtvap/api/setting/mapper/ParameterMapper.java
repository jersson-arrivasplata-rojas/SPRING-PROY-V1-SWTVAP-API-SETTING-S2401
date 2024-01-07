package com.jersson.arrivasplata.swtvap.api.setting.mapper;

import com.jersson.arrivasplata.swtvap.api.setting.model.Parameter;
import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterRequest;
import com.jersson.arrivasplata.swtvap.api.setting.model.ParameterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ParameterMapper {
    ParameterMapper INSTANCE = Mappers.getMapper(ParameterMapper.class);

    @Mapping(target = "id", ignore = true)
    Parameter parameterRequestToParameter(ParameterRequest catalogRequest);

    ParameterRequest parameterToParameterRequest(Parameter catalog);

    ParameterResponse parameterToParameterResponse(Parameter catalog);

    List<ParameterResponse> mapParametersToResponses(List<Parameter> catalogs);
}
