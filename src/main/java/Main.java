
import events.Event;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Main {
    public static JDA jda;
    public static String prefix = "!";

    public static void main(String[] args) throws Exception {
        //returns bday persons name
        //birthdays returnina false, jei siust zinute, arba true, jei reikia siust, ir zmogaus varda, kuriam nereikia issiust, t.y jubiliato;
      JDABuilder jdaBuilder = JDABuilder.createDefault("token")
              .setChunkingFilter(ChunkingFilter.ALL)
              .setMemberCachePolicy(MemberCachePolicy.ALL)
              .enableIntents(GatewayIntent.GUILD_MEMBERS);

            jda = jdaBuilder.build();
            jda.getPresence().setStatus(OnlineStatus.IDLE);
            jda.addEventListener(new Event(jda));
    }
}
