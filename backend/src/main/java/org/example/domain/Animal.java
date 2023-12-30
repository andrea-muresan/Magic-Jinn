package org.example.domain;

public class Animal extends Entity<Long> {
    private String name;
    private boolean canSwim;
    private boolean canFly;
    private boolean isDomestic;
    private int numberOfFeet;
    private String size;
    private String habitat;
    private String diet;
    private String distinctiveFeature;
    private String lifespan;
    private String socialBehavior;
    private String predatorOrPrey;
    private String nocturnalDiurnal;
    private String specialAbility;
    private String speed;

    public Animal(String name, boolean canSwim, boolean canFly, boolean isDomestic, int numberOfFeet, String size, String habitat, String diet, String distinctiveFeature, String lifespan, String socialBehavior, String predatorOrPrey, String nocturnalDiurnal, String specialAbility, String speed) {
        this.name = name;
        this.canSwim = canSwim;
        this.canFly = canFly;
        this.isDomestic = isDomestic;
        this.numberOfFeet = numberOfFeet;
        this.size = size;
        this.habitat = habitat;
        this.diet = diet;
        this.distinctiveFeature = distinctiveFeature;
        this.lifespan = lifespan;
        this.socialBehavior = socialBehavior;
        this.predatorOrPrey = predatorOrPrey;
        this.nocturnalDiurnal = nocturnalDiurnal;
        this.specialAbility = specialAbility;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public int getNumberOfFeet() {
        return numberOfFeet;
    }

    public String getSize() {
        return size;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getDiet() {
        return diet;
    }

    public String getDistinctiveFeature() {
        return distinctiveFeature;
    }

    public String getLifespan() {
        return lifespan;
    }

    public String getSocialBehavior() {
        return socialBehavior;
    }

    public String getPredatorOrPrey() {
        return predatorOrPrey;
    }

    public String getNocturnalDiurnal() {
        return nocturnalDiurnal;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public String getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
