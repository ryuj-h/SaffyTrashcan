import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class mouseevent {
	
	public static void clickMouse(int mx, int my) {
	    try {
	        Robot robot = new Robot();

	        robot.mouseMove(mx, my);

	        Thread.sleep(100);

	        robot.mousePress(InputEvent.BUTTON1_MASK);

	        Thread.sleep(100);

	        robot.mouseRelease(InputEvent.BUTTON1_MASK);

	        Thread.sleep(100);    

	            
	    } catch (Exception e) {
	        e.printStackTrace();

	    }
	}
	public static void main(String args[]) {

		 
        // 현재 시간
        while(true) {
            LocalTime now = LocalTime.now();
            System.out.println(now);  // 06:20:57.008731300
 
            // 포맷 정의하기
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
 
            // 포맷 적용하기
            String formatedNow = now.format(formatter);
        
        
            if (formatedNow.equals("18")) {
            	clickMouse(643,355);
        		break;
            }
        }
	}
}
