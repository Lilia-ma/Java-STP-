package com.example.rest_service.models;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class AdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer price;


}
