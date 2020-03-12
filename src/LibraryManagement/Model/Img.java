package LibraryManagement.Model;

public class Img {
    private int imageId;
    private String img;
    private String nameBook;

    public Img() {
    }

    public Img(int imageId, String img, String nameBook) {
        this.imageId = imageId;
        this.img = img;
        this.nameBook = nameBook;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }
}
