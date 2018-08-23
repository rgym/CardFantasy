package cfvbaibai.cardfantasy.engine.skill;

import java.util.List;

import cfvbaibai.cardfantasy.GameUI;
import cfvbaibai.cardfantasy.Randomizer;
import cfvbaibai.cardfantasy.data.Skill;
import cfvbaibai.cardfantasy.engine.CardInfo;
import cfvbaibai.cardfantasy.engine.CardStatusItem;
import cfvbaibai.cardfantasy.engine.CardStatusType;
import cfvbaibai.cardfantasy.engine.SkillUseInfo;
import cfvbaibai.cardfantasy.engine.SkillResolver;
import cfvbaibai.cardfantasy.engine.HeroDieSignal;
import cfvbaibai.cardfantasy.engine.Player;
import cfvbaibai.cardfantasy.engine.StageInfo;

public final class Confusion {
    public static void apply(SkillUseInfo skillUseInfo, SkillResolver resolver, CardInfo attacker, Player defender,
            int victimCount) throws HeroDieSignal {
        Skill skill = skillUseInfo.getSkill();
        StageInfo stage = resolver.getStage();
        Randomizer random = stage.getRandomizer();
        GameUI ui = stage.getUI();

        int rate = skill.getImpact();
        List<CardInfo> victims = random.pickRandom(defender.getField().toList(), victimCount, true, null);
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
                    else if (attacker.getStatus().containsStatus(CardStatusType.迷惑)) {
                        if (magicEchoSkillResult == 1) {
                            continue;
                        }
                    }
                    else if (random.roll100(rate)) {
                        CardStatusItem status = CardStatusItem.confused(skillUseInfo);
                        ui.addCardStatus(victim, attacker, skill, status);
                        attacker.addStatus(status);
                    }
                }
                if (magicEchoSkillResult == 1) {
                    continue;
                }
            }
            if (victim.getStatus().containsStatus(CardStatusType.迷惑)) {
                continue;
            }
            if (random.roll100(rate)) {
                CardStatusItem status = CardStatusItem.confused(skillUseInfo);
                ui.addCardStatus(attacker, victim, skill, status);
                victim.addStatus(status);
            }
        }
    }
}
