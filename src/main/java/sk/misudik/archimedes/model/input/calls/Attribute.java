package sk.misudik.archimedes.model.input.calls;

public class Attribute {

    private String date;
    private float riskScore;
    private String number;
    private boolean greenList;
    private boolean redList;

    public Attribute() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(float riskScore) {
        this.riskScore = riskScore;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isGreenList() {
        return greenList;
    }

    public void setGreenList(boolean greenList) {
        this.greenList = greenList;
    }

    public boolean isRedList() {
        return redList;
    }

    public void setRedList(boolean redList) {
        this.redList = redList;
    }
}
