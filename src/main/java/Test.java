package Launch;

import java.io.IOException;
import LireApi.Index;
import LireApi.ParallelIndex;
import LireApi.Search;

import java.util.List;
import LireApi.SearchResult;

public class Test {

	public static void main(String[] args) throws IOException {

		try {
			//Index.index("/home/kilian/Documents/Projects/OMD/lire-api/CorelDB/art_antiques/435000.jpg");
			//ParallelIndex.index("/home/kilian/Documents/Projects/OMD/lire-api/CorelDB/art_antiquess");
			List<SearchResult> res = Search.searchNBest("/home/kilian/Documents/Projects/OMD/lire-api/CorelDB/art_antiques/435000.jpg", 4);
			System.out.println("OK");
		} catch(IOException e) {
			System.out.println("KO");
		}

	}

}