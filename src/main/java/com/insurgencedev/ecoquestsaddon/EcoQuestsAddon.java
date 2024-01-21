package com.insurgencedev.ecoquestsaddon;

import com.insurgencedev.ecoquestsaddon.listeners.EcoQuestsEventListener;
import org.bukkit.Bukkit;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "EcoQuestsAddon", version = "1.0.1", author = "InsurgenceDev", description = "EcoQuests Support")
public class EcoQuestsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (Bukkit.getPluginManager().isPluginEnabled("EcoQuests")) {
            registerEvent(new EcoQuestsEventListener());
        }
    }
}
