package com.example.NoSqlMongoDb.domain.documents;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Boolean isMarried;
}
