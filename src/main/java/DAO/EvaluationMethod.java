package DAO;

public enum EvaluationMethod {
    CC,
    PW, // practical work - TP
    PP;

    public float getPercentage() {
        switch (this) {
            case CC: return 0.3f;
            case PW: return 0.2f;
            case PP: return 0.5f;
        }
        return 0.f;
    }
}
