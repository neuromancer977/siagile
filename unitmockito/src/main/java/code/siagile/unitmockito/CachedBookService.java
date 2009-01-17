package code.siagile.unitmockito;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CachedBookService implements IBookService {
	private IBookService remoteBookService;
	private Map<String, IBook> cache;

	public CachedBookService(IBookService bookService) {
		if (bookService == null) throw new IllegalArgumentException();

		remoteBookService = bookService;
		cache = new HashMap<String, IBook>();
	}

	public IBook getBook(String code) throws NoSuchElementException {
		if (cache.containsKey(code)) return cache.get(code);

		return cacheAndGetBookBy(code);
	}

	private IBook cacheAndGetBookBy(String code) {
		final IBook result = remoteBookService.getBook(code);
		cache.put(code, result);
		return result;
	}

	public IBookService getRemoteBookService() {
		return remoteBookService;
	}
}
