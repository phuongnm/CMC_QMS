package com.cmc.repo;
import com.cmc.domain.Issues;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.addon.finder.annotations.RooFinder;
import org.springframework.roo.addon.finder.annotations.RooFinders;

@RooJpaRepository(entity = Issues.class)
@RooFinders(finders = { @RooFinder(finder = "findByDoneRatioEquals", returnType = Issues.class) })
public interface IssuesRepository {
}
