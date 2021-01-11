package com.codewithankit.online;

public class modal  {
    private String textView;
    private int image;

    public modal(String textView, int image) {
        this.textView = textView;
        this.image = image;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
