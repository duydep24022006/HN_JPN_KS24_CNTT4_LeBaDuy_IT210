package SS1.BT.B4.repository;

public interface EmailRepository {
    void send(String userId, String message);
}
