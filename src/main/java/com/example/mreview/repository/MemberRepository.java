package com.example.mreview.repository;

import com.example.mreview.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {

//    @Query("select m, avg(coalesce(r.grade,0)),  count(r) from Movie m " +
//            "left outer join Review  r on r.movie = m group by m")
//    Page<Object[]> getListPage(Pageable pageable);

    @Query("select m, mi, avg(coalesce(r.grade,0)),  count(distinct r) from Movie m " +
            "left outer join MovieImage mi on mi.movie = m " +
            "left outer join Review  r on r.movie = m group by m ")
    Page<Object[]> getListPage(Pageable pageable);
}
