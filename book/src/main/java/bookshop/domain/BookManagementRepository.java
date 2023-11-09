package bookshop.domain;

import bookshop.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "bookManagements",
    path = "bookManagements"
)
public interface BookManagementRepository
    extends PagingAndSortingRepository<BookManagement, Long> {}
