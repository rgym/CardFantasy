package cfvbaibai.cardfantasy.engine.skill;

import java.util.List;

import cfvbaibai.cardfantasy.GameUI;
import cfvbaibai.cardfantasy.data.Skill;
import cfvbaibai.cardfantasy.engine.CardInfo;
import cfvbaibai.cardfantasy.engine.CardStatusItem;
import cfvbaibai.cardfantasy.engine.SkillUseInfo;
import cfvbaibai.cardfantasy.engine.SkillResolver;
import cfvbaibai.cardfantasy.engine.HeroDieSignal;
import cfvbaibai.cardfantasy.engine.Player;

public final class Seal {
    public static void apply(SkillUseInfo skillUseInfo, SkillResolver resolver, CardInfo attacker, Player defender)
            throws HeroDieSignal {
        if (attacker.hasUsed(skillUseInfo)) {
            return;
        }
        Skill skill = skillUseInfo.getSkill();
        List<CardInfo> victims = defender.getField().getAliveCards();
        GameUI ui = resolver.getStage().getUI();
        ui.useSkill(attacker, victims, skill, true);
        for (CardInfo victim : victims) {
            if (!resolver.resolveAttackBlockingSkills(attacker, victim, skill, 1).isAttackable()) {
                continue;
            }
            int magicEchoSkillResult = resolver.resolveMagicEchoSkill(attacker, victim, skill);
            if (magicEchoSkillResult==1||magicEchoSkillResult==2) {
                if(attacker.isDead())
                {
                    if (magicEchoSkillResult == 1) {
                        continue;
                    }
                }
                else{
                    if (!resolver.resolveAttackBlockingSkills(victim, attacker, skill, 1).isAttackable()) {
                        if (magicEchoSkillResult == 1) {
                            continue;
                        }
                    }
                    else {
                        CardStatusItem status = CardStatusItem.trapped(skillUseInfo);
                        ui.addCardStatus(victim, attacker, skill, status);
                        attacker.addStatus(status);
                    }
                }
                if (magicEchoSkillResult == 1) {
                    continue;
                }
            }
            CardStatusItem status = CardStatusItem.trapped(skillUseInfo);
            ui.addCardStatus(attacker, victim, skill, status);
            victim.addStatus(status);
        }
        attacker.setUsed(skillUseInfo);
    }
}
