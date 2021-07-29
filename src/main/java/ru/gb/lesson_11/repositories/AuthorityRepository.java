package ru.gb.lesson_11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson_11.models.Authority;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
