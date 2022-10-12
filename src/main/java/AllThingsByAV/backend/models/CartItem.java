package AllThingsByAV.backend.models;


import java.io.Serializable;

public class CartItem implements Serializable {
    private Long productId;
    private Integer productQty;

    public CartItem(Long productId, Integer productQty) {
        this.productId = productId;
        this.productQty = productQty;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }
}
