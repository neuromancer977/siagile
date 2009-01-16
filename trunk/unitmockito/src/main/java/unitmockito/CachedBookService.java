package unitmockito;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CachedBookService implements IBookService {
	private IBookService 		_remoteBookService;
	private Map<String, IBook> 	_cache;
	
	public CachedBookService(IBookService bookService){
		if(bookService == null){
			throw new IllegalArgumentException();
		}
		_remoteBookService = bookService;
		_cache = new HashMap<String, IBook>();
	}
	
	public IBook getBook(String code) throws NoSuchElementException {
		IBook ibook = _cache.get(code);
		if(ibook != null){
			return ibook;
		}else{
			IBook result = _remoteBookService.getBook(code);
			_cache.put(code, result);
			return result;
		}
	}

	public IBookService getRemoteBookService() {
	     return _remoteBookService;
	}
}

