package pl.idea4u.entities.idea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IdeaRepository extends JpaRepository<Idea, Integer>{

    @Query(value = "SELECT * FROM `isch`.`idea`" +
            " WHERE `available` = 'Y'" +
            " ORDER BY `id` DESC" +
            " LIMIT 10",
            nativeQuery = true)
    List<Idea> findLastTenIdeas();

    @Query(value = "SELECT * FROM `isch`.`idea`" +
            " WHERE `available` = 'Y'" +
            " ORDER BY `rank` DESC, `id` DESC" +
            " LIMIT 10",
            nativeQuery = true)
    List<Idea> findTopTenIdeas();

    @Query(value = "SELECT COUNT(*) FROM `isch`.`idea`" +
            " WHERE `available` = 'Y'",
            nativeQuery = true)
    int countIdeas();

    @Modifying
    @Transactional
    @Query(value = "UPDATE `isch`.`idea`" +
            " SET `rank` = :rank" +
            " WHERE `id` = :id",
            nativeQuery = true)
    void updateRank(@Param("id") int id, @Param("rank") int rank);

}
