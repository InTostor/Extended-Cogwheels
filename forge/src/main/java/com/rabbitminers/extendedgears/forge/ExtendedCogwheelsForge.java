package com.rabbitminers.extendedgears.forge;

import com.rabbitminers.extendedgears.ExtendedCogwheels;
import com.rabbitminers.extendedgears.ExtendedCogwheelsClient;
import com.rabbitminers.extendedgears.cogwheels.CogwheelMaterials;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
#if MC_18
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
#else
import net.minecraftforge.data.event.GatherDataEvent;
#endif


@Mod(ExtendedCogwheels.MOD_ID)
public class ExtendedCogwheelsForge {
    public ExtendedCogwheelsForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ExtendedCogwheels.registrate().registerEventListeners(eventBus);
        ExtendedCogwheels.init();
        CogwheelMaterials.init();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT,
                () -> ExtendedCogwheelsClient::init);

        eventBus.addListener(EventPriority.LOWEST, ExtendedCogwheelsForge::gatherData);
    }

    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExtendedCogwheels.gatherData(gen, true);
    }
}
