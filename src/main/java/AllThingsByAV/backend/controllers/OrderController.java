package AllThingsByAV.backend.controllers;

import AllThingsByAV.backend.models.CartItem;
import AllThingsByAV.backend.services.OrderService;
import AllThingsByAV.backend.services.ProductService;
import com.squareup.square.Environment;
import com.squareup.square.SquareClient;
import com.squareup.square.api.CheckoutApi;
import com.squareup.square.models.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;


    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }
    @GetMapping("/getTestCartItem")
    public List<CartItem> test(){
        List<CartItem> list = new ArrayList<>();
        list.add(new CartItem(1L,1));
        list.add(new CartItem(2L,2));
        return list;
    }
    @PostMapping("/guest/checkout")
    @Async
    public CreatePaymentLinkResponse checkoutCart(@RequestBody List<CartItem> cart) throws InterruptedException {
        Integer totalPrice = 0;
        SquareClient square = new SquareClient.Builder()
        .environment(Environment.SANDBOX)
        .accessToken(System.getenv("square_access_token"))
        .build();

        CheckoutApi checkoutApi = square.getCheckoutApi();

        for (CartItem item : cart) {
            Integer price = (int)(productService.get(item.getProductId()).getPrice() * item.getProductQty() * 100);
            totalPrice = price + totalPrice;
        }
        Long total = totalPrice.longValue();
        Money amountMoney = new Money.Builder()
                .amount(total)
                .currency("USD")
                .build();
        QuickPay quickPay = new QuickPay.Builder(
                "total",
                amountMoney,
                "LM3A8ZDY28XHD")
                .build();

        CheckoutOptions checkoutOptions = new CheckoutOptions.Builder()
                .allowTipping(true)
                .redirectUrl(System.getenv("fronend_url") + "/success")
                .askForShippingAddress(true)
                .build();

        CreatePaymentLinkRequest body = new CreatePaymentLinkRequest.Builder()
                .quickPay(quickPay)
                .checkoutOptions(checkoutOptions)
                .build();
        final CreatePaymentLinkResponse[] res = {null};
        checkoutApi.createPaymentLinkAsync(body)
                .thenAccept(result -> {
                    System.out.println("Success!");
                    System.out.println(result);
                    res[0] = result;
                })
                .exceptionally(exception -> {
                    System.out.println("Failed to make the request");
                    System.out.println(String.format("Exception: %s", exception.getMessage()));
                    return null;
                });
        Thread.sleep(3000);
        return res[0];
    }
}
