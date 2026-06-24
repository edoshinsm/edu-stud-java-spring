package edu.driver;

import edu.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("lowerCase")
public class LowerCaseLogger implements Logger {
    /**
     * Вывод лог-сообщения нижним регистром
     *
     * @param logMessage - сообщение
     */
    @Override
    public void printLog(String logMessage) {
        IO.println("ЛОГ: " + logMessage.toLowerCase());
    }
}
