package cs4240f13.hoowhatyouwearing.objects;


public class Article {
	
	public enum ArticleType{
		TOP, BOTTOMS, OUTERWEAR, SHOES;
	}

	public enum Clothing{
		TSHIRT, LONGSLEEVET, SWEATER, WINTERJACKET, RAINJACKET, PANTS, SHORTS, FLIPFLOPS, SHOES;
		
		private int offset;
		
		public void setOffset(){
			if(this == TSHIRT)
				offset = 1;
			if(this == LONGSLEEVET)
				offset = 2;
			if(this == SWEATER)
				offset = 3;
			if(this == WINTERJACKET)
				offset = 4;
			if(this == RAINJACKET)
				offset = 5;
			if(this == PANTS)
				offset = 6;
			if(this == SHORTS)
				offset = 7;
			if(this == FLIPFLOPS)
				offset = 8;
			if(this == SHOES)
				offset = 9;
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
