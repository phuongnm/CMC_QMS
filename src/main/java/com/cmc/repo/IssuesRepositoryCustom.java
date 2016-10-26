package com.cmc.repo;
import com.cmc.domain.Issues;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;

@RooJpaRepositoryCustom(entity = Issues.class, defaultSearchResult = Issues.class)
public interface IssuesRepositoryCustom {
}
