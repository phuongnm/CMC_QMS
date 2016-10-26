package com.cmc.repo;
import com.cmc.domain.Projects;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

@RooJpaRepository(entity = Projects.class)
public interface ProjectsRepository {
}
