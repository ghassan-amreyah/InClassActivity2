package edu.cs1191704.inclassactivity2;

public class Book {

    String title;
    String author;
    boolean select;
    int pages;



    public Book(String title, String author, int pages, boolean select) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.select = select;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    public boolean getSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

}
