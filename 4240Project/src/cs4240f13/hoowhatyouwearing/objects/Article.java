package cs4240f13.hoowhatyouwearing.objects;


public class Article {
	
	public enum ArticleType{
		TOP, BOTTOMS, OUTERWEAR, SHOES;
	}

	
	public enum Clothing{
		TSHIRT, LONGLSEEVET, SWEATER, WINTERJACKET, RAINJACKET, PANTS, SHORTS, FLIPFLOPS, SHOES;
	}
	
	private ArticleType article; 
	private Clothing clothing; //Example: T-shirt, Pants, Rainjacket, Flip-Flops
	
	public Article(ArticleType Type, Clothing clothes){
		article = Type;
		clothing = clothes;
	}
	
	public ArticleType getArticleType(){
		return article;
	}
	
	public Clothing getArticle(){
		return clothing;
	}
}
