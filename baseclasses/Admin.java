package baseclasses;

public class Admin {
    private String mAdminName;
    private String mAdminId;
    private String mAdminLocation;
    private long mAdminContact;

    public String getmAdminName() {
        return mAdminName;
    }

    public void setmAdminName(String mAdminName) {
        this.mAdminName = mAdminName;
    }

    public String getmAdminId() {
        return mAdminId;
    }

    public void setmAdminId(String mAdminId) {
        this.mAdminId = mAdminId;
    }

    public String getmAdminLocation() {
        return mAdminLocation;
    }

    public void setmAdminLocation(String mAdminLocation) {
        this.mAdminLocation = mAdminLocation;
    }

    public long getmAdminContact() {
        return mAdminContact;
    }

    public void setmAdminContact(long mAdminContact) {
        this.mAdminContact = mAdminContact;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "mAdminName='" + mAdminName + '\'' +
                ", mAdminId='" + mAdminId + '\'' +
                ", mAdminLocation='" + mAdminLocation + '\'' +
                ", mAdminContact=" + mAdminContact +
                '}';
    }
}
