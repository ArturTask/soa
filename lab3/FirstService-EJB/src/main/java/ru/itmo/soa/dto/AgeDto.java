package ru.itmo.soa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AgeDto implements Serializable {

    float averageAge;
}
