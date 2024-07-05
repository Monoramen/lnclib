package logic;


import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

import java.io.IOException;

import java.util.concurrent.atomic.AtomicInteger;


public class Main {

     public static void main(String[] args) {
        System.out.println("Starting");
        String token = "1172097134:AAHcscJQEZk-p2_EUVdhm_NSmDe8YgX2b0g";
        try {
            TelegramBot bot = new TelegramBot(token);
            new Builder(bot).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static class Builder {
        private static int LONG_POOLING_TIMEOUT_IN_SECONDS = 7;
        private AtomicInteger updateId = new AtomicInteger(0);
        private BotCommands botCommands;

        private TelegramBot bot;

        public Builder(TelegramBot bot) {
            this.bot = bot;
            this.botCommands = new BotCommands(bot);

        }

        public void run() throws InterruptedException {
            while (true) {
                System.out.println("Checking for updates...");
                bot.execute(
                        new GetUpdates().limit(100).offset(updateId.get()).timeout(LONG_POOLING_TIMEOUT_IN_SECONDS),
                        new Callback<GetUpdates, GetUpdatesResponse>() {

                            @Override
                            public void onResponse(GetUpdates request, GetUpdatesResponse response) {
                                for (Update update : response.updates()) {
                                    System.err.println("Update: " + update);
                                    if (update.message() != null && update.message().text() != null) {
                                        String messageText = update.message().text();

                                        if (!botCommands.processCommand(update) && update.message() != null && update.message().text() != null) {
                                            bot.execute(new SendMessage(update.message().from().id(), "I don't understand this command. Please use /help to see the list of available commands."));
                                        }
                                        updateId.set(update.updateId() + 1);
                                    }

                                }
                            }

                            @Override
                            public void onFailure(GetUpdates request, IOException e) {
                                e.printStackTrace();
                            }
                        });

                Thread.sleep(LONG_POOLING_TIMEOUT_IN_SECONDS * 2200);
            }
        }
    }
}
