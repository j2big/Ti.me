package com.time.time;

/**
 * Created by Afolabi on 12/20/2015.
 */
public class Profiles {

    int _day, _month, _year, _from_time, _til_time, _reminder_num;
    String _dayoweek, _profile_name, _profile_description, _profile_color, _event_type, _event_name, _event_description, _event_location, _invited, _reminder_period, _remider_minhr;
    private int _profile_id;

    public Profiles() {
    }

    public Profiles(int profileId, String profileName, String profileColor, String profileDescription) {
        this._profile_name = profileName;
        this._profile_color = profileColor;
        this._profile_description = profileDescription;
        this._profile_id = profileId;
    }

    public Profiles(String profileName, String profileDescription, String profileColor) {
        this._profile_name = profileName;
        this._profile_color = profileColor;
        this._profile_description = profileDescription;

    }


    //getters
    public String getProfileName() {
        return _profile_name;
    }

    //setters
    public void setProfileName(String profileName) {
        this._profile_name = profileName;
    }

    public int getProfileId() {
        return _profile_id;
    }

    public void setProfileId(int profileId) {
        this._profile_id = profileId;
    }

    public String getProfileColor() {
        return _profile_color;
    }

    public void setProfileColor(String profileColor) {
        this._profile_color = profileColor;
    }

    public String getProfileDescription() {
        return _profile_description;
    }

    public void setProfileDescription(String profileDescription) {
        this._profile_description = profileDescription;
    }
}
