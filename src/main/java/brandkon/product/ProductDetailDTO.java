package brandkon.product;

import brandkon.brand.BrandDto;

public class ProductDetailDTO {
    private Long productId;
    private String productName;
    private int price;
    private BrandDto brand;
    private int expirationDays;

    public ProductDetailDTO(Long productId, String productName, int price, BrandDto brand, int expirationDays) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.brand = brand;
        this.expirationDays = expirationDays;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(int expirationDays) {
        this.expirationDays = expirationDays;
    }
}