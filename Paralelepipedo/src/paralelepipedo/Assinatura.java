package paralelepipedo;

public class Assinatura {
    
    private Double sepallengthMin;
    private Double sepalwidthMin;
    private Double petallengthMin;
    private Double petalwidthMin;
    private Double sepallengthMax;
    private Double sepalwidthMax;
    private Double petallengthMax;
    private Double petalwidthMax;

    public Assinatura() {
        this.sepallengthMin = Double.MAX_VALUE;
        this.sepalwidthMin = Double.MAX_VALUE;
        this.petallengthMin = Double.MAX_VALUE;
        this.petalwidthMin = Double.MAX_VALUE;
        this.sepallengthMax = Double.MIN_VALUE;
        this.sepalwidthMax = Double.MIN_VALUE;
        this.petallengthMax = Double.MIN_VALUE;
        this.petalwidthMax = Double.MIN_VALUE;
    }
    
    

    public Double getSepallengthMin() {
        return sepallengthMin;
    }

    public void setSepallengthMin(Double sepallengthMin) {
        this.sepallengthMin = sepallengthMin;
    }

    public Double getSepalwidthMin() {
        return sepalwidthMin;
    }

    public void setSepalwidthMin(Double sepalwidthMin) {
        this.sepalwidthMin = sepalwidthMin;
    }

    public Double getPetallengthMin() {
        return petallengthMin;
    }

    public void setPetallengthMin(Double petalengthMin) {
        this.petallengthMin = petalengthMin;
    }

    public Double getPetalwidthMin() {
        return petalwidthMin;
    }

    public void setPetalwidthMin(Double petalwidthMin) {
        this.petalwidthMin = petalwidthMin;
    }

    public Double getSepallengthMax() {
        return sepallengthMax;
    }

    public void setSepallengthMax(Double sepallengthMax) {
        this.sepallengthMax = sepallengthMax;
    }

    public Double getSepalwidthMax() {
        return sepalwidthMax;
    }

    public void setSepalwidthMax(Double sepalwidthMax) {
        this.sepalwidthMax = sepalwidthMax;
    }

    public Double getPetallengthMax() {
        return petallengthMax;
    }

    public void setPetallengthMax(Double petalengthMax) {
        this.petallengthMax = petalengthMax;
    }

    public Double getPetalwidthMax() {
        return petalwidthMax;
    }

    public void setPetalwidthMax(Double petalwidthMax) {
        this.petalwidthMax = petalwidthMax;
    }
    
    public void updateSepallength(Double sepallength){
        if(sepallength > getSepallengthMax()){
            setSepallengthMax(sepallength);
        }
        if(sepallength < getSepallengthMin()){
            setSepallengthMin(sepallength);
        }
    }
    
    public void updatePetallength(Double petallength){
        if(petallength > getPetallengthMax()){
            setPetallengthMax(petallength);
        }
        if(petallength < getPetallengthMin()){
            setPetallengthMin(petallength);
        }
    }
    
    public void updateSepalwidth(Double sepalwidth){
        if(sepalwidth > getSepalwidthMax()){
            setSepalwidthMax(sepalwidth);
        }
        if(sepalwidth < getSepalwidthMin()){
            setSepalwidthMin(sepalwidth);
        }
    }
    
    public void updatePetalwidth(Double petalwidth){
        if(petalwidth > getPetalwidthMax()){
            setPetalwidthMax(petalwidth);
        }
        if(petalwidth < getPetalwidthMin()){
            setPetalwidthMin(petalwidth);
        }
    }
    
}
