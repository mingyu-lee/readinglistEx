package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Mingyu Lee on 2016-12-11.
 * Description:
 */
@Controller // 컴포넌트 스캔으로 스프링 애플리케이션 빈으로 등록
@RequestMapping("/") // 요청을 처리하는 모든 메소드를 기본 URL 경로인 / 로 매핑
public class ReadingListController {

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    // 인스턴스 변수에 지정한 독자의 Book 리스트를 컨트롤러의 생성자로 주입된 레포지토리에서 조회
    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Reader reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
        }
        return "readingList";
    }

    // 요청 바디에 있는 데이터를 Book 객체에 바인드하여 HTTP POST 요청 처리
    // 레포지토리의 save() 메소드를 이용하여 Book 객체를 저장
    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Reader reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
