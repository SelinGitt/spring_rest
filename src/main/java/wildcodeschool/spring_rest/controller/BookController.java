package wildcodeschool.spring_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wildcodeschool.spring_rest.entity.BookDO;
import wildcodeschool.spring_rest.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<BookDO> getAllBooks() {
        return (List<BookDO>) bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public BookDO getBookById(@PathVariable final Integer id) {
        Optional<BookDO> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null);
    }

    @PostMapping
    public BookDO createBook(@RequestBody final BookDO book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public BookDO updateBook(@PathVariable final Integer id, @RequestBody final BookDO bookDetails) {
        Optional<BookDO> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            BookDO book = bookOptional.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setDescription(bookDetails.getDescription());
            return bookRepository.save(book);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable final Integer id) {
        bookRepository.deleteById(id);
    }

    @GetMapping("/search")
    public Iterable<BookDO> searchBook(@RequestParam final String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
