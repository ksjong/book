package bookshop.infra;

import bookshop.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class BookManagementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<BookManagement>> {

    @Override
    public EntityModel<BookManagement> process(
        EntityModel<BookManagement> model
    ) {
        return model;
    }
}
