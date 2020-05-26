package com.awake.thecovid19tracker.ui.dashboard;

import android.os.Parcel;
import android.os.Parcelable;

public class CovidState implements Parcelable {
    String mState, mDeaths, mTodayCases, mTodayDeaths, mTests, mActive;
    int mCases;

    public CovidState(String states, int cases, String todayCases, String deaths, String todayDeaths, String tests) {
        this.mActive = mActive;
        this.mCases = mCases;
        this.mState = mState;
        this.mTodayCases = mTodayCases;
        this.mTodayDeaths = mTodayDeaths;
        this.mDeaths = mDeaths;
        this.mTests = mTests;
    }


    public int getmCases() {
        return mCases;
    }

    public String getmActive() {
        return mActive;
    }

    public String getmDeaths() {
        return mDeaths;
    }

    public String getmState() {
        return mState;
    }

    public String getmTests() {
        return mTests;
    }

    public String getmTodayCases() {
        return mTodayCases;
    }

    public String getmTodayDeaths() {
        return mTodayDeaths;
    }

    protected CovidState(Parcel in) {
        this.mState = in.readString();
        this.mCases = in.readInt();
        this.mTodayCases = in.readString();
        this.mDeaths = in.readString();
        this.mTodayDeaths = in.readString();
        this.mTests = in.readString();
        this.mActive = in.readString();

    }

    public static final Creator<CovidState> CREATOR = new Creator<CovidState>() {
        @Override
        public CovidState createFromParcel(Parcel in) {
            return new CovidState(in);
        }

        @Override
        public CovidState[] newArray(int size) {
            return new CovidState[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mState);
        dest.writeInt(this.mCases);
        dest.writeString(this.mTodayCases);
        dest.writeString(this.mDeaths);
        dest.writeString(this.mTodayDeaths);
        dest.writeString(this.mTests);
        dest.writeString(this.mActive);
    }
}
