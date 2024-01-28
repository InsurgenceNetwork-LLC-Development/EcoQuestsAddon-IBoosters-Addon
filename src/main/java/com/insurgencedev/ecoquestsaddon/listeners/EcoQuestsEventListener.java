package com.insurgencedev.ecoquestsaddon.listeners;

import com.willfp.ecoquests.api.event.PlayerTaskExpGainEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.insurgenceboosters.api.IBoosterAPI;
import org.insurgencedev.insurgenceboosters.data.BoosterFindResult;

public final class EcoQuestsEventListener implements Listener {

    @EventHandler
    private void onGain(PlayerTaskExpGainEvent event) {
        final String TYPE = "Quests";
        final String NAMESPACE = "ECO_QUESTS";
        final double[] totalMulti = {1};

        BoosterFindResult pResult = IBoosterAPI.INSTANCE.getCache(event.getPlayer()).getBoosterDataManager().findActiveBooster(TYPE, NAMESPACE);
        if (pResult instanceof BoosterFindResult.Success boosterResult) {
            totalMulti[0] += boosterResult.getBoosterData().getMultiplier();
        }

        IBoosterAPI.INSTANCE.getGlobalBoosterManager().findGlobalBooster(TYPE, NAMESPACE, globalBooster -> {
            totalMulti[0] += globalBooster.getMultiplier();
            return null;
        }, () -> null);

        event.setAmount(calculateAmount(event.getAmount(), totalMulti[0]));
    }

    private long calculateAmount(double amount, double multi) {
        return (long) (amount * (multi < 1 ? 1 + multi : multi));
    }
}
