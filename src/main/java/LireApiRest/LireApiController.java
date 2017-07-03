package LireApiRest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import LireApi.Index;
import LireApi.ParallelIndex;
import LireApi.Search;

import java.util.List;
import LireApi.SearchResult;

@RestController
public class LireApiController {

	@RequestMapping("/indeximg")
	public Response indexImg(@RequestParam(value="img") String imgPath) throws IOException {
		Index.index(imgPath);
		return new Response(200, "Image " + imgPath + " has been indexed");
	}

	@RequestMapping("/indexdir")
	public Response indexDir(@RequestParam(value="dir") String dirPath) throws IOException {
		ParallelIndex.index(dirPath);
		return new Response(200, "Directory " + dirPath + " has been indexed");
	}

	@RequestMapping("/search")
	public SearchResponse indexDir(@RequestParam(value="img") String imgPath,
								   @RequestParam(value="n", defaultValue="10") int n) throws IOException {
		List<SearchResult> res = Search.searchNBest(imgPath, n);
		return new SearchResponse(200, "Searched images similar to " + imgPath, res);
	}
}