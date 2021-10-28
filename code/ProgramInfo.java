package code;

public class ProgramInfo {
    public static final float LEVEL_ADA = 1.53f;

    private float languageLevel;
    private float sizeInKB;
    private float errors;

    public ProgramInfo (float languageLevel, float size, float errors) {
        this.languageLevel = languageLevel;
        this.sizeInKB = size;
        this.errors = errors;
    }

    public float getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(float languageLevel) {
        this.languageLevel = languageLevel;
    }

    public float getSizeInKB() {
        return sizeInKB;
    }

    public void setSizeInKB(float sizeInKB) {
        this.sizeInKB = sizeInKB;
    }

    public float getErrors() {
        return errors;
    }

    public void setErrors(float errors) {
        this.errors = errors;
    }

}
