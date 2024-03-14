package baseclasses;

public class Book {
    private String mBookTitle;
    private String mIsbn;
    private String mAuthor;
    private int mBookCount;
    private int mPublictionYear;

    public String getmBookTitle() {
        return mBookTitle;
    }

    public void setmBookTitle(String mBookTitle) {
        this.mBookTitle = mBookTitle;
    }

    public String getmIsbn() {
        return mIsbn;
    }

    public void setmIsbn(String mIsbn) {
        this.mIsbn = mIsbn;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public int getmBookCount() {
        return mBookCount;
    }

    public void setmBookCount(int mBookCount) {
        this.mBookCount = mBookCount;
    }

    public int getmPublictionYear() {
        return mPublictionYear;
    }

    public void setmPublictionYear(int mPublictionYear) {
        this.mPublictionYear = mPublictionYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "mBookTitle='" + mBookTitle + '\'' +
                ", mIsbn='" + mIsbn + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mBookCount=" + mBookCount +
                ", mPublictionYear=" + mPublictionYear +
                '}';
    }
}
