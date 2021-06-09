package project.order;

/**
 * OrderService
 */
public interface OrderService {

    Order creatOrder(Long memberId, String itemName, int itemPrice);

}
