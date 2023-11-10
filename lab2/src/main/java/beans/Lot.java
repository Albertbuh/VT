package beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class Lot implements Serializable {
    public static final String defaultDescDir = "D:\\Univer\\vt\\labs\\lab2\\src\\main\\webapp\\text\\descriptions\\lots\\";
    private static final String defaultDescName = "no.txt";
    public static final String defaultImgDir = "D:\\Univer\\vt\\labs\\lab2\\src\\main\\webapp\\templates\\images\\lots\\";
    private static final String defaultImageName = "no.jpg";
    private String name;
    private String descriptionPath;
    private String imageName;
    private BigDecimal price;

    private String generateDescPath(String name) {
        return defaultDescDir + "/" + name;
    }
    private String generateImagePath(String name) {
        return defaultImgDir + "/" + name;
    }
    public Lot() {
       name = "";
       descriptionPath = (defaultDescName);
        imageName = (defaultImageName);
       price = new BigDecimal(0);
    }

    private java.util.UUID generateNameSalt() {
        return java.util.UUID.randomUUID();
    }
    public Lot(String name, String descName, String imgName, double price) {
        this.name = name; //+ '.' +  generateNameSalt();
        this.descriptionPath = (descName.isEmpty() ? defaultDescName : descName);
        this.imageName = (imgName.isEmpty() ? defaultImageName : imgName);
        this.price = new BigDecimal(price);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionPath() {
        return descriptionPath;
    }
    public void setDescriptionPath(String descPath) {
        this.descriptionPath = descPath;
    }

    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imagePath) {
        this.imageName = imagePath;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
