package ru.urvanov.virtualpets.server.remoting;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ru.urvanov.virtualpets.server.domain.Book;
import ru.urvanov.virtualpets.server.domain.Pet;
import ru.urvanov.virtualpets.server.domain.SelectedPet;
import ru.urvanov.virtualpets.server.service.PetService;
import ru.urvanov.virtualpets.shared.domain.GetPetBooksResult;
import ru.urvanov.virtualpets.shared.exception.DaoException;
import ru.urvanov.virtualpets.shared.exception.ServiceException;
import ru.urvanov.virtualpets.shared.service.BookService;

@Service(value="bookRemoting")
public class BookRemoting implements BookService {

    @Autowired
    private PetService petService;
    
    @Override
    public GetPetBooksResult getPetBooks() throws DaoException,
            ServiceException {
        ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        SelectedPet selectedPet = (SelectedPet) sra.getAttribute("pet", ServletRequestAttributes.SCOPE_SESSION);
        Pet pet = petService.findFullById(selectedPet.getId());
        Set<Book> books = pet.getBooks();
        
        boolean[] resultBooks = new boolean[Book.MAX_ID];
        books.stream().forEach((b)->{resultBooks[b.getId() - 1] = true;});
        GetPetBooksResult result = new GetPetBooksResult();
        result.setBooks(resultBooks);
        return result;
    }

}
