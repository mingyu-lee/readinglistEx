package readinglist;

/**
 * Created by Mingyu Lee on 2016-12-11.
 * Description:
 */

import lombok.Data;

import javax.persistence.*;

@Data
@Entity// JPA 엔티티로 지정
public class Book {

    @Id // 엔티티의 유일성을 식별
    @GeneratedValue(strategy=GenerationType.AUTO) // 자동으로 값을 제공하는 필드로 지정
    private Long id;
    private Reader reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

}
