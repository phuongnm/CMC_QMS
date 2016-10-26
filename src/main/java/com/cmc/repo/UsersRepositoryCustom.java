package com.cmc.repo;
import com.cmc.domain.Users;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;

@RooJpaRepositoryCustom(entity = Users.class, defaultSearchResult = Users.class)
public interface UsersRepositoryCustom {
}
