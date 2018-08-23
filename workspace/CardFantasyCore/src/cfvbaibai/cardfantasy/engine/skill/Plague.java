package cfvbaibai.cardfantasy.engine.skill;

import java.util.List;

import cfvbaibai.cardfantasy.GameUI;
import cfvbaibai.cardfantasy.data.Skill;
import cfvbaibai.cardfantasy.engine.CardInfo;
import cfvbaibai.cardfantasy.engine.EntityInfo;
import cfvbaibai.cardfantasy.engine.OnDamagedResult;
import cfvbaibai.cardfantasy.engine.SkillEffect;
import cfvbaibai.cardfantasy.engine.SkillEffectType;
import cfvbaibai.cardfantasy.engine.SkillUseInfo;
import cfvbaibai.cardfantasy.engine.SkillResolver;
import cfvbaibai.cardfantasy.engine.HeroDieSignal;
import cfvbaibai.cardfantasy.engine.OnAttackBlockingResult;
import cfvbaibai.cardfantasy.engine.Player;

public final class Plague {
    public static void apply(SkillUseInfo skillUseInfo, SkillResolver resolver, EntityInfo attacker, Player defenderHero)
            throws HeroDieSignal {
        Skill skill = skillUseInfo.getSkill();
        int damage = skill.getImpact();
        GameUI ui = resolver.getStage().getUI();
        List<CardInfo> victims = defenderHero.getField().getAliveCards();
        ui.useSkill(attacker, victims, skill, true);

        for (CardInfo victim : victims) {
            OnAttackBlockingResult blockingResult = resolver.resolveAttackBlockingSkills(attacker, victim, skill, damage);
            if (!blockingResult.isAttackable()) {
                continue;
            }
            int magicEchoSkillResult = resolver.resolveMagicEchoSkill(attacker, victim, skill);
            if (magicEchoSkillResult == 1 || magicEchoSkillResult == 2) {
                if (attacker instanceof CardInfo) {
                    CardInfo attackCard =  (CardInfo)attacker;
                    if(attackCard.isDead())
                    {
                        if (magicEchoSkillResult == 1) {
                            continue;
                        }
                    }
                    else {
                        OnAttackBlockingResult blockingResult2 = resolver.resolveAttackBlockingSkills(victim, attackCard, skill, damage);
                        if (!blockingResult2.isAttackable()) {
                            if (magicEchoSkillResult == 1) {
                                continue;
                            }
                        } else {
                            ui.adjustAT(victim, attackCard, -damage, skill);
                            attackCard.addEffect(new SkillEffect(SkillEffectType.ATTACK_CHANGE, skillUseInfo, -damage, true));
                            ui.attackCard(victim, attackCard, skill, damage);
                            OnDamagedResult damagedResult2 = resolver.applyDamage(victim, attackCard, skill, damage);
                            resolver.resolveDeathSkills(victim, attackCard, skill, damagedResult2);
                        }
                    }
                }
                if (magicEchoSkillResult == 1) {
                    continue;
                }
            }
            ui.adjustAT(attacker, victim, -damage, skill);
            victim.addEffect(new SkillEffect(SkillEffectType.ATTACK_CHANGE, skillUseInfo, -damage, true));
            ui.attackCard(attacker, victim, skill, damage);
            OnDamagedResult damagedResult = resolver.applyDamage(attacker, victim, skill, damage);
            resolver.resolveDeathSkills(attacker, victim, skill, damagedResult);
        }
    }
}
