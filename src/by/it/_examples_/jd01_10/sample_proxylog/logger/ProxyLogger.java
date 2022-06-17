package by.it._examples_.jd01_10.sample_proxylog.logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Логгер для объектов на интерфейсе Sender
 */
public class ProxyLogger {

    //метод, который создает прокси-объект
    @SuppressWarnings("unchecked")
    public static <T> T getLoggedSender(T target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                getInvocationHandler(target)
        );
    }

    //метод создает обработчик вызовов методов
    private static InvocationHandler getInvocationHandler(Object target) {
        return (proxy, proxyMethod, args) -> {
            Method method = target.getClass().getMethod(
                    proxyMethod.getName(), (Class<?>[]) proxyMethod.getGenericParameterTypes());
            if (method.isAnnotationPresent(Log.class)) {
                log(method);
            }
            //else
            //throw new InvocationTargetException(null, String.format("method %s should be annotated ", method));
            return method.invoke(target, args);
        };
    }

    //метод для вывод лога в консоль с данными его аннотации
    private static void log(Method method) {
        Log a = method.getAnnotation(Log.class);
        System.out.printf("\033[%dmLevel:%-10s\033[0m Name: %-20s LOG: %s\n",
                a.level().color, a.level(), method.getName(), a.text()
        );
    }

}
