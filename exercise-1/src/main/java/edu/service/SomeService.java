package edu.service;

import edu.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SomeService {
    private static final Log log = LogFactory.getLog(SomeService.class);
    private Logger logger;

    @Autowired
    @Qualifier("lowerCase")
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * Вывод лог-сообщения
     *
     * @param message - сообщение
     */
    public void printLog(String message) {
        logger.printLog(message);
    }

    /**
     * Вывод лог-сообщений
     *
     * @param messages - сообщения
     */
    public void printLogs(String[] messages) {
        Arrays.stream(messages).forEach(logger::printLog);
    }
}
