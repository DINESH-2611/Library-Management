package baseclasses;

public class Member {
    private String mMemberName;
    private String mMemberId;
    private String mMemberLocation;
    private long mMemberContact;

    public String getmMemberName() {
        return mMemberName;
    }

    public void setmMemberName(String mMemberName) {
        this.mMemberName = mMemberName;
    }

    public String getmMemberId() {
        return mMemberId;
    }

    public void setmMemberId(String mMemberId) {
        this.mMemberId = mMemberId;
    }

    public String getmMemberLocation() {
        return mMemberLocation;
    }

    public void setmMemberLocation(String mMemberLocation) {
        this.mMemberLocation = mMemberLocation;
    }

    public long getmMemberContact() {
        return mMemberContact;
    }

    public void setmMemberContact(long mMemberContact) {
        this.mMemberContact = mMemberContact;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mMemberName='" + mMemberName + '\'' +
                ", mMemberId='" + mMemberId + '\'' +
                ", mMemberLocation='" + mMemberLocation + '\'' +
                ", mMemberContact=" + mMemberContact +
                '}';
    }
}
