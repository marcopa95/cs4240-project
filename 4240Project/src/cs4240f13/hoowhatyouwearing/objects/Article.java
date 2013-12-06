package cs4240f13.hoowhatyouwearing.objects;


public class Article {
	
	public enum ArticleType{
		TOP, BOTTOMS, OUTERWEAR, RAINGEAR, FOOTWEAR;
	}

	public enum Clothing{
		TSHIRT(1), LONGSLEEVET(2), // tops
		SWEATER(3), WINTERJACKET(4), // outerwear
		RAINJACKET(5), // special weather
		SHORTS(6), PANTS(7), // bottoms
		FLIPFLOPS(8), SHOES(9); // footwear
		
		private int offset;
		
		Clothing (int offset) {
			this.offset = offset;
		}
		
		public int getOffset(){
			return offset;
		}
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
