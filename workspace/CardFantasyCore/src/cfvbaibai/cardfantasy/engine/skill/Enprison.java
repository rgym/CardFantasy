package cfvbaibai.cardfantasy.engine.skill;

import java.util.List;

import cfvbaibai.cardfantasy.CardFantasyRuntimeException;
import cfvbaibai.cardfantasy.GameUI;
import cfvbaibai.cardfantasy.data.Skill;
import cfvbaibai.cardfantasy.engine.CardInfo;
import cfvbaibai.cardfantasy.engine.SkillResolver;
import cfvbaibai.cardfantasy.engine.HeroDieSignal;
import cfvbaibai.cardfantasy.engine.OnAttackBlockingResult;
import cfvbaibai.cardfantasy.engine.Player;

public class Enprison {
    public static void apply(SkillResolver resolver, Skill cardSkill, CardInfo attacker, Player defender) throws HeroDieSignal {
        if (attacker == null) {
            return;
        }
        if (defender == null) {
            return;
        }
        GameUI ui = resolver.getStage().getUI();
        int victimCount = cardSkill.getImpact();

        List<CardInfo> victims = resolver.getStage().getRandomizer().pickRandom(
            defender.getField().toList(), victimCount, true, null);
        if (victims.isEmpty()) {
            return;
        }
        
        ui.useSkill(attacker, victims, cardSkill, true);
        for (CardInfo victim : victims) {
            OnAttackBlockingResult result = resolver.resolveAttackBlockingSkills(attacker, victim, cardSkill, 1);
            if (!result.isAttackable()) {
                continue;
            }
            CardInfo expelledCard = victim.getOwner().getField().expelCard(victim.getPosition());
            if (expelledCard != victim) {
                throw new CardFantasyRuntimeException("expelledCard != defender");
            }

            ui.returnCard(attacker, victim, cardSkill);
            victim.getOwner().getDeck().addCard(victim);
            victim.setSummonNumber(0);
            victim.setRuneActive(false);
            resolver.resolveLeaveSkills(victim);
        }
    }
}
