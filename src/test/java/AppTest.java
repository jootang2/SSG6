import com.ll.ssg6.Rq;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    @Test
    void rq_getPath(){
        Rq rq = new Rq("삭제?id=10");

        String path = rq.getPath();

        assertEquals("삭제",path);


    }
    @Test
    void rq_getid(){
        Rq rq = new Rq("삭제?id=10");
        int id = rq.getIntParam("id", 0);

        assertEquals(10,id);


    }


    @Test
        void 테스트(){
            int rs = 3+5;
            assertEquals(8,rs);
            assertTrue(true);
        }

        @Test
        void 입출력테스트(){
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output));

            System.out.println("안녕");

            String rs = output.toString().trim();

            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
            try {
                output.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            assertEquals("안녕", rs);
        }


}
