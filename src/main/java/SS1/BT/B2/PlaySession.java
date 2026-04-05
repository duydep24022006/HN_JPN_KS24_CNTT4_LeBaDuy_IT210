package SS1.BT.B2;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component
@Scope("prototype") // mỗi lần getBean sẽ tạo một instance mới
public class PlaySession
{
    private double playTime=0;
    public void addTime(double time)
    {
        playTime+=time;
    }
}
