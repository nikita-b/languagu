package org.languano.repositories;


import org.springframework.data.repository.CrudRepository;
import org.languano.models.Word;


public interface WordRepository extends CrudRepository<Word, Long> {
}