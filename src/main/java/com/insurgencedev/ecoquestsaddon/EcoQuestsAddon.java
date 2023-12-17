package com.insurgencedev.ecoquestsaddon;

import com.insurgencedev.ecoquestsaddon.listeners.EcoQuestsEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "EcoQuestsAddon", version = "1.0.0", author = "InsurgenceDev", description = "EcoQuests Support")
public class EcoQuestsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        registerEvent(new EcoQuestsEventListener());
    }
}
