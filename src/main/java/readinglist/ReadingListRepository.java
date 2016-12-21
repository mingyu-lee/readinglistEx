package readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Mingyu Lee on 2016-12-11.
 * Description:
 * Book 객체를 영속화할 수 있는 리포지토리
 * Book: 리포지토리가 사용할 도메인 타입
 * Long: 클래스의 ID 프로퍼티타입
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    // 지정한 독자의 이름으로 독서 목록을 검색
    List<Book> findByReader(Reader reader);
}
