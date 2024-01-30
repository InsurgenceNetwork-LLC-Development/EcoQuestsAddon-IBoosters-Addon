package com.insurgencedev.ecoquestsaddon;

import com.insurgencedev.ecoquestsaddon.listeners.EcoQuestsEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;
import org.insurgencedev.insurgenceboosters.libs.fo.Common;

@IBoostersAddon(name = "EcoQuestsAddon", version = "1.0.3", author = "InsurgenceDev", description = "EcoQuests Support")
public class EcoQuestsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadAblesStart() {
        if (Common.doesPluginExist("EcoQuests")) {
            registerEvent(new EcoQuestsEventListener());
        }
    }
}
