package ru.practicum.stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.practicum.stats.model.HitEntity;
import ru.practicum.statsdto.ResponseHitDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsRepository extends JpaRepository<HitEntity, Long> {

    @Query("select new ru.practicum.statsdto.ResponseHitDto(" +
            "   h.app, " +
            "   h.uri, " +
            "   case when :unique = true " +
            "       then count(distinct(h.ip)) " +
            "       else count(h.ip) " +
            "   end " +
            ") " +
            "from HitEntity h " +
            "where h.timestamp between :start and :end" +
            "   and (coalesce(:uris, null) is null or h.uri in :uris) " +
            "group by h.app, h.uri " +
            "order by 3 desc")
    List<ResponseHitDto> getStats(@Param("start") LocalDateTime start,
                                  @Param("end") LocalDateTime end,
                                  @Param("uris") List<String> uris,
                                  @Param("unique") Boolean unique);

}
