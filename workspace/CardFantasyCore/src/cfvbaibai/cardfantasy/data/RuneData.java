package cfvbaibai.cardfantasy.data;

public enum RuneData {
    ����(RuneClass.GROUND, 3, FeatureType.��Һ, 3, 1, 1, Growth.RUNE, RuneActivator.myHeroHP(60)),
    ����(RuneClass.GROUND, 3, FeatureType.����, 1, 1, 1, Growth.RUNE, RuneActivator.enemyField(2, null)),
    �Ҿ�(RuneClass.GROUND, 3, FeatureType.���ܻ���, 3, 1, 2, Growth.RUNE, RuneActivator.enemyField(1, null)),
    ��ɰ(RuneClass.GROUND, 3, FeatureType.��Һ, 5, 1, 2, Growth.RUNE, RuneActivator.round(12)),
    �ұ�(RuneClass.GROUND, 4, FeatureType.��, 5, 1, 3, Growth.RUNE, RuneActivator.myField(1, Race.����)),
    ��Ԩ(RuneClass.GROUND, 4, FeatureType.����, 5, 1, 3, Growth.RUNE, RuneActivator.enemyGrave(1, Race.����)),
    ʯ��(RuneClass.GROUND, 4, FeatureType.��������, 5, 1, 3, Growth.RUNE, RuneActivator.myGrave(1, Race.����)),
    ���(RuneClass.GROUND, 5, FeatureType.��Ѫ, 5, 1, 4, Growth.RUNE, RuneActivator.myField(1, Race.����)),
    ����(RuneClass.GROUND, 4, FeatureType.����, 5, 1, 4, Growth.RUNE, RuneActivator.enemyField(1, Race.����)),
    ����(RuneClass.GROUND, 4, FeatureType.�ѻ�, 5, 1, 5, Growth.RUNE, RuneActivator.myGrave(2, Race.����)),
    ����(RuneClass.GROUND, 5, FeatureType.����, 6, 1, 5, Growth.RUNE, RuneActivator.myGrave(1, Race.����)),
    ����(RuneClass.GROUND, 4, FeatureType.ת��, 4, 1, 5, Growth.RUNE, RuneActivator.myGrave(1, Race.����)),
    
    ˪��(RuneClass.WATER, 3, FeatureType.����, 3, 1, 1, Growth.RUNE, RuneActivator.myGrave(2, null)),
    ����(RuneClass.WATER, 3, FeatureType.˪������, 1, 1, 1, Growth.RUNE, RuneActivator.myDeck(2, null)),
    ��׶(RuneClass.WATER, 3, FeatureType.����, 5, 1, 2, Growth.RUNE, RuneActivator.round(14)),
    ����(RuneClass.WATER, 3, FeatureType.����, 3, 1, 2, Growth.RUNE, RuneActivator.enemyField(1, Race.����)),
    ����(RuneClass.WATER, 4, FeatureType.Ⱥ������, 5, 1, 3, Growth.RUNE, RuneActivator.myGrave(1, Race.����)),
    ��Ȫ(RuneClass.WATER, 4, FeatureType.����, 5, 1, 3, Growth.RUNE, RuneActivator.myField(1, Race.����)),
    ŭ��(RuneClass.WATER, 4, FeatureType.����, 4, 1, 3, Growth.RUNE, RuneActivator.myHeroHP(40)),
    ѩ��(RuneClass.WATER, 4, FeatureType.˪������, 6, 1, 4, Growth.RUNE, RuneActivator.enemyField(1, Race.����)),
    ����(RuneClass.WATER, 3, FeatureType.����, 5, 1, 4, Growth.RUNE, RuneActivator.myGrave(1, Race.����)),
    ʥȪ(RuneClass.WATER, 6, FeatureType.����, 5, 1, 4, Growth.RUNE, RuneActivator.enemyGrave(1, Race.����)),
    ����(RuneClass.WATER, 4, FeatureType.����ѩ, 6, 1, 5, Growth.RUNE, RuneActivator.myField(1, Race.����)),
    ����(RuneClass.WATER, 3, FeatureType.����, 3, 1, 5, Growth.RUNE, RuneActivator.myGrave(3, Race.����)),
    
