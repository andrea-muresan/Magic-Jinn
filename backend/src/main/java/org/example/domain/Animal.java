package org.example.domain;

public class Animal extends Entity<Long> {
    private String name;
    private String canSwim;
    private String canFly;
    private String isDomestic;
    private String numberOfFeet;
    private String size;
    private String habitat;
    private String diet;
    private String distinctiveFeature;
    private String socialBehavior;
    private String predatorOrPrey;
    private String nocturnalDiurnal;
    private String specialAbility;
    private String speed;

    public Animal(String name, String canSwim, String canFly, String isDomestic, String numberOfFeet, String size,
                  String habitat, String diet, String distinctiveFeature, String socialBehavior,
                  String predatorOrPrey, String nocturnalDiurnal, String specialAbility, String speed) {
        this.name = name;
        this.canSwim = canSwim;
        this.canFly = canFly;
        this.isDomestic = isDomestic;
        this.numberOfFeet = numberOfFeet;
        this.size = size;
        this.habitat = habitat;
        this.diet = diet;
        this.distinctiveFeature = distinctiveFeature;
        this.socialBehavior = socialBehavior;
        this.predatorOrPrey = predatorOrPrey;
        this.nocturnalDiurnal = nocturnalDiurnal;
        this.specialAbility = specialAbility;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getCanSwim() {
        return canSwim;
    }

    public String getCanFly() {
        return canFly;
    }

    public String getIsDomestic() {
        return isDomestic;
    }

    public String getNumberOfFeet() {
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
        return "---" + name + "----";
    }
}
