package org.languano;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.response.*;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.*;
import org.springframework.boot.SpringApplication;

import java.util.List;
import java.util.logging.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class Telegram {
    public void run() {
        Logger logger = Logger.getLogger(Telegram.class.getName());

        logger.info("Run bot");

        String telegramBotToken = System.getenv("TELEGRAM_BOT_TOKEN");
        if (telegramBotToken == null) {
            logger.info("Can't find Telegram token");
            System.exit(-1);
        }
        TelegramBot bot = new TelegramBot(telegramBotToken);

        logger.info("Create Update listener...");

        bot.setUpdatesListener(updates -> {
            // ... process updates
            System.out.println("Hello ");
            if (updates != null) {
                for (Update update : updates) {
                    //System.out.println("Hello ");
                    long chatId = update.message().chat().id();
                    logger.info("ID: " + String.valueOf(chatId));
                    SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));
                    logger.info(response.toString());
                }
            }
            // return id of last processed update or confirm them all
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
// Create Exception Handler
        }, e -> {
            if (e.response() != null) {
                // got bad response from telegram
                e.response().errorCode();
                e.response().description();
            } else {
                // probably network error
                e.printStackTrace();
            }
        });
        logger.info("Bot subscribed on updates");
        GetUpdates getUpdates = new GetUpdates().limit(100).offset(0);
        GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
        List<Update> updates = updatesResponse.updates();
//        if (updates != null) {
//            for (Update update : updates) {
//                //System.out.println("Hello ");
//                long chatId = update.message().chat().id();
//                logger.info("ID: " + String.valueOf(chatId));
//                SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));
//                logger.info(response.toString());
//            }
//        }


    }
}