package screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.lang.Nullable;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class PeriodicalScopeConfigurer implements Scope {
    Map<String, Pair<LocalTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (map.containsKey(name)) {
            Pair<LocalTime, Object> pair = map.get(name);
            int secondsLast = LocalTime.now().getSecond() - pair.getKey().getSecond();
            if (secondsLast > 3) {
                map.put(name, new Pair(LocalTime.now(), objectFactory.getObject()));
            }
        } else {
            map.put(name, new Pair(LocalTime.now(), objectFactory.getObject()));
        }
        return map.get(name).getValue();
    }

    @Nullable
    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Nullable
    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Nullable
    @Override
    public String getConversationId() {
        return null;
    }
}
