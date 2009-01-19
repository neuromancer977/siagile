package code.siagile.unitmockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.*;

public class CachedBookServiceTest {
	@Test
	public void testConstructor() {
		// anonymous class to test in isolation CachedBookService constructor
		IBookService bookServiceParameter = new IBookService() {
			public IBook getBook(String code) throws NoSuchElementException {
				return null;
			}
		};
		CachedBookService cachedBookService = new CachedBookService(bookServiceParameter);
		assertNotNull("Assert not null", cachedBookService.getRemoteBookService());
		assertSame("Assert same reference", bookServiceParameter, cachedBookService.getRemoteBookService());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNullArg() {
		// should throw IllegaArgumentException with null arg
		new CachedBookService(null);
	}

	@Test
	public void testGetBook() {
		// (1) creo il mock per il collaboratore
		IBookService remoteBookService = mock(IBookService.class);
		// un mock per l'oggetto di ritorno
		IBook mockBook = mock(IBook.class);
		// (2) registro il comportamento atteso
		when(remoteBookService.getBook("id123")).thenReturn(mockBook);

		CachedBookService cachedBookService = new CachedBookService(remoteBookService);
		// (3) eseguo la chiamata alla classe sotto test che interagisce con il mock
		IBook result = cachedBookService.getBook("id123");
		assertSame("Assert same reference", mockBook, result);
		// (4) verifico che il mock e' stato utilizzato correttamente
		verify(remoteBookService);
	}

	@Test
	public void testGetBookTwoDifferentCodes() {
		// (1) creo il mock per il collaboratore
		IBookService remoteBookService = mock(IBookService.class);
		// creo mock diversi per gli oggetti di ritorno
		IBook mockBook1 = mock(IBook.class);
		IBook mockBook2 = mock(IBook.class);
		// (2) registro il comportamento atteso
		when(remoteBookService.getBook("id123")).thenReturn(mockBook1);
		when(remoteBookService.getBook("id456")).thenReturn(mockBook2);

		CachedBookService cachedBookService = new CachedBookService(remoteBookService);
		// (3) eseguo la chiamata alla classe sotto test che interagisce con il mock
		IBook result1 = cachedBookService.getBook("id123");
		assertSame("Assert same reference", mockBook1, result1);
		IBook result2 = cachedBookService.getBook("id456");
		assertSame("Assert same reference", mockBook2, result2);
		// (4) verifico che il mock e' stato utilizzato correttamente
		verify(remoteBookService);
	}

	@Test
	public void testGetSameBookTwoTimes() {
		// (1) creo il mock per il collaboratore
		IBookService remoteBookService = mock(IBookService.class);
		IBook mockBook = mock(IBook.class);
		// (2) registro solo una chiamata
		when(remoteBookService.getBook("id123")).thenReturn(mockBook);

		CachedBookService cachedBookService = new CachedBookService(remoteBookService);
		// (3) eseguo la chiamata alla classe sotto test che interagisce con il mock
		IBook result = cachedBookService.getBook("id123");
		assertSame(mockBook, result);
		IBook secondResult = cachedBookService.getBook("id123");
		assertSame(result, secondResult);
		// (4) verifico che il mock e' stato utilizzato correttamente
		verify(remoteBookService, times(1)); // una servita dalla cache
	}

}