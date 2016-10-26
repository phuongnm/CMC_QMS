package com.cmc.repo;
import com.cmc.domain.Projects;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;

@RooJpaRepositoryCustom(entity = Projects.class, defaultSearchResult = Projects.class)
public interface ProjectsRepositoryCustom {
}
