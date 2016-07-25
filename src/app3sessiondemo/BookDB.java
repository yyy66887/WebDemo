package app3sessiondemo;

import java.util.LinkedHashMap;
import java.util.Map;
//实际开发中是没有的。由数据库来代替的
public class BookDB {
	//key:书的id  value：id对应的书对象
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	static{
		books.put("1", new Book("1", "葵花宝典", "葛付以", 5.00f, "欲练此功，必须练好基本功"));
		books.put("2", new Book("2", "玉女心经", "朱巧玲", 8.00f, "欲练此功，必须清纯"));
		books.put("3", new Book("3", "辟邪剑法", "邹海洋", 5.00f, "欲练此功，必须练好基本功"));
		books.put("4", new Book("4", "金瓶梅", "刘建平", 15.00f, "古代爱情小说"));
		books.put("5", new Book("5", "红楼梦", "曹雪芹", 105.00f, "古代诺贝尔获奖作品"));
	}
	public static Book findBookById(String bookId){
		return books.get(bookId);
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
}
