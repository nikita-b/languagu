package org.languano.repositories;

import org.languano.models.Language;
import org.springframework.data.repository.CrudRepository;
public interface LanguageRepository extends CrudRepository<Language, Long> {
}