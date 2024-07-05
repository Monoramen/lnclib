package logic;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public class BotCommands {

    private final TelegramBot bot;

    public BotCommands(TelegramBot bot) {
        this.bot = bot;
    }

    public void processStartCommand(long chatId) {
        bot.execute(new SendMessage(chatId, "Hello! I'm a bot that can help you find words by their code. Just send " +
                "me a code and I'll find the words for you.\n" + "\n Just send me a /num <code>"));
    }

    public void processHelpCommand(long chatId) {
        bot.execute(new SendMessage(chatId, "Here are the available commands:\n\n/start - start the bot\n" +
                "/help - show this help message\n\nTo find words by their code, just send me a \n /num <code>."));
    }

    public boolean processCommand(Update update) {
        String messageText = update.message().text();
        if (messageText != null) {
            if (messageText.startsWith("/start")) {
                processStartCommand(update.message().from().id());
                return true;
            } else if (messageText.startsWith("/help")) {
                processHelpCommand(update.message().from().id());
                return true;
            }
        }
        return false;
    }
}

