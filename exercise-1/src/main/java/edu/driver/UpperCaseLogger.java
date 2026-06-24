package edu.driver;

import edu.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("upperCase")
public class UpperCaseLogger implements Logger {
    /**
     * Вывод лог-сообщения верхним регистром
     *
     * @param logMessage - сообщение
     */
    @Override
    public void printLog(String logMessage) {
        IO.println("ЛОГ: " + logMessage.toUpperCase());
    }
}