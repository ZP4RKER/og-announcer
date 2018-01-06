package co.zpdev.bots.ogannouncer;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.AnnotatedEventManager;
import net.dv8tion.jda.core.hooks.SubscribeEvent;

import java.util.Arrays;
import java.util.List;

public class Main {

    private List<String> discrims = Arrays.asList(
            "0001", "0002", "0003", "0004", "0005", "0006", "0007", "0008", "0009",
            "1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999",
            "0101", "0202", "0303", "0404", "0505", "0606", "0707", "0808", "0909",
            "1234", "4321", "0123", "3210",
            "6969", "0069", "4200", "0420", "6900", "0690",
            "2018", "2017"
    );

    public static void main(String[] args) throws Exception {

        new JDABuilder(AccountType.BOT)
                .setToken(args[0])
                .setEventManager(new AnnotatedEventManager())
                .addEventListener(new Main()).buildAsync();

    }

    @SubscribeEvent
    public void onJoin(GuildMemberJoinEvent event) {
        if (!discrims.contains(event.getUser().getDiscriminator())) return;

        String username = event.getUser().getName() + "#" + event.getUser().getDiscriminator();
        String msg = "[Discord.Cheap] " + username + " has been added to the stock.";
        event.getJDA().getTextChannelById(399039281450057729L).sendMessage(msg).queue();
    }

}
