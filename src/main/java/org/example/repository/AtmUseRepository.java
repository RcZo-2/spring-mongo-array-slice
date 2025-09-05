package org.example.repository;

import org.example.model.AtmUse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AtmUseRepository extends MongoRepository<AtmUse, String> {

    @Aggregation(pipeline = {
            "{ $project: { atmuse: { $slice: [ '$atmuse', ?0, ?1 ] } } }"
    })
    List<AtmUse> findAtmUseWithPagination(int skip, int limit);
}
