package pnw.Slot;

public class ShopInfoBean {

    private int userID;
    private int itemID;
    private int itemPrice;
    private int goodsID;
    private String item_name;

    public ShopInfoBean(int userID,int itemID,int itemPrice,int goodsID) {
        this.userID = userID;
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        this.goodsID = goodsID;
    }

    public int getUserID() {
        return userID;
    }
    public int getItemID() {
        return itemID;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public int getGoodsID() {
        return goodsID;
    }
    public String getItemName(){
        return item_name;
    }
    public void setItemName(String name){
        this.item_name = name;
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