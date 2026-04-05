package SS1.BT.B3.repository;


public interface InventoryRepository  {
    boolean isAvailable(String foodName, int quantity);
    void reduceStock(String foodName, int quantity);
}
