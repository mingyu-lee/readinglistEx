package readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 이민규 on 2016-12-21.
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {
    // JpaRepository를 확장하므로 추가 구현 코드를 작성할 필요가 없다.
    // 스프링 데이터 JPA가 런타임에 자동으로 구현체를 생성한다.
}
