import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Bai
 * @since 2021/11/7
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, URISyntaxException {

//        byte[] bytes = Files.readAllBytes(Paths.get("/Users/bai/Downloads/study/Hello.xlass"));

        MyClassLoader myClassLoader = new MyClassLoader();

        Path path = Paths.get(myClassLoader.getClass().getResource("Hello.xlass").toURI());
        byte[] bytes = Files.readAllBytes(path);

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ((byte) 255 - bytes[i]);
        }

        Class<?> aClass = myClassLoader.defineClass("Hello", bytes, 0, bytes.length);
        Method hello = aClass.getMethod("hello");
        // invoke
        hello.invoke(aClass.newInstance());


    }


}
