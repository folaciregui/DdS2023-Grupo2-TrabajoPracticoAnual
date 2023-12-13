package presentacion.handlers;

import io.javalin.Javalin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppHandlers {
    private IHandler[] handlers = new IHandler[]{
            new AccessDeniedHandler(),
    };

    public static void applyHandlers(Javalin app) {
        //Arrays.stream(new AppHandlers().handlers).toList().forEach(handler -> handler.setHandle(app));
        List<IHandler> handlerList = Arrays.stream(new AppHandlers().handlers)
                .collect(Collectors.toList());

        handlerList.forEach(handler -> handler.setHandle(app));

    }
}