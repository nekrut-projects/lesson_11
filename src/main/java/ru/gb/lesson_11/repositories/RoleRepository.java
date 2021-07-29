package ru.gb.lesson_11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson_11.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
