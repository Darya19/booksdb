package com.epam.day8.model.entity;

import java.util.Arrays;

public class Book {

    private int id;
    private String title;
    private String[] authors;
    private double price;
    private int pages;

    public Book() {
    }

    public Book(int id, String title, String[] authors, double price, int pages) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.pages = pages;
    }

    public Book(String title, String[] authors, double price, int pages) {
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (getId() != book.getId()) return false;
        if (Double.compare(book.getPrice(), getPrice()) != 0) return false;
        if (getPages() != book.getPages()) return false;
        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getAuthors(), book.getAuthors());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getAuthors());
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getPages();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", authors=").append(Arrays.toString(authors));
        sb.append(", price=").append(price);
        sb.append(", pages=").append(pages);
        sb.append('}');
        return sb.toString();
    }
}
