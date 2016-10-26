package com.cmc.repo;
import com.cmc.domain.Users;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;

@RooJpaRepository(entity = Users.class)
public interface UsersRepository {
}
