package LibraryManagament.Model;

public class Img {
    private int imageId;
    private String img;
    private String nameBook;
    private String imageType;

    public Img() {
    }

    public Img(int imageId, String img, String nameBook,String imageType) {
        this.imageId = imageId;
        this.img = img;
        this.nameBook = nameBook;
        this.imageType = imageType;
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

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
