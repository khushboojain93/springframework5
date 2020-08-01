package com.infogain.springframework5.repositories;

import com.infogain.springframework5.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
