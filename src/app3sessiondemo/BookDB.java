package app3sessiondemo;

import java.util.LinkedHashMap;
import java.util.Map;
//ʵ�ʿ�������û�еġ������ݿ��������
public class BookDB {
	//key:���id  value��id��Ӧ�������
	private static Map<String, Book> books = new LinkedHashMap<String, Book>();
	static{
		books.put("1", new Book("1", "��������", "����", 5.00f, "�����˹����������û�����"));
		books.put("2", new Book("2", "��Ů�ľ�", "������", 8.00f, "�����˹��������崿"));
		books.put("3", new Book("3", "��а����", "�޺���", 5.00f, "�����˹����������û�����"));
		books.put("4", new Book("4", "��ƿ÷", "����ƽ", 15.00f, "�Ŵ�����С˵"));
		books.put("5", new Book("5", "��¥��", "��ѩ��", 105.00f, "�Ŵ�ŵ��������Ʒ"));
	}
	public static Book findBookById(String bookId){
		return books.get(bookId);
	}
	public static Map<String,Book> findAllBooks(){
		return books;
	}
}
