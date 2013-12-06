package cs4240f13.hoowhatyouwearing.objects;

public class Article {
	
	private String ArticleType; //Examples: Top, Bottom, Outerwear, Shoes
	private String Clothing; //Example: T-shirt, Pants, Rainjacket, Flip-Flops
	public Article(String Type, String clothing){
		ArticleType = Type;
		Clothing = clothing;
	}
	public String getArticleType(){
		return ArticleType;
	}
	
	public String getArticle(){
		return Clothing;
	}
}
