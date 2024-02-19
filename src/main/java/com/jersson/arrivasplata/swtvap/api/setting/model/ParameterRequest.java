package com.jersson.arrivasplata.swtvap.api.setting.model;

import com.jersson.arrivasplata.swtvap.api.setting.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class ParameterRequest {
    private Long id;
    private Long parentId;
    private Long groupId;
    private String description;
    private String value;
    private String code;
    private Long position;
    private Status status;
    private LocalDate deletedAt;
}
