package LireApiRest;

import LireApiRest.Response;
import java.util.List;
import LireApi.SearchResult;

public class SearchResponse extends Response {

	List<SearchResult> res;

	public SearchResponse(int status, String message, List<SearchResult> res) {
		super(status, message);
		this.res = res;
	}

	public List<SearchResult> getRes() {
		return this.res;
	}
}