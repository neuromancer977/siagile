package unitmockito;
import java.util.NoSuchElementException;

public class RemoteBookService implements IBookService {
	public IBook getBook(String code) throws NoSuchElementException{
		// nop
		return null;
	}
}
