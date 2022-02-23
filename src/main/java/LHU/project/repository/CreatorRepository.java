package LHU.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatorRepository extends JpaRepository<Creator,Integer> {
    @Query(value = "select * from creator",nativeQuery = true)
    List<Creator> getAllCreator();
}
