package com.ssafy.tnt.db.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.tnt.db.entity.Notice;
import com.ssafy.tnt.db.entity.NoticeDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Projection;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ssafy.tnt.db.entity.QNotice.notice;
import static com.ssafy.tnt.db.entity.QUser.user;

@Repository
@RequiredArgsConstructor
public class NoticeCustomRepository {

    private final JPAQueryFactory queryFactory;
    int size = 10;

    public List<NoticeDTO> findAllNotice (int page) {
        return queryFactory
                .select(Projections.constructor(NoticeDTO.class,
                        notice,
                        user
                ))
                .from(notice)
                .leftJoin(user).on(notice.writer.eq(user.id))
                .offset((page-1)*size)
                .limit(size)
                .orderBy(notice.date.desc())
                .fetch();
    }

    public NoticeDTO getNoticeById (Long no) {
        return queryFactory
                .select(Projections.constructor(NoticeDTO.class,
                        notice,
                        user
                ))
                .from(notice)
                .leftJoin(user).on(notice.writer.eq(user.id))
                .where(notice.no.eq(no))
                .fetchOne();
    }

}
