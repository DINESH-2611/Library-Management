package baseclasses;

import java.util.List;

public class Library {
    private String mlibraryName;
    private String mLibraryId;
    private String mLocation;

    private List<Admin> mAdminsList;
    private List<Book> mBooksList;
    private List<Member> mMemberList;

    public String getMlibraryName() {
        return mlibraryName;
    }

    public void setMlibraryName(String mlibraryName) {
        this.mlibraryName = mlibraryName;
    }

    public String getmLibraryId() {
        return mLibraryId;
    }

    public void setmLibraryId(String mLibraryId) {
        this.mLibraryId = mLibraryId;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public List<Admin> getmAdminsList() {
        return mAdminsList;
    }

    public void setmAdminsList(List<Admin> mAdminsList) {
        this.mAdminsList = mAdminsList;
    }

    public List<Book> getmBooksList() {
        return mBooksList;
    }

    public void setmBooksList(List<Book> mBooksList) {
        this.mBooksList = mBooksList;
    }

    public List<Member> getmMemberList() {
        return mMemberList;
    }

    public void setmMemberList(List<Member> mMemberList) {
        this.mMemberList = mMemberList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "mlibraryName='" + mlibraryName + '\'' +
                ", mLibraryId='" + mLibraryId + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mAdminsList=" + mAdminsList +
                ", mBooksList=" + mBooksList +
                ", mMemberList=" + mMemberList +
                '}';
    }
}