    ����(RuneClass.WIND, 3, FeatureType.����, 3, 1, 1, Growth.RUNE, RuneActivator.enemyGrave(2, null)),
    ����(RuneClass.WIND, 3, FeatureType.��������, 1, 1, 1, Growth.RUNE, RuneActivator.myHeroHP(50)),
    ����(RuneClass.WIND, 3, FeatureType.����, 5, 1, 2, Growth.RUNE, RuneActivator.round(14)),
    ����(RuneClass.WIND, 4, FeatureType.�ѻ�, 4, 1, 2, Growth.RUNE, RuneActivator.myGrave(1, Race.ɭ��)),
    ����(RuneClass.WIND, 4, FeatureType.�ش�, 4, 1, 3, Growth.RUNE, RuneActivator.enemyGrave(1, Race.����)),
    쫷�(RuneClass.WIND, 4, FeatureType.��������, 4, 1, 3, Growth.RUNE, RuneActivator.myHeroHP(40)),
    ����(RuneClass.WIND, 4, FeatureType.Ⱥ�廤��, 4, 1, 3, Growth.RUNE, RuneActivator.myHand(1, Race.ɭ��)),
    ����(RuneClass.WIND, 4, FeatureType.��Ѫ, 5, 1, 4, Growth.RUNE, RuneActivator.enemyField(1, Race.����)),
    �׶�(RuneClass.WIND, 4, FeatureType.�ܴ�, 6, 1, 4, Growth.RUNE, RuneActivator.myField(1, Race.ɭ��)),
    ����(RuneClass.WIND, 4, FeatureType.��׷�ʹ�, 6, 1, 4, Growth.RUNE, RuneActivator.myGrave(1, Race.ɭ��)),
    ����(RuneClass.WIND, 4, FeatureType.�ױ�, 6, 1, 5, Growth.RUNE, RuneActivator.myField(1, Race.ɭ��)),
    ����(RuneClass.WIND, 3, FeatureType.����, 5, 1, 5, Growth.RUNE, RuneActivator.myGrave(2, Race.ɭ��)),
    
    ��ȭ(RuneClass.FIRE, 3, FeatureType.����, 3, 1, 1, Growth.RUNE, RuneActivator.enemyField(2, null)),
    ����(RuneClass.FIRE, 3, FeatureType.��ǽ, 1, 1, 1, Growth.RUNE, RuneActivator.myHeroHP(60)),
    ����(RuneClass.FIRE, 3, FeatureType.����, 5, 1, 2, Growth.RUNE, RuneActivator.round(12)),
    ����(RuneClass.FIRE, 5, FeatureType.����, 4, 1, 2, Growth.RUNE, RuneActivator.myHand(1, Race.����)),
    ڤ��(RuneClass.FIRE, 4, FeatureType.�һ����, 3, 1, 3, Growth.RUNE, RuneActivator.myGrave(1, Race.����)),
    ����(RuneClass.FIRE, 4, FeatureType.Ⱥ������, 4, 1, 3, Growth.RUNE, RuneActivator.myHeroHP(50)),
    ����(RuneClass.FIRE, 4, FeatureType.��ǽ, 5, 1, 3, Growth.RUNE, RuneActivator.enemyField(1, Race.ɭ��)),
    �׼�(RuneClass.FIRE, 5, FeatureType.ħ��, 4, 1, 4, Growth.RUNE, RuneActivator.myField(1, Race.����)),
    ����(RuneClass.FIRE, 5, FeatureType.�Ա�, 4, 1, 4, Growth.RUNE, RuneActivator.enemyField(1, Race.ɭ��)),
    �ƻ�(RuneClass.FIRE, 6, FeatureType.��Ǵ, 6, 1, 4, Growth.RUNE, RuneActivator.myField(1, Race.����)),
    ����(RuneClass.FIRE, 5, FeatureType.����籩, 6, 1, 5, Growth.RUNE, RuneActivator.myGrave(1, Race.����)),
    ��ɱ(RuneClass.FIRE, 4, FeatureType.ս��, 6, 1, 5, Growth.RUNE, RuneActivator.myGrave(2, Race.����)),
    ;
    
    private RuneClass runeClass;
    private int maxEnergy;
    private FeatureType featureType;
    private int incrFeatureLevel;
    private int initFeatureLevel;
    private Growth growth;
    private int star;
    private RuneActivator activator;

    RuneData(RuneClass runeClass, int maxEnergy, FeatureType featureType, int initFeatureLevel,
            int incrFeatureLevel, int star, Growth growth, RuneActivator activator) {
        this.runeClass = runeClass;
        this.maxEnergy = maxEnergy;
        this.featureType = featureType;
        this.initFeatureLevel = initFeatureLevel;
        this.incrFeatureLevel = incrFeatureLevel;
        this.growth = growth;
        this.star = star;
        this.activator = activator;
    }

    public RuneClass getRuneClass() {
        return runeClass;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public int getIncrFeatureLevel() {
        return incrFeatureLevel;
    }

    public int getInitFeatureLevel() {
        return initFeatureLevel;
    }

    public Growth getGrowth() {
        return growth;
    }

    public int getStar() {
        return star;
    }
    
    public RuneActivator getActivator() {
        return this.activator;
    }
}