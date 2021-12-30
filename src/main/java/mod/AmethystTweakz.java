package mod;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("amethyst_tweakz")
public class AmethystTweakz
{

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public AmethystTweakz() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }




    @Mod.EventBusSubscriber(modid = "amethyst_tweakz")
    public static class EventsBus {
        @SubscribeEvent
        public static void registerTrade(WandererTradesEvent tradeeven) {
            tradeeven.getRareTrades().add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 8), new ItemStack(Items.BUDDING_AMETHYST, 1), 3, 3, 0.2F));
        }

        @SubscribeEvent
        public static void registerTrade(VillagerTradesEvent tradeeven) {

            if ((tradeeven.getType() == VillagerProfession.CLERIC)) {
                tradeeven.getTrades().get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.AMETHYST_SHARD, 12), 3, 3, 0.1F));

            }
        }
    }


}
