package wildcodeschool.spring_rest.repository;

import org.springframework.data.repository.CrudRepository;
import wildcodeschool.spring_rest.entity.BookDO;

import java.util.List;

public interface BookRepository extends CrudRepository<BookDO, Integer> {

    List<BookDO> findByTitleContainingIgnoreCase(final String keyword);
}
