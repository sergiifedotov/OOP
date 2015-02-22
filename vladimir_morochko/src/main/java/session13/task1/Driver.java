package session13.task1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by vladimir on 22.02.2015.
 */
@Scope("prototype")
@Component
public class Driver {
    @Value("${driver_name}")
    private String driver_name;

    public Driver() {
    }

    public Driver(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getName() {
        return driver_name;
    }

    public void setName(String driver_name) {
        this.driver_name = driver_name;
    }

    @Override
    public String toString() {
        return "Driver{driver_name='" + driver_name + "'"
                + "}";
    }

}
