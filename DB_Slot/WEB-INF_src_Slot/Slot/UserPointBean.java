package pnw.Slot;

import java.io.Serializable;

public class UserPointBean implements Serializable{

    /**
     * 主キー
     */
    private String ID;

    /**
     * ポイント
     */
    private int point;


    public UserPointBean(String ID, int point) {
        this.ID = ID;
        this.point = point;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getpoint() {
        return point;
    }

    public void setpoint(int point) {
        this.point = point;
    }



}