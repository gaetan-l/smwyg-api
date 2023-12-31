package com.gaetanl.smwygapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class User implements ModelObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Setter
    private String username;

    // TODO: Should this be a Set<Title> ?
    @ElementCollection
    private final Set<String> favorites = new HashSet<>();

    @Override
    @JsonIgnore
    public @NonNull String getIdAsString() {
        return String.valueOf(id);
    }



    // Indexes
    public enum UserIndex implements ModelIndex<User> {
        ID {@Override public String getIndexedValue(final User objectToIndex) {return String.valueOf(objectToIndex.id);}},
        USERNAME {@Override public String getIndexedValue(final User objectToIndex) {return objectToIndex.username;}}
    }
}
