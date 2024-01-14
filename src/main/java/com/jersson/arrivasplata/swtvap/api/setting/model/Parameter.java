package com.jersson.arrivasplata.swtvap.api.setting.model;

import com.jersson.arrivasplata.swtvap.api.setting.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "swtvap_parameters")
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(length = 250)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String value;

    @Column(length = 50)
    private String code;

    @Column(name = "position")
    private Long position;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
