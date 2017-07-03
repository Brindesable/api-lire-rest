package LireApi;

public class SearchResult {

	String imgPath;
	double score;

	public SearchResult(String imgPath, double score) {
		this.imgPath = imgPath;
		this.score = score;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public double getScore() {
		return this.score;
	}
}