package brandkon.product;

public class ProductDTO {
    private Long id;
    private String productName; // 타입: String
    private int price; // 타입: int
    private String imageUrl; // 타입: String
    private String brandName; // 타입: String

    public ProductDTO(Long id, String productName, int price, String imageUrl, String brandName) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.brandName = brandName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
