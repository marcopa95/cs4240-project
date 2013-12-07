package cs4240f13.hoowhatyouwearing.objects;


public class Article implements Comparable {
	
	public enum ArticleType{
		TOP, BOTTOMS, OUTERWEAR, RAINGEAR, FOOTWEAR;
	}

	public enum Clothing{
		TSHIRT(20), LONGSLEEVET(30), // tops
		SWEATER(30), WINTERJACKET(40), // outerwear
		RAINJACKET(30), // special weather
		SHORTS(30), PANTS(50), // bottoms
		FLIPFLOPS(10), SHOES(50); // footwear
		
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

	@Override
	public int compareTo(Object arg0) {
		Article compared = (Article) arg0;
		return this.getArticle().getOffset() - compared.getArticle().getOffset();
	}
}
