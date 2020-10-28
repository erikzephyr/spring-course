package com.pluralsight.springcourse.swagger.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Pc implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Brand can't be empty")
    private String brand;

    private Double price;

    @Min(value = 1, message = "Score should not be less than 1")
    @Max(value = 10, message = "Score should not be greater than 10")
    private Integer score;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
