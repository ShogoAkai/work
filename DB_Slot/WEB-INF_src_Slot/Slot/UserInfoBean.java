package pnw.Slot;

public class UserInfoBean {

    private int userID;
    private String user_Name;
    private int score;

    public UserInfoBean(String user_Name,int score,int userID) {
        this.user_Name = user_Name;
        this.score = score;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
    public String getUserName(){
        return user_Name;
    }
    public int getScore() {
        return score;
    }
    public void addScore(int score){
        this.score += score;
    }

    // public void setUserID(String userID) {
    //     this.userID = userID;
    // }

    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    /**
     * @return String return the ID
     */
    // public int getID() {
    //     return ID;
    // }

    /**
     * @param ID the ID to set
     */
    // public void setID(int ID) {
    //     this.ID = ID;
    // }

}