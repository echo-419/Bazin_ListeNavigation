package com.example.bilannavigation;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String Nom;
    private String Prénom;
    private String Mail;
    private String Pseudo;

    public User(String Nom, String Prénom, String Mail, String Pseudo){

        super();
        this.Nom=Nom;
        this.Prénom=Prénom;
        this.Mail=Mail;
        this.Pseudo=Pseudo;
    }

    public String getNom(){
        return Nom;
    }
    public void setNom(String Nom){
        this.Nom=Nom;
    }

    public String getPrénom(){
        return Prénom;
    }
    public void setPrénom(String Prénom){
        this.Prénom=Prénom;
    }

    public String getMail(){
        return Mail;
    }
    public void setMail(String Mail){
        this.Mail=Mail;
    }

    public String getPseudo(){
        return Pseudo;
    }
    public void setPseudo(String Pseudo){
        this.Pseudo=Pseudo;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    //@Override
    public void writeToParcel(Parcel dest,int flags){

        dest.writeString(Nom);
        dest.writeString(Prénom);
        dest.writeString(Mail);
        dest.writeString(Pseudo);

    }


    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source)
        {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User(Parcel source){
        this.Nom=source.readString();
        this.Prénom=source.readString();
        this.Mail=source.readString();
        this.Pseudo=source.readString();
    }

}
