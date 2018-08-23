package cfvbaibai.cardfantasy.data;

import java.util.ArrayList;
import java.util.List;

import cfvbaibai.cardfantasy.CardFantasyRuntimeException;

public class Card implements Cloneable, Comparable <Card> {
    private CardData sourceInfo;
    private int exp;
    private String uniqueName;
    private CardSkill extraSkill;
    private int overrideHP = -1;
    private int overrideAT = -1;
    private List<CardSkill> normalSkill; //new add
    private int setDelay; //new add

    public Card(CardData sourceInfo) {
        this(sourceInfo, 0, "");
    }

    public Card(CardData sourceInfo, int cardLevel, String suffix) {
        this(sourceInfo, cardLevel, null, null, suffix,-1,-1);
    }

    public Card(CardData sourceInfo, int cardLevel, CardSkill extraSkill, String prefix, String suffix,int overrideHP,int overrideAT) {
        if (sourceInfo == null) {
            throw new CardFantasyRuntimeException("sourceInfo should not be null");
        }
        if (prefix == null) {
            prefix = "";
        }
        if (suffix == null) {
            suffix = "";
        }
        this.sourceInfo = sourceInfo;
        this.growToLevel(cardLevel);
        this.extraSkill = extraSkill;
        this.uniqueName = prefix + sourceInfo.getName() + suffix;
        this.overrideHP = overrideHP;
        this.overrideAT = overrideAT;
        this.normalSkill=new ArrayList<>();//new add
        this.setDelay = -1;//new add
    }
    
    public String getId() {
        return this.sourceInfo.getId();
    }
    
    public String getWikiId() {
        return this.sourceInfo.getWikiId();
    }

    public String getUniqueName() {
        return this.uniqueName;
    }
    
    public int getSummonSpeed() {
        //new add start
        if(this.setDelay>=0)
        {
            return this.setDelay;
        }
        //new add end
        return this.sourceInfo.getSummonSpeed();
    }
    
    public int getLevel() {
        return sourceInfo.getGrowth().getLevel(exp);
    }
    
    public int getInitAT() {
        if (this.overrideAT <= 0) {
            return this.sourceInfo.getBaseAT() + this.sourceInfo.getIncrAT() * this.getLevel();
        }
        else{
            return this.overrideAT;
        }
    }

    public int getMaxHP() {
        if (this.overrideHP <= 0) {
            return this.sourceInfo.getBaseHP() + this.sourceInfo.getIncrHP() * this.getLevel();
        } else {
            return this.overrideHP;
        }
    }
    
    public void setOverrideHP(int overrideHP) {
        this.overrideHP = overrideHP;
    }

    public List<CardSkill> getAllSkills() {
        List <CardSkill> skills = new ArrayList<CardSkill>(sourceInfo.getSkills());

        //new add start
        if (this.normalSkill.size()>0) {
            for(CardSkill skill:this.normalSkill) {
                skills.add(skill);
            }
        }
        //new add end

        if (this.extraSkill != null) {
            skills.add(this.extraSkill);
        }
        return skills;
    }

    public void growToLevel(int level) {
        this.exp = sourceInfo.getGrowth().getRequiredExp(level);
    }
    
    public Race getRace() {
        return this.sourceInfo.getRace();
    }

    public String getName() {
        return this.sourceInfo.getName();
    }

    public CardSkill getExtraSkill() {
        return this.extraSkill;
    }

    public int getCost() {
        int cost = this.sourceInfo.getBaseCost();
        if (this.getLevel() > 10 || this.extraSkill != null) {
            cost += this.sourceInfo.getIncrCost();
        }
        return cost;
    }
    
    public int getBaseCost() {
        return this.sourceInfo.getBaseCost();
    }

    public int getStar() {
        return this.sourceInfo.getStar();
    }

    @Override
    public int compareTo(Card another) {
        int result = this.getName().compareToIgnoreCase(another.getName());
        if (result != 0) {
            return result;
        }
        result = this.getLevel() - another.getLevel();
        if (result != 0) {
            return result;
        }
        if (this.getExtraSkill() == null && another.getExtraSkill() == null) {
            return 0;
        }
        if (this.getExtraSkill() == null) {
            return -1;
        }
        if (another.getExtraSkill() == null) {
            return 1;
        }
        return this.getExtraSkill().compareTo(another.getExtraSkill());
    }
    
    public String getParsableDesc() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getName());
        if (this.getExtraSkill() != null) {
            sb.append("+");
            sb.append(this.getExtraSkill().getParsableDesc());
        }
        sb.append("-");
        sb.append(this.getLevel());
        return sb.toString();
    }

    //new add start
    public void addNormalSkill(CardSkill skill)
    {
        this.normalSkill.add(skill);
    }

    public void setSetDelay(int setDelay) {
        this.setDelay = setDelay;
    }

    //new add end
}
