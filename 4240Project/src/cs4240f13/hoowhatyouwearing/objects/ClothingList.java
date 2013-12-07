package cs4240f13.hoowhatyouwearing.objects;

import java.util.ArrayList;

import cs4240f13.hoowhatyouwearing.objects.Article.ArticleType;
import cs4240f13.hoowhatyouwearing.objects.Article.Clothing;

public class ClothingList {
	
	private ArrayList<Article> array = new ArrayList<Article>();
	
	public ClothingList(){
	
	}
	
	
	
	public void addClothing(Article.ArticleType ArticleType, Article.Clothing Article){
		Article article = new Article(ArticleType, Article);
		array.add(article);
	}
	
	public void removeClothing(Article.ArticleType ArticleType, Article.Clothing Article){
		for(int i=0; i<array.size();i++){
			if(array.get(i).getArticle() == Article && array.get(i).getArticleType() == ArticleType)
				array.remove(i);
			}
	}
	
	public void clearClothes(){
		array.clear();
	}
	
	public String listClothing(){
		String list="";
		for(int i=0;i<array.size();i++){
			list += array.get(i).getArticleType() + ": " + array.get(i).getArticle() + "\n";
		}
		return list;
	}
	
	public String getClothing(Article.ArticleType ArticleType, Article.Clothing Article){
		Article temp = null;
		for(int i=0;i<array.size();i++){
			if(array.get(i).getArticle() == Article && array.get(i).getArticleType() == ArticleType)
				temp = array.get(i);
		}
		String article = temp.getArticleType() + ": " + temp.getArticle();
		
		return article;
	}
	
	public boolean containsClothing(Article.ArticleType ArticleType, Article.Clothing Article){
		boolean contains = false;
		//Article article = new Article(ArticleType, Article);
		for(int i=0;i<array.size();i++){
			if(array.get(i).getArticleType() == ArticleType && array.get(i).getArticle() == Article)
				contains = true;
		}
		return contains;
	}
	
	public ArrayList<Article> getClothes() {
		return array;
	}
	public static void main(String[] args) {
		ClothingList clothes = new ClothingList();
		
		clothes.addClothing(ArticleType.TOP, Clothing.TSHIRT);
		clothes.addClothing(ArticleType.TOP, Clothing.LONGSLEEVET);
		
		if(clothes.containsClothing(ArticleType.OUTERWEAR, Clothing.SWEATER))
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
		}
	}


